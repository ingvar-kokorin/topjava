package ru.javawebinar.topjava.db;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class HardCodeDb {
    private final List<Meal> meals;

    public static final AtomicInteger mealCount = new AtomicInteger(0);

    {
        meals = new CopyOnWriteArrayList<Meal>() {{
            add(new Meal(LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0), "Завтрак", 500));
            add(new Meal(LocalDateTime.of(2020, Month.JANUARY, 30, 13, 0), "Обед", 1000));
            add(new Meal(LocalDateTime.of(2020, Month.JANUARY, 30, 20, 0), "Ужин", 500));
            add(new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 0, 0), "Еда на граничное значение", 100));
            add(new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 10, 0), "Завтрак", 1000));
            add(new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 13, 0), "Обед", 500));
            add(new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 20, 0), "Ужин", 410));
        }};

        for (int i = 0; i < 7; i++) {
            meals.get(i).setId(i + 1);
            System.out.println(meals.get(i).getId());
        }

        mealCount.set(meals.size());
    }

    public List<Meal> getMeals() {
        return meals;
    }
}
