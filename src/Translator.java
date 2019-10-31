import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Locale;

public class Translator {

	public static String translate(String textToTranslate, String translateFrom, String translateTo) throws Exception {
		try {
			String pageSource = getPageSource(textToTranslate, translateFrom, translateTo);
			String[] translatedText1 = pageSource.split("div dir=\"ltr\" class=\"t0\">");
			String[] translatedText2 = translatedText1[1].split("</");
			return translatedText2[0];
		} catch (Exception e) {
			return "There was an error translating the text.";
		}
	}

	private static String getPageSource(String textToTranslate, String translateFrom, String translateTo) throws Exception{
		String pageUrl = String.format("https://translate.google.com/m?sl=%s&tl=%s&q=%s", translateFrom, translateTo, URLEncoder.encode(textToTranslate, "UTF-8"));
		URL url = new URL(pageUrl);
		HttpURLConnection connection = null;
		BufferedReader bufferedReader = null;
		StringBuilder pageSource = new StringBuilder();
		try {
			connection = (HttpURLConnection) url.openConnection();
			connection.setConnectTimeout(15000);
			connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
			bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				pageSource.append(line + System.lineSeparator());
			}
			return pageSource.toString();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null) connection.disconnect();
			if (bufferedReader != null) bufferedReader.close();
		}
		return null;
	}

}
