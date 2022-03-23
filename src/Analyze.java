
import javax.swing.*;
import java.io.*;
import java.util.*;

public class Analyze {

    public static void analyze(String source, String dest, String example) {
        try (BufferedReader sourceReader = new BufferedReader(new FileReader(source));
             BufferedReader dictionaryReader = new BufferedReader(new FileReader(example));
             BufferedWriter destWriter = new BufferedWriter(new FileWriter(dest))) {

            char[] alphabet = Alphabet.sortedAlphabet();
            ArrayList<Character> dictionaryCharList = new ArrayList<>();
            ArrayList<Character> encryptedCharList = new ArrayList<>();

            HashMap<Character, Float> dictionaryCharMap = new HashMap<>();
            HashMap<Character, Float> encryptedCharMap = new HashMap<>();

            HashMap<Character, Character> replaceCharMap = new HashMap<>();

            //encrypted and dictionary files are copied to ArrayLists
            fileToList(dictionaryReader, dictionaryCharList, dictionaryReader.read());
            fileToList(sourceReader, encryptedCharList, Character.toLowerCase(sourceReader.read()));

            //two maps filled with character frequency
            charFrequencyMap(alphabet, dictionaryCharList, dictionaryCharMap);
            charFrequencyMap(alphabet, encryptedCharList, encryptedCharMap);

            //maps with char frequency sorted by values
            HashMap<Character, Float> sortedDictionaryCharMap = Analyze.sortHashMapByValues(dictionaryCharMap);
            HashMap<Character, Float> sortedEncryptedCharMap = Analyze.sortHashMapByValues(encryptedCharMap);

            //keys from sorted maps copied to ArrayLists in same order
            ArrayList<Character> list1 = new ArrayList<>(sortedDictionaryCharMap.keySet());
            ArrayList<Character> list2 = new ArrayList<>(sortedEncryptedCharMap.keySet());


            fileWriter(destWriter, encryptedCharList, list1, list2);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void fileWriter(BufferedWriter destWriter, ArrayList<Character> encryptedCharList, ArrayList<Character> list1, ArrayList<Character> list2) throws IOException {
        for (char character : encryptedCharList) {
            for (int j = 0; j < list2.size(); j++) {
                if (character == list2.get(j)) {
                    destWriter.write(list1.get(j));
                }
            }

        }
    }

    private static void charFrequencyMap(char[] alphabet, ArrayList<Character> dictionaryCharList, HashMap<Character, Float> dictionaryCharMap) {
        for (char c : alphabet) {
            int charCount = 0;
            for (Character character : dictionaryCharList) {
                if (character == c) {
                    charCount++;
                }
            }
            float charFrequency = (charCount * 100F) / dictionaryCharList.size();
            dictionaryCharMap.put(c, charFrequency);
        }
    }


    private static void fileToList(BufferedReader dictionaryReader, ArrayList<Character> dictionaryCharList, int dictionaryReader1) throws IOException {
        while (dictionaryReader.ready()) {
            dictionaryCharList.add((char) dictionaryReader1);
        }
    }

    private static LinkedHashMap<Character, Float> sortHashMapByValues(HashMap<Character, Float> passedMap) {
        List<Character> mapKeys = new ArrayList<>(passedMap.keySet());
        List<Float> mapValues = new ArrayList<>(passedMap.values());
        Collections.sort(mapKeys);
        Collections.sort(mapValues);

        LinkedHashMap<Character, Float> sortedMap = new LinkedHashMap<>();

        for (Float val : mapValues){
            Iterator<Character> keyIt = mapKeys.iterator();
            while (keyIt.hasNext()) {
                char key = keyIt.next();
                Float comp1 = passedMap.get(key);

                if (comp1.equals(val)) {
                    keyIt.remove();
                    sortedMap.put(key, val);
                    break;
                }
            }
        }
        return sortedMap;
    }
}