package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        // Write your code here
        //input rows, seatPerRows, totalSeats
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seatsPerRow = scanner.nextInt();
        int totalSeats = rows * seatsPerRow;

        //Draw a map of seats
        char[][] map = new char[rows][seatsPerRow];
        for(int i=0; i< rows;i++){
            for(int j=0; j< seatsPerRow; j++){
                map[i][j]= 'S';
            }
        }
        drawMap(map);

        //Calculate price
        System.out.println("Enter a row number:");
        int row = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seat = scanner.nextInt();
        int price = 0;

        if (totalSeats <= 60) {
            price = 10;
        } else {
            int halfFirst = rows / 2;
            price = row <= halfFirst ? 10 : 8;
        }
        System.out.println("Ticket price: $" + price);

        //draw seat map again
        map[row-1][seat-1] = 'B';
        drawMap(map);
        scanner.close();
    }

    //draw seat map
    private static void drawMap(char[][] map){
        System.out.println("\nCinema:");
       for(int i =0; i <=map.length;i++){
           if(i==0){
               //draw the first line
               System.out.print("  ");
               for(int j =1;j<= map[0].length;j++ ){
                   System.out.print(j + " ");
               }
           }else{
               //draw other lines
               System.out.print("\n" + i);
               for(int j = 1; j<= map[0].length;j++){
                   System.out.print(" " + map[i-1][j-1]);
               }
           }
       }
        System.out.println();
    }
}