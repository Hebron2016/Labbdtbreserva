package seg.crud.Auditoria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import seg.crud.Auditoria.model.Log;

public interface ILogRepository  extends JpaRepository<Log, Integer>{

}
