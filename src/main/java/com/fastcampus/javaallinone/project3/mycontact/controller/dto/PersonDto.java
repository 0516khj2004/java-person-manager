package com.fastcampus.javaallinone.project3.mycontact.controller.dto;

import com.fastcampus.javaallinone.project3.mycontact.domain.dto.Birthday;
import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class PersonDto {
    @NotBlank(message = "이름은 필수값입니다")
    private String name;

    private String hobby;
    private String address;
    private LocalDate birthday;
    private String job;
    private String phoneNumber;

}
