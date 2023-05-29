package com.konyang.admin.domain.members;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Members {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String tel;

    @Column
    private String addr;

    @Builder
    public Members(String name, String tel, String addr){
        this.name = name;
        this.tel = tel;
        this.addr = addr;
    }

}
