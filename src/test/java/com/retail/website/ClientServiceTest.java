package com.retail.website;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.retail.website.model.Client;
import com.retail.website.service.ClientService;

public class ClientServiceTest {

	@InjectMocks
	ClientService service;

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

		when(service.getClient(1)).thenReturn(client);
//

		assertEquals("Thapelo Moyeni", client.getClientName());

	}

}
