package com.example.controller;

import com.example.entity.Note;
import com.example.services.NoteService;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;


@Controller
@RequestMapping("/note")
public class NoteController {

    private NoteService ns;

    @GetMapping("/create")
    public String create() {
        return "create";
    }


    @PostMapping("/create")
    public RedirectView createNote(@RequestParam(name = "noteTitle") String noteTitle, @RequestParam(name = "noteText") String noteText) {
        RedirectView rw = new RedirectView();
        rw.setUrl("/note/list");
        Note note = new Note();
        if (ns.getNotes().get(0)==null) {
            note.setId(1L);
        } else {
            note.setId(ns.getNotes().size()+1);
        }

        note.setTitle(noteTitle);
        note.setContent(noteText);
        System.out.println("-----"+note);
        ns.add(note);
        System.out.println("Note add = " + ns.getNotes().size());
        return rw;
    }

    @GetMapping("/list")
    public ModelAndView getNotes() {
        ModelAndView maw = new ModelAndView("/list");
        maw.addObject("notes",ns.listAll());
        return maw;
    }




//    @GetMapping("/delete/{id}")
//    public ModelAndView deleteNote(@RequestParam("id") long id){
//        ModelAndView result = new ModelAndView("test");
//        result.addObject("text",  "Note id= "+id+" - deleted");
//        return result;
//    }

//    @GetMapping("/delete")
//    public RedirectView delete(@RequestParam long id){
//        RedirectView redirectView = new RedirectView();
//        redirectView.setUrl("/note/list");
//        notes.remove(id);
//        return  redirectView;
//    }



    //    @PostMapping("/delete/{id}")
//    public String deleteNote(@PathVariable long id) {
//        Note note = findNoteById(id);
//        noteList.remove(note);
//        return "redirect:/note/list";
//    }



//    @GetMapping("/edit/{id}")
//    public String editNote(@PathVariable long id, Model model) {
//        Note note = findNoteById(id);
//        model.addAttribute("note", note);
//        return "note-edit";
//    }

//    @PostMapping("/update")
//    public String updateNote(@ModelAttribute Note note) {
//        Note existingNote = findNoteById(note.getId());
//        existingNote.setTitle(note.getTitle());
//        existingNote.setContent(note.getContent());
//        return "redirect:/note/list";
//    }



//    private Note findNoteById(long id) {
//        return noteList.stream()
//                .filter(note -> note.getId() == id)
//                .findFirst()
//                .orElseThrow(() -> new IllegalArgumentException("Note not found"));
//    }

}
