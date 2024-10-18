package seg.crud.Auditoria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import seg.crud.Auditoria.model.PaginaLink;


public interface IPaginaLinkRepository extends JpaRepository<PaginaLink, Integer>{

	@Query(value =	"SELECT dbo.fn_qtdLinks(?1) AS codigoLink")
	public int findCountQtdLink(int a);

}
