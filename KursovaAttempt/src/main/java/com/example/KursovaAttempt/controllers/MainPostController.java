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
public class MainPostController {
    @Autowired
    private MainService mainService;

    @PostMapping("/post")
    public RedirectView submitPost(
            HttpServletRequest request,
            @ModelAttribute Room room,
            RedirectAttributes redirectAttributes) {
        if (Room.isValidRoom(room)) {
            mainService.addRoom(room);
            redirectAttributes.addFlashAttribute("room", room);

            return new RedirectView("/", true);
        } else {
            return new RedirectView("/post", true);
        }
    }

    @PostMapping("/put/{id}")
    public RedirectView submitPut(
            HttpServletRequest request,
            @ModelAttribute Room room,
            RedirectAttributes redirectAttributes) {
        if (Room.isValidRoom(room)) {
            mainService.updateRoom(room);
            redirectAttributes.addFlashAttribute("room", room);
            return new RedirectView("/{id}", true);
        } else {
            return new RedirectView("/put/{id}", true);
        }
    }
}