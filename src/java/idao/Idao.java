package idao;

import java.util.List;

/**
 *
 * @author alsorc
 */
public interface Idao<T, V> {

    boolean insertRecord(T model);

    boolean deleteRecord(V idModel);

    boolean updateRecord(T model, V idModel);

    T ReadOneRecord(V idModel);

    List<T> readRecords();
}
