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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	@JsonIgnore(value = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private String id;

	@Column(name = "user_name", nullable = false)
	private String userName;

	@Email
	@Column(name = "mail", nullable = false)
	private String mail;

	@Column(name = "phone", nullable = false)
	private String phone;

	@JsonIgnore(value = true)
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "nationality_id", nullable = true)
	private Nationality nationality;

	@JsonIgnore(value = true)
	@OneToMany(mappedBy = "user")
	private List<Remaining> remainings = new ArrayList<>();

/*
	public User(String userName, String mail, String phone) {
		this.id = "";
		this.userName = userName;
		this.mail = mail;
		this.phone = phone;
		this.remainings = new ArrayList<>();
	}
*/
}
