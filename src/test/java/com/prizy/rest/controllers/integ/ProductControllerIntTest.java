/**
 * 
 */
package com.prizy.rest.controllers.integ;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.prizy.bootstrap.App;
import com.prizy.common.utils.TestUtils;
import com.prizy.entities.Product;
import com.prizy.entities.builders.ProductBuilder;

/**
 * @author Shailendra
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerIntTest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();
	private final Product product = new ProductBuilder().with(s -> {
		s.setId(500L);
		s.setName("Samsung Note 3");
		s.setLongDescription("Pune");
		s.setBasePrice(30000L);
	}).createProduct();

	@Test
	public void saveAndRetrieveProduct() throws JSONException {

		HttpEntity<Product> entity = new HttpEntity<Product>(product, headers);
		ResponseEntity<Product> response = restTemplate.exchange(
				createURLWithPort("/product"), HttpMethod.POST, entity,
				Product.class);

		Product createdProduct = response.getBody();
		final Long productId = createdProduct.getId();
		assertEquals("Samsung Note 3", createdProduct.getName());
		assertThat(HttpStatus.CREATED, is(response.getStatusCode()));

		HttpEntity<Product> reqEntity = new HttpEntity<Product>(null, headers);
		response = restTemplate.exchange(createURLWithPort("/product/"
				+ productId), HttpMethod.GET, reqEntity, Product.class);
		Product retrievedProduct = response.getBody();
		logger.info("retrievedProduct: "
				+ TestUtils.asJsonString(retrievedProduct));
		assertThat(30000L, is(retrievedProduct.getBasePrice()));

	}

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

}