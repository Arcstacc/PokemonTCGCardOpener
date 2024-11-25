
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/**
 * The CreatePokemon class represents a a random simulation. CreatePokemon is a pokemon
 * with various attributes such as name, gender, stats (IVs), measurents (PVs), Rarityies,
 * characteristics, cost and more.
 */

public class CreatePokemon {
    private DecimalFormat dc1 = new DecimalFormat("#.00");
    private String name;
    private String gender;
    private ArrayList<Integer> individualValues;
    private ArrayList<Double> personalityValues;
    private ArrayList<String> rarityValues;
    private String characteristic;
    private double cost;

    /**
     * Constructor for the CreatePokemon class. This creates a new instance CreatePokemon with no
     * parameters since everything is random. It choses all the attributes of the pokemon with
     * randomized logic or other methods later on.
     */
    public CreatePokemon() {
        // everything is random
        if ((int) (Math.random() * 2) == 0) {
            gender = "Male";
        }
        else {
            gender = "Female";
        }
        name = randomName();
        individualValues = randomIndividualValues();
        characteristic = randomCharacteristics(individualValues);
        personalityValues = randomPersonalityValues();
        rarityValues = randomRarities();
        cost = Double.parseDouble(dc1.format(randomCardPrice()));
    }
    /**
     * The getInfo method for the CreatePokemon class. This will help fetch
     * all the attributes of the Pokémon.
     * There are no parameters
     * @return returns a String representing a formatted string of all attributes
     */
    public String getInfo() {
        // Nice formating
        String niceIV = "";
        String[] ivStats = new String[]{"HP:", "ATT:", "DEF:", "SATT:", "SDEF:", "SPD:"};

        for (int i = 0; i < individualValues.size(); i++) {
            niceIV += ivStats[i] + individualValues.get(i) + " ";
        }

        String nicePV = "";
        String[] pvStats = new String[]{"Width:", "Height:", "Growth:"};
        for (int i = 0; i < personalityValues.size(); i++) {
            nicePV += pvStats[i] + personalityValues.get(i) + " ";
        }

        String niceRV = "Rarities: ";
        String rarityString = rarityValues.toString();
        niceRV += rarityString.substring(1, rarityString.length() - 1);

        String info = "";
        info += name + " (" + gender + ")" + " \n";
        info += niceIV + " \n";
        info += characteristic + " \n";
        info += nicePV + " \n";
        info += niceRV + " \n";
        info += "Value: $" + cost;

        return info;
    }
    /**
     * The getCost method for the CreatePokemon class. This will help fetch
     * only the cost of the pokemon for logic handling.
     * @return returns a double representing the value of the Pokémon.
     */
    public double getCost() {
        return cost;
    }

    /**
     * The randomName method for the CreatePokemon class. This will help fetch
     * a random name from PokemonNames.txt using a random index between 0-1024
     * @return returns a String representing the name of the Pokémon
     */
    public String randomName() {
        ArrayList<String> names = getFileData("src/PokemonNames");
        int randomNum = (int) (Math.random() * 1025); // Since using index, we only need 0-1024
        return names.get(randomNum);
    }

    /**
     * The randomIndividualValues method for the CreatePokemon class. This will generate
     * random states of attributes like hp, attack, and defense. All between 0-31.
     * @return returns stats, a ArrayList<Integer> representing the numeraical stats of the Pokémon
     */
    public ArrayList<Integer> randomIndividualValues() {
        ArrayList<Integer> stats = new ArrayList<Integer>();
        // stats are 6: hp, attack, defense, specialAttack, specialDefense, speed
        // b/t 0-31
        for (int i = 0; i < 6; i++) {
            stats.add((int) (Math.random() * 32));
        }
        return stats;
    }

    /**
     * The randomCharacteristics method for the CreatePokemon class. This will set a
     * random charactersitc from Characteristics.txt using the pokemon's IV (stats)
     * as a parameter. For example if the pokemons highest value is a 31 on hp, the pokemon
     * may love to eat.
     * @param ivs is the list of stat values b/t 0-31
     * @return returns a string representing a random characteristic based on
     * the highest stat of the pokemon.
     */
    public String randomCharacteristics(ArrayList<Integer> ivs) {
        int max = 31; // find max IV
        int index; // Index for max IV
        int characteristicIndex;
        ArrayList<String> characteristics = getFileData("src/Characteristics"); // 30 characteristics
        String randCharacteristic;

        while (!ivs.contains(max)) {
            max--;
        }
        index = ivs.indexOf(max);
        // formula for characteristics, 5 for each stat, max stat gets a characteristic
        characteristicIndex = (index * 5) + (int) (Math.random() * 5);

        return characteristics.get(characteristicIndex);
    }

