package cinema;

import java.util.Scanner;

public class MyInput {
    private static final Scanner sc = new Scanner(System.in);

    public static int readInt(String message){
        System.out.println(message);
        return sc.nextInt();
    }

}
