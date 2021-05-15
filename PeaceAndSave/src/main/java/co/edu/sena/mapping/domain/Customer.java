package co.edu.sena.mapping.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = ("customer"), schema = ("surrogate"), uniqueConstraints = {
        @UniqueConstraint(name = ("uk_docunum_tydoc"), columnNames = {("document_number"), ("type_document_id")}),
        @UniqueConstraint(name = ("ux_customer_user_id"), columnNames = ("document_number"))})
public class Customer {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = ("id"))
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Column(name = ("document_number"), length = 15, nullable = false)
    private String documentNumber;

    @NotNull
    @Column(name = ("first_name"), length = 20, nullable = false)
    private String firstName;

    @Column(name = ("second_name"), length = 20)
    private String secondName;

    @NotNull
    @Column(name = ("first_surname"), length = 20, nullable = false)
    private String firstSurname;

    @Column(name = ("second_surname"), length = 20)
    private String secondSurname;

    @Column(name = ("photo"))
    private int photo;

    @Column(name = ("photo_content_type"))
    private String photoContentType;

    @Column(name = ("firm_responsible"))
    private String firmResponsible;

    @Column(name = ("firm_responsible_content_type"))
    private String firmResponsibleContentType;

    @JsonIgnore
    @NotNull
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = ("type_document_id"), nullable = false, foreignKey = @ForeignKey(name = ("fk_customer_type_document_id")), referencedColumnName = ("id"))
    private TypeDocument typeDocumentId;

    @JsonIgnore
    @NotNull
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = ("user_id"), nullable = false, foreignKey = @ForeignKey(name = ("fk_customer_user_id")), referencedColumnName = ("id"))
    private User userId;

    @OneToMany(mappedBy = ("customerId"), fetch = FetchType.LAZY)
    private List<Instructor> instructor;

    @OneToMany(mappedBy = "customerId", cascade = CascadeType.ALL)
    private List<ResponsibleDependency> responsibleDependencies;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFirstSurname() {
        return firstSurname;
    }

    public void setFirstSurname(String firstSurname) {
        this.firstSurname = firstSurname;
    }

    public String getSecondSurname() {
        return secondSurname;
    }

    public void setSecondSurname(String secondSurname) {
        this.secondSurname = secondSurname;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getPhotoContentType() {
        return photoContentType;
    }

    public void setPhotoContentType(String photoContentType) {
        this.photoContentType = photoContentType;
    }

    public String getFirmResponsible() {
        return firmResponsible;
    }

    public void setFirmResponsible(String firmResponsible) {
        this.firmResponsible = firmResponsible;
    }

    public String getFirmResponsibleContentType() {
        return firmResponsibleContentType;
    }

    public void setFirmResponsibleContentType(String firmResponsibleContentType) {
        this.firmResponsibleContentType = firmResponsibleContentType;
    }

    public TypeDocument getTypeDocument() {
        return typeDocumentId;
    }

    public void setTypeDocument(TypeDocument typeDocumentId) {
        this.typeDocumentId = typeDocumentId;
    }

    public User getUser() {
        return userId;
    }

    public void setUser(User userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
