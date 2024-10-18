package seg.crud.Auditoria.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table ( name = "requisicao")
public class Requisicao {
	@Id
	@Column( name="codigoRequisicao", nullable = false)
	private int codigoRequisicao;
	@Column( name="http", nullable = false)
	private int http;
	@Column( name="tempo", nullable = false)
	private int tempo;
	@ManyToOne( targetEntity=Sessao.class,  fetch = FetchType.LAZY)
	@JoinColumn( name="sessaoCodigoSessao", nullable=false)
	private Sessao sessaoCodigoSessao;
	@ManyToOne( targetEntity=Pagina.class, fetch = FetchType.LAZY)
	@JoinColumn( name="paginaUrl", nullable = false)
	private Pagina paginaUrl;
	
	public int getCodigoRequisicao() {
		return codigoRequisicao;
	}
	public void setCodigoRequisicao(int codigoRequisicao) {
		this.codigoRequisicao = codigoRequisicao;
	}
	public int getHttp() {
		return http;
	}
	public void setHttp(int http) {
		this.http = http;
	}
	public int getTempo() {
		return tempo;
	}
	public void setTempo(int tempo) {
		this.tempo = tempo;
	}
	public Sessao getSessaoCodigoSessao() {
		return sessaoCodigoSessao;
	}
	public void setSessaoCodigoSessao(Sessao sessaoCodigoSessao) {
		this.sessaoCodigoSessao = sessaoCodigoSessao;
	}
	public Pagina getPaginaUrl() {
		return paginaUrl;
	}
	public void setPaginaUrl(Pagina paginaUrl) {
		this.paginaUrl = paginaUrl;
	}
	@Override
	public String toString() {
		return "Requisicao [codigoRequisicao=" + codigoRequisicao + ", http=" + http + ", tempo=" + tempo + ", sessao="
				+ sessaoCodigoSessao + ", pagina=" + paginaUrl + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(codigoRequisicao, http, paginaUrl, sessaoCodigoSessao, tempo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Requisicao other = (Requisicao) obj;
		return codigoRequisicao == other.codigoRequisicao && http == other.http && Objects.equals(paginaUrl, other.paginaUrl)
				&& Objects.equals(sessaoCodigoSessao, other.sessaoCodigoSessao) && tempo == other.tempo;
	}
	
}
