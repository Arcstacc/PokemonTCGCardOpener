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
        int rolls = 1;
        final double CARD_COST = 10;

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
        System.out.println("Draw 1 card for now. This can be changed with option 2.");

        while (userChoice != 6) {
            if (userChoice == 0) {
                System.out.println("1. Draw card \n" +
                        "2. Change draws per roll \n" +
                        "3. Look at pokédex \n" +
                        "4. Look at bank \n" +
                        "5. Sell pokémon (Unavailable) \n" +
                        "6. Leave");
                userChoice = s.nextInt();
            }
            else if (userChoice == 1) {
                if (pokébank.getBank() >= (rolls * CARD_COST)) {
                    createBlank();
                    for (int i = 0; i < rolls; i++) {
                        CreatePokemon pokemondraw = new CreatePokemon();
                        System.out.println(pokemondraw.getInfo());
                        System.out.println();
                        listOfPokemon.addPokemon(pokemondraw);
                        pokébank.withdraw(CARD_COST);
                    }
                }
                else {
                    System.out.println("NO MORE MONEY SRY!");
                }
                userChoice = 0;
            }
            else if (userChoice == 2) {
                System.out.println("How many cards do you want to draw per roll?");
                rolls = s.nextInt();
                userChoice = 0;
            }
            else if (userChoice == 3) {
                System.out.println(listOfPokemon.getPokemon());
                userChoice = 0;
            }
            else if (userChoice == 4) {
                System.out.println("You have $" + pokébank.getBank() + ", Keep winning!");
                userChoice = 0;
            }
            else if (userChoice == 5) {
                int totalProfit = 0;
//                for (int i = 0; i < listOfPokemon.getListOfPokemon().size(); i ++)
//                    listOfPokemon.getListOfPokemon().get(i)

                pokébank.deposit(0);
                userChoice = 0;
            }
            else if (userChoice == 6) {
                System.out.println("Goodbye");
            }
            else {
                System.out.println("Try again");
                userChoice = 0;
            }
        }
    }
    public static void createBlank() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }
}
