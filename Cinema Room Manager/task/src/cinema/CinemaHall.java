package cinema;

public class CinemaHall {
    private final int rows;
    private final int seatsPerRow;
    private char[][] seatMap;
    private int soldTicket = 0;
    private int currentIncome = 0;


    public CinemaHall(int rows, int seatsPerRow) {
        this.rows = rows;
        this.seatsPerRow = seatsPerRow;
        setSeatMap();
    }

    //draw seat map for a new hall
    private void setSeatMap() {
        this.seatMap = new char[rows][seatsPerRow];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seatsPerRow; j++) {
                seatMap[i][j] = 'S';
            }
        }
    }

    private int getTotalSeats() {
        return rows * seatsPerRow;
    }

    private int getTotalIncome() {
        // if totalSeat < 60, same price $10 for all seats
        //else half first would be 10, other half would be 8 (halfFirst < other half)
        int halfFirst = rows / 2;
        return getTotalSeats() <= 60 ? 10 * getTotalSeats() : (10 * halfFirst + 8 * (rows - halfFirst)) * seatsPerRow;
    }

    public void showMenu() {
        boolean isClosed = false;
        while (!isClosed) {
            int select = MyInput.readInt("\n1. Show the seats\n" +
                    "2. Buy a ticket\n" +
                    "3. Statistics\n" +
                    "0. Exit");
            switch (select) {
                case 1:
                    drawMap();
                    break;
                case 2:
                    int currentSold = soldTicket;
                    //loop til another ticket is sold
                    while (currentSold == soldTicket) {
                        sellTicket();
                    }
                    break;
                case 3:
                    showStatistic();
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
        //read userInput and validate seat
        int row = MyInput.readInt("Enter a row number:");
        int seat = MyInput.readInt("Enter a seat number in that row:");
        if (row < 1 || row > rows || seat < 1 || seat > seatsPerRow) {
            System.out.println("Wrong input!");
            return;
        }
        //check if the seat has been purchased
        if (seatMap[row - 1][seat - 1] == 'B') {
            System.out.println("That ticket has already been purchased!");
        } else {
            //Calculate price
            int price = getTotalSeats() <= 60 ? 10 : row <= rows / 2 ? 10 : 8;
            System.out.println("Ticket price: $" + price);
            // change soldTicket, currentIncome, seatMap
            soldTicket++;
            currentIncome += price;
            seatMap[row - 1][seat - 1] = 'B';
        }
    }

    private void showStatistic() {
        double percentSold = soldTicket * 100.0 / getTotalSeats();

        String ticket = "Number of purchased tickets: %d\n" +
                "Percentage: %.2f%%\n";
        String income = "Current income: $%d\n" +
                "Total income: $%d";
        System.out.printf(ticket + income, soldTicket, percentSold, currentIncome, getTotalIncome());
    }
}
