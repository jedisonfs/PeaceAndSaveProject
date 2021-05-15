package co.edu.sena.mapping.service.dto;

import co.edu.sena.mapping.domain.enums.Condition;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class UserDto {

	private Integer id;
	private String login;
	private String email;
	private Condition activited;
	private String createBy;
}
