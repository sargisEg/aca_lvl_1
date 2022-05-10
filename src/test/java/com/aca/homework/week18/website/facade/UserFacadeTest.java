package com.aca.homework.week18.website.facade;

import com.aca.homework.week18.website.entity.User;
import com.aca.homework.week18.website.facade.user.*;
import com.aca.homework.week18.website.service.core.CreateUserParams;
import com.aca.homework.week18.website.service.core.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class UserFacadeTest {

    private UserFacade testSubject;

    @Mock
    private UserService userService;

    private UserMapper userMapper;

    @BeforeEach
    public void init() {
        userMapper = new UserMapperImpl();
        testSubject = new UserFacadeImpl(userService, userMapper);
    }

    @Test
    public void testSignUpFirstTime() {

        final User returnUser = new User(
                "username",
                "first name",
                "second name"
        );
        returnUser.setId(1L);

        Mockito.when(
                userService.create(
                        new CreateUserParams(
                                "username",
                                "first name",
                                "second name"
                        )
                )
        ).thenReturn(returnUser);

        Mockito.when(
                userService.findByUsername("username")
        ).thenReturn(Optional.empty());

        final UserDto actualResponseDto = testSubject.signUp(
                new UserSignUpRequestDto(
                        "username",
                        "first name",
                        "second name"
                )
        );

        final UserDto exceptedResponseDto = new UserDto(
                1L,
                "username",
                "first name",
                "second name"
        );
        Assertions.assertThat(actualResponseDto).isEqualTo(exceptedResponseDto);

        Mockito.verify(userService).create(
                new CreateUserParams(
                        "username",
                        "first name",
                        "second name"
                ));
        Mockito.verify(userService).findByUsername("username");
        Mockito.verifyNoMoreInteractions(userService);
    }

    @Test
    public void testSignUpSecondTime() {
        final User returnUser = new User(
                "username",
                "first name",
                "second name"
        );
        returnUser.setId(1L);
        Mockito.when(
                userService.create(
                        new CreateUserParams(
                                "username",
                                "first name",
                                "second name"
                        )
                )
        ).thenReturn(returnUser);

        Mockito.when(
                userService.findByUsername("username")
        ).thenReturn(Optional.empty());

        testSubject.signUp(
                new UserSignUpRequestDto(
                        "username",
                        "first name",
                        "second name"
                )
        );

        Mockito.when(
                userService.findByUsername("username")
        ).thenReturn(
                Optional.of(returnUser)
        );

        final UserDto actualResponseDto = testSubject.signUp(
                new UserSignUpRequestDto(
                        "username",
                        "first name",
                        "second name"
                )
        );

        final UserDto exceptedResponseDto = new UserDto(List.of("User with username username already exist."));

        Assertions.assertThat(actualResponseDto).isEqualTo(exceptedResponseDto);

        Mockito.verify(userService).create(
                new CreateUserParams(
                        "username",
                        "first name",
                        "second name"
                ));
        Mockito.verify(userService, Mockito.times(2)).findByUsername("username");
        Mockito.verifyNoMoreInteractions(userService);
    }
}