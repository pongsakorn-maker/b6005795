package se.g21.backend.employeesystem.entities;

import lombok.*;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

@Data
@Entity
@NoArgsConstructor
@Table(name = "Employee")
public class Employee {
	@Id
	@SequenceGenerator(name = "Employee_seq", sequenceName = "Employee_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Employee_seq")
	@Column(name = "Employee_ID", unique = true, nullable = true)
	private @NonNull Long id;

	private @NonNull String firstname;

	private @NonNull String lastname;

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Employee.class)
	@JoinColumn(name = "Nametitle_ID", insertable = true)
	private @NonNull Nametitle nametitle;

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Employee.class)
	@JoinColumn(name = "Gender_ID", insertable = true)
	private @NonNull Gender gender;
}
