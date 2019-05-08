
package Main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Driver {
	public static void main(String[] args) throws IOException {
		//String disc = WebManager.openAndWait("cs", "345");
		String disc = "hi";
		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = Files.newBufferedReader(Paths.get("courses.txt"))) {
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (IOException e) {
			System.err.format("IOException: %s%n", e);
		}
		BufferedWriter writer = new BufferedWriter (new FileWriter("newFile.txt"));
		String[] lines = sb.toString().split("\n");
		for (String l : lines) {
			writer.append( WebManager.openAndWait(l.split("\t")[0], l.split("\t")[1]));
			writer.append("\n");
		}
		writer.close();
	}
}
