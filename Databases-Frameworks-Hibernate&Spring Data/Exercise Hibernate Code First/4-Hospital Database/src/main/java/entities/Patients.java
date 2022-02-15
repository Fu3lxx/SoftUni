package entities;

import entities.interfaces.BaseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table (name = "patients")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Patients extends BaseEntity {

    private String firstName;
    private String lastName;
    private String address;
    private LocalDateTime dateOfBirth;
    private byte[] picture;
    private boolean hasInsurance;
    private Set<Visitations> visitations;
    private Set<Diagnose> diagnoses;
    private Set<Medicament> medicaments;

    public Patients(String firstName, String lastName, String address
            , LocalDateTime dateOfBirth, boolean hasInsurance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.hasInsurance = hasInsurance;
    }

    public Patients(String firstName, String lastName, String address
            , LocalDateTime dateOfBirth, byte[] picture, boolean hasInsurance) {
        this(firstName,lastName,address,dateOfBirth,hasInsurance);
        this.picture = picture;
    }

    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "address", nullable = false)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "date_of_birth", nullable = false)
    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Lob
    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    @Column(name = "has_insurance")
    public boolean isHasInsurance() {
        return hasInsurance;
    }

    public void setHasInsurance(boolean hasInsurance) {
        this.hasInsurance = hasInsurance;
    }

    @OneToMany(targetEntity = Visitations.class)

    public Set<Visitations> getVisitations() {
        return visitations;
    }

    public void setVisitations(Set<Visitations> visitations) {
        this.visitations = visitations;
    }

    @ManyToMany(targetEntity = Diagnose.class)
    @JoinColumn(name = "diagnose_id",referencedColumnName = "id")
    public Set<Diagnose> getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(Set<Diagnose> diagnoses) {
        this.diagnoses = diagnoses;
    }

    @ManyToMany(targetEntity = Medicament.class)
    @JoinColumn(name = "medicament_id",referencedColumnName = "id")
    public Set<Medicament> getMedicaments() {
        return medicaments;
    }

    public void setMedicaments(Set<Medicament> medicaments) {
        this.medicaments = medicaments;
    }
}
