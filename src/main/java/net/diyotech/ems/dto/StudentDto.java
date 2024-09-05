package net.diyotech.ems.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class StudentDto {
    private Long id;
    private String fullName;
    private String email;
    private String gender;
}
