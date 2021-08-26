package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        // Write your code here
        Scanner scanner = new Scanner(System.in);
        //read inputs and find total seats in a room
        //rows and seats no greater than 9
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seatPerRow = scanner.nextInt();
        if (rows > 9 || seatPerRow > 9) {
            return;
        }
        int totalSeats = rows * seatPerRow;

        //total <=60, price is $10
        //total >60, first half rows will be $10, other half $8 (first half<=other half)
        //find sum revenue
        int revenue;
        if (totalSeats <= 60) {
            revenue = 10 * totalSeats;
        } else {
            int halfFirst = rows / 2;
            revenue = seatPerRow * (halfFirst * 10 + (rows - halfFirst) * 8);
        }
        System.out.println("Total income:\n$" + revenue);
        scanner.close();
    }
}