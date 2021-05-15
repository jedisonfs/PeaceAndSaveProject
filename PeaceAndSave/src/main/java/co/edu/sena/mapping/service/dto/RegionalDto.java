package co.edu.sena.mapping.service.dto;

import java.io.Serializable;

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
public class RegionalDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer regionalCode;
	private String regionalName;
	private Condition regionalState;

}
