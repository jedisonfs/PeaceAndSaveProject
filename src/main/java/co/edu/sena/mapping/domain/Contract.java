package co.edu.sena.mapping.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = ("contract"), schema = ("surrogate"), uniqueConstraints = {
		@UniqueConstraint(name = ("uk_contnum_contye"), columnNames = { ("contract_number"), ("contract_year") }) })
public class Contract {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = ("id"))
	private Integer id;

	@NotNull
	@Column(name = ("contract_number"), nullable = false)
	private Integer contractNumber;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = ("contract_year"), nullable = false)
	private Date contractYear;

	@OneToMany(mappedBy = ("contractId"),cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<InstructorContract> instructorContractsList;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getContractNumber() {
		return contractNumber;
	}

	public void setContractNumber(Integer contractNumber) {
		this.contractNumber = contractNumber;
	}

	public Date getContractYear() {
		return contractYear;
	}

	public void setContractYear(Date contractYear) {
		this.contractYear = contractYear;
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
		Contract other = (Contract) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}