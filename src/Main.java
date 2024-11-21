import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
//        double testCost = 0.0;
//        for (int i = 0; i < 10; i++) {
//            CreatePokemon pokemon = new CreatePokemon();
//            double tempCost = pokemon.getCost();
//            testCost += tempCost;
//            System.out.println(tempCost);
//        }
//        System.out.println();
//        System.out.println(testCost);

        Scanner s = new Scanner(System.in);
        int userChoice = 0;

        Pokedex listOfPokemon = new Pokedex();
        Bank pokébank = new Bank(1000);

        System.out.println("Hello, welcome to the PokéPoké Stop!");
        System.out.println("Market is offline temporally");
        System.out.println("Format is as follows:\n" +
                "Name " + "(Gender)\n" +
                "Stats: [Hp, Attack, Defense, Special Attack, Special Defense, Speed]\n" +
                "Characteristic\n" +
                "[Width,Height,Growth]\n" +
                "[Rarity]\n" +
                "Cost\n");
        System.out.println("You start off with $1000!");
        System.out.println("Each card costs 10$!");

        while (userChoice != 5) {
            if (userChoice == 0) {
                System.out.println("1. Draw card \n" +
                        "2. Look at pokédex \n" +
                        "3. Look at bank \n" +
                        "4. Sell pokémon (Unavailable) \n" +
                        "5. Leave");
                userChoice = s.nextInt();
            }
            else if (userChoice == 1) {
                CreatePokemon pokemondraw = new CreatePokemon();
                System.out.println(pokemondraw.getInfo());
                System.out.println();
                listOfPokemon.addPokemon(pokemondraw);

                pokébank.withdraw(10);

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
//                int pokemonIndex;
//
//                System.out.println(listOfPokemon.getPokemon());
//                if (!listOfPokemon.getPokemon().isEmpty()) {
//                    System.out.println("Chose from the list a pokemon to sell (Number)");
//                    pokemonIndex = s.nextInt() - 1;
//                }
//                else {
//                    pokemonIndex = -1;
//                }
//                System.out.println(pokemonIndex);
//
//                System.out.println(pokébank.getBank());

                pokébank.deposit(0);
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
