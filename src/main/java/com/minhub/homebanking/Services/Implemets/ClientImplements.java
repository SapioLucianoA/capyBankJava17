package com.minhub.homebanking.Services.Implemets;


import com.minhub.homebanking.DTOs.ClientDTO;
import com.minhub.homebanking.Models.Client;
import com.minhub.homebanking.Models.PasswordValidation;
import com.minhub.homebanking.Records.ClientRecord;
import com.minhub.homebanking.Repositories.ClientRepository;
import com.minhub.homebanking.Services.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientImplements implements ClientService {
    @Autowired
    private ClientRepository clientRepository;




    @Override
    public ResponseEntity<?> createClient(ClientRecord clientR) {
        if (clientR.name().isBlank()){
            return new ResponseEntity<>("Missing Name", HttpStatus.FORBIDDEN);
        }
        if (clientR.lastName().isBlank()){
            return new ResponseEntity<>("Missing last name", HttpStatus.FORBIDDEN);
        }
        if (clientR.email().isBlank()){
            return new ResponseEntity<>("Complete your Email", HttpStatus.FORBIDDEN);
        }
        if (clientR.password().isBlank()){
            return new ResponseEntity<>("Complete your password", HttpStatus.FORBIDDEN);
        }
        if (!PasswordValidation.validate(clientR.password())){
            return new ResponseEntity<>("Your password must have at least eight (8) characters, one (1) number, one (1) uppercase letter, one (1) special character, and it should not have any white spaces.", HttpStatus.FORBIDDEN);
        }
        Client client = new Client(clientR.name(), clientR.lastName(), clientR.email(), clientR.password());
        clientRepository.save(client);
        return new ResponseEntity<>("client created!", HttpStatus.CREATED);
    }

    @Override
    public List<ClientDTO> getAllClients() {
        List<Client> clientList = clientRepository.findAll();
        return clientList.stream().map(client -> new ClientDTO(client)).collect(Collectors.toList());
    }


}
