package cinema;

public class CinemaHall {
    private int rows;
    private int seatsPerRow;
    private char[][] seatMap;
    private static final char EMPTY_SEAT = 'S';
    private static final char BOOKED_SEAT = 'B';

    public CinemaHall(int rows, int seatsPerRow) {
        this.rows = rows;
        this.seatsPerRow = seatsPerRow;
        setSeatMap();
    }

    //set seat map for a new hall
    private void setSeatMap() {
        this.seatMap = new char[rows][seatsPerRow];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seatsPerRow; j++) {
                seatMap[i][j] = EMPTY_SEAT;
            }
        }
    }

    public int getTotalSeat() {
        return rows * seatsPerRow;
    }

    public void showMenu() {
        boolean isClosed = false;
        while (!isClosed) {
            int select = MyInput.readInt("\n1. Show the seats\n" +
                    "2. Buy a ticket\n" +
                    "0. Exit");
            switch (select) {
                case 1:
                    drawMap();
                    break;
                case 2:
                    sellTicket();
                    break;
                default:
                    isClosed = true;
            }
        }
    }

    //draw seat map
    private void drawMap() {
        System.out.println("\nCinema:");
        for (int i = 0; i <= seatMap.length; i++) {
            if (i == 0) {
                //draw the first line
                System.out.print("  ");
                for (int j = 1; j <= seatMap[0].length; j++) {
                    System.out.print(j + " ");
                }
            } else {
                //draw other lines
                System.out.print("\n" + i);
                for (int j = 1; j <= seatMap[0].length; j++) {
                    System.out.print(" " + seatMap[i - 1][j - 1]);
                }
            }
        }
        System.out.println();
    }

    private void sellTicket() {
        int row = MyInput.readInt("Enter a row number:");
        int seat = MyInput.readInt("Enter a seat number in that row:");

        //check if the seat has been taken
        if (seatMap[row - 1][seat - 1] == BOOKED_SEAT) {
            System.out.println("Sorry, the seat has been taken.");
        } else {
            //Calculate price
            int price = 0;
            if (getTotalSeat() <= 60) {
                price = 10;
            } else {
                int halfFirst = rows / 2;
                price = row <= halfFirst ? 10 : 8;
            }
            System.out.println("Ticket price: $" + price);
            seatMap[row - 1][seat - 1] = BOOKED_SEAT;
        }
    }
}
