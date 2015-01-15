//package co.eltiempo.controllers;
//
//import org.springframework.stereotype.Controller;
//
//@Controller
//public class ControllerSample {
//	@Autowired
//	private AccountRepository accountRepository;
//
//	@Autowired
//	private ClientRepository clientRepository;
//
//	/**
//	 * 
//	 * @param clientId
//	 * @return
//	 */
//	@RequestMapping(value = "/clients/{clientId}/accounts", method = RequestMethod.POST)
//	@ResponseBody
//	public ResponseEntity<Message> addAccount(@PathVariable Long clientId,
//			@Valid @RequestBody NewAccountRequest accountRequest) {
//		try {
//			Client searchedClient = clientRepository.findOne(clientId);
//			if (searchedClient != null) {
//				Account account = new Account(accountRequest.getInitBalance(),
//						new ArrayList<Movement>(), searchedClient);
//				searchedClient.getAccounts().add(account);
//				accountRepository.save(account);
//				return new ResponseEntity<Message>(new Message(
//						"The account was added correctly with a number: "
//								+ account.getNumber()), HttpStatus.CREATED);
//			} else {
//				return new ResponseEntity<Message>(
//						new Message(
//								"You need to specify a valid client for add an account"),
//						HttpStatus.BAD_REQUEST);
//			}
//		} catch (Exception e) {
//			return new ResponseEntity<Message>(new Message(
//					"There was an error adding the account" + e.getMessage()),
//					HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
//
//	/**
//	 * 
//	 * @param id
//	 *            Account Id
//	 * @return
//	 */
//	@RequestMapping(value = "/accounts/{id}", method = RequestMethod.GET)
//	@ResponseStatus(HttpStatus.OK)
//	@ResponseBody
//	public Account getAccount(@PathVariable Long id) {
//		Account searchedAccount = accountRepository.findOne(id);
//		return searchedAccount;
//	}
//
//	/**
//	 * 
//	 * @param id
//	 *            Account Id
//	 * @return
//	 */
//	@RequestMapping(value = "/accounts/{id}", method = RequestMethod.DELETE)
//	@ResponseBody
//	public ResponseEntity<Message> deleteAccount(@PathVariable Long id) {
//		try {
//			accountRepository.delete(id);
//			return new ResponseEntity<Message>(new Message(
//					"The account was successfully removed"),
//					HttpStatus.ACCEPTED);
//		} catch (Exception e) {
//			return new ResponseEntity<Message>(
//					new Message(
//							"There was an error removing the account. Verify the account number, probably it doesn't exist"),
//					HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
//
//}
