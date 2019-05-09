package Format;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FormatUtils {
	public static void writeForExcell(String text) {

		// ANTH 315. Human Evolution
		// ANTH 316. Human Evolutionary Psychology
		String newText = "";
		String[] lines = text.split("\n");

		for (String line : lines) {
			newText += line.split("\\.", 2)[0].split(" ")[0] + "\t" + line.split("\\.",2)[0].split(" ")[1] + "\t" + line.split("\\.", 2)[1] + "\n";
		}
		System.out.println(newText);

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("parsedCourseList.txt"));
			writer.append(newText);

			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
