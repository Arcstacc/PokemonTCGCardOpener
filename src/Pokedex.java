import java.util.ArrayList;

public class Pokedex {
    ArrayList<CreatePokemon> listOfPokemon;
    int count;
    public Pokedex() {
        listOfPokemon = new ArrayList<>();
        count = 0;
    }
    
    public void addPokemon(CreatePokemon pokemon) {
        listOfPokemon.add(pokemon);
        count++;
        
    }
    public double sellPokemon(Bank bank) {
        double totalCost = 0;
        for (int i = 0; i < listOfPokemon.size(); i ++) {
            totalCost += listOfPokemon.get(i).getCost();
        }
        bank.deposit(totalCost);
        listOfPokemon.removeAll(listOfPokemon);
        count = 0;

        return totalCost;
    }

        

    public String getPokemon() {
        String formattedListOfPokemon = "";
        for (int i = 0; i < listOfPokemon.size(); i++) {
            formattedListOfPokemon += "" + (i + 1) + ". " + listOfPokemon.get(i).getInfo() + "\n";
        }
        return formattedListOfPokemon;
    }

    public ArrayList<CreatePokemon> getListOfPokemon() {
        return listOfPokemon;
    }
}
