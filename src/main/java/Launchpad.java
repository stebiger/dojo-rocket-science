import de.oc.hg.dojo.rocketscience.rocket.Rocket;

public class Launchpad {

	public static void main(String[] args) {
//		iteration1();
//		iteration2();
		iteration3();
	}
	
	private static void iteration1() {
		String rocket = new Rocket().createRockets("Hello");
		System.out.print(rocket);
	}
	
	private static void iteration2() {
		String rockets = new Rocket().createRockets("Das Pferd frisst keinen Gurkensalat");
		System.out.println(rockets);
	}
	
	private static void iteration3() {
		String input = "Hello THM";
		String rocket = new Rocket().createRockets(input);
		System.out.print(rocket);
		
		
		for(int i=0; i < 100000; i++) {
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
