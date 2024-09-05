package net.diyotech.ems.entity;

import jakarta.persistence.*;
import lombok.*;

//@Data->@Getter  @Setter @ToString @RequiredArgsConstructor @EqualsAndHashCode
@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
//@Table(name = "STD")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name = "student_id")
    private Long id;


    private String fullName;

    //@Column(name = "email_address")
    private String email;

    private String gender;

    private String phone;

    private String address;
}
