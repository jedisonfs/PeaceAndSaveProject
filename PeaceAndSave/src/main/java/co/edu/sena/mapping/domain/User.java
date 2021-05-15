package co.edu.sena.mapping.domain;

import co.edu.sena.mapping.domain.enums.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = ("user"), schema = ("surrogate"),
        uniqueConstraints = {@UniqueConstraint(name = ("uk_login"), columnNames = {("login")}),
                @UniqueConstraint(name = ("uk_email"), columnNames = ("email"))}
)
public class User {
	
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = ("id"), nullable = false)
    private Integer id;

    @NotNull
    @Column(name = ("login"), length = 50, nullable = false)
    private String login;

    @NotNull
    @Column(name = ("password_hash"), length = 60, nullable = false)
    private String passwordHash;

    @NotNull
    @Column(name = ("email"), length = 191, nullable = false)
    private String email;

    @Column(name = ("image_url"), length = 256)
    private String imageUrl;

    @NotNull
    @Column(name = ("activated"), nullable = false)
    private Condition activated;

    @Column(name = ("lang_key"), length = 10)
    private String langKey;

    @Column(name = ("activated_key"), length = 20)
    private String activatedKey;

    @Column(name = ("reset_key"), length = 20)
    private String resetKey;

    @NotNull
    @Column(name = ("created_by"), length = 50, nullable = false)
    private String createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = ("create_date"))
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = ("reset_date"))
    private Date resetDate;

    @Column(name = ("last_modified_by"), length = 50)
    private String lastModifiedBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = ("last_modified_date"), length = 50)
    private Date lastModifiedDateBy;

    @JoinTable(
            name = ("user_authority"),schema = ("surrogate"),
            joinColumns = {@JoinColumn(name = ("user_id"),foreignKey = @ForeignKey(name = ("fk_user_id")),referencedColumnName = ("id"),nullable = false)},
            inverseJoinColumns = @JoinColumn(name = ("authority_name"),foreignKey = @ForeignKey(name = ("fk_authority_name")),referencedColumnName = ("name"),nullable = false)
    )
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Authority> authority;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = ("userId"))
    private Customer customer;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Condition getActivated() {
        return activated;
    }

    public void setActivated(Condition activated) {
        this.activated = activated;
    }

    public String getLangKey() {
        return langKey;
    }

    public void setLangKey(String langKey) {
        this.langKey = langKey;
    }

    public String getActivatedKey() {
        return activatedKey;
    }

    public void setActivatedKey(String activatedKey) {
        this.activatedKey = activatedKey;
    }

    public String getResetKey() {
        return resetKey;
    }

    public void setResetKey(String resetKey) {
        this.resetKey = resetKey;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getResetDate() {
        return resetDate;
    }

    public void setResetDate(Date resetDate) {
        this.resetDate = resetDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Date getLastModifiedDateBy() {
        return lastModifiedDateBy;
    }

    public void setLastModifiedDateBy(Date lastModifiedDateBy) {
        this.lastModifiedDateBy = lastModifiedDateBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
