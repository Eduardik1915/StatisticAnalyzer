import java.util.Arrays;

public class Alphabet {
    private static final char[] ALPHABET = {
            'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й',
            'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф',
            'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я',
            ' ', '!', '"', ',', '-', '.', ':', '?', '\n',
            '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'
    };

    public static char[] sortedAlphabet(){
        char[] array = ALPHABET;
        Arrays.sort(array);
        return array;
    }

    public static int alphabetLength(){
        return ALPHABET.length;
    }
}