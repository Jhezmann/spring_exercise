package cn.jhezmann.service;

public interface BaseService<T> {

    T get(Integer id, String name);
}
