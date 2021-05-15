package co.edu.sena.mapping.service.dto;

import java.util.Date;

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
public class RequestDto {

	private Integer id;
	private String slopes;
	private Condition contractState;
	private Integer contractNumber;
	private Date contractYear;
	private String documentNumber;
	private String firstName;
	private String firstSurname;
	private String documentName;
	private String initial;
}
