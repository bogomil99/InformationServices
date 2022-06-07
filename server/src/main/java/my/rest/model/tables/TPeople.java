package my.rest.model.tables;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * @author bborisov
 */
@Data
@Entity
@Table(name = "T_PEOPLE")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TPeople implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	@Column(name = "FULL_NAME", nullable = false)
	String fullName;
	
	@Column(name = "PIN")
	String pin;

}
