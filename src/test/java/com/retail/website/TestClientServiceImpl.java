package com.retail.website;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.retail.website.model.Client;
import com.retail.website.serviceImpl.ClientServiceImpl;

public class TestClientServiceImpl {

	@InjectMocks
	ClientServiceImpl service;

//    @Mock
//    private CustomerArchiveConfigRepository repo;

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

//		when(service.getClient(1)).thenReturn(client);

		assertEquals("Thapelo Moyeni", service.getClient(1).getClientName());

	}

	@Test
	void getAllClients() {

		int count = 0;
		for (int i : service.getAllClients().keySet()) {
			count = count + 1;
		}
		assertEquals(5, count);

	}

	@Test
	void discountForEvery100() {

		assertEquals(0, service.discountForEvery100(90));
	}

	@Test
	void discountForEvery1002() {

		assertEquals(10, service.discountForEvery100(200));
	}

	@Test
	void getClientBill() {

		Map<String, Object> data = new HashMap<>();
		data.put("clientId", 1);
		data.put("amount", 90);
		data.put("itemType", "groceryy");

		Map<String, Object> dataResponse = service.getClientBill(data);
		dataResponse.get("clientData");
		assertEquals(
				"{amountsubmited=90.0, clientId=1, client=Client(clientID=1, clientStatus=employee, clientName=Thapelo Moyeni, clientDateCreated=2016-02-08), discount=27.0, bill=63.0}",
				dataResponse.toString());

	}

	@Test
	void getClientBill2() {

		Map<String, Object> data = new HashMap<>();
		data.put("clientId", 2);
		data.put("amount", 90);
		data.put("itemType", "groceryy");

		Map<String, Object> dataResponse = service.getClientBill(data);
		dataResponse.get("clientData");
		assertEquals(
				"{amountsubmited=90.0, clientId=2, client=Client(clientID=2, clientStatus=affiliate, clientName=Tsepo Moyo, clientDateCreated=2016-02-08), discount=9.0, bill=81.0}",
				dataResponse.toString());

	}

	@Test
	void getClientBill3() {

		Map<String, Object> data = new HashMap<>();
		data.put("clientId", 3);
		data.put("amount", 90);
		data.put("itemType", "groceryy");

		Map<String, Object> dataResponse = service.getClientBill(data);

		assertEquals(
				"{amountsubmited=90.0, clientId=3, client=Client(clientID=3, clientStatus=customer, clientName=Tomas Yang, clientDateCreated=2016-02-08), discount=4.5, bill=85.5}",
				dataResponse.toString());

	}

	@Test
	void getClientBill4() {

		Map<String, Object> data = new HashMap<>();
		data.put("clientId", 4);
		data.put("amount", 90);
		data.put("itemType", "groceryy");

		Map<String, Object> dataResponse = service.getClientBill(data);
		dataResponse.get("clientData");
		assertEquals(
				"{amountsubmited=90.0, clientId=4, client=Client(clientID=4, clientStatus=customer, clientName=Theresa Sly, clientDateCreated=2016-02-08), discount=4.5, bill=85.5}",
				dataResponse.toString());

	}

	@Test
	void getClientBill5() {

		Map<String, Object> data = new HashMap<>();
		data.put("clientId", 4);
		data.put("amount", 90);
		data.put("itemType", "groceryy");

		Map<String, Object> dataResponse = service.getClientBill(data);
		dataResponse.get("clientData");
		assertEquals(
				"{amountsubmited=90.0, clientId=4, client=Client(clientID=4, clientStatus=customer, clientName=Theresa Sly, clientDateCreated=2016-02-08), discount=4.5, bill=85.5}",
				dataResponse.toString());

	}

	@Test
	void getClientBill6() {

		Map<String, Object> data = new HashMap<>();
		data.put("clientId", 2);
		data.put("amount", 90);
		data.put("itemType", "groceryy");

		Map<String, Object> dataResponse = service.getClientBill(data);
		dataResponse.get("clientData");
		assertEquals(
				"{amountsubmited=90.0, clientId=2, client=Client(clientID=2, clientStatus=affiliate, clientName=Tsepo Moyo, clientDateCreated=2016-02-08), discount=9.0, bill=81.0}",
				dataResponse.toString());

	}

	@Test
	void getClientBill7() {

		Map<String, Object> data = new HashMap<>();
		data.put("clientId", 5);
		data.put("amount", 90);
		data.put("itemType", "groceryy");

		Map<String, Object> dataResponse = service.getClientBill(data);
		dataResponse.get("clientData");
		assertEquals(
				"{amountsubmited=90.0, clientId=5, client=Client(clientID=5, clientStatus=customer, clientName=Tsepang Mokoroko, clientDateCreated=2021-02-08), discount=0.0, bill=90.0}",
				dataResponse.toString());

	}
}
