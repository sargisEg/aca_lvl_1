package com.aca.homework.week19.job.platform.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "INVITATIONS")
public class Invitation {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "INVITATION_ID_SEQUENCE"
    )
    @SequenceGenerator(name = "INVITATION_ID_SEQUENCE")
    private Long id;

    @Column(name = "state", nullable = false, length = 10)
    @Enumerated(EnumType.STRING)
    private InvitationState invitationState;

    @ManyToOne
    @JoinColumn(
            name = "organization_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "FK_INVITATIONS_ORGANIZATION_ID_ID")
    )
    private Organization organization;


    @OneToOne
    @JoinColumn(
            name = "user_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "FK_INVITATIONS_USER_ID_ID")
    )
    private User user;

    public Invitation(InvitationState invitationState, Organization organization, User user) {
        this.invitationState = invitationState;
        this.organization = organization;
        this.user = user;
    }

    public Invitation() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Invitation{");
        sb.append("id=").append(id);
        sb.append(", invitationState=").append(invitationState);
        sb.append(", organization=").append(organization);
        sb.append(", user=").append(user);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Invitation)) return false;
        Invitation that = (Invitation) o;
        return Objects.equals(id, that.id) && invitationState == that.invitationState && Objects.equals(organization, that.organization) && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, invitationState, organization, user);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public InvitationState getInvitationState() {
        return invitationState;
    }

    public void setInvitationState(InvitationState invitationState) {
        this.invitationState = invitationState;
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
