import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        CreatePokemon pokemon1 = new CreatePokemon();
        System.out.println(pokemon1.getInfo());

        Scanner s = new Scanner(System.in);
        int userChoice = 0;

        System.out.println("Hello, welcome to the PokéPoké Stop!");

        while (userChoice != 5) {
            if (userChoice == 0) {
                System.out.println("1. Draw card \n" +
                        "2. Look at pokédex \n" +
                        "3. Look at bank \n" +
                        "4. Sell pokémon \n" +
                        "5. Leave");
                userChoice = s.nextInt();
            }
            else if (userChoice == 1) {
                System.out.println(1);
                userChoice = 0;
            }
            else if (userChoice == 2) {
                System.out.println(2);
                userChoice = 0;
            }
            else if (userChoice == 3) {
                System.out.println(3);
                userChoice = 0;
            }
            else if (userChoice == 4) {
                System.out.println(4);
                userChoice = 0;
            }
            else if (userChoice == 5) {
                System.out.println("Goodbye");
            }
            else {
                System.out.println("Try again");
                userChoice = 0;
            }
        }
    }
}
