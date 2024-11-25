import java.util.ArrayList;
/**
 * The Pokedex class represents a Storage mechanism. A Pokedex is a databse with a list of
 * pokemon and a headcount of the number of pokemon
 */

public class Pokedex {
    private ArrayList<CreatePokemon> listOfPokemon;
    private int count;
    /**
     * Constructor for the Pokédex class. This creates a new instance of a Pokédex with no
     * parameters since it starts empty and is manipulated.
     */
    public Pokedex() {
        listOfPokemon = new ArrayList<>();
        count = 0;
    }
    /**
     * addPokemon method for the Pokédex class. This method will append a pokemon to
     * the list of pokemon in the pokedex. It has no return.
     * @param pokemon is a CreatePokemon object representing a random pokemon
     */
    public void addPokemon(CreatePokemon pokemon) {
        listOfPokemon.add(pokemon);
        count++;
        
    }
    /**
     * sellPokemon method for the Pokédex class. This method will sell (remove) all
     * pokemon and return a reasonable market price for the sold Pokémon.
     * @param bank is a Bank object representing the user's budget
     * @return returns the cost of all pokemon that is deposited into the users bank.
     */
    public double sellPokemon(Bank bank) {
        double totalCost = 0;
        // adds the value of each pokemon to total cost and deposits the money
        for (int i = 0; i < listOfPokemon.size(); i ++) {
            totalCost += listOfPokemon.get(i).getCost();
        }
        bank.deposit(totalCost);
        listOfPokemon.removeAll(listOfPokemon);
        count = 0;

        return totalCost;
    }
    /**
     * The getPokemon method for the Pokédex class. This will help fetch
     * all the Pokémon currently in the Pokédex.
     * There are no parameters
     * @return returns a String representing a formatted string of all Pokémon
     */
    public String getPokemon() {
        String formattedListOfPokemon = "";
        for (int i = 0; i < listOfPokemon.size(); i++) {
            formattedListOfPokemon += "" + (i + 1) + ". " + listOfPokemon.get(i).getInfo() + "\n";
        }
        return formattedListOfPokemon;
    }
    /**
     * The getListOfPokemon method for the Pokédex class. This will help fetch
     * only the list of the pokedex pokemon.
     * There are no parameters
     * @return returns a ArrayList of all the pokemon from CreatePokemon
     */
    public ArrayList<CreatePokemon> getListOfPokemon() {
        return listOfPokemon;
    }
}
