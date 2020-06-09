package consomi.entities;


import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonDeserialize(using = ApplicationUserDeserializer.class)
public class Liv {
	//@JsonProperty("Id")
	//@SerializedName("Id")
	private int id;

	//@JsonProperty("Mail")
	//@SerializedName("Mail")
	private String Mail;
	//@JsonProperty("adresse")
	//@SerializedName("adresse")
	private String adresse;

	//@JsonProperty("idU")
	//@SerializedName("idU")
	private int idU;
	//@JsonProperty("activite")
	//@SerializedName("activite")
	private int activite;
	
	//@JsonProperty("etat")
		//@SerializedName("etat")
		private int etat;

	
	
	public Liv() {
		
	}
	
	public Liv(int id, String Mail, String adresse,  int idU,
			int activite ,int etat) {
		super();
		this.id = id;
		this.Mail = Mail;
		this.adresse = adresse;
		this.idU = idU;
		this.activite = activite;
		this.etat = etat;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getetat() {
		return etat;
	}

	public void setetat(int etat) {
		this.etat = etat;
	}
	
	public String getMail() {
		return Mail;
	}

	public void setMail(String Mail) {
		this.Mail = Mail;
	}

	public String getadresse() {
		return adresse;
	}

	public void setadresse(String adresse) {
		this.adresse= adresse;
	}

	
	public int getidU() {
		return idU;
	}

	public void setidU(int idU) {
		this.idU = idU;
	}


	public int getactivite() {
		return activite;
	}

	public void setactivite(int activite) {
		this.activite = activite;
	}

	

	@Override
	public String toString() {
		return "Livreur [id=" + id + ", Mail=" + Mail + ",adresse=" + adresse + ", idU=" + idU
				+ ", activite=" + activite + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;

		result = prime * result + id;
		

		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Liv other = (Liv) obj;
		
		if (Mail == null) {
			if (other.Mail != null)
				return false;
		} else if (!Mail.equals(other.Mail))
			return false;
		
		if (adresse == null) {
			if (other.adresse != null)
				return false;
		} else if (!adresse.equals(other.adresse))
			return false;
		if (id != other.id)
			return false;
		if (idU != other.idU)
			return false;
		if (activite != other.activite)
			return false;
		
		
		return true;
	}
	
	
	
}
