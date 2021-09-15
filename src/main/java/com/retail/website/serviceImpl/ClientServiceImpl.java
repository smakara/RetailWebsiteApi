package com.retail.website.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.retail.website.model.Client;
import com.retail.website.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

	@Override
	public Client getClient(int clientID) {
		Map<Integer, Client> clientmap = new HashMap<Integer, Client>();

		Client client = new Client();
		client.setClientID(1);
		client.setClientDateCreated("2016-02-08");
		client.setClientName("Thapelo Moyeni");
		client.setClientStatus("employee");

		Client client2 = new Client();
		client2.setClientID(2);
		client2.setClientDateCreated("2016-02-08");
		client2.setClientName("Tsepo Moyo");
		client2.setClientStatus("affiliate");

		Client client3 = new Client();
		client3.setClientID(3);
		client3.setClientDateCreated("2016-02-08");
		client3.setClientName("Tomas Yang");
		client3.setClientStatus("customer");

		Client client4 = new Client();
		client4.setClientID(4);
		client4.setClientDateCreated("2016-02-08");
		client4.setClientName("Theresa Sly");
		client4.setClientStatus("customer");

		Client client5 = new Client();
		client5.setClientID(5);
		client5.setClientDateCreated("2021-02-08");
		client5.setClientName("Tsepang Mokoroko");
		client5.setClientStatus("customer");

		clientmap.put(1, client);
		clientmap.put(2, client2);
		clientmap.put(3, client3);
		clientmap.put(4, client4);
		clientmap.put(5, client5);

		return clientmap.get(clientID);
	}

	@Override
	public Map<Integer, Client> getAllClients() {

		Map<Integer, Client> clientmap = new HashMap<Integer, Client>();
		Client client = new Client();
		client.setClientID(1);
		client.setClientDateCreated("2016-02-08");
		client.setClientName("Thapelo Moyeni");
		client.setClientStatus("employee");

		Client client2 = new Client();
		client2.setClientID(2);
		client2.setClientDateCreated("2016-02-08");
		client2.setClientName("Tsepo Moyo");
		client2.setClientStatus("affiliate");

		Client client3 = new Client();
		client3.setClientID(3);
		client3.setClientDateCreated("2016-02-08");
		client3.setClientName("Tomas Yang");
		client3.setClientStatus("customer");

		Client client4 = new Client();
		client4.setClientID(4);
		client4.setClientDateCreated("2016-02-08");
		client4.setClientName("Theresa Sly");
		client4.setClientStatus("customer");

		Client client5 = new Client();
		client5.setClientID(5);
		client5.setClientDateCreated("2021-02-08");
		client5.setClientName("Tsepang Mokoroko");
		client5.setClientStatus("customer");

		clientmap.put(1, client);
		clientmap.put(2, client2);
		clientmap.put(3, client3);
		clientmap.put(4, client4);
		clientmap.put(5, client5);

		return clientmap;
	}

	@Override
	public Map<String, Object> getClientBill(Map<String, Object> data) {
		Map<String, Object> responseMap = new HashMap<>();

		double totalDiscount = 0.00;
		int clientId = Integer.parseInt(data.get("clientId").toString());
		double amountSubmitted = Double.parseDouble(data.get("amount").toString());
		String itemType = (data.get("itemType").toString());

		if (getClient(clientId).getClientStatus().compareTo("employee") == 0 && !"grocery".equals(itemType)) {

			System.out.println("=====> itemType " + itemType);

			totalDiscount = discountForEvery100(amountSubmitted) + (((30 * amountSubmitted) / 100));

		}

		if (getClient(clientId).getClientStatus().compareTo("affiliate") == 0 && !"grocery".equals(itemType)) {

			totalDiscount = discountForEvery100(amountSubmitted) + (((10 * amountSubmitted) / 100));
		}

		if (getClient(clientId).getClientStatus().compareTo("customer") == 0 && !"grocery".equals(itemType)) {
			getClient(clientId).getClientDateCreated();

			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");

			Date startDate = null;
			try {
				startDate = sdf1.parse(getClient(clientId).getClientDateCreated());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			LocalDate startDate_l = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			if (Period.between(startDate_l, LocalDate.now()).getYears() > 2) {

				totalDiscount = discountForEvery100(amountSubmitted) + (((5 * amountSubmitted) / 100));

			} else {

				totalDiscount = discountForEvery100(amountSubmitted);

			}

		}

		responseMap.put("clientId", data.get("clientId"));
		responseMap.put("client", getClient(clientId));
		responseMap.put("amountsubmited", (amountSubmitted));
		responseMap.put("discount", totalDiscount);
		responseMap.put("bill", (amountSubmitted - totalDiscount));
		return responseMap;
	}

	public double discountForEvery100(double bill) {

		double discount = ((bill / 100) * 5);

		return bill > 100 ? discount : 0; // if bill is greater than 100 we discount else we dont
	}

//	 public double discount(double ) {
//		 
//		 return 2.0;
//	 }

}
