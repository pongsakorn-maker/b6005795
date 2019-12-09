package se.g21.backend.employeesystem.entities;

import lombok.*;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
@NoArgsConstructor
@Table(name = "Role")
public class Role {
    @Id
    @SequenceGenerator(name = "Role_seq", sequenceName = "Role_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Role_seq")
    @Column(name = "Role_ID", unique = true, nullable = true)
    private @NonNull Long id;

    @Column(name = "Role")
    private @NonNull String role;

    @OneToMany(fetch = FetchType.EAGER)
    private Collection<Employee> rec;

}
