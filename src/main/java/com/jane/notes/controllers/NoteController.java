package com.jane.notes.controllers;

import com.jane.notes.models.Note;
import com.jane.notes.services.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.element.ModuleElement;
import java.util.List;

@RestController
@RequestMapping("/api/notes")
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;

    @PostMapping
    public Note createNote(@RequestBody String content, @AuthenticationPrincipal UserDetails userDetails) {
        System.out.println("userDetails: " + userDetails    );
        String username = userDetails.getUsername();
        System.out.println("username : " + username);
        Note createNote = noteService.createNote(username, content);
        return createNote;
    }

    @GetMapping
    public List<Note> getAllNotes(@AuthenticationPrincipal UserDetails userDetails) {
        String username = userDetails.getUsername();
        System.out.println("username : " + username);
        List<Note> notes = noteService.getNotes(username);
        return notes;
    }
    @PutMapping("/{noteId}")
    public Note updateNote(@PathVariable Long noteId, @RequestBody String content, @AuthenticationPrincipal UserDetails userDetails) {
        String username = userDetails.getUsername();
        System.out.println("username : " + username);
        Note updatedNote = noteService.updateNote(noteId, content, username);
        return updatedNote;
    }

    @DeleteMapping("/{noteId}")
    public void deleteNote(@PathVariable Long noteId, @AuthenticationPrincipal UserDetails userDetails) {
        String username = userDetails.getUsername();
        System.out.println("username : " + username);
        noteService.deleteNote(noteId, username);
    }


}
