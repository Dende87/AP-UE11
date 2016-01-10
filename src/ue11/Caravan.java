package ue11;

import java.util.ArrayList;

public class Caravan {

	LeaderCamel leaderCamel;
	private ArrayList<Camel> camelList = new ArrayList<Camel>();
	private int distanceToTarget;

	public Caravan(LeaderCamel leaderCamel) {
		this.leaderCamel = leaderCamel;
	}

	/**
	 * F�gt ein Kamel der Caravane zu
	 * @param camel camel (Camel)
	 */
	public void addCamel(Camel camel) {
		this.camelList.add(camel);
	}

	/**
	 * Setzt die Distanz zum n�chsten Ziel
	 * @param distance distance (int)
	 */
	public void setDistanceToTarget(int distance) {
		this.distanceToTarget = distance;
	}

	/**
	 * Gibt die Distanz zum n�chsten Ziel zur�ck
	 * @return distance to Target (int)
	 */
	public int getDistanceToTarget() {
		return distanceToTarget;
	}

	/**
	 * F�gt der Caravane Last hinzu, diese wird Gleichm��ig auf alle Kamele verteilt
	 * @param load load (int)
	 */
	public void addLoad(int load) {

		Camel camel = null;
		for (int i = 0; i < load; i++) {
			camel = getFastesCamel();
			if (!camel.getMoveable()) {
				System.out.println(i + " Einheiten k�nnen nicht verteilt werden!");
				return;
			}
			camel.setLoad(1);
		}
	}

	/**
	 * Gibt die zu erwartende Zeit aus bis das Ziel erreicht werden k�nnte.
	 */
	public void printEstimatedTravelTime(){
		// Distanze geteilt durch langsamstes Camel

		double estimatedTime = getDistanceToTarget() / getSlowestCamel().getCurrentPace();
		System.out.println("Erwartete ankunft in: " + estimatedTime + "h");
	}

	/**
	 * Gibt das langsamste Kamel zur�ck
	 * @return slowest Camel (Camel) throws Exception if one Camel cannot move
	 */
	private Camel getSlowestCamel(){

		if (getFastesCamel().getCurrentPace() <= 0) throw new IllegalArgumentException("Deine Kamele sind �berladen!");
		
		int minPace = getFastesCamel().getCurrentPace();
		Camel camel = null;
		for (Camel currentCamel : camelList) {
			if (currentCamel.getCurrentPace() < minPace) {
				minPace = currentCamel.getCurrentPace();
				camel = currentCamel;
			}
		}

		return camel;
	}

	/**
	 * Gibt das schnellste Kamel zur�ck
	 * @return fastes Camel (Camel)
	 */
	private Camel getFastesCamel() {

		int maxPace = 0;
		Camel camel = null;
		for (Camel currentCamel : this.camelList) {
			if (currentCamel.getCurrentPace() > maxPace) {
				maxPace = currentCamel.getCurrentPace();
				camel = currentCamel;
			}
		}

		if (camel == null) {
			return this.camelList.get(0);
		}

		return camel;
	}

}
