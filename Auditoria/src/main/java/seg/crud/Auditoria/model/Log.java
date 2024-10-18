package seg.crud.Auditoria.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table ( name = "log")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Log {

	@Id
	@Column( name="codigoLog", nullable=false)
	private int codigoLog;
	@Column( name="mensagem", length=255, nullable=false)
	private String mensagem;
	@ManyToOne(targetEntity= Sessao.class, fetch = FetchType.LAZY)
	@JoinColumn( name="sessaoCodigoSessao", nullable =false)
	private Sessao sessaoCodigoSessao;
}
