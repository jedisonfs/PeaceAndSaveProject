package co.edu.sena.mapping.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = ("training_center"), schema = ("surrogate"), uniqueConstraints = {
        @UniqueConstraint(name = ("uk_centcod__centnam_ux_centcod"), columnNames = ("center_code")),
        @UniqueConstraint(name = ("uk_centcod__centnam_ux_centnam"), columnNames = ("center_name"))})
public class TrainingCenter {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = ("id"))
    private Integer id;

    @NotNull
    @Column(name = ("center_code"), nullable = false)
    private Integer centerCode;

    @NotNull
    @Column(name = ("center_name"), length = 60, nullable = false)
    private String centerName;

    @NotNull
    @Column(name = ("center_anddress"), length = 60, nullable = false)
    private String centerAnddress;

    @NotNull
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = ("regional_id"), foreignKey = @ForeignKey(name = ("fk_training_center_regional_id")), referencedColumnName = ("id"), nullable = false)
    private Regional regionalId;

    @OneToMany(mappedBy = ("trainingCenterId"), cascade = CascadeType.ALL)
    private List<Dependency> dependencyList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCenterCode() {
        return centerCode;
    }

    public void setCenterCode(Integer centerCode) {
        this.centerCode = centerCode;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public String getCenterAnddress() {
        return centerAnddress;
    }

    public void setCenterAnddress(String centerAnddress) {
        this.centerAnddress = centerAnddress;
    }

    public Regional getRegional() {
        return regionalId;
    }

    public void setRegional(Regional regional) {
        this.regionalId = regional;
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
        TrainingCenter other = (TrainingCenter) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
