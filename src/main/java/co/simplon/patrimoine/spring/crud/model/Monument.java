package co.simplon.patrimoine.spring.crud.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Monuments")
@NamedQueries({ @NamedQuery(name = "Monument.findAll", query = " SELECT m FROM Monument m ORDER BY m.name "),
		@NamedQuery(name = "Monument.findByName", query = " SELECT m FROM Monument m WHERE lower(m.name) like lower(concat(:nameToFind,'%'))") })
public class Monument {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NAME", length = 255)
	private String name;

	// LAZY au sens de recherche a la demande, au cas ou nous ayons beaucoup de
	// données, evite de saturer la memoire vive
	// fetch= retirer, extraire...
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_city")
	private City city;

	@ManyToMany(mappedBy = "monuments")
	private Set<User> users = new HashSet<>();

	public Monument(String name) {
		super();
		this.name = name;
	}

	public Monument(String name, City city) {
		this.name = name;
		this.city = city;
	}

	public Monument() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Monument [id=" + id + ", name=" + name + ", city=" + city.getName() + "]";
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
