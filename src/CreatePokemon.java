
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class CreatePokemon {
    String name;
    String gender;
    ArrayList<Integer> individualValues;
    String characteristic;
    public CreatePokemon() {
        if ((int) (Math.random() * 2) == 0) {
            gender = "male";
        }
        else {
            gender = "female";
        }
        name = randomName();
        individualValues = randomIndividualValues();
        characteristic = randomCharacteristics(individualValues);
    }

    public String getInfo() {


        return name + " " + gender + " " + individualValues + " " + characteristic ;
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
ArrayList<String> characteristics = getFileData("src/Characteristics"); // 30 characteristics
String randCharacteristic;

while (!ivs.contains(max)) {
    max--;
}

index = ivs.indexOf(max);

return "a";
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