package school.hei.bankapi.repository;
import java.util.List;

public interface CrudOperations<T> {

    List<T> findAll();

    T findById(int id);

    void save(T toSave);

    void saveAll(List<T> toSave);

    void update(T toUpdate);

    void delete(int id);
}
