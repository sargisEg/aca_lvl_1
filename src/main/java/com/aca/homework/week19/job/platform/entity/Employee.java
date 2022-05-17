package com.aca.homework.week19.job.platform.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "EMPLOYEES")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMPLOYER_ID_SEQUENCE")
    @SequenceGenerator(name = "EMPLOYER_ID_SEQUENCE")
    private Long id;

    @ManyToOne
    @JoinColumn(
            name = "organization_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "FK_EMPLOYEES_ORGANIZATION_ID_ID")
    )
    private Organization organization;

    @OneToOne
    @JoinColumn(
            name = "user_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "FK_EMPLOYEES_USER_ID_ID")
    )
    private User user;

    public Employee() {
    }

    public Employee(Organization organization, User user) {
        this.organization = organization;
        this.user = user;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Employer{");
        sb.append("id=").append(id);
        sb.append(", organization=").append(organization);
        sb.append(", user=").append(user);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) && Objects.equals(organization, employee.organization) && Objects.equals(user, employee.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, organization, user);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
