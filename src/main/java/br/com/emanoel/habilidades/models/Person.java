package br.com.emanoel.habilidades.models;
import java.io.Serializable;
import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;

import br.com.emanoel.habilidades.data.vo.v1.PersonVO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name= "person")
public class Person extends RepresentationModel<Person> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prs_id")
	private Long id;
	
	@Column(name = "prs_name", nullable = false, length = 80)
	private String firstName;
	
	@Column(name = "prs_lastName", nullable = false, length = 80)
	private String lastName;
	
	@Column(name = "prs_address", nullable = false, length = 100)
	private String address;
	
	@Column(name = "prs_gender", length = 10)
	private String gender;
//	public Person(String firstName, String lastName, String address, String gender) {
//		super();
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.address = address;
//		this.gender = gender;
//	}

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
	
	@Override
	public int hashCode() {
		return 
				Objects.
				hash(address, firstName, gender, id, lastName);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(address, other.address) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(gender, other.gender) && Objects.equals(id, other.id)
				&& Objects.equals(lastName, other.lastName);
	}
}
	