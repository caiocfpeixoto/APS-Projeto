package security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class DemoSecurityApplication {

	public static void main(String[] args) {
		//System.out.println(new BCryptPasswordEncoder().encode("123456"));
		SpringApplication.run(DemoSecurityApplication.class, args);
	}

//	@Autowired
//	JavaMailSender sender;
	
//	@Override
//	public void run(String... args) throws Exception {
		
//		SimpleMailMessage simple = new SimpleMailMessage();
//		simple.setTo("peixotinho2002@gmail.com");
//		simple.setText("Teste numero 1");
//		simple.setSubject("teste 1");
//		sender.send(simple);
//	}
}
