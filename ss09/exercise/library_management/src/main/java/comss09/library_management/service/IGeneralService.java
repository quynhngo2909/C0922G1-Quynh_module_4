package comss09.library_management.service;

import java.util.List;

public interface IGeneralService<T> {
    List<T> getAll();
    void save(T t);
    void delete(int id);

    T findById(int id);
}
