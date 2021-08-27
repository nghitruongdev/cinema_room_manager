package cinema;

public class Cinema {

    public static void main(String[] args) {
        // Write your code here
        int rows = MyInput.readInt("Enter the number of rows:");
        int seatsPerRow = MyInput.readInt("Enter the number of seats in each row:");
        CinemaHall hall = new CinemaHall(rows, seatsPerRow);
        hall.showMenu();
    }






}