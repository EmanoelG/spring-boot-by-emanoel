package br.com.springrestful.models;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.boot.context.properties.bind.DefaultValue;

import jakarta.persistence.*;

@Entity
@Table(name = "person")
public class Person implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prs_id", nullable = false)
	private Long id;

	@Column(name = "prs_name", nullable = false, length = 80)
	private String firstName;

	@Column(name = "prs_lastName", nullable = false, length = 80)
	private String lastName;

	@Column(name = "prs_address", nullable = false, length = 100)
	private String address;

	@Column(name = "prs_gender", length = 10)
	private String gender;

	@Column(nullable = false)
	private Boolean enabled = false; 

	public Person() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Person person = (Person) o;
		return Objects.equals(id, person.id) && Objects.equals(firstName, person.firstName)
				&& Objects.equals(lastName, person.lastName) && Objects.equals(address, person.address)
				&& Objects.equals(gender, person.gender);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, firstName, lastName, address, gender);
	}
}
