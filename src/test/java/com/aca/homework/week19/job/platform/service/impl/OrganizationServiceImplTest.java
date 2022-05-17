package com.aca.homework.week19.job.platform.service.impl;

import com.aca.homework.week19.job.platform.entity.Organization;
import com.aca.homework.week19.job.platform.repository.OrganizationRepository;
import com.aca.homework.week19.job.platform.service.core.organization.CreateOrganizationParams;
import com.aca.homework.week19.job.platform.service.core.organization.OrganizationService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrganizationServiceImplTest {

    private OrganizationService organizationService;

    @Mock
    private OrganizationRepository organizationRepository;

    @BeforeEach
    public void init() {
        organizationService = new OrganizationServiceImpl(organizationRepository);
    }

    @Test
    public void testCreateWhenParamsIsNull() {
        Assertions.assertThatThrownBy(() -> organizationService.create(null))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testFindByIdWhenIdIsNull() {
        Assertions.assertThatThrownBy(() -> organizationService.findById(null))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testFindByNameWhenNameIsNull() {
        Assertions.assertThatThrownBy(() -> organizationService.findByName(null))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testFindByNameWhenNameIsEmpty() {
        Assertions.assertThatThrownBy(() -> organizationService.findByName(""))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testCreate() {
        final Organization organizationForReturn = new Organization("name", LocalDate.now());
        organizationForReturn.setId(1L);
        when(organizationRepository.save(new Organization("name", LocalDate.now())))
                .thenReturn(organizationForReturn);

        final Organization resultExpected = new Organization("name", LocalDate.now());
        resultExpected.setId(1L);
        final Organization resultActual = organizationService.create(new CreateOrganizationParams("name", LocalDate.now()));

        Assertions.assertThat(resultActual).isEqualTo(resultExpected);

        verify(organizationRepository).save(new Organization("name", LocalDate.now()));
        verifyNoMoreInteractions(organizationRepository);
    }

    @Test
    public void testFindById() {
        final Organization organizationForReturn = new Organization("name", LocalDate.now());
        organizationForReturn.setId(1L);
        when(organizationRepository.findById(1L))
                .thenReturn(Optional.of(organizationForReturn));

        final Organization resultExpected = new Organization("name", LocalDate.now());
        resultExpected.setId(1L);
        final Optional<Organization> resultActual = organizationService.findById(1L);

        Assertions.assertThat(resultActual).isEqualTo(Optional.of(resultExpected));

        verify(organizationRepository).findById(1L);
        verifyNoMoreInteractions(organizationRepository);
    }

    @Test
    public void testFindByName() {
        final Organization organizationForReturn = new Organization("name", LocalDate.now());
        organizationForReturn.setId(1L);
        when(organizationRepository.findByName("name"))
                .thenReturn(Optional.of(organizationForReturn));

        final Organization resultExpected = new Organization("name", LocalDate.now());
        resultExpected.setId(1L);
        final Optional<Organization> resultActual = organizationService.findByName("name");

        Assertions.assertThat(resultActual).isEqualTo(Optional.of(resultExpected));

        verify(organizationRepository).findByName("name");
        verifyNoMoreInteractions(organizationRepository);
    }

}