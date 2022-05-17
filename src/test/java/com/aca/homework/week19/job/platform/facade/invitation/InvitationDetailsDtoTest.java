package com.aca.homework.week19.job.platform.facade.invitation;

import com.aca.homework.week19.job.platform.entity.InvitationState;
import com.aca.homework.week19.job.platform.facade.organization.OrganizationDto;
import com.aca.homework.week19.job.platform.facade.user.UserDetailsDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class InvitationDetailsDtoTest {

    @Test
    public void testWhenErrorIsNull() {
        Assertions.assertThatThrownBy(() -> new InvitationDetailsDto(null))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testWhenIdIsNull() {
        Assertions.assertThatThrownBy(() ->
                        new InvitationDetailsDto(
                                null,
                                InvitationState.ACCEPTED,
                                new OrganizationDto(List.of("")),
                                new UserDetailsDto(List.of(""))
                        )
                )
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testWhenInvitationStatusIsNull() {
        Assertions.assertThatThrownBy(() ->
                        new InvitationDetailsDto(
                                1L,
                                null,
                                new OrganizationDto(List.of("")),
                                new UserDetailsDto(List.of(""))
                        )
                )
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testWhenOrganizationDetailsDtoIsNull() {
        Assertions.assertThatThrownBy(() ->
                        new InvitationDetailsDto(
                                1L,
                                InvitationState.ACCEPTED,
                                null,
                                new UserDetailsDto(List.of(""))
                        )
                )
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testWhenUserDetailsDtoIsNull() {
        Assertions.assertThatThrownBy(() ->
                        new InvitationDetailsDto(
                                1L,
                                InvitationState.ACCEPTED,
                                new OrganizationDto(List.of("")),
                                null
                        )
                )
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

}