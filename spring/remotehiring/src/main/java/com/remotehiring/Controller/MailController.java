package com.remotehiring.Controller;
import com.remotehiring.Services.MailService;
import com.remotehiring.entities.Users;
import com.remotehiring.exceptions.CustomMailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {

	@Autowired
	private MailService mailService;

	@GetMapping("mail/signup")
	public ResponseEntity<String> signupMail(@RequestBody Users user) {
		try {
			mailService.signupMail(user);
			return ResponseEntity.ok("Signup email sent successfully to " + user.getEmail());
		} catch (CustomMailException e) {
			// Log the error
			e.printStackTrace();
			// Return an appropriate HTTP response
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Failed to send signup email: " + e.getMessage());
		}
	}
}
