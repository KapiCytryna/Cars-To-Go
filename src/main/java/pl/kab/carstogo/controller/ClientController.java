package pl.kab.carstogo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kab.carstogo.model.Client;
import pl.kab.carstogo.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> findAll() {
        return clientService.findAll();
    }

    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return clientService.addClient(client);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable("id") Integer id) {
        clientService.remove(id);
    }

    @PutMapping("/{id}")
    public Client updateClient(@PathVariable("id") Integer id, @RequestBody Client client) {
        return clientService.update(id,client);
    }

    public ResponseEntity<Object> patchClient(@PathVariable("id") Integer id,
                                              @RequestParam("field") String field,
                                              @RequestParam("value") String value) {
        try {
            return new ResponseEntity<>(clientService.patchClient(id,field,value), HttpStatus.ACCEPTED);
        } catch (NumberFormatException e){
            return new ResponseEntity<>("Bad format for value/field try again", HttpStatus.BAD_REQUEST);
        }
    }
}
