package com.example.KursovaAttempt;

import com.example.KursovaAttempt.classes.HeatingBattery;
import com.example.KursovaAttempt.classes.Room;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class MainService {
    private List<Room> rooms = new ArrayList<>();
    public Room getRoom (Integer id){
        for (Room room : rooms){
            if(Objects.equals(room.getId(), id)){
                return room;
            }
        }
        return null;
    }
    public MainService(){
        initRooms();
    }
    private void initRooms (){

        Room livingRoom = new Room();
        livingRoom.setBattery(new HeatingBattery(20, 140));
        Room hall = new Room();
        hall.setBattery(new HeatingBattery(23, 170));
        Room toilet = new Room();
        toilet.setBattery(new HeatingBattery(233, 10));
        Room bedroom = new Room();
        bedroom.setBattery(new HeatingBattery(25, 200));

        livingRoom.setAutoId();
        livingRoom.setHumidity(50);
        livingRoom.setIllumination(500);
        livingRoom.setTemperature(19);

        hall.setAutoId();
        hall.setHumidity(50);
        hall.setIllumination(500);
        hall.setTemperature(19);

        toilet.setAutoId();
        toilet.setHumidity(50);
        toilet.setIllumination(500);
        toilet.setTemperature(19);

        bedroom.setAutoId();
        bedroom.setHumidity(50);
        bedroom.setIllumination(500);
        bedroom.setTemperature(19);

        rooms.add(livingRoom);
        rooms.add(hall);
        rooms.add(toilet);
        rooms.add(bedroom);

    }

    public String getRooms() {
        return rooms.toString();
    }

    public void updateRoom(Room room) {
        for(int i = 0 ; i < rooms.size(); i++){
            Room r = rooms.get(i);
            if(Objects.equals(r.getId(), room.getId())) {
                rooms.set(i, room);
            }
        }
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Room deleteRoom(Integer id) {
        for (int i = 0; i < rooms.size(); i++) {
            Room r = rooms.get(i);
            if (Objects.equals(r.getId(), id)) {
                rooms.remove(i);
                return r;
            }

        }
        return null;
    }
}
