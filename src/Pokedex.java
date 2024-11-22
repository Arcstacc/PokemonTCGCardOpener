import java.util.ArrayList;

public class Pokedex {
    ArrayList<CreatePokemon> listOfPokemon = new ArrayList<>();
    public void addPokemon(CreatePokemon pokemon) {
        listOfPokemon.add(pokemon);
    }
    public void removePokemon(int indexOfPokemon) {
        listOfPokemon.remove(indexOfPokemon - 1);
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
