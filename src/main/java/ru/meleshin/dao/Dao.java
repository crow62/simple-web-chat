package ru.meleshin.dao;

import java.util.List;

public interface Dao<T> {
    List<T> showAll();

    void save(T t);
}
