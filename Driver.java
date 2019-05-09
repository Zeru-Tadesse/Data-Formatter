import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Driver {
	public static void main(String[] args) throws IOException {
		parseCourseList();
	}

	// use after get class list
	public static void parseCourseList() {
		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = Files.newBufferedReader(Paths.get("unparsedCourseList.txt"))) {
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (IOException e) {
			System.err.format("IOException: %s%n", e);
		}
		Format.FormatUtils.writeForExcell(sb.toString());

	}

	public static void getClassList() throws IOException {
		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = Files.newBufferedReader(Paths.get("subjectList.txt"))) {
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (IOException e) {
			System.err.format("IOException: %s%n", e);
		}
		String[] lines = sb.toString().split("\n");
		for (String l : lines) {
			WebManager.openPrefix(l);
		}

		// String list_of_classes = WebManager.openPrefix("ACTG");

	}

	// being replaced
	public static void findClassInfo() throws IOException {

		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = Files.newBufferedReader(Paths.get("courses.txt"))) {
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (IOException e) {
			System.err.format("IOException: %s%n", e);
		}
		BufferedWriter writer = new BufferedWriter(new FileWriter("newFile.txt"));
		String[] lines = sb.toString().split("\n");
		for (String l : lines) {
			writer.append(WebManager.openClass(l.split("\t")[0], l.split("\t")[1]));
			writer.append("\n");
		}
		writer.close();
	}

}
