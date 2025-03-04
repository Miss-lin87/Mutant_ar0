package se.linda.functions;
import java.util.Scanner;
import java.util.logging.Logger;

public class funcs {
    Logger message = Logger.getLogger(getClass().getName());

    static String user_input_string(String input_line){
        Scanner input_from_user = new Scanner(System.in);
        message.info(input_line);
        return input_from_user.nextLine();
    }

    static Integer user_input_integer(){
        Scanner input_from_user = new Scanner(System.in);
        message.info("Please enter a number: ");
        return input_from_user.nextInt();
    }
}