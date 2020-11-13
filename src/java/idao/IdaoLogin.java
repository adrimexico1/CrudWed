package idao;

import java.util.List;

/**
 *
 * @author adrian
 */
public interface IdaoLogin<T> {

    boolean insert(T model);

    T checarUsuario(T model);
}
