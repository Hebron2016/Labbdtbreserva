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

import seg.crud.Auditoria.model.Pagina;
import seg.crud.Auditoria.repository.IPaginaRepository;

@Controller
public class PaginaController {

	@Autowired
	private IPaginaRepository pRep;
	
	@RequestMapping(name="pagina", value = "/pagina", method = RequestMethod.GET)
	public ModelAndView paginaGet(ModelMap model) {
		return new ModelAndView("pagina");
	}
	
	@RequestMapping(name="pagina", value = "/pagina", method = RequestMethod.POST)
	public ModelAndView paginaPost(
			@RequestParam Map<String, String> params,
			ModelMap model) {
		String url = params.get("url");
		String codigoHtml = params.get("codigoHtml");
		String tipoConteudo = params.get("tipoConteudo");
		String titulo = params.get("titulo");
		String lenArqBytes = params.get("lenArqBytes");
		String botao = params.get("botao");

		Pagina pagina = new Pagina();
		if (!botao.equals("Listar")) {
			pagina.setUrl(url);
		}
		if (botao.equals("Inserir") || botao.equals("Atualizar")){
			pagina.setCodigoHtml(codigoHtml);
			pagina.setTipoConteudo(tipoConteudo);
			pagina.setTitulo(titulo);
			pagina.setLenArqBytes(Integer.parseInt(lenArqBytes));
		}
		
		String saida = "";
		String erro = "";
		List<Pagina> paginas = new ArrayList<>();
		
		try {
			if (botao.equals("Inserir")) {
				pRep.save(pagina);
				saida = "Pagina inserido com sucesso";
			}
			if (botao.equals("Atualizar")) {
				pRep.save(pagina);
				saida = "Pagina atualizado com sucesso";
			}
			if (botao.equals("Excluir")) {
				pRep.delete(pagina);
				saida = "Pagina excluido com sucesso";
			}
			if (botao.equals("Buscar")) {
				pagina = pRep.findById(pagina.getUrl()).get();
			}
			if (botao.equals("Listar")) {
				paginas = pRep.findAll();
			}
		}catch(Exception e) {
			erro = e.getMessage();
		} finally{
			model.addAttribute("saida", saida);
			model.addAttribute("erro", erro);
			model.addAttribute("pagina", pagina);
			model.addAttribute("paginas", paginas);
		}
		return new ModelAndView("pagina");
	}
}
