package co.edu.sena.mapping.service.dto;

import co.edu.sena.mapping.domain.enums.Condition;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class TypeDocumentDto {

	private Integer id;
	private String initial;
	private String documentName;
	private Condition typeDocumentState;
}
