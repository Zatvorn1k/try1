package com.demoex.try2.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class UserDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Size(min = 3, max = 15, message = "Логин должно быть от 3 до 15 символов")
    private String username;
    @NotEmpty
    @Size(min = 3, max = 15, message = "Имя должно быть от 3 до 15 символов")
    private String name;
    @NotEmpty
    @Size(min = 3, max = 15, message = "Фамилия должно быть от 3 до 15 символов")
    private String surname;
    @NotEmpty
    @Size(min = 3, max = 15, message = "Отчество должно быть от 3 до 15 символов")
    private String lastname;
    @NotEmpty
    @Size(min = 10, max = 11, message = "Номер телефона должен быть от 10 до 11 символов")
    private String phoneNum;
    @NotEmpty
    @jakarta.validation.constraints.Email(message = "Невалидный email")
    private String email;
    @NotEmpty
    private String password;
}
