package edu.aprender.test;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;

import edu.aprender.persistence.entity.Cargo;
import edu.aprender.persistence.entity.Casillero;
import edu.aprender.persistence.entity.Empleado;
import edu.aprender.persistence.jpa.EmpleadoJPA;

public class EmpleadoTest {
	
	static  Logger logger = Logger.getLogger(EmpleadoTest.class.getName());
	
	public static void main(String[] args) {
		EmpleadoJPA empleadoJPA = new EmpleadoJPA();
		
		// Entidades con datos estáticos
		Cargo cargo=new Cargo();
		cargo.setCodigo(1);
		
		// Entidades con datos estáticos
		Casillero casillero=new Casillero();
		casillero.setCodigo(1);
		
		// Entidades con datos estáticos
		Empleado entidadEmpleado = new Empleado();
		//entidadEmpleado.setId(1);
		entidadEmpleado.setNombre("Antonio");
		entidadEmpleado.setApellido("Perez");
		entidadEmpleado.setEdad(30);
		entidadEmpleado.setArea("100");
		entidadEmpleado.setFechaIngreso(new Date(Calendar.getInstance().getTime().getTime()));
		entidadEmpleado.setCargo(cargo);
		entidadEmpleado.setCasillero(casillero);
		
		try {
			logger.debug("Registrando un nuevo empleado");
			empleadoJPA.setup();
			empleadoJPA.insertar(entidadEmpleado);
			mostrar(empleadoJPA.consultar());
			empleadoJPA.close();
			
			logger.debug("Actualizamos un  empleado");
			empleadoJPA.setup();
			entidadEmpleado.setApellido("Gomez");
			empleadoJPA.actualizar(entidadEmpleado);
			mostrar(empleadoJPA.consultar());
			empleadoJPA.close();

			logger.debug("Eliminamos un  empleado");
			empleadoJPA.setup();
			empleadoJPA.eliminar(1);
			mostrar(empleadoJPA.consultar());
			empleadoJPA.close();
		} catch (Exception e) {
			logger.error("Error " + e.getMessage());
			e.printStackTrace();
		} finally {
			
		}
	}
	
	private static void mostrar(List<Empleado> listaEntidad){
		for (int i = 0; i < listaEntidad.size(); i++) {
			Empleado entidad = (Empleado) listaEntidad.get(i);
			logger.info(entidad.toString());
		}
	}

}
