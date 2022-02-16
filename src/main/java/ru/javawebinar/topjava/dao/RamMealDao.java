package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.db.HardCodeDb;
import ru.javawebinar.topjava.model.Meal;

import java.util.List;

public class RamMealDao implements Dao<Meal> {
    private final HardCodeDb db;

    public RamMealDao(HardCodeDb db) {
        this.db = db;
    }

    @Override
    public List<Meal> getAll() {
        return db.getMeals();
    }

    @Override
    public void add(Meal entity) {
        db.getMeals().add(entity);
        entity.setId(HardCodeDb.mealCount.incrementAndGet());
    }

    @Override
    public void update(Meal entity) {
        int oldMealIndex = findMealIndex(entity);
        if (oldMealIndex != -1) {
            db.getMeals().set(oldMealIndex, entity);
        }
    }

    @Override
    public void delete(int mealId) {
        db.getMeals().removeIf(m -> m.getId().equals(mealId));
    }

    private int findMealIndex(Meal meal) {
        for (int i = 0; i < db.getMeals().size(); i++) {
            Integer oldMealId = db.getMeals().get(i).getId();
            if (meal.getId().equals(oldMealId)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Meal getById(int id) {
        return db.getMeals().stream()
                .filter(m -> m.getId().equals(id))
                .findFirst()
                .get();
    }
}
