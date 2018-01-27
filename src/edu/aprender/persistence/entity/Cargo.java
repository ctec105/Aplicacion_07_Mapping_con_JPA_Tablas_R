package edu.aprender.persistence.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_cargo")
public class Cargo implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="COD_CAR")
	private int codigo;
	
	@Column(name="DES_CAR")
	private String descripcion;
	
	@OneToMany(mappedBy="cargo")
	private Collection<Empleado> empleados;
	
	public Collection<Empleado> getEmpleados() {
		return empleados;
	}
	public void setEmpleados(Collection<Empleado> empleados) {
		this.empleados = empleados;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "Cargo [codigo=" + codigo + ", descripcion=" + descripcion
				+ ", empleados=" + empleados + "]";
	}
	
}