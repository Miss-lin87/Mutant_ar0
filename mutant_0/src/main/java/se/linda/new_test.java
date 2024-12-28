package se.linda;

public class new_test{
    public static void main(String[] args) {
        boolean valid = false;
        Integer stats = 20;
        Integer steeps = 3; 
        while (valid == false){
            if (steeps > stats && stats < 0){
                System.out.println("Steeps to high. Lowering" + steeps);
                steeps --;
            }
            if (stats <= 0){
                valid = true;
            }
            else {
                System.out.println("This is a test " + stats);
                stats = stats - steeps;
            }
        }
    }
}
