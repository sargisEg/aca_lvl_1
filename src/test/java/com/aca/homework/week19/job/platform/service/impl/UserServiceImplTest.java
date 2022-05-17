package com.aca.homework.week19.job.platform.service.impl;

import com.aca.homework.week19.job.platform.entity.User;
import com.aca.homework.week19.job.platform.repository.UserRepository;
import com.aca.homework.week19.job.platform.service.core.user.CreateUserParams;
import com.aca.homework.week19.job.platform.service.core.user.UpdateUserParams;
import com.aca.homework.week19.job.platform.service.core.user.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    public void init() {
        userService = new UserServiceImpl(userRepository);
    }

    @Test
    public void testCreateWhenParamsNull() {
        Assertions.assertThatThrownBy(() -> userService.create(null))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testUpdateWhenParamsNull() {
        Assertions.assertThatThrownBy(() -> userService.update(null))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testFindByIdWhenIdIsNull() {
        Assertions.assertThatThrownBy(() -> userService.findById(null))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testFindByUsernameWhenUsernameIsNull() {
        Assertions.assertThatThrownBy(() -> userService.findByUsername(null))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testFindByUsernameWhenUsernameIsEmpty() {
        Assertions.assertThatThrownBy(() -> userService.findByUsername(""))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testCreate() {
        final User userForReturn = new User("username", "name", false);
        userForReturn.setId(1L);
        when(
                userRepository.save(new User(
                        "username",
                        "name",
                        false
                ))
        ).thenReturn(userForReturn);

        final User userActual = userService.create(new CreateUserParams("username", "name", false));
        final User userExpected = new User("username", "name", false);
        userExpected.setId(1L);

        Assertions.assertThat(userActual).isEqualTo(userExpected);

        verify(userRepository).save(new User("username", "name", false));
        verifyNoMoreInteractions(userRepository);
    }

    @Test
    public void testUpdate() {
        final User user = new User("username", "name", false);
        user.setId(1L);
        when(
                userRepository.save(user)
        ).thenReturn(user);

        final User userActual = userService.update(new UpdateUserParams(1L, "username", "name", false));
        final User userExpected = new User("username", "name", false);
        userExpected.setId(1L);

        Assertions.assertThat(userActual).isEqualTo(userExpected);

        final User userForUpdate = new User(
                "username",
                "name",
                false
        );
        userForUpdate.setId(1L);
        verify(userRepository).save(userForUpdate);
        verifyNoMoreInteractions(userRepository);
    }

    @Test
    public void testFindById() {
        final User userForReturn = new User("username", "name", false);
        userForReturn.setId(1L);
        when(
                userRepository.findById(1L)
        ).thenReturn(Optional.of(userForReturn));

        final Optional<User> actualResult = userService.findById(1L);
        final User userExpected = new User("username", "name", false);
        userExpected.setId(1L);
        final Optional<User> expectedResult = Optional.of(userExpected);

        Assertions.assertThat(actualResult).isEqualTo(expectedResult);

        verify(userRepository).findById(1L);
        verifyNoMoreInteractions(userRepository);
    }

    @Test
    public void testFindByUsername() {
        final User userForReturn =
                new User("username", "name", false);
        userForReturn.setId(1L);
        when(
                userRepository.findByUsername("username")
        ).thenReturn(Optional.of(userForReturn));

        final Optional<User> actualResult = userService.findByUsername("username");
        final User userExpected = new User("username", "name", false);
        userExpected.setId(1L);
        final Optional<User> expectedResult = Optional.of(userExpected);

        Assertions.assertThat(actualResult).isEqualTo(expectedResult);

        verify(userRepository).findByUsername("username");
        verifyNoMoreInteractions(userRepository);
    }
}