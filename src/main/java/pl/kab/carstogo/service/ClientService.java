package pl.kab.carstogo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kab.carstogo.entity.ClientEntity;
import pl.kab.carstogo.model.Client;
import pl.kab.carstogo.repository.ClientRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> findAll(){
        return clientRepository.findAll().stream()
                .map(ClientEntity::mapToClient)
                .collect(Collectors.toList());
    }

    public Client addClient (Client client){
        ClientEntity clientEntity = clientRepository.save(client.mapToClientEntity());
        return clientEntity.mapToClient();
    }

    public Client findById(Integer id) {
        return findEntityById(id).mapToClient();
    }

    public ClientEntity findEntityById(Integer id) {
        return clientRepository.findById(id).orElseThrow();
    }

    public void remove (Integer id) {
        clientRepository.deleteById(id);
    }

    public Client update(Integer id, Client client){
        ClientEntity clientEntity = clientRepository.findById(id).orElseThrow();
        Optional.ofNullable(client.getFirstName()).ifPresent(clientEntity::setFirstName);
        Optional.ofNullable(client.getLastName()).ifPresent(clientEntity::setLastName);
        Optional.ofNullable(client.getEmail()).ifPresent(clientEntity::setEmail);
        Optional.ofNullable(client.getAddress()).ifPresent(clientEntity::setAddress);
        clientRepository.save(clientEntity);
        return clientEntity.mapToClient();
    }

    public Client patchClient(Integer id, String field, String value){
        ClientEntity foundClient = clientRepository.findById(id).orElseThrow();
        if(field.equalsIgnoreCase("firstName")){
            foundClient.setFirstName(value);
        } else if (field.equalsIgnoreCase("lastName")){
            foundClient.setLastName(value);
        } else if (field.equalsIgnoreCase("address")){
            foundClient.setAddress(value);
        } else if (field.equalsIgnoreCase("email")){
            foundClient.setEmail(value);
        }
        clientRepository.save(foundClient);
        return foundClient.mapToClient();
    }
}
