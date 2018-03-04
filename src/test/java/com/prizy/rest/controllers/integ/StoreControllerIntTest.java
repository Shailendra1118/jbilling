/**
 * 
 */
package com.prizy.rest.controllers.integ;

import static org.hamcrest.CoreMatchers.is;
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
import com.prizy.entities.Store;
import com.prizy.entities.builders.StoreBuilder;

/**
 * @author Shailendra
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StoreControllerIntTest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();
	private final Store store = new StoreBuilder().with(s -> {
		s.setName("Vijay Sales");
		s.setLocation("Pune");
		s.setDesc("Electronix store");
	}).createStore();

	@Test
	public void saveAndRetrieveStore() throws JSONException {

		HttpEntity<Store> entity = new HttpEntity<Store>(store, headers);
		ResponseEntity<Store> response = restTemplate.exchange(
				createURLWithPort("/store"), HttpMethod.POST, entity,
				Store.class);

		Store createdStore = response.getBody();
		final Long storeId = createdStore.getId();
		assertThat("Vijay Sales", is(createdStore.getName()));
		assertThat(HttpStatus.CREATED, is(response.getStatusCode()));

		HttpEntity<Store> reqEntity = new HttpEntity<Store>(null, headers);
		response = restTemplate.exchange(
				createURLWithPort("/store/" + storeId), HttpMethod.GET,
				reqEntity, Store.class);
		Store retrievedStore = response.getBody();
		logger.info("Retrieved Store: "
				+ TestUtils.asJsonString(retrievedStore));
		assertThat("Pune", is(retrievedStore.getLocation()));

	}

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

}