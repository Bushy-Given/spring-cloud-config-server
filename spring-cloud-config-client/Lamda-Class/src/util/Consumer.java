package util;

import java.util.Objects;

/**
 * Created by Bushy-Netshidaulu
 * on 5/22/2020
 */
@FunctionalInterface
public interface Consumer<T> {
    void accept(T t);

    default Consumer<T> andThen(Consumer<T> other){
        Objects.requireNonNull(other);
        return (T t)-> {
            this.accept(t);
            other.accept(t);
        };
    }
}
