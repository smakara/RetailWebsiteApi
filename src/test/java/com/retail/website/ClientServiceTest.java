package com.retail.website;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.retail.website.model.Client;
import com.retail.website.serviceImpl.ClientServiceImpl;

public class ClientServiceTest {

	@InjectMocks
	ClientServiceImpl service;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testGetClient() {

		Client client = new Client();
		client.setClientID(1);
		client.setClientDateCreated("2016-02-08");
		client.setClientName("Thapelo Moyeni");
		client.setClientStatus("employee");

		assertEquals("Thapelo Moyeni", client.getClientName());

	}

}
