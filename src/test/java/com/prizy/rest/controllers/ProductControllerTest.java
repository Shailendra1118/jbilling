/**
 * 
 */
package com.prizy.rest.controllers;

import static org.hamcrest.core.Is.is;
import static org.mockito.Matchers.refEq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prizy.entities.Product;
import com.prizy.entities.builders.ProductBuilder;
import com.prizy.services.intf.IProductService;

/**
 * @author Shailendra
 *
 */

public class ProductControllerTest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Mock
	private IProductService service;

	@InjectMocks
	private ProductController productController;

	private MockMvc mockMvc;

	private Product mockProduct = new ProductBuilder().with(builder -> {
		builder.setId(200L);
		builder.setName("Samsung Note 3");
		builder.setBasePrice(20000L);
		builder.setLongDescription("Best in segment");
		builder.setType("Mobile");
		builder.setImgUrl("http://s3.aws.prizy/123");
	}).createProduct();

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(productController).build();

	}

	@Test
	public void getProductByIdTest() throws Exception {

		when(service.getProductById(Mockito.anyLong())).thenReturn(mockProduct);

		RequestBuilder requestBuilder = get("/product/{id}", 200L).accept(
				MediaType.APPLICATION_JSON_UTF8_VALUE);

		mockMvc.perform(requestBuilder)
				.andDo(h -> logger.info("Product JSON: "
						+ h.getResponse().getContentAsString()))
				.andExpect(status().isOk())
				.andExpect(
						content().contentType(
								MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(jsonPath("$.id", is(200)))
				.andExpect(jsonPath("$.name", is("Samsung Note 3")))
				.andExpect(jsonPath("$.basePrice", is(20000)))
				.andExpect(jsonPath("$.longDescription", is("Best in segment")));

		verify(service, Mockito.times(1)).getProductById(200L);
		verifyNoMoreInteractions(service);

	}

	@Test
	public void getProductByIdNotFoundTest() throws Exception {

		when(service.getProductById(1L)).thenReturn(null);

		mockMvc.perform(get("/product/{id}", 1L)).andExpect(
				status().isNotFound());

		verify(service, times(1)).getProductById(1L);
		verifyNoMoreInteractions(service);
	}

	@Test
	public void createProductSuccessTest() throws Exception {

		Product productAdded = new ProductBuilder().with(builder -> {
			builder.setName("Iphone X");
			builder.setBasePrice(40000L);
			builder.setLongDescription("Best in segment");
			builder.setType("Mobile");
			builder.setImgUrl("http://s3.aws.prizy/123");
		}).createProduct();

		when(service.isExists(productAdded.getName())).thenReturn(false);
		doNothing().when(service).create(productAdded);

		RequestBuilder requestBuilder = post("/product").contentType(
				MediaType.APPLICATION_JSON_UTF8_VALUE).content(
				asJsonString(productAdded));

		mockMvc.perform(requestBuilder)
				.andDo(h -> logger.info("Product JSON: "
						+ h.getResponse().getContentAsString()))
				.andExpect(status().isCreated());

		verify(service, times(1)).isExists(productAdded.getName());
		// TODO implement equals in Product
		verify(service, times(1)).create(refEq(productAdded));
		verifyNoMoreInteractions(service);

	}

	@Test
	public void createProductConflictTest() throws Exception {

		Product productAdded = new ProductBuilder().with(builder -> {
			builder.setName("Iphone X");
			builder.setBasePrice(40000L);
			builder.setLongDescription("Best in segment");
			builder.setType("Mobile");
			builder.setImgUrl("http://s3.aws.prizy/123");
		}).createProduct();

		// product already exists with this name
		when(service.isExists(productAdded.getName())).thenReturn(true);
		doNothing().when(service).create(productAdded);

		RequestBuilder requestBuilder = post("/product").contentType(
				MediaType.APPLICATION_JSON_UTF8_VALUE).content(
				asJsonString(productAdded));

		mockMvc.perform(requestBuilder)
				.andDo(h -> logger.info("Product JSON: "
						+ h.getResponse().getContentAsString()))
				.andExpect(status().isConflict());

		verify(service, times(1)).isExists(productAdded.getName());
		// create shouldn't be called
		verify(service, times(0)).create(refEq(productAdded));
		verifyNoMoreInteractions(service);

	}

	/*
	 * converts a Java object into JSON representation
	 */
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
