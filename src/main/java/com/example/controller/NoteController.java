package com.example.controller;

import com.example.entity.Note;
import com.example.services.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


@Controller
@RequestMapping("/note")
public class NoteController {

    private NoteService ns = new NoteService();

    @GetMapping("/create")
    public String create() {

        		Note note1 = new Note(1L, "NOTE-1", "It's note 1 content");
		Note note2 = new Note(2L, "NOTE-2", "It's note 2 content");
        ns.add(note1);
        ns.add(note2);


        return "create";
    }

    @PostMapping("/create")
    public RedirectView createNote(@ModelAttribute Note note) {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/note/list");
        ns.add(note);
        return redirectView;
    }

    @GetMapping("/list")
    public ModelAndView getNotes() {
        ModelAndView maw = new ModelAndView("list");
        maw.addObject("notes",ns.listAll());
        return maw;
    }





    @GetMapping("/edit")
    public String edit(Model model, @RequestParam long id) {
        Note note = ns.getById(id);
        model.addAttribute("note", note);
        return "note/list";
    }

    @PostMapping("/edit")
    public RedirectView editNote(@ModelAttribute Note note) {
        RedirectView rv = new RedirectView();
        rv.setUrl("/note/list");
        ns.update(note);
        return rv;
    }

    @GetMapping("/delete")
    public RedirectView delete(@RequestParam long id) {
        RedirectView rv = new RedirectView();
        rv.setUrl("/note/list");
        ns.deleteById(id);
        return rv;
    }

}
