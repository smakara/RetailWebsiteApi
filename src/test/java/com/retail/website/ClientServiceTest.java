package com.retail.website;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

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

		assertEquals("Thapelo Moyeni", client.getClientName());

	}

	@Test
	void testBillClient() {

		Client client = new Client();
		client.setClientID(1);
		client.setClientDateCreated("2016-02-08");
		client.setClientName("Thapelo Moyeni");
		client.setClientStatus("employee");

		Map<String, Object> map = new HashMap<>();
		map.put("clientId", 1);
		map.put("amount", 900);
		map.put("itemType", "grocery");

		assertEquals("{\n" + "  \"clientData\": {\n" + "    \"amountsubmited\": 900.0,\n" + "    \"clientId\": 1,\n"
				+ "    \"client\": {\n" + "      \"clientID\": 1,\n" + "      \"clientStatus\": \"employee\",\n"
				+ "      \"clientName\": \"Thapelo Moyeni\",\n" + "      \"clientDateCreated\": \"2016-02-08\"\n"
				+ "    },\n" + "    \"discount\": 315.0,\n" + "    \"bill\": 585.0\n" + "  }\n" + "}",
				service.getClientBill(map).get("clientData").toString());
	}

}
