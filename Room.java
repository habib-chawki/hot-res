package sample;

import java.time.LocalDate;

public class Room {
    public static final double singleRoomPrice = 100, doubleRoomPrice = 150, tripleRoomPrice = 200, quadRoomPrice = 250, suitePrice = 400;
    public static final double breakfastPrice = 10, lunchPrice = 25, dinnerPrice = 20;

    private String mainResident;
    private LocalDate bookingDate;

    private String roomType;
    private int numOfNights;
    private int numOfAdults;
    private int numOfChildren;
    private boolean isBreakfastOrdered, isLunchOrdered, isDinnerOrdered;
    private String specialRequest;

    public Room(String mainResident, LocalDate bookingDate, String roomType, int numOfNights, int numOfAdults, int numOfChildren, boolean isBreakfastOrdered, boolean isLunchOrdered, boolean isDinnerOrdered, String specialRequest) {
        this.mainResident = mainResident.equals("") ? "Jon Doe" : mainResident;
        this.bookingDate = (bookingDate == null) ? LocalDate.now() : bookingDate;
        this.roomType = roomType;
        this.numOfNights = numOfNights;
        this.numOfAdults = numOfAdults;
        this.numOfChildren = numOfChildren;
        this.isBreakfastOrdered = isBreakfastOrdered;
        this.isLunchOrdered = isLunchOrdered;
        this.isDinnerOrdered = isDinnerOrdered;
        this.specialRequest = specialRequest;
    }

    public String getMainResident() {
        return mainResident;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public String getRoomType(){
        return roomType;
    }

    public int getNumOfNights() {
        return numOfNights;
    }

    public int getNumOfAdults() {
        return numOfAdults;
    }

    public int getNumOfChildren() {
        return numOfChildren;
    }

    public boolean isBreakfastOrdered() {
        return isBreakfastOrdered;
    }

    public boolean isLunchOrdered() {
        return isLunchOrdered;
    }

    public boolean isDinnerOrdered() {
        return isDinnerOrdered;
    }

    public String getSpecialRequest() {
        return specialRequest;
    }

    public double getRoomPrice(){
        return (
                getNightRate(roomType)
                + getMealsPrice() * numOfAdults
                + (getMealsPrice() * numOfChildren) / 2
        ) * numOfNights;
    }

    public double getNightRate(String roomType){
        switch(roomType){
            case "Single": return singleRoomPrice;
            case "Double": return doubleRoomPrice;
            case "Triple": return tripleRoomPrice;
            case "Quad": return quadRoomPrice;
        }
        return suitePrice;
    }

    public double getMealsPrice(){
        double mealsPrice = 0.0;

        if(isBreakfastOrdered)
            mealsPrice += breakfastPrice;

        if(isLunchOrdered)
            mealsPrice += lunchPrice;

        if(isDinnerOrdered)
            mealsPrice += dinnerPrice;

        return mealsPrice;
    }

    @Override
    public String toString() {
        return String.format
                ("%s, %s room, Adults(%d), Children(%d), %s, %s, %s, %s (%.2f)",
                        mainResident,
                        roomType,
                        numOfAdults,
                        numOfChildren,
                        isBreakfastOrdered ? "Breakfast included" : "No breakfast",
                        isLunchOrdered ? "Lunch included" : "No lunch",
                        isDinnerOrdered ? "Dinner included" : "No dinner",
                        specialRequest.equals("") ? "No special requests" : specialRequest,
                        getRoomPrice()
                );
    }
}
