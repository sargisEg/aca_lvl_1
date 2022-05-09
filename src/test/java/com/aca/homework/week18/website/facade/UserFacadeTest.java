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

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class UserFacadeTest {

    private UserFacade testSubject;

    @Mock
    private UserService userService;

    @BeforeEach
    public void init() {
        testSubject = new UserFacadeImpl(userService);
    }

    @Test
    public void testSignUpFirstTime() {

        final UserSignUpResponseDto exceptedResponseDto = new UserSignUpResponseDto(
                1L,
                "username"
        );

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

        final UserSignUpResponseDto actualResponseDto = testSubject.signUp(
                new UserSignUpRequestDto(
                        "username",
                        "first name",
                        "second name"
                )
        );

        Assertions.assertThat(actualResponseDto).isEqualTo(exceptedResponseDto);
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

        Assertions.assertThatThrownBy(() -> {
            testSubject.signUp(
                    new UserSignUpRequestDto(
                            "username",
                            "first name",
                            "second name"
                    )
            );
        }).isExactlyInstanceOf(UserAlreadyExistException.class);
    }
}