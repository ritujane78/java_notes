package com.jane.notes.services;

import com.jane.notes.models.Note;
import org.springframework.stereotype.Service;

import java.util.List;

public interface NoteService {
    public Note createNote(String username, String content);
    public List<Note> getNotes(String username);
    public Note updateNote(Long noteId, String content, String username);
    public void deleteNote(Long noteId, String username);
}
