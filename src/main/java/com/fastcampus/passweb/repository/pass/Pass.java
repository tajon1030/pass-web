package com.fastcampus.passweb.repository.pass;

import com.fastcampus.passweb.repository.BaseEntity;
import com.fastcampus.passweb.repository.packaze.Packaze;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter @Setter
@Builder
public class Pass extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer passSeq;
    private Integer packageSeq;
    private String userId;

    @Enumerated(EnumType.STRING)
    private PassStatus status;
    private Integer remainingCount;

    private LocalDateTime startedAt;
    private LocalDateTime endedAt;
    private LocalDateTime expiredAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "packageSeq", insertable = false, updatable = false)
    private Packaze packaze;
}
