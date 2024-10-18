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

import seg.crud.Auditoria.model.Link;
import seg.crud.Auditoria.repository.ILinkRepository;

@Controller
public class LinkController {

	@Autowired
	private ILinkRepository lRep;
	
	@RequestMapping(name="link", value = "/link", method = RequestMethod.GET)
	public ModelAndView linkGet(ModelMap model) {
		return new ModelAndView("link");
	}
	
	@RequestMapping(name="link", value = "/link", method = RequestMethod.POST)
	public ModelAndView linkPost(
			@RequestParam Map<String, String> params,
			ModelMap model) {
		String codigoLink = params.get("codigoLink");
		String titulo = params.get("titulo");
		String target = params.get("target");
		String botao = params.get("botao");

		Link link = new Link();
		if (!botao.equals("Listar")) {
			link.setCodigoLink(Integer.parseInt(codigoLink));
		}
		if (botao.equals("Inserir") || botao.equals("Atualizar")){
			link.setTitulo(titulo);
			link.setTarget(target);
		}
		
		String saida = "";
		String erro = "";
		List<Link> links = new ArrayList<>();
		
		try {
			if (botao.equals("Inserir")) {
				lRep.save(link);
				saida = "Link inserido com sucesso";
			}
			if (botao.equals("Atualizar")) {
				lRep.save(link);
				saida = "Link atualizado com sucesso";
			}
			if (botao.equals("Excluir")) {
				lRep.delete(link);
				saida = "Link excluido com sucesso";
			}
			if (botao.equals("Buscar")) {
				link = lRep.findById(link.getCodigoLink()).get();
			}
			if (botao.equals("Listar")) {
				links = lRep.findAll();
				for (Link l: links) {
					System.out.println(l.toString());
				}
			}
		}catch(Exception e) {
			erro = e.getMessage();
		} finally{
			model.addAttribute("saida", saida);
			model.addAttribute("erro", erro);
			model.addAttribute("link", link);
			model.addAttribute("links", links);
		}
		return new ModelAndView("link");
	}
}
