package morseCode;

import static morseCode.MorseCode.englishToMorse;
import static morseCode.MorseCode.morseToEnglish;

import java.util.HashMap;
import java.util.Map;

public abstract class morseTable {

    private HashMap<Character, String> englishMap = new HashMap<>();
    private HashMap<String, Character> morseMap = new HashMap<>();

    public morseTable() {
        englishMap.put('A', ".-");
        englishMap.put('B', "-...");
        englishMap.put('C', "-.-.");
        englishMap.put('D', "-..");
        englishMap.put('E', ".");
        englishMap.put('F', "..-.");
        englishMap.put('G', "--.");
        englishMap.put('H', "....");
        englishMap.put('I', "..");
        englishMap.put('J', ".---");
        englishMap.put('K', "-.-");
        englishMap.put('L', ".-..");
        englishMap.put('M', "--");
        englishMap.put('N', "-.");
        englishMap.put('O', "---");
        englishMap.put('P', ".--.");
        englishMap.put('Q', "--.-");
        englishMap.put('R', ".-.");
        englishMap.put('S', "...");
        englishMap.put('T', "-");
        englishMap.put('U', "..-");
        englishMap.put('V', "...-");
        englishMap.put('W', ".--");
        englishMap.put('X', "-..-");
        englishMap.put('Y', "-.--");
        englishMap.put('Z', "--..");
        englishMap.put(' ', "/");

        for (Map.Entry<Character, String> entry : englishMap.entrySet()) {
            morseMap.put(entry.getValue(), entry.getKey());
        }
    }

    public HashMap<Character, String> getMorse(){
        return englishMap;
    }

    public HashMap<String, Character> getEnglish(){
        return morseMap;
    }
}
