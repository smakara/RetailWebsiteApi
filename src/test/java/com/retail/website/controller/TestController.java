//package com.retail.website.controller;
//
//import static org.junit.Assert.assertEquals;
//
//import org.junit.Test;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//public class TestController extends AbstractTest {
//
////	@Override
////	@Before
////	public void setUp() {
////		super.setUp();
////	}
//
//	@Test
//	public void getClientList() throws Exception {
//		String uri = "/list";
//		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
//				.andReturn();
//
//		int status = mvcResult.getResponse().getStatus();
//		assertEquals(200, status);
////		String content = mvcResult.getResponse().getContentAsString();
////		Product[] productlist = super.mapFromJson(content, Product[].class);
////		assertTrue(productlist.length > 0);
//	}
//}
