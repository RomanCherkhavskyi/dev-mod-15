package com.example.services;

import com.example.entity.Note;
import com.example.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@RequiredArgsConstructor
@Service
public class NoteService  {

    private final NoteRepository repository;

    public Note add(Note note) {
        repository.save(note);
        return note;
    }

    public Note getById(long id) {
                 return repository.findById(id)
                .stream()
                .findAny()
                .orElseThrow(() -> {
                    throw new NoSuchElementException("The note is missing.");
                });
    }

    public void deleteById(long id)  {
        repository.findById(id)
                .stream()
                .findAny()
                .orElseThrow(() -> {
                    throw new NoSuchElementException("The note is missing.");
                });
        repository.deleteById(id);
    }

    public void update(Note note) {
        repository.findById(note.getId())
                .stream()
                .findAny()
                .orElseThrow(() -> {
                    throw new NoSuchElementException("The note is missing.");
                });
        repository.save(note);
    }
    public List<Note> listAll(){
        return repository.findAll();
    }

}
