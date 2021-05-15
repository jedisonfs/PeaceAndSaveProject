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
public class DependencyDto {

	private Integer id;
	private String depencendyName;
	private Condition dependencyState;
	private String dependencyUbication;
	private Integer centerCode;
	private String centerName;
	private String centerAddress;
	private String reginalName;
}
