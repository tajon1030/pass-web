package com.fastcampus.passweb.repository.user;

import com.fastcampus.passweb.repository.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.*;

@Getter @Setter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends BaseEntity {

    @Id
    private String userId;

    private String userName;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    private String phone;

    private String meta;
}
