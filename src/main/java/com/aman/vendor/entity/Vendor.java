package com.aman.vendor.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Name can't be blank")
    private String name;

    @NotBlank(message = "Address can't be blank")
    @Size(max = 100)
    private String address;

    @NotBlank(message = "City can't be blank")
    @Size(max = 100)
    private String city;

    @NotBlank(message = "State can't be blank")
    @Size(max = 100)
    private String state;

    @NotBlank(message = "Pincode can't be blank")
    @Column(name = "pin_code", nullable = false)
    @Size(min = 6, max = 6)
    @Pattern(regexp = "\\d{6}")
    private String pin_code;

    @NotBlank(message = "email can't be blank")
    @Column(name = "email", nullable = false, unique = true)
    @Size(max = 255)
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
    private String email;

    @NotBlank(message = "Phone number can't be blank")
    @Column(name = "phone_number", nullable = false)
    @Size(min = 10, max = 10)
    @Pattern(regexp = "\\d{10}")
    private String phone_number;

    private String unique_code;

}
