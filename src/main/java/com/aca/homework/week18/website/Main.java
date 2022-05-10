package com.aca.homework.week18.website;

import com.aca.homework.week18.website.entity.Image;
import com.aca.homework.week18.website.entity.User;
import com.aca.homework.week18.website.facade.post.*;
import com.aca.homework.week18.website.facade.post.image.ImageMapper;
import com.aca.homework.week18.website.facade.post.image.ImageMapperImpl;
import com.aca.homework.week18.website.facade.user.*;
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
        PostService postService = new PostServiceImpl(postRepository, userService);
        ImageService imageService = new ImageServiceImpl(imageRepository, postService);

        UserMapper userMapper = new UserMapperImpl();
        PostMapper postMapper = new PostMapperImpl(userMapper);
        ImageMapper imageMapper = new ImageMapperImpl();

        UserFacade userFacade = new UserFacadeImpl(userService, userMapper);
        PostFacade postFacade = new PostFacadeImpl(
                postService,
                userService,
                imageService,
                imageMapper,
                postMapper
        );


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
                        List.of("AAA123", "ASAS156", "asd7112s")
                )
        );

        postFacade.create(
                new PostCreateRequestDto(
                        "username1",
                        "title2",
                        "description3",
                        List.of("BBa123BB", "AAA4456")
                )
        );

        postFacade.getAllUserPosts("username1");
    }
}
