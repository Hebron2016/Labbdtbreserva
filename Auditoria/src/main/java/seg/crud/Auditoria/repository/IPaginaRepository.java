package seg.crud.Auditoria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import seg.crud.Auditoria.model.Pagina;


public interface IPaginaRepository  extends JpaRepository<Pagina, String> {

	@Query(value = "SELECT p FROM Pagina p WHERE p.url = ?1")
	public Pagina findPaginaUrl(String url);

	@Query(value = "SELECT p FROM Pagina p WHERE p.lenArqBytes = ?1")
	public List<Pagina> findPaginaLenArqBytes(int len);

}
