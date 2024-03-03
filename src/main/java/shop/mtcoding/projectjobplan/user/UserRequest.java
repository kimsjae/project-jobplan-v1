package shop.mtcoding.projectjobplan.user;

import lombok.Data;

import java.sql.Timestamp;

public class UserRequest {
    @Data
    public static class JoinDTO {
        private String username;
        private String password;
        private String name;
        private String birthdate;
        private char gender;
        private Integer phoneNumber;
        private String address;
        private String email;
        // emp
        private Boolean isEmployer;
        private Integer employerIdNumber;
        private String businessName;
    }
    @Data
    public static class LoginDTO {
        private String username;
        private String password; // 암호화 필요
    }

    @Data
    public static class UpdateDTO {
        private String username;
        private String password;
        private String name;
        private String birthdate;
        private char gender;
        private Integer phoneNumber;
        private String address;
        private String email;
        // emp
        private Boolean isEmployer;
        private Integer employerIdNumber;
        private String businessName;
    }
}
