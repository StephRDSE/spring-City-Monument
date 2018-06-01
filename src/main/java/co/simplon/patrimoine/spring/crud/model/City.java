package co.simplon.patrimoine.spring.crud.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CITIES")
@NamedQueries({ @NamedQuery(name = "City.findAll", query = " SELECT c FROM City c ORDER BY c.name "),
		@NamedQuery(name = "City.findByName", query = " SELECT c FROM City c WHERE lower(c.name) like lower(concat(:nameToFind,'%'))") })
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NAME", nullable = false, length = 255)
	private String name;

	@Column(name = "LATITUDE", nullable = false)
	private Double latitude;

	@Column(name = "LONGITUDE", nullable = false)
	private Double longitude;

	//
	@OneToMany(mappedBy = "city", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Monument> monuments = new ArrayList<>();

	public City() {
	}

	public City(String name, double latitude, double longitude) {
		// this appelle le constructeur de cette classe (ici celui d en dessous)
		this(null, name, latitude, longitude);
	}

	public City(Long id, String name, double latitude, double longitude) {
		this.id = id;
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;

	}

	public void setName(String nom) {
		this.name = nom;
	}

	public Double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", nbmonuments=" + monuments.size() + "]";
	}

	public List<Monument> getMonuments() {
		return monuments;
	}

	public void setMonuments(List<Monument> monuments) {
		this.monuments = monuments;
	}

}
