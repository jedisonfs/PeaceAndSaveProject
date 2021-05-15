package co.edu.sena.mapping.service.dto;

import co.edu.sena.mapping.domain.enums.Condition;
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
public class CustomerDto {

	private Integer id;
	private String documentNumber;
	private String firstName;
	private String firstSurname;
	private String initial;
	private String documentName;
	private String userId;
	private String login;
	private Condition activated;
	private String email;
	private Byte firmResponsible;
}
