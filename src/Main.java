import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter text to translate: ");
		String textToTranslate = input.nextLine();
		String translatedText = Translator.translate(textToTranslate, Language.AUTO_DETECT, Language.ENGLISH);
		System.out.println("Translated text: " + translatedText);
	}
	
}
