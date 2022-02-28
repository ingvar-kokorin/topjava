package ru.javawebinar.topjava.util;

import java.util.Map;

public class CollectionUtils {
    public static <K, V> boolean isEmpty(Map<K, V> meals) {
        return meals == null || meals.isEmpty();
    }
}
