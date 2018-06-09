package ma.oga.microsystemes.dashboard.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
class KeycloakController {
	@PostMapping("/admin/logout")
	public String logout(HttpServletRequest request) throws Exception {
		request.logout();
		return "redirect:/admin";
	}
}
