package com.minhub.homebanking.DTOs;

import com.minhub.homebanking.Models.Client;

public class ClientDTO {
    private String Id;
    private String name, lastName, email;

    public ClientDTO() {
    }
    public ClientDTO(Client client){
        this.Id = client.getId();
        this.email = client.getEmail();
        this.name = client.getName();
        this.lastName = client.getLastName();
        this.email = client.getEmail();
    }

    public String getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }
}
