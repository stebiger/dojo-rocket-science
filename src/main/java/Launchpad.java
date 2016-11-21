import de.oc.hg.dojo.rocketscience.rocket.Rocket;

public class Launchpad {

	public static void main(String[] args) {
		iteration1();
//		iteration2();
//		iteration3();
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
		String rocket = new Rocket().createRockets("Hello");
		System.out.print(rocket);
		for(int i=0; i < 100000; i++) {
			if(i%2 == 0) {
				System.out.print("\r VvV");
			} else {
				System.out.print("\r vVv");
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}

}
