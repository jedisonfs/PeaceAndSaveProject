package co.edu.sena.mapping.domain;

import co.edu.sena.mapping.domain.enums.Condition;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = ("instructor_contract"), schema = ("surrogate"), uniqueConstraints = {
        @UniqueConstraint(name = ("uk_contid_instid"), columnNames = {("contract_id"), ("instructor_id")})})
public class InstructorContract {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = ("id"))
    private Integer id;

    @NotNull
    @Column(name = ("contract_state"), nullable = false)
    private Condition contractState;

    @NotNull
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = ("contract_id"), foreignKey = @ForeignKey(name = ("fk_instructor_contract_contract_id")), referencedColumnName = ("id"), nullable = false)
    private Contract contractId;

    @NotNull
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = ("instructor_id"), foreignKey = @ForeignKey(name = ("fk_instructor_contract_instructor_id")), referencedColumnName = ("id"), nullable = false)
    private Instructor instructorId;

    @OneToMany(mappedBy = ("instructorContractId"), cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Request> requestsList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Condition getContractState() {
        return contractState;
    }

    public void setContractState(Condition constractState) {
        this.contractState = constractState;
    }

    public Contract getContract() {
        return contractId;
    }

    public void setContract(Contract contractId) {
        this.contractId = contractId;
    }

    public Instructor getInstructor() {
        return instructorId;
    }

    public void setInstructor(Instructor instructorId) {
        this.instructorId = instructorId;
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
        InstructorContract other = (InstructorContract) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
