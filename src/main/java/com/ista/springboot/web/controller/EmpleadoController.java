package com.ista.springboot.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ista.springboot.web.model.Empleado;
import com.ista.springboot.web.service.IEmpleadoService;


@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class EmpleadoController {

	@Autowired
    private IEmpleadoService EmpleadoService;

    @GetMapping("/Empleado/listar")
    public ResponseEntity<List<Empleado>> getAll() {
        try {
            return new ResponseEntity<>(EmpleadoService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/Empleado/search/{id}")
    public ResponseEntity<Empleado> getById(@PathVariable("id") Integer id){
        try {
            return  new ResponseEntity<>(EmpleadoService.findById(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/Empleado/crear")
    public ResponseEntity<Empleado> createReproducion(@RequestBody Empleado Empleado){
        try {
            return new ResponseEntity<>(EmpleadoService.save(Empleado), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/Empleado/delete/{id}")
    public ResponseEntity<?> deletesong(@PathVariable("id") Integer id) {
        try {
        	EmpleadoService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (DataIntegrityViolationException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("404 not found");
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/Empleado/update/{id}")
    public ResponseEntity<Empleado> updateClient(@RequestBody Empleado Empleado, @PathVariable("id") Integer id){
    	Empleado canUp = EmpleadoService.findById(id);

        if(canUp == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            try {
                canUp.setNombre(Empleado.getNombre());
                canUp.setApellido(Empleado.getApellido());
                canUp.setTelefono(Empleado.getTelefono());
                canUp.setDireccion(Empleado.getDireccion());
                canUp.setFecha_nacimiento(Empleado.getFecha_nacimiento());
                canUp.setObservacion(Empleado.getObservacion());
                canUp.setDias_trabajo(Empleado.getDias_trabajo());
                canUp.setSueldo(Empleado.getSueldo());
                return new ResponseEntity<>(EmpleadoService.save(Empleado), HttpStatus.CREATED);
            }catch (Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

    }
}
