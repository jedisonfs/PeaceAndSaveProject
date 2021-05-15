package co.edu.sena.mapping.domain;

import co.edu.sena.mapping.domain.enums.Condition;
import org.hibernate.boot.model.source.spi.FetchCharacteristics;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = ("instructor"), schema = ("surrogate"), uniqueConstraints = {
        @UniqueConstraint(name = ("ux_instructor_customer_id"), columnNames = ("customer_id"))})
public class Instructor {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = ("id"))
    private Integer id;

    @NotNull
    @Column(name = ("instructor_state"), nullable = false)
    private Condition instructorState;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL,optional = false)
    @JoinColumn(name = ("customer_id"), foreignKey = @ForeignKey(name = ("fk_instructor_customer_id")), referencedColumnName = ("id"), nullable = false)
    private Customer customerId;

    @OneToMany(mappedBy = ("instructorId"), fetch = FetchType.LAZY)
    private List<InstructorContract> instructorContractsList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Condition getInstructorState() {
        return instructorState;
    }

    public void setInstructorState(Condition instructorState) {
        this.instructorState = instructorState;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
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
        Instructor other = (Instructor) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
