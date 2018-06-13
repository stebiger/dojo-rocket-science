import de.oc.hg.dojo.rocketscience.rocket.RocketFactory;

public class Launchpad {

	public static void main(String[] args) {
		iteration1();
		System.out.println();
		iteration2();
		System.out.println();
		iteration3();
	}
	
	private static void iteration1() {
		String rocket = new RocketFactory().createRockets("Hello");
		System.out.println(rocket);
	}
	
	private static void iteration2() {
		String rockets = new RocketFactory().createRockets("Gurkensalat Das Pferd frisst keinen");
		System.out.println(rockets);
	}
	
	private static void iteration3() {
		String input = "Hello THM";
		String rocket = new RocketFactory().createRockets(input);
		System.out.print(rocket);
		
		
		for(int i=0; i < Integer.MAX_VALUE; i++) {
			if(i%2 == 0) {
				String waves = createWaves(input, "VvV ");
				System.out.print("\r" + waves);
			} else {
				String waves = createWaves(input, "vVv ");
				System.out.print("\r" + waves);
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}		
	}

	private static String createWaves(String input, String style) {
		String[] strings = input.split(" ");
		StringBuilder waves = new StringBuilder();
		for (String string : strings) {
			waves.append(" ").append(style);
		}
		
		return waves.toString();
	}

}
