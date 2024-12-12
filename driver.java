import java.util.Scanner;

public class driver {

	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
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
		vv.getModelDetails();
		while (true) {
		
		System.out.println("s : increase speed");
		System.out.println("d : decrease speed");
		System.out.println("u : drift");
		a = scan.nextLine().charAt(0);
		switch (a) {
		
		case 's': 
			n = scan.nextInt();
			vv.increaseSpeed(n, true);
			break;
		case 'd':
			n = scan.nextInt();
			vv.decreaseSpeed(n, true);
			break;
		case 'u':
			vv.drift();
			break;
			
		}
		if (vv.hasGas()) {
		
		System.out.println("Enter 'kill' to close, or anything else to continue playing.");
		scan.nextLine();
		s = scan.nextLine();
		if (s.equals("kill"))
			break;
		
		} else {
		
			System.out.println("No more gas! Refuel? (y/n)");
			scan.nextLine();
			a = scan.nextLine().charAt(0);
			if (a != 'y')
				return;
			vv.refuel(vv.gallonsInTank);
			System.out.println("Tank now has = " + vv.checkGas() + " gallons of gas.");
			
		}

		}
		scan.close();
	}

}
