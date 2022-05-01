package com.aca.homework.week17.note.service.impl;

import com.aca.homework.week17.note.entity.Note;
import com.aca.homework.week17.note.entity.User;
import com.aca.homework.week17.note.repository.NoteRepository;
import com.aca.homework.week17.note.repository.UserRepository;
import com.aca.homework.week17.note.service.core.CreateNoteParams;
import com.aca.homework.week17.note.service.core.NoteService;
import com.aca.homework.week17.note.service.core.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

public class NoteServiceImpl implements NoteService {

    private static final Logger LOGGER = LoggerFactory.getLogger(NoteServiceImpl.class);

    private final NoteRepository noteRepository;
    private final UserService userService;

    public NoteServiceImpl(NoteRepository noteRepository, UserService userService) {
        this.noteRepository = noteRepository;
        this.userService = userService;
    }

    @Override
    public Note create(CreateNoteParams params) {
        Assert.notNull(params, "Params should not be null");
        LOGGER.info("Creating a note with params - {}", params);

        final User user = userService.getById(params.getUser_id());

        final Note noteFromParams = new Note(
                params.getText(),
                user,
                params.getCreationDate());

        final Note note = noteRepository.save(noteFromParams);

        LOGGER.info("Successfully created a note with params - {}, result - {}", params, note);
        return note;
    }
}
