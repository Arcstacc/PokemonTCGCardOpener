import java.sql.SQLOutput;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;

class Main {
    public static void main(String[] args) {
        // Inits all nessasary variables
        Scanner s = new Scanner(System.in);
        DecimalFormat dc1 = new DecimalFormat("0.00");
        int userChoice = 0;
        int rolls = 1;
        final double CARD_COST = 10;

        Pokedex listOfPokemon = new Pokedex();
        Bank pokébank = new Bank(1000);

        // Introduction
        System.out.println("Hello, welcome to the PokéPoké Stop!");
        System.out.println("Here you can win big by opening pokémon cards");
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
                        "5. Sell all pokémon \n" +
                        "6. Leave");
                userChoice = s.nextInt();
            }
            // draw cards with necessary logic like bank and pokedex
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
                // checks bank
                else {
                    System.out.println("NO MORE MONEY SRY!");
                }
                userChoice = 0;
            }
            // gets user to change cards per roll to make things easier
            else if (userChoice == 2) {
                System.out.println("How many cards do you want to draw per roll?");
                rolls = s.nextInt();
                userChoice = 0;
            }
            // prints out pokedex
            else if (userChoice == 3) {
                createBlank();
                System.out.println(listOfPokemon.getPokemon());
                userChoice = 0;
            }
            // prints out banking info
            else if (userChoice == 4) {
                createBlank();
                System.out.println("You have $" + pokébank.getBank() + ", Keep winning!");
                userChoice = 0;
            }
            // prints out the return on investment
            // and also uses necessary objects and methods to
            // sell Pokémon correctly
            else if (userChoice == 5) {
                createBlank();
                int count = listOfPokemon.getListOfPokemon().size();
                double totalCost = Double.parseDouble(dc1.format(listOfPokemon.sellPokemon(pokébank)));
                System.out.println("You've sold " + count + " pokemon for $" + totalCost + ". Pleasure doing business.");

                userChoice = 0;
            }
            // In case the user enters 11 or smth
            else {
                System.out.println("Try again");
                userChoice = 0;
            }
        }
        // End
        createBlank();
        System.out.println("You earn $" + pokébank.getBank() + " Nice!");
        System.out.println("Goodbye");
    }
    /**
     * The createBlank method simply creates 100 blank lines.
     * This helps separate the previous code with outputs to improve readability.
     */
    public static void createBlank() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }
}
