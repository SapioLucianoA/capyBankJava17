package com.minhub.homebanking.Controllers;

import com.minhub.homebanking.DTOs.ClientDTO;
import com.minhub.homebanking.Models.Client;
import com.minhub.homebanking.Records.ClientRecord;
import com.minhub.homebanking.Repositories.ClientRepository;
import com.minhub.homebanking.Services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@RestController
@RequestMapping("/api")
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ClientService clientService;

     @GetMapping("/clients")
     public List<ClientDTO> getAllClients (){
        return clientService.getAllClients();
     }
    @PostMapping("/client")
     public ResponseEntity<?> createClient(ClientRecord clientR){
        return  clientService.createClient(clientR);
     }

}
