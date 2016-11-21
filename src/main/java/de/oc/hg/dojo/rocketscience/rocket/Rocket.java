package de.oc.hg.dojo.rocketscience.rocket;

import java.util.ArrayList;
import java.util.List;

public class Rocket {

	private String headTop  = "  |  ";
	private String head     = " /_\\ ";
	private String bodyPart = " |_| ";
	private String bottom   = "/___\\";
	private String flames   = " VvV ";
	
	public String createRockets(String input) {
		String[] words = input.split(" ");
		int sizeOfLongestRocket = 0;
		for (String word : words) {
			sizeOfLongestRocket = Math.max(sizeOfLongestRocket, word.length());
		}

		sizeOfLongestRocket += 5; // all default parts included!

		List<List<String>> listOfRockets = new ArrayList<List<String>>();

		for (String word : words) {
			List<String> rocket = buildRocket(word);
			listOfRockets.add(rocket);
			int size = rocket.size();
			
			if (size < sizeOfLongestRocket) {
				int differenz = sizeOfLongestRocket - size;
				ArrayList<String> fueller = new ArrayList<String>(differenz);
				for (int i = 0; i < differenz; i++) {
					fueller.add("     ");
				}
				rocket.addAll(0, fueller);
			}
		}

		StringBuilder output = new StringBuilder();
		for (int i = 0; i < sizeOfLongestRocket; i++) {
			for (List<String> l : listOfRockets) {
				output.append(l.get(i));
			}
			output.append("\n");
		}
		output.deleteCharAt(output.length() - 1);
		return output.toString();
	}

	private List<String> buildRocket(String word) {
		List<String> rocketString = new ArrayList<String>();

		rocketString.add(headTop);
		rocketString.add(head);

		for (int i = 0; i < word.length(); i++) {
			rocketString.add(" |" + word.charAt(i) + "| ");
		}

		rocketString.add(bodyPart);
		rocketString.add(bottom);
		rocketString.add(flames);

		return rocketString;
	}
}
