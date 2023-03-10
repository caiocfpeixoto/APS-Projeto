package security.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import security.domain.Usuario;


@Controller
@RequestMapping("u")
public class UsuarioController {
	
	// abrir cadastro de usuarios (medico/admin/paciente)
		@GetMapping("/novo/cadastro/usuario")
		public String cadastroPorAdminParaAdminMedicoPaciente(Usuario usuario) {
			
			return "usuario/cadastro";
		}
}
