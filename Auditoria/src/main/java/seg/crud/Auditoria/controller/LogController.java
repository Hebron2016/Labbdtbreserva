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

import seg.crud.Auditoria.model.Log;
import seg.crud.Auditoria.model.Sessao;
import seg.crud.Auditoria.repository.ILogRepository;
import seg.crud.Auditoria.repository.ISessaoRepository;

@Controller
public class LogController {

	@Autowired
	private ILogRepository lRep;
	@Autowired
	private ISessaoRepository sRep;
	
	@RequestMapping(name="log", value = "/log", method = RequestMethod.GET)
	public ModelAndView logGet(ModelMap model) {
		return new ModelAndView("log");
	}
	
	@RequestMapping(name="log", value = "/log", method = RequestMethod.POST)
	public ModelAndView logPost(
			@RequestParam Map<String, String> params,
			ModelMap model) {
		String codigoLog = params.get("codigoLog");
		String mensagem = params.get("mensagem");
		String sessaoCodigoSessao = params.get("sessaoCodigoSessao");
		String botao = params.get("botao");

		Log log = new Log();
		Sessao sessao = new Sessao();
		if (!botao.equals("Listar")) {
			log.setCodigoLog(Integer.parseInt(codigoLog));
		}
		if (botao.equals("Inserir") || botao.equals("Atualizar")){
			log.setMensagem(mensagem);
			sessao = sRep.findById(Integer.parseInt(sessaoCodigoSessao)).get();
			log.setSessaoCodigoSessao(sessao);
		}
		
		String saida = "";
		String erro = "";
		List<Log> logs = new ArrayList<>();
		
		try {
			if (botao.equals("Inserir")) {
				lRep.save(log);
				saida = "Log inserido com sucesso";
			}
			if (botao.equals("Atualizar")) {
				lRep.save(log);
				saida = "Log atualizado com sucesso";
			}
			if (botao.equals("Excluir")) {
				lRep.delete(log);
				saida = "Log excluido com sucesso";
			}
			if (botao.equals("Buscar")) {
				log = lRep.findById(log.getCodigoLog()).get();
			}
			if (botao.equals("Listar")) {
				logs = lRep.findAll();
			}
		}catch(Exception e) {
			erro = e.getMessage();
		} finally{
			model.addAttribute("saida", saida);
			model.addAttribute("erro", erro);
			model.addAttribute("log", log);
			model.addAttribute("logs", logs);
		}
		return new ModelAndView("log");
	}
}
