package henryjames.employeeprojects;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

@GetMapping("/login")
public String showLoginPage(ModelMap map) {
    
    System.out.println("Displaying login page.");
    
    return "login";
}

@PostMapping("/login")
public String showWelcomePage(@RequestParam String name) {
    
    System.out.println("Displaying Post login page.");
    
    return "welcome";
}
}