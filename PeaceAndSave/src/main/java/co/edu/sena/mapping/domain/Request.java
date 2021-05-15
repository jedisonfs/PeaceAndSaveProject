package co.edu.sena.mapping.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = ("request"), schema = ("surrogate"), uniqueConstraints = {
		@UniqueConstraint(name = ("ux_request_instructor_contract_id"), columnNames = { ("instructor_contract_id") }) })
public class Request {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = ("id"))
	private Integer id;

	@Column(name = ("slopes"), length = 300)
	private String slopes;

	@NotNull
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name = ("instructor_contract_id"), foreignKey = @ForeignKey(name = ("fk_request_instructor_contract_id")), referencedColumnName = ("id"), nullable = false)
	private InstructorContract instructorContractId;

	@NotNull
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = ("causal_termination_id"), foreignKey = @ForeignKey(name = ("fk_request_causal_termination_id")), referencedColumnName = ("id"), nullable = false)
	private CausalTermination causalTerminationId;

	@OneToMany(mappedBy = ("requestId"),cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<PeaceAndSave> peaceAndSaveList;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSlopes() {
		return slopes;
	}

	public void setSlopes(String slopes) {
		this.slopes = slopes;
	}

	public InstructorContract getInstructorContract() {
		return instructorContractId;
	}

	public void setInstructorContract(InstructorContract instructorContractId) {
		this.instructorContractId = instructorContractId;
	}

	public CausalTermination getCausalTermination() {
		return causalTerminationId;
	}

	public void setCausalTermination(CausalTermination causalTerminationId) {
		this.causalTerminationId = causalTerminationId;
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
		Request other = (Request) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
