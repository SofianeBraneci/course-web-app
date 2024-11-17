package com.curso.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "enrollments", uniqueConstraints ={
        @UniqueConstraint(name = "unique_enrollment", columnNames = {"user_id", "course_id"})
    }
)
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Enrollment {
    @Id
    @Column(name = "id", columnDefinition = "UUID", nullable = false)
    private UUID id;
    @Column(name = "user_id")
    private String userId;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Enrollment that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
