package com.example.btlappmuasambe.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
public class UserGroup implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "nvarchar(max)")
    private String name;

    public UserGroup(String name) {
        this.name = name;
    }

    public UserGroup(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
