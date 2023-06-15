package com.example.controller;

import com.example.entity.Note;
import com.example.services.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@RequestMapping("/note")
@RequiredArgsConstructor
@Controller
public class NoteController {

    private final NoteService ns;

    @GetMapping("/create")
    public String create() {
        return ("create");
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
        ModelAndView maw = new ModelAndView("note");
        maw.addObject("notes",ns.listAll());
        return maw;
    }


    @GetMapping("/update")
    public String edit(Model model, @RequestParam long id) {
        Note note = ns.getById(id);
        model.addAttribute("note", note);
        return ("update");
    }

    @PostMapping("/update")
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
