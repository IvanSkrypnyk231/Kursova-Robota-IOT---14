package com.example.KursovaAttempt.controllers;



import com.example.KursovaAttempt.MainService;
import com.example.KursovaAttempt.classes.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainGetController {
    @Autowired
    private MainService mainService;

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


