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

import seg.crud.Auditoria.model.Requisicao;
import seg.crud.Auditoria.model.Sessao;
import seg.crud.Auditoria.model.Pagina;
import seg.crud.Auditoria.repository.IPaginaRepository;
import seg.crud.Auditoria.repository.IRequisicaoRepository;
import seg.crud.Auditoria.repository.ISessaoRepository;

@Controller
public class RequisicaoController {

	@Autowired
	private IRequisicaoRepository rRep;
	
	@Autowired
	private ISessaoRepository sRep;
	
	@Autowired
	private IPaginaRepository pRep;
	
	@RequestMapping(name="requisicao", value = "/requisicao", method = RequestMethod.GET)
	public ModelAndView requisicaoGet(ModelMap model) {
		return new ModelAndView("requisicao");
	}
	
	@RequestMapping(name="requisicao", value = "/requisicao", method = RequestMethod.POST)
	public ModelAndView requisicaoPost(
			@RequestParam Map<String, String> params,
			ModelMap model) {
		String codigoRequisicao = params.get("codigoRequisicao");
		String http = params.get("http");
		String tempo = params.get("tempo");
		String sessaoCodigoSessao = params.get("sessaoCodigoSessao");
		String paginaUrl = params.get("paginaUrl");
		String botao = params.get("botao");

		Requisicao requisicao = new Requisicao();
		Sessao sessao = new Sessao();
		Pagina pagina = new Pagina();
		if (!botao.equals("Listar")) {
			requisicao.setCodigoRequisicao(Integer.parseInt(codigoRequisicao));
		}
		if (botao.equals("Inserir") || botao.equals("Atualizar")){
			requisicao.setHttp(Integer.parseInt(http));
			requisicao.setTempo(Integer.parseInt(tempo));
			sessao = sRep.findById(Integer.parseInt(sessaoCodigoSessao)).get();
			requisicao.setSessaoCodigoSessao(sessao);
			pagina = pRep.findPaginaUrl(paginaUrl);
			requisicao.setPaginaUrl(pagina);
		}
		
		String saida = "";
		String erro = "";
		List<Requisicao> requisicoes = new ArrayList<>();
		
		try {
			if (botao.equals("Inserir")) {
				rRep.save(requisicao);
				saida = "Requisicao inserido com sucesso";
			}
			if (botao.equals("Atualizar")) {
				rRep.save(requisicao);
				saida = "Requisicao atualizado com sucesso";
			}
			if (botao.equals("Excluir")) {
				rRep.delete(requisicao);
				saida = "Requisicao excluido com sucesso";
			}
			if (botao.equals("Buscar")) {
				requisicao = rRep.findById(requisicao.getCodigoRequisicao()).get();
			}
			if (botao.equals("Listar")) {
				requisicoes = rRep.findAll();
			}
		}catch(Exception e) {
			erro = e.getMessage();
		} finally{
			model.addAttribute("saida", saida);
			model.addAttribute("erro", erro);
			model.addAttribute("requisicao", requisicao);
			model.addAttribute("requisicaos", requisicoes);
		}
		return new ModelAndView("requisicao");
	}
}
