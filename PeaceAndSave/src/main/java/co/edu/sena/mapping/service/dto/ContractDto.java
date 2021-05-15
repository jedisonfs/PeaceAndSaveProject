package co.edu.sena.mapping.service.dto;

import java.util.Date;

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
public class ContractDto {

	private Integer id;
	private Integer contractNumber;
	private Date contractYear;
}
