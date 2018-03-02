/**
 * 
 */
package com.prizy.rest.controllers;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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

import com.prizy.entities.builders.PriceDetailsBuilder;
import com.prizy.entities.vo.PriceDetails;
import com.prizy.services.intf.IPriceDetailsService;

/**
 * @author Shailendra
 *
 */
public class PriceDetailsControllerTest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Mock
	private IPriceDetailsService service;

	@InjectMocks
	private PriceDetailsController controller;

	private MockMvc mockMvc;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	private PriceDetails mockPrice = new PriceDetailsBuilder().with(
			builder -> {
				builder.setProductId(200L);
				builder.setDesc("Best in segment");
				builder.setProductName("Samsung Note 3");
				builder.setBasePrice(15000L);
				builder.setAveragePrice(21000L);
				builder.setLowestPrice(18000L);
				builder.setHighestPrice(24000L);
				builder.setIdealPrice(23000L);
				builder.setCountOfDiffPrices(10L);

			}).createProduct();

	@Test
	public void getPriceDetailsSuccess() throws Exception {

		when(service.getPriceDetails(Mockito.anyLong())).thenReturn(mockPrice);

		RequestBuilder requestBuilder = get("/product/{productId}/prices", 200L)
				.accept(MediaType.APPLICATION_JSON);

		mockMvc.perform(requestBuilder)
				.andDo(h -> logger.info("PriceDetails JSON: "
						+ h.getResponse().getContentAsString()))
				.andExpect(status().isOk())
				.andExpect(
						content().contentType(
								MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(jsonPath("$.productId", is(200)))
				.andExpect(jsonPath("$.productName", is("Samsung Note 3")))
				.andExpect(jsonPath("$.basePrice", is(15000)))
				.andExpect(jsonPath("$.averagePrice", is(21000)))
				.andExpect(jsonPath("$.lowestPrice", is(18000)))
				.andExpect(jsonPath("$.highestPrice", is(24000)))
				.andExpect(jsonPath("$.idealPrice", is(23000)))
				.andExpect(jsonPath("$.countOfDiffPrices", is(10)));

		verify(service, Mockito.times(1)).getPriceDetails(200L);
		verifyNoMoreInteractions(service);

	}
}
