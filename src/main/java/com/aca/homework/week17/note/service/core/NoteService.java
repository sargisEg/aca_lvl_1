package com.aca.homework.week17.note.service.core;

import com.aca.homework.week17.note.entity.Note;
import org.springframework.stereotype.Service;

@Service
public interface NoteService {

    Note create(CreateNoteParams params);
}
