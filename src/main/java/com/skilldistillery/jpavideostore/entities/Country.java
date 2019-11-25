package com.skilldistillery.jpavideostore.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Country {

	@Id
	@Column(name = "country_code")
	private int countryCode;
	@Column
	private String country;
	
	@Column(name = "formal_name")
	private String formalName;
	
	@Column
	private String sovereignty;
	
	@Column
	private String capital;
	
	@Column(name = "iso3_code")
	private String isoCode;
	@Column
	private String tld;
	
	public Country() {
		super();
	}
	public int getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(int countryCode) {
		this.countryCode = countryCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getFormalName() {
		return formalName;
	}
	public void setFormalName(String formalName) {
		this.formalName = formalName;
	}
	public String getSovereignty() {
		return sovereignty;
	}
	public void setSovereignty(String sovereignty) {
		this.sovereignty = sovereignty;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public String getIsoCode() {
		return isoCode;
	}
	public void setIsoCode(String isoCode) {
		this.isoCode = isoCode;
	}
	public String getTld() {
		return tld;
	}
	public void setTld(String tld) {
		this.tld = tld;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((capital == null) ? 0 : capital.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + countryCode;
		result = prime * result + ((formalName == null) ? 0 : formalName.hashCode());
		result = prime * result + ((isoCode == null) ? 0 : isoCode.hashCode());
		result = prime * result + ((sovereignty == null) ? 0 : sovereignty.hashCode());
		result = prime * result + ((tld == null) ? 0 : tld.hashCode());
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
		Country other = (Country) obj;
		if (capital == null) {
			if (other.capital != null)
				return false;
		} else if (!capital.equals(other.capital))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (countryCode != other.countryCode)
			return false;
		if (formalName == null) {
			if (other.formalName != null)
				return false;
		} else if (!formalName.equals(other.formalName))
			return false;
		if (isoCode == null) {
			if (other.isoCode != null)
				return false;
		} else if (!isoCode.equals(other.isoCode))
			return false;
		if (sovereignty == null) {
			if (other.sovereignty != null)
				return false;
		} else if (!sovereignty.equals(other.sovereignty))
			return false;
		if (tld == null) {
			if (other.tld != null)
				return false;
		} else if (!tld.equals(other.tld))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Country [countryCode=" + countryCode + ", country=" + country + ", formalName=" + formalName
				+ ", sovereignty=" + sovereignty + ", capital=" + capital + ", isoCode=" + isoCode + ", tld=" + tld
				+ "]";
	}
}
