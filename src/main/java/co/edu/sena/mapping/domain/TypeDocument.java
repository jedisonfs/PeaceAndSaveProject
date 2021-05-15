package co.edu.sena.mapping.domain;

import co.edu.sena.mapping.domain.enums.Condition;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = ("type_document"), schema = ("surrogate"), uniqueConstraints = {
		@UniqueConstraint(name = ("uk_type_document_initial"), columnNames = ("initial")),
		@UniqueConstraint(name = ("uk_type_document_document_name"), columnNames = ("document_name")) })
public class TypeDocument {

	private static final long serialVerisonUID = 1L;

	@Id
	@Column(name = ("id"))
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NotNull
	@Column(name = ("initial"), length = 6, nullable = false)
	private String initial;

	@NotNull
	@Column(name = ("document_name"), length = 30, nullable = false)
	private String documentName;

	@NotNull
	@Column(name = ("type_document_state"), nullable = false)
	private Condition typeDocumentState;
	
	@OneToMany(mappedBy = ("typeDocumentId"),cascade = CascadeType.ALL)
	private List<Customer> customerList;

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setInitil(String initial) {
		this.initial = initial;
	}

	public String getInitial() {
		return initial;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setTypeDocumentState(Condition condition) {
		this.typeDocumentState = condition;
	}

	public Condition getTypeDocumentState() {
		return typeDocumentState;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TypeDocument that = (TypeDocument) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
