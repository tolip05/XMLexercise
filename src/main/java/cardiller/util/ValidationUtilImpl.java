package cardiller.util;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

public class ValidationUtilImpl implements ValidationUtil {
    private Validator validator;

    public ValidationUtilImpl() {
        this.validator =
                Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Override
    public <T> Boolean isValid(T object) {
        return this.validator.validate(object).size() == 0;
    }

    @Override
    public <T> Set<ConstraintViolation<T>> violations(T object) {
        return this.validator.validate(object);
    }
}
