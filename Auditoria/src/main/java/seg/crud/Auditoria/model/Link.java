package seg.crud.Auditoria.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="link")
@Data
public class Link {
	@Id
	@Column(name= "codigoLink", nullable=false)
	private int codigoLink;
	@Column(name="titulo", length=50, nullable=false)
	private String titulo;
	@Column( name="target", length=7,nullable=false)
	private String target;
}
