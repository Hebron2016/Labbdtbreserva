package seg.crud.Auditoria.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table( name="pagina")
@Data
public class Pagina {

	@Id
	@Column ( name="url", length=255 ,nullable = false)
	private String url;
	@Column ( name="codigoHtml", length=255, nullable = false)
	private String codigoHtml;
	@Column ( name="tipoConteudo", length=100, nullable = false)
	private String tipoConteudo;
	@Column ( name="titulo", length=50, nullable = false)
	private String titulo;
	@Column ( name="lenArqBytes", nullable = false)
	private int lenArqBytes;
}
