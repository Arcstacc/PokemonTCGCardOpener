
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class CreatePokemon {
    private DecimalFormat dc1 = new DecimalFormat("#.00");
    private String name;
    private String gender;
    private ArrayList<Integer> individualValues;
    private ArrayList<Double> personalityValues;
    private ArrayList<String> rarityValues;
    private String characteristic;
    private double cost;

    public CreatePokemon() {
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

    public String getInfo() {
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


    public double getCost() {
        return cost;
    }

    public String randomName() {
        ArrayList<String> names = getFileData("src/PokemonNames");
        int randomNum = (int) (Math.random() * 1025); // Since using index, we only need 0-1024
        return names.get(randomNum);
    }

    public ArrayList<Integer> randomIndividualValues() {
        ArrayList<Integer> stats = new ArrayList<Integer>();
        // stats are 6: hp, attack, defense, specialAttack, specialDefense, speed
        for (int i = 0; i < 6; i++) {
            stats.add((int) (Math.random() * 32));
        }
        return stats;
    }

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
        characteristicIndex = (index * 5) + (int) (Math.random() * 5);

        return characteristics.get(characteristicIndex);
    }

    public ArrayList<Double> randomPersonalityValues() {
        ArrayList<Double> personalityRatios = new ArrayList<Double>();
        // ratios are Height ratio, Weight ratio, Growth rate
        for (int i = 0; i < 3; i++) {
            // b/t 0.5 and 2.0
            personalityRatios.add(Double.valueOf(dc1.format(((Math.random() * 15) + 5) / 10)));
        }
        return personalityRatios;
    }

    public ArrayList<String> randomRarities() {

        ArrayList<String> rarities = new ArrayList<String>(); // Stores rarties

        // For calculations
        String[] raritiesPossible = new String[]{"Shiny", "Full art", "Reverse holo", "Ghost foil", "Limited edition", "Das’s signature"};
        String[] chances = new String[]{"1/3", "1/5", "1/10", "1/20", "1/30", "1/50"};

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

    public double randomCardPrice() {
        double basePrice = Double.parseDouble(dc1.format( ((int) (Math.random() * 16 + 10) / 100.0))); // b/t
        double costMultiplier = 1;
        int totalIVStats = 0;
        for (int i = 0; i < individualValues.size(); i++) {
            totalIVStats += individualValues.get(i);
        }
        // Multiply cost with IV

        costMultiplier *= (1 + ((double) totalIVStats / 100));
//        System.out.println(costMultiplier);

        // Multiply cost with PV
        for (int i = 0; i < personalityValues.size(); i++) {
            costMultiplier *= personalityValues.get(i);
        }
//        System.out.println(costMultiplier);

        // Multiply cost with RV
        String[] raritiesPossible = new String[]{"Normal", "Shiny", "Full art", "Reverse holo", "Ghost foil", "Limited edition", "Das’s signature"};
        Double[] costMultiplers = new Double[]{1.0, 3.0, 6.0, 7.0, 9.0, 12.0, 30.0};
        for (int i = 0; i < rarityValues.size(); i++) {
            int indexRarity = Arrays.stream(raritiesPossible).toList().indexOf(rarityValues.get(i));
            costMultiplier *= costMultiplers[indexRarity];
        }
//        System.out.println("Base: " + basePrice);
//        System.out.println("Multipler: " + costMultiplier);
        return (basePrice * costMultiplier);

    }

    public static ArrayList<String> getFileData(String fileName) {
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