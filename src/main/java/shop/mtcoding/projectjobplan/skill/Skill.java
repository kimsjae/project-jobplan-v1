package shop.mtcoding.projectjobplan.skill;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "skill_tb")
public class Skill { // Tech Stack
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer userId; // null 허용  -> 5
    private Integer employerId; // 1          -> null  채용공고로 옮김.

    private String skillName;
}
