package security.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import security.domain.Paciente;
import security.domain.Usuario;
import security.service.PacienteService;
import security.service.UsuarioService;

@Controller
@RequestMapping("pacientes")
public class PacienteController {

	@Autowired
	private PacienteService service;
	@Autowired
	private UsuarioService usuarioservice;
	
	// abrir pagina de dados pessoais do paciente
	@GetMapping("/dados")
	public String cadastrar(Paciente paciente, ModelMap model, @AuthenticationPrincipal User user) {
		paciente = service.buscarPorUsuarioEmail(user.getUsername());
		
		if(paciente.hasNotId()) {
			paciente.setUsuario(new Usuario(user.getUsername()));
		}
		model.addAttribute("paciente", paciente);
		return "paciente/cadastro";
	}
	
	// salvar o form de dados pessoais do paciente com verificacao de senha 
	@PostMapping("/salvar")
	public String salvar(Paciente paciente, ModelMap model, @AuthenticationPrincipal User user) {
		Usuario u = usuarioservice.buscarPorEmail(user.getUsername());
		if(UsuarioService.isSenhaCorreta(paciente.getUsuario().getSenha(), u.getSenha())) {
			paciente.setUsuario(u);
			service.salvar(paciente);
			model.addAttribute("sucesso", "Seus dados foram inseridos com sucesso.");
		}else {
			model.addAttribute("falha", "Sua senha não confere, tente novamente.");
		}
		return "paciente/cadastro";
	}
	
	// editar o form de dados pessoais do paciente com verificacao de senha 
	@PostMapping("/editar")
	public String editar(Paciente paciente, ModelMap model, @AuthenticationPrincipal User user) {
		Usuario u = usuarioservice.buscarPorEmail(user.getUsername());
		if(UsuarioService.isSenhaCorreta(paciente.getUsuario().getSenha(), u.getSenha())) {
			service.editar(paciente);
			model.addAttribute("sucesso", "Seus dados foram editados com sucesso.");
		}else {
			model.addAttribute("falha", "Sua senha não confere, tente novamente.");
		}
		return "paciente/cadastro";
	}
}
