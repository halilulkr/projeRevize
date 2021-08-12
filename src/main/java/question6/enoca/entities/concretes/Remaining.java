package question6.enoca.entities.concretes;

import java.time.LocalDate;
import java.util.List;

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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "remainings")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Remaining {

	@Id
	@JsonIgnore(value = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private String id;

	@Column(name = "start_date", nullable = false)
	private LocalDate startDate;

	@Column(name = "expire_date", nullable = false)
	private LocalDate expireDate;

	@JsonIgnore(value = true)
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;

	@JsonIgnore(value = true)
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id")
	private Product product;

/*
	public Remaining(LocalDate startDate, LocalDate expireDate) {
		this.startDate = startDate;
		this.expireDate = expireDate;
	}
*/
}
