package com.example.KursovaAttempt.controllers;


import com.example.KursovaAttempt.MainService;
import com.example.KursovaAttempt.classes.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainDeleteController {

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

}

