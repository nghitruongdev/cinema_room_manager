package cinema;

public class Cinema {

    public static void main(String[] args) {
        // Write your code here
        for (int i = 0; i < 8; i++) {
            if (i == 0) {
                System.out.print("Cinema:\n  ");
                for (int j = 1; j < 9; j++) {
                    System.out.print(j + " ");
                }
                System.out.println();
            } else {
                System.out.println(i + " " + "S ".repeat(8));
            }

        }
    }
}