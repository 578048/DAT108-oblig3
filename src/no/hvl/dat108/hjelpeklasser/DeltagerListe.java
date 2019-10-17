package no.hvl.dat108.hjelpeklasser;

import java.util.ArrayList;
import java.util.List;

import no.hvl.dat108.entiteter.Deltager;

public class DeltagerListe {
	
	private List<Deltager> deltagerListe;
	
	public DeltagerListe() {
		deltagerListe = new ArrayList<Deltager>();
	}
	
	public List<Deltager> getDeltagerListe() {
		return deltagerListe;
	}
	
	public void leggTilDeltager(Deltager d) {
		deltagerListe.add(d);
	}

}
