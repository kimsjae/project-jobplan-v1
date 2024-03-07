package shop.mtcoding.projectjobplan.resume;

import lombok.Data;

import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;

public class ResumeResponse {
    @Data
    public static class ResumeAndUserDTO{
        private Integer id;
        private Integer userId; // writtenBy
        private String title;
        private String content; // cv, cover letter 자기소개서
        private String career; // 회사명+경력

        private String address;

        // employer, 사업자 항목 nullable
        private boolean isEmployer; // 사업자인지
        private String name ;
    }

    @Data
    public static class ResumeDetailDTO{
        private String username;
        private String birthdate;
        private String address;
        private String phoneNumber;
        private String email;

        private Integer resumeUserId;
        private String title;
        private String content;
        private String schoolName;
        private String major;
        private String educationLevel;
        private String career;

        public String getBirthyear() { // 생년까지만 출력
            return birthdate.substring(0, 4);
        }
    }
}



