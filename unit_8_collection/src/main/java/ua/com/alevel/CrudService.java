package ua.com.alevel;

import java.util.List;

public interface CrudService<U> {

    void create(U u);
    List<U> findAll();
    <N> void add(N n);
    <N, X extends N> void put(X x);
}
