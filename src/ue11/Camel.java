package ue11;

public class Camel {

	// Max Tempo
	private int maxPace;
	// Camel Name
	private String name;
	// zu tragendes Gewicht
	private int load;
	// derzeitiges Gewicht
	private int currentPace;
	// Bewegungsfähig? bzw überladen?
	private boolean moveable;

	/**
	 * Constructor
	 * 
	 * @param name
	 *            Name des Kamels
	 * @param maxPace
	 *            Maximales Tempo
	 */
	public Camel(String name, int maxPace) {
		this.name = name;
		this.maxPace = maxPace;
		this.load = 0;
		moveable = true;
	}

	/**
	 * holt das Aktuelle maximale Tempo des Kamels
	 * 
	 * @return currentPace (int)
	 */
	public int getCurrentPace() {
		return this.currentPace = maxPace - load;
	}

	/**
	 * Gibt die Bewegungsfähigkeit zurück
	 * @return moveablitiy (boolean)
	 */
	public boolean getMoveable() {
		return this.moveable;
	}

	/**
	 * Setzt das zu tragende Gewicht des Kamels
	 * @param load weight (int)
	 */
	public void setLoad(int load) {
		if (getCurrentPace() - load <= 0) {
			this.currentPace = 0;
			moveable = false;
		} else {
			this.currentPace = getCurrentPace() - load;
		}

		this.load += load;
	}

	/**
	 * Gibt das aktuell zu tragende Gewicht aus
	 * @return load (int)
	 */
	public int getLoad() {
		return load;
	}

	/**
	 * Gibt das mögliche maximale Tempo zurück, welches das Kamel ohne Gewicht leistet
	 * @return maxPace (int)
	 */
	public int getMaxPace() {
		return maxPace;
	}

	/**
	 * Gibt den Namen des Kamels zurück
	 * @return name (String)
	 */
	public String getName() {
		return name;
	}

}
