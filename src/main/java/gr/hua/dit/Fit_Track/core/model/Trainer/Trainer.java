package gr.hua.dit.Fit_Track.core.model;

import java.time.Instant;

import static gr.hua.dit.Fit_Track.core.model.Type.TRAINER;

public class Trainer {

    private Long id;

    private String firstName;

    private String lastName;

    private int age;

    private Type type;

    private String emailAddress;

    private String mobilePhoneNumber;

    private String passwordHash;

    private String specialization; // type of sport or type of training

    private String area; //area where a trainer does his work

    private Instant createdAt; //when he was created

    public Trainer(Long id, Instant createdAt, String firstName, String lastName, int age,Type type, String emailAddress,
                   String mobilePhoneNumber, String passwordHash, String specialization, String area) {
        this.id = id;
        this.createdAt = createdAt;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.type = TRAINER;
        this.emailAddress = emailAddress;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.passwordHash = passwordHash;
        this.specialization = specialization;
        this.area = area;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", emailAddress='" + emailAddress + '\'' +
                ", mobilePhoneNumber='" + mobilePhoneNumber + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", specialization='" + specialization + '\'' +
                ", area='" + area + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
