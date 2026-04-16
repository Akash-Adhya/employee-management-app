package com.ems.entities;

import com.ems.enums.AccountStatus;
import com.ems.enums.Role;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true,nullable = false)
    private String email;

    @Column(unique = true,nullable = false)
    private String contactNo;

    @Column(nullable = false)
    private String password;

    private LocalDate dob;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccountStatus accountStatus = AccountStatus.ACTIVE;

    private  String imageUrl;

    @Column(nullable = false,unique = true)
    private String employeeId;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    //Embedded Objects
    @Embedded
    private Address address;

    @Embedded
    private Authentication auth;


    private LocalDateTime createdAt = LocalDateTime.now();




    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(
                new SimpleGrantedAuthority("ROLE_"+role.name())
        );
    }

    @Override
    public String getUsername() {
        return employeeId;
    }
}