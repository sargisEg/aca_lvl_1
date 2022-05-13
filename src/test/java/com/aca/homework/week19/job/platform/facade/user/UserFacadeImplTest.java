package com.aca.homework.week19.job.platform.facade.user;

import com.aca.homework.week19.job.platform.entity.User;
import com.aca.homework.week19.job.platform.repository.UserRepository;
import com.aca.homework.week19.job.platform.service.core.CreateUserParams;
import com.aca.homework.week19.job.platform.service.core.UpdateUserParams;
import com.aca.homework.week19.job.platform.service.core.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class UserFacadeImplTest {

    private UserFacade testSubject;

    @Mock
    private UserService userService;

    @Mock
    private UserMapper userMapper;

    @BeforeEach
    public void init() {
        testSubject = new UserFacadeImpl(userService, userMapper);
    }

    @Test
    public void testSignUpWhenNull() {
        Assertions.assertThatThrownBy(() -> testSubject.signUp(null))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testGetUserDetailsWhenNull() {
        Assertions.assertThatThrownBy(() -> testSubject.getUserDetails(null))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testOpenToWorkDetailsWhenNull() {
        Assertions.assertThatThrownBy(() -> testSubject.openToWork(null))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testGetUserDetailsWhenNotFound() {

        when(userService.findById(1L)).thenReturn(Optional.empty());

        final UserDetailsDto expectedDto = new UserDetailsDto(List.of("User with id - 1 does not exist"));

        Assertions.assertThat(testSubject.getUserDetails(1L))
                .isEqualTo(expectedDto);

        verify(userService).findById(1L);
        verifyNoMoreInteractions(userService, userMapper);
    }

    @Test
    public void testGetUserDetails() {

        final User userForReturn = new User("username", "name", false);
        userForReturn.setId(1L);
        when(userService.findById(1L)).thenReturn(Optional.of(userForReturn));

        when(userMapper.map(userForReturn)).thenReturn(new UserDetailsDto(
                1L,
                "username",
                "name",
                false
        ));

        final UserDetailsDto expectedDto = new UserDetailsDto(
                1L,
                "username",
                "name",
                false
        );

        Assertions.assertThat(testSubject.getUserDetails(1L))
                .isEqualTo(expectedDto);

        verify(userService).findById(1L);
        verify(userMapper).map(userForReturn);
        verifyNoMoreInteractions(userService, userMapper);
    }

    @Test
    public void testSignUpWhenAlreadyExist() {

        when(userService.findByUsername("username")).thenReturn(Optional.of(new User("username", "n", false)));

        final UserDetailsDto expectedDto = new UserDetailsDto(List.of("User with username - username already exist"));

        Assertions.assertThat(testSubject.signUp(new UserSignUpRequestDto("username", "name")))
                .isEqualTo(expectedDto);

        verify(userService).findByUsername("username");
        verifyNoMoreInteractions(userService, userMapper);
    }

    @Test
    public void testSignUp() {

        when(userService.findByUsername("username")).thenReturn(Optional.empty());

        final User userForReturn = new User("username", "name", false);
        userForReturn.setId(1L);
        when(userService.create(new CreateUserParams("username", "name", false)))
                .thenReturn(userForReturn);

        when(userMapper.map(userForReturn)).thenReturn(new UserDetailsDto(
                1L,
                "username",
                "name",
                false
        ));

        final UserDetailsDto expectedDto = new UserDetailsDto(
                1L,
                "username",
                "name",
                false
        );

        Assertions.assertThat(testSubject.signUp(new UserSignUpRequestDto("username", "name")))
                .isEqualTo(expectedDto);

        verify(userService).findByUsername("username");
        verify(userService).create(new CreateUserParams("username", "name", false));
        verify(userMapper).map(userForReturn);
        verifyNoMoreInteractions(userService, userMapper);
    }

    @Test
    public void testOpenToWorkWhenNotFound() {

        when(userService.findById(1L)).thenReturn(Optional.empty());

        final UserDetailsDto expectedDto = new UserDetailsDto(List.of("User with id - 1 does not exist"));

        Assertions.assertThat(testSubject.openToWork(1L))
                .isEqualTo(expectedDto);

        verify(userService).findById(1L);
        verifyNoMoreInteractions(userService, userMapper);
    }

    @Test
    public void testOpenToWorkWhenAlreadyOpened() {

        final User userForReturn = new User("username", "name", true);
        userForReturn.setId(1L);
        when(userService.findById(1L)).thenReturn(Optional.of(userForReturn));

        final UserDetailsDto expectedDto = new UserDetailsDto(List.of("User with id - 1 already open for offers"));

        Assertions.assertThat(testSubject.openToWork(1L))
                .isEqualTo(expectedDto);

        verify(userService).findById(1L);
        verifyNoMoreInteractions(userService, userMapper);
    }

    @Test
    public void testOpenToWork() {

        final User userForReturn = new User("username", "name", false);
        userForReturn.setId(1L);
        when(userService.findById(1L)).thenReturn(Optional.of(userForReturn));

        final User updatedUserForReturn = new User("username", "name", true);
        updatedUserForReturn.setId(1L);
        when(userService.update(new UpdateUserParams(
                1L,
                "username",
                "name",
                true
        ))).thenReturn(updatedUserForReturn);

        when(userMapper.map(updatedUserForReturn)).thenReturn(new UserDetailsDto(
                1L,
                "username",
                "name",
                true
        ));

        final UserDetailsDto expectedDto = new UserDetailsDto(
                1L,
                "username",
                "name",
                true
        );

        Assertions.assertThat(testSubject.openToWork(1L))
                .isEqualTo(expectedDto);

        verify(userService).findById(1L);
        verify(userService).update(new UpdateUserParams(
                1L,
                "username",
                "name",
                true
        ));
        verify(userMapper).map(updatedUserForReturn);
        verifyNoMoreInteractions(userService, userMapper);
    }

}