package com.sheinahamisi.ladies.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SalonDto {
    private String name;
    private String image;
    private String location;
    private String phone;
    private Integer ratings;
    private String workingHours;
}
