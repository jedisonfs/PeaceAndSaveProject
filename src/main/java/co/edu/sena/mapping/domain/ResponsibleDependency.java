package co.edu.sena.mapping.domain;

import co.edu.sena.mapping.domain.enums.Condition;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = ("responsible_dependency"), schema = ("surrogate"), uniqueConstraints = {
        @UniqueConstraint(name = ("ux_custid"), columnNames = ("customer_id"))})
public class ResponsibleDependency {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = ("id"))
    private Integer id;

    @NotNull
    @Column(name = ("responsible_state"), nullable = false)
    private Condition responsibleState;

    @NotNull
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = ("customer_id"), foreignKey = @ForeignKey(name = ("fk_responsible_dependency_customer_id")), referencedColumnName = ("id"), nullable = false)
    private Customer customerId;

    @NotNull
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = ("dependency_id"), foreignKey = @ForeignKey(name = ("fk_responsible_dependency_dependency_id")), referencedColumnName = ("id"), nullable = false)
    private Dependency dependencyId;

    @OneToMany(mappedBy = ("responsibleDependencyId"), cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PeaceAndSave> peaceAndSaveList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Condition getResponsibleState() {
        return responsibleState;
    }

    public void setResponsibleState(Condition responsibleState) {
        this.responsibleState = responsibleState;
    }

    public Customer getCustomer() {
        return customerId;
    }

    public void setCustomer(Customer customerId) {
        this.customerId = customerId;
    }

    public Dependency getDependency() {
        return dependencyId;
    }

    public void setDependency(Dependency dependencyId) {
        this.dependencyId = dependencyId;
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
        ResponsibleDependency other = (ResponsibleDependency) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
