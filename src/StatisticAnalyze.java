import java.io.*;
import java.util.*;

public class StatisticAnalyze {
    public static void analyze(String source, String dest, String example) {
        int dictionaryLength;
        int encryptedLength;
        char[] alphabet = Alphabet.sortedAlphabet();
        HashMap<Character, Float> dictionaryCharMap = new HashMap<>();
        HashMap<Character, Float> encryptedCharMap = new HashMap<>();

        //fill maps with keys as characters and values as 0
        fillMapsWithKeys(alphabet, dictionaryCharMap);
        fillMapsWithKeys(alphabet, encryptedCharMap);

        try {
            dictionaryLength = fillMapWithCharSequenceAndGetFileLength(example, dictionaryCharMap);
            encryptedLength = fillMapWithCharSequenceAndGetFileLength(source, encryptedCharMap);

            updateMapValuesToPercentSequence(dictionaryCharMap, dictionaryLength);
            updateMapValuesToPercentSequence(encryptedCharMap, encryptedLength);

            HashMap<Character, Float> sortedDictionaryCharMap = sortHashMapByValues(dictionaryCharMap);
            HashMap<Character, Float> sortedEncryptedCharMap = sortHashMapByValues(encryptedCharMap);

            ArrayList<Character> dictionaryMapKeys = new ArrayList<>(sortedDictionaryCharMap.keySet());
            ArrayList<Character> encryptedMapKeys = new ArrayList<>(sortedEncryptedCharMap.keySet());

            writeStatisticDataToFile(dest, source, dictionaryMapKeys, encryptedMapKeys);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void fillMapsWithKeys(char[] alphabet, HashMap<Character, Float> encryptedCharMap) {
        for (char c : alphabet) {
            encryptedCharMap.put(c, 0F);
        }
    }

    private static void updateMapValuesToPercentSequence(HashMap<Character, Float> dictionaryCharMap, int dictionaryLength) {
        for (Map.Entry<Character, Float> entry : dictionaryCharMap.entrySet()) {
            dictionaryCharMap.replace(entry.getKey(), entry.getValue() * 100F / dictionaryLength);
        }
    }

    private static int fillMapWithCharSequenceAndGetFileLength(String example, HashMap<Character, Float> dictionaryCharMap) throws IOException {
        int length = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(example))) {
            while (reader.ready()) {
                String line = reader.readLine();
                length += line.length();
                char[] character = line.toCharArray();
                for (char ch : character) {
                    for (Map.Entry<Character, Float> entry : dictionaryCharMap.entrySet()) {
                        if (ch == entry.getKey()) {
                            dictionaryCharMap.replace(entry.getKey(), entry.getValue() + 1);
                        }
                    }
                }
            }
        }
        return length;
    }

    private static void writeStatisticDataToFile(String dest, String source, ArrayList<Character> dictionaryMapKeys, ArrayList<Character> encryptedMapKeys) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dest));
             BufferedReader reader = new BufferedReader(new FileReader(source))) {
            while (reader.ready()) {
                String line = reader.readLine().toLowerCase();
                char[] arr = line.toCharArray();
                for (char c : arr) {
                    for (int j = 0; j < encryptedMapKeys.size(); j++) {
                        if (c == encryptedMapKeys.get(j)) {
                            writer.write(dictionaryMapKeys.get(j));
                        }
                    }
                }
            }
        }
    }

    private static LinkedHashMap<Character, Float> sortHashMapByValues(HashMap<Character, Float> passedMap) {
        List<Character> mapKeys = new ArrayList<>(passedMap.keySet());
        List<Float> mapValues = new ArrayList<>(passedMap.values());
        Collections.sort(mapKeys);
        Collections.sort(mapValues);

        LinkedHashMap<Character, Float> sortedMap = new LinkedHashMap<>();

        for (Float val : mapValues) {
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

