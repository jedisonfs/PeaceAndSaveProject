package co.edu.sena.mapping.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import co.edu.sena.mapping.domain.enums.Condition;


@Entity
@Table(name = ("peace_and_save"), schema = ("surrogate"), uniqueConstraints = {
        @UniqueConstraint(name = "ux_paasav_requid", columnNames = ("request_id")),
        @UniqueConstraint(name = ("ux_paasav_respdepid"), columnNames = ("responsible_dependency_id"))})
public class PeaceAndSave {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = ("id"))
    private Integer id;

    @NotNull
    @Column(name = ("state_peace_and_save"), nullable = false)
    private Condition statePeaceAndSave;

    @Column(name = ("causal_rejection"), length = 300)
    private String causalRejection;

    @NotNull
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = ("request_id"), foreignKey = @ForeignKey(name = ("fk_peace_and_save_request_id")), referencedColumnName = ("id"), nullable = false)
    private Request requestId;

    @NotNull
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = ("responsible_dependency_id"), foreignKey = @ForeignKey(name = "fk_pace_and_save_responsible_dependency_id"), referencedColumnName = ("id"), nullable = false)
    private ResponsibleDependency responsibleDependencyId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Condition getStatePeaceAndSave() {
        return statePeaceAndSave;
    }

    public void setStatePeaceAndSave(Condition statePeaceAndSave) {
        this.statePeaceAndSave = statePeaceAndSave;
    }

    public String getCausalRejection() {
        return causalRejection;
    }

    public void setCausalRejection(String causalRejection) {
        this.causalRejection = causalRejection;
    }

    public Request getRequest() {
        return requestId;
    }

    public void setRequest(Request requestId) {
        this.requestId = requestId;
    }

    public ResponsibleDependency getResponsibleDependency() {
        return responsibleDependencyId;
    }

    public void setResponsibleDependency(ResponsibleDependency responsibleDependencyId) {
        this.responsibleDependencyId = responsibleDependencyId;
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
        PeaceAndSave other = (PeaceAndSave) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
