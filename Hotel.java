package sample;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class Hotel {

    public static final int maxNumOfRooms = 10;

    private int numOfStars;
    private String name, address;
    private HashMap<LocalDate, ArrayList<Room>> rooms;

    public Hotel(String name, String address, int numOfStars){
        this.name = name;
        this.address = address;
        this.numOfStars = numOfStars;
        rooms = new HashMap<>();
    }

    public boolean bookRoom(Room room){
        if(rooms.containsKey(room.getBookingDate())){
            if(rooms.get(room.getBookingDate()).size() == maxNumOfRooms){
                return false;
            }else{
                rooms.get(room.getBookingDate()).add(room);
            }
        }else{
            ArrayList<Room> temp = new ArrayList<>();
            temp.add(room);
            rooms.put(room.getBookingDate(), temp);
        }
        return true;
    }

    public void printListOfResidents(){
        rooms.forEach((date, roomsList) -> System.out.println(date + " " + roomsList));
    }

    public int getNumOfStars() {
        return numOfStars;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
