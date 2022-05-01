package com.aca.homework.week17.note.facade.note;

import com.aca.homework.week17.note.entity.Note;
import com.aca.homework.week17.note.entity.User;
import com.aca.homework.week17.note.service.core.CreateNoteParams;
import com.aca.homework.week17.note.service.core.NoteService;
import com.aca.homework.week17.note.service.core.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.time.LocalDate;

public class NoteFacadeImpl implements NoteFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(NoteFacadeImpl.class);

    private final NoteService noteService;
    private final UserService userService;

    public NoteFacadeImpl(NoteService noteService, UserService userService) {
        this.noteService = noteService;
        this.userService = userService;
    }

    @Override
    public NoteCreationResponseDto create(NoteCreationRequestDto dto) {
        Assert.notNull(dto, "Request should not be null");
        LOGGER.info("Creating note for request - {}", dto);

        final User user = userService.getByUsername(dto.getUsername());


        final LocalDate localDateNow = LocalDate.now();

        final Note note = noteService.create(
                new CreateNoteParams(
                        dto.getText(),
                        user.getId(),
                        localDateNow
                )
        );

        final NoteCreationResponseDto responseDto =
                new NoteCreationResponseDto(
                        note.getUser().getUsername(),
                        note.getText(),
                        note.getCreationDate()
                );

        LOGGER.info("Successfully Created note for request - {}, response - {}", responseDto);
        return responseDto;
    }
}
