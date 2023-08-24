package util;

import bean.UserInfo;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

import java.util.List;
import java.util.Set;

public class ValidationUtil {
    // 这个类是线程安全的
    private final static Validator validator;

    static {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    public static List<String> validate(UserInfo userInfo) {
        // 如果被校验对象userInfo没有校验通过，则violations里边就有校验信息。
        Set<ConstraintViolation<UserInfo>> violations = validator.validate(userInfo);
        return violations.stream().map(v -> v.getPropertyPath() + ": " + v.getInvalidValue() + ", " + v.getMessage()).toList();
    }
}
