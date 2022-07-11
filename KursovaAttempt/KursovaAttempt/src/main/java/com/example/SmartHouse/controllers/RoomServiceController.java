package com.example.SmartHouse.controllers;

import com.example.SmartHouse.MainService;
import com.example.SmartHouse.classes.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RoomServiceController {

    @Autowired
    private MainService mainService;

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Integer> deleteRoom(@PathVariable Integer id){
        Room r = mainService.deleteRoom(id);
        if (r == null ){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(id);
    }


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



    @RequestMapping(value = "/", method= RequestMethod.GET)
    @ResponseBody
    public String allRooms() {
        return mainService.getRooms();
    }

    @RequestMapping(value = "/{id}", method= RequestMethod.GET)
    @ResponseBody
    public String getRoom(@PathVariable("id" )Integer id) {
        Room room = mainService.getRoom(id);
        if(room == null){
            return "No room found";
        }
        return room.toString();
    }

    @GetMapping(path = "/put/{id}")
    public String dataEdit(@PathVariable("id" )Integer id, Model model) {
        Room room = mainService.getRoom(id);
        if(room == null){
            return "No room found";
        }
        model.addAttribute("room", room);
        return "room";
    }

    @GetMapping(path = "/post")
    public String addRoom( Model model) {

        model.addAttribute("room", new Room());
        return "newRoom";
    }

}
