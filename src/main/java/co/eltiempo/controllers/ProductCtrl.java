package co.eltiempo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.eltiempo.controllers.aux.Message;
import co.eltiempo.domain.Product;
import co.eltiempo.repositories.ProductRepository;

@Controller
public class ProductCtrl {
	@Autowired
	private ProductRepository productRepository;

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	@ResponseBody
	public Iterable<Product> getProducts() {
		return productRepository.findAll();
	}
	
	/**
	 * 
	 * @param product
	 * @return
	 */
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public ResponseEntity<Message> addProduct(
			@Valid @RequestBody Product product) {
		try {
			productRepository.save(product);
			return new ResponseEntity<Message>(new Message(
					"Product succesfully added with id: " + product.getId()),
					HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Message>(new Message(
					"Error adding the product:" + e.toString()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	/**
	 * 
	 * @param productId
	 * @return
	 */
	@RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Product getProduct(@PathVariable Long id) {
		Product searchedProduct = productRepository.findOne(id);
		return searchedProduct;
	}
	
	/**
	 * 
	 * @param productId
	 * @return
	 */
	@RequestMapping(value = "/products/{productId}", method = RequestMethod.DELETE)
	public ResponseEntity<Message> deleteProduct(@PathVariable Long productId) {
		try {
			productRepository.delete(productId);
			return new ResponseEntity<Message>(new Message(
					"Product was successfully deleted"), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<Message>(
					new Message(
							"Error deleting the Product. Its probably that the required product doesn't not exist"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
