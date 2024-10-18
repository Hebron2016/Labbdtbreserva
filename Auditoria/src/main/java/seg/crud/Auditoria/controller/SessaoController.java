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

import seg.crud.Auditoria.model.Sessao;
import seg.crud.Auditoria.repository.ISessaoRepository;

@Controller
public class SessaoController {

	@Autowired
	private ISessaoRepository sRep;
	
	@RequestMapping(name="sessao", value = "/sessao", method = RequestMethod.GET)
	public ModelAndView sessaoGet(ModelMap model) {
		return new ModelAndView("sessao");
	}
	
	@RequestMapping(name="sessao", value = "/sessao", method = RequestMethod.POST)
	public ModelAndView sessaoPost(
			@RequestParam Map<String, String> params,
			ModelMap model) {
		String codigoSessao = params.get("codigoSessao");
		String usuario = params.get("usuario");
		String ip = params.get("ip");
		String botao = params.get("botao");

		Sessao sessao = new Sessao();
		if (!botao.equals("Listar")) {
			sessao.setCodigoSessao(Integer.parseInt(codigoSessao));
		}
		if (botao.equals("Inserir") || botao.equals("Atualizar")){
			sessao.setUsuario(usuario);
			sessao.setIp(ip);
		}
		
		String saida = "";
		String erro = "";
		List<Sessao> sessoes = new ArrayList<>();
		
		try {
			if (botao.equals("Inserir")) {
				sRep.save(sessao);
				saida = "Sessao inserido com sucesso";
			}
			if (botao.equals("Atualizar")) {
				sRep.save(sessao);
				saida = "Sessao atualizado com sucesso";
			}
			if (botao.equals("Excluir")) {
				sRep.delete(sessao);
				saida = "Sessao excluido com sucesso";
			}
			if (botao.equals("Buscar")) {
				sessao = sRep.findById(sessao.getCodigoSessao()).get();
			}
			if (botao.equals("Listar")) {
				sessoes = sRep.findAll();
			}
		}catch(Exception e) {
			erro = e.getMessage();
		} finally{
			model.addAttribute("saida", saida);
			model.addAttribute("erro", erro);
			model.addAttribute("sessao", sessao);
			model.addAttribute("sessoes", sessoes);
		}
		return new ModelAndView("sessao");
	}
}
