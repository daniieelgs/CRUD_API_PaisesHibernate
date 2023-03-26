package Model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "country")
public class Country {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "country_id")
	private Integer country_id;

	@Column(name = "country")
	private String country;


	public Country() {
		
	}
	
	public Country(Integer id, String country) {
		this.country_id = id;
		this.country = country;
	}
	
	public Integer getCountry_id() {
		return country_id;
	}
	public void setCountry_id(Integer id) {
		this.country_id = id;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(country_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Country)) {
			return false;
		}
		Country other = (Country) obj;
		return Objects.equals(country_id, other.country_id);
	}

	@Override
	public String toString() {
		return "Pais [country_id=" + country_id + ", country=" + country + "]";
	}
	
	
}
