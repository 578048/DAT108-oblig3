package no.hvl.dat108.EAO;

import org.eclipse.persistence.exceptions.DatabaseException;

import org.postgresql.util.PSQLException;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.postgresql.util.PSQLException;

import no.hvl.dat108.entiteter.Deltager;

@Stateless
public class DeltagerEAO {
	
	@PersistenceContext(name="deltagerPU")
	private EntityManager em;
	
	
	
	public List<Deltager> hentAlleDeltagere() {
		return em.createQuery("SELECT d from Deltager d").getResultList();
	}
	
	public boolean leggTilDeltager(Deltager d) {
		
		Deltager m = hentDeltagerMedBrukernavn(d.getMobilnummer());
		if (m == null) {
			em.persist(d);
			return true;
		}
	
		return false;
	}
	
	public Deltager hentDeltagerMedBrukernavn(String nokkel) {
		try {		
			return (Deltager) em.createQuery("SELECT d from Deltager d WHERE d.mobilnummer = " + nokkel).getSingleResult();
			//return em.find(Deltager.class, nokkel);
		} catch (NoResultException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
}
	