package question6.enoca.entities.concretes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "nationalities")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Nationality {

	@Id
	@JsonIgnore(value = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private String id;

	@Column(name = "nationality_name", nullable = false)
	private String nationalityName;

	@JsonIgnore(value = true)
	@OneToMany(mappedBy = "nationality")
	private List<User> users;

/*
	public Nationality(String nationalityName) {
		this.id = "";
		this.nationalityName = nationalityName;
		this.users = new ArrayList<>();
	}
*/
}
