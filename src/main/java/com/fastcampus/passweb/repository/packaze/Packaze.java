package com.fastcampus.passweb.repository.packaze;

import com.fastcampus.passweb.repository.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString
@Table(name = "package")
public class Packaze extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer packageSeq;

    private String packageName;
    private Integer count;
    private Integer period;
}
