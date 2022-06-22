package com.example.KursovaAttempt.controllers;

import com.example.KursovaAttempt.MainService;
import com.example.KursovaAttempt.classes.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainPutController {
    @Autowired
    private MainService mainService;

    @PutMapping("/put/{id}")
    public RedirectView submitPut(
           @RequestBody Room room, @PathVariable Integer id) {
        if (Room.isValidRoom(room)) {
            mainService.updateRoom(room);
            return new RedirectView("/{id}", true);
        } else {
            return new RedirectView("/put/{id}", true);
        }
    }

}
