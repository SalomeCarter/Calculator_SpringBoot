package com.example.calculator_springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    //    @NotBlank(message = "Not Black")
//    @NotEmpty(message = "Not Empty")
    private String name;

    //    @NotBlank(message = "Not Black")
//    @NotEmpty(message = "Not Empty")
    private String username;

    //    @NotBlank(message = "Not Black")
//    @NotEmpty(message = "Not Empty")
    private String password;


    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


}
