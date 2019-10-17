package no.hvl.dat108.EAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat108.entiteter.Deltager;

@Stateless
public class DeltagerEAO {
	
	@PersistenceContext(name="deltagerPU")
	private EntityManager em;
	
	
	public List<Deltager> hentAlleDeltagere() {
		return em.createQuery("SELECT d from Deltager d").getResultList();
	}
	
	public void leggTilDeltager(Deltager d) {	
		em.persist(d);
	}

}
