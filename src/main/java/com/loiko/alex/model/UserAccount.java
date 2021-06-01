package com.loiko.alex.model;

import com.loiko.alex.enumerable.Role;
import com.loiko.alex.enumerable.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import java.time.LocalDate;

/**
 * @author Alexey Loiko
 * @project user-interface
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Builder
@ToString
@EqualsAndHashCode(of = "id")
@Table(name = "user_account", schema = "user_account_storage")
public class UserAccount extends BaseEntity<Long> {

    @Size(min = 3, max = 16, message = "От 3 до 16 знаков")
    @Column(name = "username", nullable = false)
    private String username;

    @Size(min = 3, max = 16, message = "От 3 до 16 знаков")
    @Column(name = "password", nullable = false)
    private String password;

    @Size(min = 1, max = 16, message = "От 1 до 16 знаков")
    @Column(name = "first_name")
    private String firstName;

    @Size(min = 1, max = 16, message = "От 1 до 16 знаков")
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "creation_date")
    private LocalDate creationDate;

    @Transient
    private String passwordConfirm;

    public UserAccount(String username, String password, String firstName, String lastName, Role role, Status status) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.status = status;
        this.creationDate = LocalDate.now();
    }
}