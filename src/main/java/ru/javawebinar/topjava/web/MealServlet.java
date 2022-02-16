package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.javawebinar.topjava.dao.Dao;
import ru.javawebinar.topjava.dao.RamMealDao;
import ru.javawebinar.topjava.db.HardCodeDb;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class MealServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(MealServlet.class);
    private static final String INSERT_OR_EDIT = "meal.jsp";
    private static final String LIST_MEALS = "listMeals.jsp";
    private final Dao<Meal> dao = new RamMealDao(new HardCodeDb());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("redirect to meals");

        List<MealTo> mealTo = MealsUtil.filteredByStreams(dao.getAll(), null, null, MealsUtil.caloriesPerDay);

        String forward = "";
        String action = req.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {
            int mealId = Integer.parseInt(req.getParameter("mealId"));
            dao.delete(mealId);

            forward = LIST_MEALS;
            req.setAttribute("meals", mealTo);
        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            int mealId = Integer.parseInt(req.getParameter("mealId"));
            Meal meal = dao.getById(mealId);

            req.setAttribute("meal", meal);
        } else if (action.equalsIgnoreCase("listMeal")) {
            forward = LIST_MEALS;
            req.setAttribute("meals", mealTo);
        } else {
            forward = INSERT_OR_EDIT;
        }

        req.getRequestDispatcher(forward).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        Meal meal = new Meal();

        meal.setCalories(Integer.parseInt(req.getParameter("calories")));
        meal.setDescription(req.getParameter("description"));
        try {
            LocalDateTime ldt = LocalDateTime.parse(req.getParameter("dob"));

            meal.setDateTime(ldt);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String mealId = req.getParameter("mealId");

        if (mealId == null || mealId.isEmpty()) {
            dao.add(meal);
        } else {
            meal.setId(Integer.parseInt(mealId));
            dao.update(meal);
        }

        resp.sendRedirect("meals?action=listMeal");
    }
}
