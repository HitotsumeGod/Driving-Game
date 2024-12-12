import java.util.Random;

class virtualVehicle extends car {

	public virtualVehicle(String modelName) {
	
		switch (modelName) {
		
		case "f_mustang":
			name = "Ford Mustang";
			seating = "leather";
			year = 1999;
			rateOfAcceleration = 4;
			speedCap = 120;
			milesToAGallon = 12;
			gallonsInTank = 24;
			hasPowerSteering = false;
			break;
		case "t_tundra":
			name = "Toyota Tundra";
			seating = "leather";
			year = 2018;
			rateOfAcceleration = 2;
			speedCap = 180;
			milesToAGallon = 8;
			gallonsInTank = 18;
			hasPowerSteering = true;
			break;
		case "s_ascent":
			name = "Subaru Ascent";
			seating = "chrome";
			year = 2017;
			rateOfAcceleration = 1;
			speedCap = 220;
			milesToAGallon = 6;
			gallonsInTank = 12;
			hasPowerSteering = true;
			break;
		
		}
	
	}
	
	private float currentSpeed = 0;
	private float currentDrift = 0;
	private static int gasInTank = 0;
	
	public void increaseSpeed(int toSpeed, boolean printEndSpeed) {
		
		try {
			process(rateOfAcceleration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		currentSpeed += toSpeed;
		gasInTank--;
		if (printEndSpeed)
			System.out.println("Current speed is now " + currentSpeed + "!");
	
	}
	
	public void decreaseSpeed(int toSpeed, boolean printEndSpeed) {
		
		try {
			process(rateOfAcceleration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		currentSpeed -= toSpeed;
		if (printEndSpeed)
			System.out.println("Current speed is now " + currentSpeed + "!");
	
	}
	
	public void drift() {
		
		Random rand = new Random();
		float max = 3.1f;
		float min = 2.7f;
		if (currentSpeed > 0) {
			
			currentSpeed = 0;
			currentDrift = rand.nextFloat((max - min) + 1) + min;
			System.out.println("Vehicle stopped. Drift was " + currentDrift + ".");
			
		}
	
	}
	
	public void getModelDetails() {
	
		System.out.println(name + " (" + year + ")");
		System.out.println("Miles to a gallon : " + milesToAGallon);
		System.out.println("Has power steering : " + hasPowerSteering);
		System.out.println("Type of seating : " + seating);
		System.out.println();
	
	}
	
	public boolean hasGas() {
	
		if (gasInTank <= 0)
			return false;
		return true;
	
	}
	
	public void refuel(int gas) {
		
		currentSpeed = 0;
		gasInTank += gas;
	
	}
	
	public int checkGas() {
	
		return gasInTank;
	
	}
	
	private void process(int num) throws InterruptedException {
	
		System.out.println();
		for (int i = 0; i < num; i++) {
			
			Thread.sleep(200);
			System.out.print(".");
			
		}
	
	}	

}
