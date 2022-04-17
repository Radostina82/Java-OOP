package bakery.repositories.interfaces;

import java.util.Collection;
import java.util.Map;

public interface Repository<T> {

    Collection<T> getAll();

    void add(T t);

}
