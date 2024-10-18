package seg.crud.Auditoria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import seg.crud.Auditoria.model.Log;
//import seg.crud.Auditoria.model.Requisicao;
import seg.crud.Auditoria.model.Sessao;

public interface ISessaoRepository  extends JpaRepository<Sessao, Integer> {

	@Query(value = "SELECT s FROM Sessao s WHERE s.ip = ?1 ")
	public List<Sessao> findBySessaoIp(String ip);
/*	
	@Query(value = "SELECT l FROM Log l, Sessao s WHERE s.codigoSessao = l.sessaoCodigoSessao AND s.ip = ?1")
	public List<Log> findBySessaoIpLog(String ip);

	@Query(value = "SELECT r FROM Requisicao r, Sessao s WHERE r.sessaoCodigoSessao = s.codigoSessao AND s.usuario = ?1")
	public List<Requisicao> findBySessaoUserRequisicao(String usuario);
*/
}
