package App;

public class Display {
    public void DisplayWord(String word, boolean[] charactersGuessed) {
        StringBuilder wordToDisplay = new StringBuilder();

        for (byte i = 0; i < charactersGuessed.length; i++) {
            if (charactersGuessed[i]) {
               wordToDisplay.append(word.charAt(i));
            } else {
                wordToDisplay.append('_');
            }
        }

        System.out.println(wordToDisplay);
    }
}
