
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
public class CreatePokemon {
    DecimalFormat dc1 = new DecimalFormat("#.00");
    String name;
    String gender;
    ArrayList<Integer> individualValues;
    ArrayList<Double> personalityValues;
    ArrayList<String> rarityValues;
    String characteristic;
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
    }

    public String getInfo() {


        return name + " \n" +
                gender + " \n" +
                individualValues + " " + characteristic + " " + personalityValues;
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
        ArrayList<String> rarities = new ArrayList<String>();
        ArrayList<String> raritiesPossible = getFileData("src/Rarities");
        ArrayList<String> chancesMultiplier = getFileData("src/RaritiesProbability")        ArrayList<String> multiplier;
        Integer[] chances = new Integer[]{1, 3, 5, 10, 20, 30, 50};


         for (int i = 0; i <= chancesMultiplier.size(); i++) {
            int chance = Integer.parseInt(chancesMultiplier.get(i).substring(0, chancesMultiplier.get(i).indexOf(",")));
        }
        return personalityRatios;
    }


        // Normal (1/1) (1xValue)
        //Shininess (1/3) (1.4xValue)
        //Full art  (1/5) (1.8xValue)
        //Reverse holo (1/10) (2.6xValue)
        //Ghost foil (1/20) (4.0xValue)
        //Limited edition (1/30) (6.5xValue)
        //Das’s signature (1/50) (10xValue)
        //Returns a string of rarity value
        //If no rarity, return normal

        for (int i = 0; i < 3; i++) {
            // b/t 0.5 and 2.0
            personalityRatios.add(Double.valueOf(dc1.format(((Math.random() * 15) + 5) / 10)));
        }
        return personalityRatios;
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