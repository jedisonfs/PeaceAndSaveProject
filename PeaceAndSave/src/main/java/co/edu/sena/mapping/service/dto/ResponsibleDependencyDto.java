package co.edu.sena.mapping.service.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class ResponsibleDependencyDto {

	private Integer id;
	private String responsibleState;
	private String documentNumber;
	private String firstName;
	private String firstSurname;
	private String initial;
	private String documentName;
	private String depencendyName;
	private String dependencyUbication;
}
