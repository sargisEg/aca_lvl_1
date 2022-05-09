package com.aca.homework.week18.website;

import com.aca.homework.week18.website.entity.Image;
import com.aca.homework.week18.website.entity.User;
import com.aca.homework.week18.website.facade.post.*;
import com.aca.homework.week18.website.facade.user.UserFacade;
import com.aca.homework.week18.website.facade.user.UserFacadeImpl;
import com.aca.homework.week18.website.facade.user.UserSignUpRequestDto;
import com.aca.homework.week18.website.repository.ImageRepository;
import com.aca.homework.week18.website.repository.PostRepository;
import com.aca.homework.week18.website.repository.UserRepository;
import com.aca.homework.week18.website.service.core.*;
import com.aca.homework.week18.website.service.impl.ImageServiceImpl;
import com.aca.homework.week18.website.service.impl.PostServiceImpl;
import com.aca.homework.week18.website.service.impl.UserServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@SpringBootApplication
@EnableJpaRepositories
public class Main {

    public static void main(String[] args) {
        final ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
        UserRepository userRepository = context.getBean(UserRepository.class);
        ImageRepository imageRepository = context.getBean(ImageRepository.class);
        PostRepository postRepository = context.getBean(PostRepository.class);

        UserService userService = new UserServiceImpl(userRepository);
        ImageService imageService = new ImageServiceImpl(imageRepository);
        PostService postService = new PostServiceImpl(postRepository, userService, imageService);

        UserFacade userFacade = new UserFacadeImpl(userService);
        PostFacade postFacade = new PostFacadeImpl(postService, userService, imageService);


        userFacade.signUp(
                new UserSignUpRequestDto(
                        "username1",
                        "first1",
                        "second1"
                )
        );

        userFacade.signUp(
                new UserSignUpRequestDto(
                        "username2",
                        "first2",
                        "second2"
                )
        );

        postFacade.create(
                new PostCreateRequestDto(
                        "username1",
                        "title",
                        "description",
                        List.of(new Image("BB123BB"), new Image("AAA4456"))
                )
        );

        postFacade.create(
                new PostCreateRequestDto(
                        "username1",
                        "title2",
                        "description3",
                        List.of(new Image("BBa123BB"), new Image("AAA4456"))
                )
        );

        postFacade.getAllUserPosts(
                new GetAllUserPostsRequestDto("username1")
        );
    }
}
