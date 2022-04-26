package com.aca.homework.week16.organization;


import javax.persistence.*;

@Entity
@Table(name = "ORGANIZATION_USERS")
public class OrganizationUsers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "organizationId", referencedColumnName = "id")
    private Organization organization;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id", unique = true)
    private User user;

    public OrganizationUsers() {
    }

    public OrganizationUsers(Organization organization, User user) {
        this.organization = organization;
        this.user = user;
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
