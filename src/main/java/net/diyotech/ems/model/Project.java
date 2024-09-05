package net.diyotech.ems.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Project {
    private String name;
    private Double budget;
    private Float duration;
}
