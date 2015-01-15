package co.eltiempo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.eltiempo.controllers.aux.Message;
import co.eltiempo.controllers.aux.UserSignIn;
import co.eltiempo.domain.User;
import co.eltiempo.repositories.ClientRepository;

/**
 * 
 * @author Felipe Triana
 * @version 1.0
 */
@Controller
public class UserCtrl {

	@Autowired
	private ClientRepository clientRepository;

	@RequestMapping(value = "/clients", method = RequestMethod.POST)
	public ResponseEntity<Message> addAnUser(@Valid @RequestBody User user) {
		try {
			clientRepository.save(user);
			return new ResponseEntity<Message>(
					new Message("Client succesfully added with email: "
							+ user.getEmail()), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Message>(new Message(
					"Error adding the client:" + e.toString()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/sigin", method = RequestMethod.POST)
	public ResponseEntity<Message> siginUser(@Valid @RequestBody UserSignIn user) {
		try {
			User clientSearched = clientRepository.findUserByEmailAndPassword(
					user.getEmail(), user.getPassword());
			if (clientSearched != null) {
				return new ResponseEntity<Message>(new Message(
						"Now you are logged as " + user.getEmail()),
						HttpStatus.OK);
			} else {
				return new ResponseEntity<Message>(
						new Message(
								"Your credential arent correct, please verify your email and password"),
						HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<Message>(new Message(
					"There was an internal error. Please try again."),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
