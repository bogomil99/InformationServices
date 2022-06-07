package my.rest.model.tables;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Entity
@Table(name = "T_MAILS")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TMails implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	@ManyToOne
	@JoinColumn(name = "T_PEOPLE_ID", nullable = false)
	TPeople tPeople;
	
	@Column(name = "EMAIL_TYPE", nullable = false)
//	@Enumerated(EnumType.STRING)
	String emailType; // enum mayby?

	@Column(name = "EMAIL")
	String email;
}
