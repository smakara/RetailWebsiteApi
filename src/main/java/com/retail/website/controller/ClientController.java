package com.retail.website.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.retail.website.model.Client;
import com.retail.website.service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
	public ClientService clientService;

	@GetMapping(path = "/list") // lists al the clients
	public Map<Integer, Client> getAllClients() {

		return clientService.getAllClients();
	}

	@GetMapping(path = "/{id}") // gets a single client based on id
	public Client getClient(@PathVariable int id) {

		;
		return clientService.getClient(id);
	}

	@PostMapping(path = "/bill") // brings back the net payable amount
	public Map<String, Object> getOtpById(@RequestBody Map<String, Object> data) {
		Map<String, Object> map = new LinkedHashMap<String, Object>();

		try {

			map.put("clientData", clientService.getClientBill(data));

			Gson gson = new Gson();
			System.out.println("map====>  " + map.get("clientData").toString());
			JsonObject jo = gson.fromJson(map.get("clientData").toString(), JsonObject.class);
			System.out.println("bill ====>  " + jo.toString());

		} catch (Exception e) {
			e.getStackTrace();
		}
		return map;
	}

}
