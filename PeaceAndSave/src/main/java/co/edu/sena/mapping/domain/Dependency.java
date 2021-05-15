package co.edu.sena.mapping.domain;

import co.edu.sena.mapping.domain.enums.Condition;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = ("dependency"), schema = ("surrogate"), uniqueConstraints = {
        @UniqueConstraint(name = ("uk_depnam_traigcentid"), columnNames = {("dependency_name"),
                ("training_center_id")})})
public class Dependency {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = ("id"))
    private Integer id;

    @NotNull
    @Column(name = ("dependency_name"), length = 60, nullable = false)
    private String dependencyName;

    @NotNull
    @Column(name = ("dependency_state"), nullable = false)
    private Condition dependencyState;

    @NotNull
    @Column(name = ("dependency_ubication"), length = 40, nullable = false)
    private String dependencyUbication;

    @NotNull
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = ("training_center_id"), foreignKey = @ForeignKey(name = ("fk_dependency_training_center_id")), referencedColumnName = ("id"), nullable = false)
    private TrainingCenter trainingCenterId;

    @OneToMany(mappedBy = ("dependencyId"), cascade = CascadeType.ALL)
    private List<ResponsibleDependency> dependencylist;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDependencyName() {
        return dependencyName;
    }

    public void setDependencyName(String dependencyName) {
        this.dependencyName = dependencyName;
    }

    public Condition getDependencyState() {
        return dependencyState;
    }

    public void setDependencyState(Condition dependencyState) {
        this.dependencyState = dependencyState;
    }

    public String getDependencyUbication() {
        return dependencyUbication;
    }

    public void setDependencyUbication(String dependencyUbication) {
        this.dependencyUbication = dependencyUbication;
    }

    public TrainingCenter getTrainingCenter() {
        return trainingCenterId;
    }

    public void setTrainingCenter(TrainingCenter trainingCenterId) {
        this.trainingCenterId = trainingCenterId;
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
        Dependency other = (Dependency) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
