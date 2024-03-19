package school.hei.bankapi.repository;
import org.yaml.snakeyaml.events.Event;
import school.hei.bankapi.model.DefaultModel;

import java.util.List;

public interface CrudOperations<T extends DefaultModel, ID> {

    List<T> findAll();
    List<T> saveAll(List<T> toSave);


    T save(T toSave);
    T findById(ID id);
    T delete(ID id);
    T update(ID id);
}
