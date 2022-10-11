package com.example.bosonit72.person.infraestructure.controler.CRUD;

import com.example.bosonit72.person.infraestructure.controler.OutPutPersonaDto.OutputPersonaDTO;
import com.example.bosonit72.person.application.service.PersonServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReadPersonByUsernameController {
    @Autowired
    PersonServiceImp ex;

    @GetMapping("/Username/{usuario}")
    public List<OutputPersonaDTO> getListFiltred(@PathVariable("usuario") String usuario) {
        return ex.getUsername(usuario);
    }


}
