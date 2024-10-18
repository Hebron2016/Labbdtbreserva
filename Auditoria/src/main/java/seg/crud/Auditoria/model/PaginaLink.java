package seg.crud.Auditoria.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="paginalink")
@IdClass(PaginaLinkId.class)
public class PaginaLink {
	
	@Id
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = Requisicao.class, fetch = FetchType.LAZY)
	@JoinColumn(name="paginaUrl", nullable = false)
	private Pagina pagina;
	@Id
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = Link.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "linkCodigoLink", nullable = false)
	private Link link;
	
	public Pagina getPagina() {
		return pagina;
	}
	public void setPagian(Pagina pagina) {
		this.pagina = pagina;
	}
	public Link getLink() {
		return link;
	}
	public void setLink(Link link) {
		this.link = link;
	}
	
}
