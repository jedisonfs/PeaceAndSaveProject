package co.edu.sena.mapping.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import co.edu.sena.mapping.domain.enums.Condition;

import java.util.List;

@Entity
@Table(name = ("causal_termination"), schema = ("surrogate"), uniqueConstraints = {
		@UniqueConstraint(name = ("ux_causal_termination_causal_name"), columnNames = ("causal_name")) })
public class CausalTermination {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = ("id"))
	private Integer id;

	@NotNull
	@Column(name = ("causal_name"), length = 40, nullable = false)
	private String causalName;

	@NotNull
	@Column(name = ("causal_state"), nullable = false)
	private Condition causalState;

	@OneToMany(mappedBy = ("causalTerminationId"),fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Request> requestList;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCausalName() {
		return causalName;
	}

	public void setCausalName(String causalName) {
		this.causalName = causalName;
	}

	public Condition getCausalState() {
		return causalState;
	}

	public void setCausalState(Condition causalState) {
		this.causalState = causalState;
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
		CausalTermination other = (CausalTermination) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
