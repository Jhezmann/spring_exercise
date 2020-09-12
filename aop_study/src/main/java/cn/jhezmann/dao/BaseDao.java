package cn.jhezmann.dao;

public interface BaseDao<T> {
    T get(Integer id, String name);
}
