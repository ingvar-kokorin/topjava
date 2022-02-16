package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;

import java.util.List;

public interface Dao<T> {
    List<T> getAll();

    void add(T entity);

    void update(T entity);

    void delete(int id);

    Meal getById(int id);
}
