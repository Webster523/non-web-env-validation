import bean.UserInfo;
import util.ValidationUtil;

import java.time.LocalDateTime;
import java.util.List;

public class ValidationTest {
    public static void main(String[] args) {
        UserInfo userInfo = new UserInfo();
        userInfo.setName("Simon Roger");
        userInfo.setAge(25);
        userInfo.setEmail("1223334@qq.com");
        userInfo.setPhone("13312345678");
        userInfo.setBirthday(LocalDateTime.MIN);
        userInfo.setPersonalPage("http://www.baidu.com");
        List<String> message = ValidationUtil.validate(userInfo);
        System.out.println(message);
//        traditionValidationTest(userInfo);
    }

    private static void traditionValidationTest(UserInfo userInfo) {
        String name = userInfo.getName();
        if (name == null || name.isEmpty() || name.trim().isEmpty()) {
            throw new RuntimeException("The property name cannot pass the validation.");
        }

        Integer age = userInfo.getAge();
        boolean ageValid = 1 <= age && age <= 800;
        if (!ageValid) {
            throw new RuntimeException("The property age cannot pass the validation.");
        }
    }
}
