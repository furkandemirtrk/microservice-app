package com.demirturk.accountservice.entity;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
@Table(value = "account")
public class Account implements Serializable {

    @PrimaryKey
    private final String id = UUID.randomUUID().toString();

    @Setter
    @Column(value = "uname")
    private String username;

    @Setter
    @Column(value = "email")
    private String email;

    @Setter
    @Column(value = "pwd")
    private String password;

    @Column(value = "created_at")
    private LocalDateTime createdAt;

    @Column(value = "is_active")
    private Boolean active;
}
