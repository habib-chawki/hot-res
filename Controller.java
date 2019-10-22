package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {

    private Hotel myHotel = new Hotel("Five stars", "my address", 5);

    @FXML
    private TextField mainResident;
    @FXML
    private DatePicker bookingDate;
    @FXML
    private ComboBox roomType;
    @FXML
    private Slider numOfNights;
    @FXML
    private Spinner numOfAdults;
    @FXML
    private Spinner numOfChildren;
    @FXML
    private CheckBox breakfastOrdered, lunchOrdered, dinnerOrdered;
    @FXML
    private TextArea specialRequest;

    @FXML
    public void makeReservation(){
        if(myHotel.bookRoom(
                new Room(
                        mainResident.getText(),
                        bookingDate.getValue(),
                        roomType.getValue().toString(),
                        (int) numOfNights.getValue(),
                        Integer.valueOf(numOfAdults.getValue().toString()),
                        Integer.valueOf(numOfChildren.getValue().toString()),
                        breakfastOrdered.isSelected(), lunchOrdered.isSelected(),
                        dinnerOrdered.isSelected(),
                        specialRequest.getText()
                )
        )){
            System.out.println("Booking confirmed !");
        } else{
            System.out.println("All rooms are already booked !");
        };

        myHotel.printListOfResidents();
    }
}
