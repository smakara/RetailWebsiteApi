package com.retail.website.service;

import java.util.Map;

import com.retail.website.model.Client;

public interface ClientService {

	public Client getClient(int clientID);

	public Map<Integer, Client> getAllClients();

	public Map<String, Object> getClientBill(Map<String, Object> data);

}
