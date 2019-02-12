package cardiller.util;

import javax.validation.ConstraintViolation;
import java.util.Set;

public interface ValidationUtil {
    <T> Boolean isValid(T object);
    <T> Set<ConstraintViolation<T>> violations(T object);
}
