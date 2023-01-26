package com.ista.springboot.web.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name ="empleados")
public class Empleado {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private Integer id_empleado;

	@Column(name = "apellido")
    private String apellido;
	
    @Column(name = "nombre")
    private String nombre;


    @Column(name = "telefono")
    private String telefono;

    @Column(name = "direccion")
    private String direccion;
    
    @Column(name = "fecha_nacimiento")
    private Date fecha_nacimiento;
    
    @Column(name = "observacion")
    private String observacion;

    @Column(name = "dias_trabajo")
    private Integer dias_trabajo;
    
    @Column(name = "sueldo")
    private Integer sueldo;

}
