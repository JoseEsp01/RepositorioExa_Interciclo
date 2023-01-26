package com.ista.springboot.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import com.ista.springboot.web.model.Empleado;
import com.ista.springboot.web.repository.IEmpleadoRepository;



public class EmpleadoServiceImpl extends GenericServiceImpl<Empleado, Integer> implements IEmpleadoService{
    @Autowired
    private IEmpleadoRepository EmpleadoRepository;

    @Override
    public CrudRepository<Empleado, Integer> getDao() {
        return EmpleadoRepository;
    }

}
