package nyc.c4q.RusiLi.Utility;

import java.util.Scanner;

public class Input {

    public static String i() { // to check for "exit"
        String sInput = null;

        Scanner scInput = new Scanner(System.in);
        sInput = scInput.nextLine();

        if (sInput.equalsIgnoreCase("exit")) {
            System.exit(0); // 0 tells the user there's no problem. Use 1 if you want to show an error.
        }

        return sInput;
    }

}
