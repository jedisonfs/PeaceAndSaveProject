package co.edu.sena.mapping.domain;

import co.edu.sena.mapping.domain.enums.Condition;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = ("regional"), schema = ("surrogate"), uniqueConstraints = {
		@UniqueConstraint(name = ("ux_regional_regional_code"), columnNames = ("regional_code")) })
public class Regional {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = ("id"))
	private Integer id;

	@NotNull
	@Column(name = ("regional_code"), nullable = false)
	private Integer regionalCode;

	@NotNull
	@Column(name = ("regional_name"), length = 40, nullable = false)
	private String regionalName;

	@NotNull
	@Column(name = ("regional_state"), nullable = false)
	private Condition regionalState;

	@OneToMany(mappedBy = ("regionalId"),cascade = CascadeType.ALL)
	private List<TrainingCenter> trainingCenterList;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRegionalCode() {
		return regionalCode;
	}

	public void setRegionalCode(Integer regionalCode) {
		this.regionalCode = regionalCode;
	}

	public String getRegionalName() {
		return regionalName;
	}

	public void setRegionalName(String regionalName) {
		this.regionalName = regionalName;
	}

	public Condition getRegionalState() {
		return regionalState;
	}

	public void setRegionalState(Condition regionalState) {
		this.regionalState = regionalState;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Regional other = (Regional) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
