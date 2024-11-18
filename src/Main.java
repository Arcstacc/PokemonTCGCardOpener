import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int userChoice = 0;

        Pokedex listOfPokemon = new Pokedex();
        Bank pokébank = new Bank(100);

        System.out.println("Hello, welcome to the PokéPoké Stop!");
        System.out.println("You can only draw card rn");
        System.out.println("Format is as follows:\n" +
                "Name\n" +
                "Gender\n" +
                "Stats: [Hp, Att, Def, SAtt, SDef, Speed]\n" +
                "Characteristic\n" +
                "[Width,Height,Growth]\n" +
                "[Rarity]\n");
        System.out.println("You start off with $100!");

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
                CreatePokemon pokemondraw = new CreatePokemon();
                System.out.println(pokemondraw.getInfo());
                System.out.println();
                listOfPokemon.addPokemon(pokemondraw);

                pokébank.withdraw(5);

                userChoice = 0;
            }
            else if (userChoice == 2) {
                System.out.println(listOfPokemon.getPokemon());
                userChoice = 0;
            }
            else if (userChoice == 3) {
                System.out.println(pokébank.getBank());
                userChoice = 0;
            }
            else if (userChoice == 4) {
                pokébank.deposit(4);
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