    /**
     * The randomPersonalityValues method for the CreatePokemon class. This will generate
     * random ratios of measurements of width, length, and growth. All between 0.5-2.0.
     * @return returns the personality ratios,
     * a ArrayList<double> representing ratios of the measurements of the Pokémon.
     */
    public ArrayList<Double> randomPersonalityValues() {
        ArrayList<Double> personalityRatios = new ArrayList<Double>();
        // ratios are Height ratio, Weight ratio, Growth rate
        for (int i = 0; i < 3; i++) {
            // b/t 0.5 and 2.0
            personalityRatios.add(Double.valueOf(dc1.format(((Math.random() * 15) + 5) / 10)));
        }
        return personalityRatios;
    }
    /**
     * The randomRarities method for the CreatePokemon class. This will generate
     * random rarity values like Shiny  or the coveted Ghost foil within a certain chance
     * @return returns a list of Strings of rarities, since all rarities are possible
     */
    public ArrayList<String> randomRarities() {

        ArrayList<String> rarities = new ArrayList<String>(); // Stores rarties

        // For calculations
        // List of rarities and probabilities
        String[] raritiesPossible = new String[]{"Shiny", "Full art", "Reverse holo", "Ghost foil", "Limited edition", "Das’s signature"};
        String[] chances = new String[]{"1/3", "1/5", "1/10", "1/20", "1/30", "1/50"};

        // uses inequalities for random so we can alter the proabilty freely
        // divides numerator by denominator using indexing to find the /
         for (int i = 0; i < raritiesPossible.length; i++) {
             String chance = chances[i];
             int numerator = Integer.parseInt(chance.substring(0, chance.indexOf("/")));
             int denominator = Integer.parseInt(chance.substring(chance.indexOf("/") + 1));
             int randomNum = (int) (Math.random() * denominator) + 1;
             if (randomNum <= numerator) {
                 rarities.add(raritiesPossible[i]);
             }
        }
         if (rarities.isEmpty()) {
             rarities.add("Normal");
         }
         return rarities;
    }
    /**
     * The randomCardPrice method for the CreatePokemon class. This will generate a random
     * card value using established attributes like IV,PV,RV.
     * @return returns a double of the card's fair value
     */
    public double randomCardPrice() {
        double basePrice = Double.parseDouble(dc1.format( ((int) (Math.random() * 16 + 10) / 100.0))); // b/t
        double costMultiplier = 1;
        int totalIVStats = 0;
        for (int i = 0; i < individualValues.size(); i++) {
            totalIVStats += individualValues.get(i);
        }
        // Multiply cost with IV
        costMultiplier *= (1 + ((double) totalIVStats / 100));

        // Multiply cost with PV
        for (int i = 0; i < personalityValues.size(); i++) {
            costMultiplier *= personalityValues.get(i);
        }

        // Multiply cost with RV
        String[] raritiesPossible = new String[]{"Normal", "Shiny", "Full art", "Reverse holo", "Ghost foil", "Limited edition", "Das’s signature"};
        Double[] costMultiplers = new Double[]{1.0, 3.0, 6.0, 7.0, 9.0, 12.0, 30.0};
        for (int i = 0; i < rarityValues.size(); i++) {
            int indexRarity = Arrays.stream(raritiesPossible).toList().indexOf(rarityValues.get(i));
            costMultiplier *= costMultiplers[indexRarity];
        }
        return (basePrice * costMultiplier);

    }
    /**
     * The getFileData method for the CreatePokemon class. This will use the name of a
     * file as a parameter to extract all the text, with every line appended to a list of strings
     * as a string.
     * @param fileName is the name of the location of the file such as PokemonNames
     * @return returns a list of Strings every line in the file.
     */
    public static ArrayList<String> getFileData(String fileName) {
        // You gave this to me
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}