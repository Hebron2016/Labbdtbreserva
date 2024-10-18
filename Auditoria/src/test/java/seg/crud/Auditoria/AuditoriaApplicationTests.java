package seg.crud.Auditoria;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import seg.crud.Auditoria.repository.ILinkRepository;
import seg.crud.Auditoria.repository.ISessaoRepository;
import seg.crud.Auditoria.model.*;
@SpringBootTest
class AuditoriaApplicationTests {
	@Autowired
	private ILinkRepository lRep;
	@Autowired
	private ISessaoRepository sRep;
	@Test
	void selectsLink() {
		List<Link> links = lRep.findAll();
		for (Link l: links) {
			System.out.println(l.toString());
		}
	}
	@Test
	void selectLog() {
		Sessao sessao = new Sessao();
		sessao.setCodigoSessao(1);
		sessao.setUsuario("sad");
		sessao.setIp("laa");
		sRep.save(sessao);
		Sessao sessao1 = new Sessao();
		sessao1 = sRep.findById(1).get();
		System.out.println(sessao1.toString()+"chegou");
		
		Log log = new Log();
		log.setCodigoLog(1);
		log.setMensagem("aaa");
		log.setSessaoCodigoSessao(sessao1);
		System.out.println(log.toString()+"chegou");
	}

}
