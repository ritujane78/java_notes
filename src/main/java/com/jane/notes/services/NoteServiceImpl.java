package com.jane.notes.services;

import com.jane.notes.models.Note;
import com.jane.notes.repositories.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;

    @Override
    public Note createNote(String username, String content) {
        Note note = new Note();
        note.setContent(content);
        note.setOwnerUsername(username);
        Note savedNote = noteRepository.save(note);
        return savedNote;
    }

    @Override
    public List<Note> getNotes(String username) {
        List<Note> personalNotes = noteRepository
                .findByOwnerUsername(username);
        return personalNotes;
    }

    @Override
    public Note updateNote(Long noteId, String content, String username) {
        Note note = noteRepository.findById(noteId).orElseThrow(()
                -> new RuntimeException("Note not found"));
        note.setContent(content);
        Note updatedNote = noteRepository.save(note);
        return updatedNote;
    }

    @Override
    public void deleteNote(Long noteId, String username) {
        Note note = noteRepository.findById(noteId).orElseThrow(
                () -> new RuntimeException("Note not found")
        );
        noteRepository.delete(note);
    }
}
