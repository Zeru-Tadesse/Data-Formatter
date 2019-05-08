package Main;

import java.awt.Desktop;
import java.net.URI;
import java.util.Scanner;

/*
 * Given a list of classes opens its corresponding course catalog search page and waits for an input
 */
public class WebManager {

	public static String openAndWait(String className, String classNumber) {
		String discription = "";
		String url = "http://catalog.jmu.edu/search_advanced.php?cur_cat_oid=10&search_database=Search&search_db=Search&cpage=1&ecpage=1&ppage=1&spage=1&tpage=1&location=33&filter%5Bkeyword%5D="
				+ className + "+" + classNumber;
		// open website
		try {
			Desktop desktop = java.awt.Desktop.getDesktop();
			URI oURL = new URI(url);
			desktop.browse(oURL);
		} catch (Exception e) {
			// e.printStackTrace();
		}
		// ask for input
		Scanner sc = new Scanner(System.in);
		System.out.println("Discription for " + className + " " + classNumber + ": ");
		discription = sc.nextLine();

		discription = discription.replace(",", ";");
		// clean input
		return discription;

	}
	//
	
}
