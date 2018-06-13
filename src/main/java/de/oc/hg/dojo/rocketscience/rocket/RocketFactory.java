package de.oc.hg.dojo.rocketscience.rocket;

import java.util.ArrayList;
import java.util.List;

public class RocketFactory {

	public String createRockets(String input) {
		String[] words = input.split(" ");
		
		int sizeOfLongestRocket = calculateSizeOfLongestRocket(words);

		List<List<String>> listOfRockets = buildRockets(words, sizeOfLongestRocket);

		String output = buildStringOutputForConsole(sizeOfLongestRocket, listOfRockets);
		
		return output;
	}

	private String buildStringOutputForConsole(int sizeOfLongestRocket, List<List<String>> listOfRockets) {
		
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

	private List<List<String>> buildRockets(String[] words, int sizeOfLongestRocket) {
		List<List<String>> listOfRockets = new ArrayList<List<String>>();

		for (String word : words) {
			List<String> rocket = buildRocket(word);
			listOfRockets.add(rocket);
			int size = rocket.size();
			
			if (size < sizeOfLongestRocket) {
				int difference = sizeOfLongestRocket - size;
				ArrayList<String> gapFillings = new ArrayList<String>(difference);
				for (int i = 0; i < difference; i++) {
					gapFillings.add(RocketFactoryConsts.WHITESPACE_GAP_FOR_ROCKETS);
				}
				rocket.addAll(0, gapFillings);
			}
		}
		
		return listOfRockets;
	}

	private int calculateSizeOfLongestRocket(String[] words) {
		int sizeOfLongestRocket = 0;
		
		for (String word : words) {
			sizeOfLongestRocket = Math.max(sizeOfLongestRocket, word.length());
		}

		sizeOfLongestRocket += RocketFactoryConsts.NUMBER_OF_DEFAULT_PARTS; // all default parts included!
		return sizeOfLongestRocket;
	}

	private List<String> buildRocket(String word) {
		List<String> rocketString = new ArrayList<String>();

		rocketString.add(RocketFactoryConsts.headTop);
		rocketString.add(RocketFactoryConsts.head);

		for (int i = 0; i < word.length(); i++) {
			rocketString.add(" |" + word.charAt(i) + "| ");
		}

		rocketString.add(RocketFactoryConsts.bodyPart);
		rocketString.add(RocketFactoryConsts.bottom);
		rocketString.add(RocketFactoryConsts.flames);

		return rocketString;
	}
}
