package com.example.demo.controllers;



        import com.example.demo.domains.Client;
        import com.example.demo.repositories.ClientRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("clients")
@CrossOrigin(origins = "http://localhost:4200")
public class ClientsController {

    @Autowired
    ClientRepository clientRepository;

    @GetMapping
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

//    @PostMapping
//    public Client addNewTask(@RequestBody Client client) {
//        return clientRepository.save(new Client(client.getName(), client.getPhoneNumber()));
//    }

}
