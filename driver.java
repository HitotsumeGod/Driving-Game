import java.util.Scanner;

public class driver {

	public void carMenu() {
	
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("g : get model details");
		System.out.println("s : increase speed");
		System.out.println("d : decrease speed");
		System.out.println("u : drift");
		System.out.println();
	
	}

	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		driver driver = new driver();
		String s;
		int n;
		char a;
		System.out.println("Would you like to initialize a new virtual vehice? (y/n)");
		while (true) {
			
			a = scan.nextLine().charAt(0);
			if (a == 'y')
				break;
			if (a == 'n')
				return;
	
		}
		System.out.println("What kind of car would you like?");
		String result = scan.nextLine().trim();
		virtualVehicle vv = new virtualVehicle(result);
		while (true) {
		
		driver.carMenu();
		a = scan.nextLine().charAt(0);
		switch (a) {
		
		case 'g':
			vv.getModelDetails();
			break;
		case 's': 
			n = scan.nextInt();
			scan.nextLine();
			vv.increaseSpeed(n, true);
			break;
		case 'd':
			n = scan.nextInt();
			scan.nextLine();
			vv.decreaseSpeed(n, true);
			break;
		case 'u':
			vv.drift();
			break;
			
		}
		if (vv.hasGas()) {
		
		} else {
		
			System.out.println("No more gas! Refuel? (y/n)");
			a = scan.nextLine().charAt(0);
			if (a != 'y')
				return;
			vv.refuel(vv.gallonsInTank);
			System.out.println("Tank now has = " + vv.checkGas() + " gallons of gas.");
			
		}

		}
	}

}
