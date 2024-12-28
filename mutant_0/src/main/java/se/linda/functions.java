package se.linda;
import java.util.Scanner;

public class functions {
    static String user_input_string(String input_line){
        Scanner input_from_user = new Scanner(System.in);
        System.out.println(input_line);
        String returning_input = input_from_user.nextLine();
        return returning_input;
    }

    static Integer user_input_integer(){
        Scanner input_from_user = new Scanner(System.in);
        System.out.println("Please enter a number: ");
        Integer returning_integer = input_from_user.nextInt();
        return returning_integer;
    }
    
    static String find_class(Object input){
        return input.getClass().getName();
    }
}