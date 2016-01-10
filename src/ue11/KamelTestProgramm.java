package ue11;

public class KamelTestProgramm {

	public static void main(String[] args) {
		// Parameter der Kamele: Name, maxpace
		LeaderCamel sandy = new LeaderCamel("Sandy", 12);
		Camel sahara = new Camel("Sahara", 18);
		Camel thunder = new Camel("Thunder", 13);
		Caravan dacar = new Caravan(sandy);
		dacar.addCamel(sahara);
		dacar.addCamel(thunder);
		dacar.setDistanceToTarget(26); // 75km bis Dakar
		dacar.addLoad(20); // Verteile Beladung optimal
		dacar.printEstimatedTravelTime();
		// Reisezeit bei derzeitiger Beladung?
		dacar.addLoad(25); // Mehr Ladung, verteile wieder optimal
		dacar.printEstimatedTravelTime();
		// Reisezeit bei derzeitiger Beladung?
	}

}
