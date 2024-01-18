package com.minhub.homebanking.Services;


import com.minhub.homebanking.DTOs.ClientDTO;
import com.minhub.homebanking.Models.Client;
import com.minhub.homebanking.Records.ClientRecord;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface ClientService {

     ResponseEntity<?> createClient(ClientRecord clientR);
     List<ClientDTO> getAllClients();
}
