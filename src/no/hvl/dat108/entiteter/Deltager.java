package no.hvl.dat108.entiteter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "oblig3", name="deltager")
public class Deltager {
	
	@Id
	private String mobilnummer;
	
	private String fornavn;
	private String etternavn;
	private String passord;
	private String salt;
	private String kjoenn;
	
	public Deltager(String mobilnummer, String fornavn, String etternavn, String passord, String kjoenn, String salt) {
		
		this.mobilnummer = mobilnummer;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.passord = passord;
		this.kjoenn = kjoenn;
		this.salt = salt;
	}

	public Deltager() {}

	public String getMobilnummer() {
		return mobilnummer;
	}

	public void setMobilnummer(String mobilnummer) {
		this.mobilnummer = mobilnummer;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public String getPassord() {
		return passord;
	}

	public void setPassord(String passord) {
		this.passord = passord;
	}

	public String getKjoenn() {
		return kjoenn;
	}

	public void setKjoenn(String kjoenn) {
		this.kjoenn = kjoenn;
	}

	public String getSalt() {
		return salt;
	}
	
	public void setSalt(String salt) {
		this.salt = salt;
	}
	
	@Override
	public String toString() {
		return "Deltager [mobilnummer=" + mobilnummer + ", fornavn=" + fornavn + ", etternavn=" + etternavn
				+ ", passord=" + passord + ", salt=" + salt + ", kjoenn=" + kjoenn + "]";
	}
	
	
	

	
	
}
