package seg.crud.Auditoria.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import seg.crud.Auditoria.model.PaginaLink;
import seg.crud.Auditoria.model.Sessao;
import seg.crud.Auditoria.repository.IPaginaLinkRepository;

@Controller
public class PaginaLinkController {

	@Autowired
	private IPaginaLinkRepository plRep;
	
	@RequestMapping(name="paginaLink", value = "/paginaLink", method = RequestMethod.GET)
	public ModelAndView paginaLinkGet(ModelMap model) {
		return new ModelAndView("paginaLink");
	}
	
	@RequestMapping(name="paginaLink", value = "/paginaLink", method = RequestMethod.POST)
	public ModelAndView paginaLinkPost(
			@RequestParam Map<String, String> params,
			ModelMap model) {
		String codigoPaginaLink = params.get("link");
		String mensagem = params.get("pagina");
		String botao = params.get("botao");

		PaginaLink paginaLink = new PaginaLink();
		Sessao sessao = new Sessao();
		if (!botao.equals("Listar")) {
			paginaLink.setLink(Integer.parseInt(codigoPaginaLink));
		}
		if (botao.equals("Inserir") || botao.equals("Atualizar")){
			paginaLink.setMensagem(mensagem);
			paginaLink.setSessaoCodigoSessao();
		}
		
		String saida = "";
		String erro = "";
		List<PaginaLink> paginaLinks = new ArrayList<>();
		
		try {
			if (botao.equals("Inserir")) {
				plRep.save(paginaLink);
				saida = "PaginaLink inserido com sucesso";
			}
			if (botao.equals("Atualizar")) {
				plRep.save(paginaLink);
				saida = "PaginaLink atualizado com sucesso";
			}
			if (botao.equals("Excluir")) {
				plRep.delete(paginaLink);
				saida = "PaginaLink excluido com sucesso";
			}
			if (botao.equals("Buscar")) {
				paginaLink = plRep.findById(paginaLink.getCodigoPaginaLink()).get();
			}
			if (botao.equals("Listar")) {
				paginaLinks = plRep.findAll();
			}
		}catch(Exception e) {
			erro = e.getMessage();
		} finally{
			model.addAttribute("saida", saida);
			model.addAttribute("erro", erro);
			model.addAttribute("paginaLink", paginaLink);
			model.addAttribute("paginaLinks", paginaLinks);
		}
		return new ModelAndView("paginaLink");
	}
}
