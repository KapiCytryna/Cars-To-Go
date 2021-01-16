package pl.kab.carstogo.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.kab.carstogo.model.Client;
import pl.kab.carstogo.service.ClientService;

@Controller
@RequestMapping("/client")
public class ClientViewController {
    private final ClientService clientService;

    @Autowired
    public ClientViewController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/all")
    public String allClients(final Model model) {
        model.addAttribute("clientList", clientService.findAll());
        return "client/list";
    }

    @GetMapping("/add")
    public String addClient(final Model model){
        model.addAttribute("clientForm", new Client());
        return "client/form";
    }

    @PostMapping("/add")
    public String addClientFormProcess(@ModelAttribute("clientForm") Client client){
        clientService.addClient(client);
        return "redirect:/client/all";
    }

    @GetMapping("/edit/{id}")
    public String editClientForm(@PathVariable("id") Integer id, Model model){
        model.addAttribute("clientForm", clientService.findById(id));
        return "client/edit-form";
    }

    @PostMapping("/edit/{id}")
    public String editClientFormProcess(@ModelAttribute Client client, @PathVariable("id") Integer id) {
        clientService.update(id, client);
        return "redirect:/client/all";
    }

    @PostMapping("/delete/{id}")
    public String deleteClientProcess(@PathVariable("id") Integer id){
        clientService.remove(id);
        return "redirect:/client/all";
    }
}
