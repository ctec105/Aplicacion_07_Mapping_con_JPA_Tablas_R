package edu.aprender.persistence.entity;

import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

import edu.aprender.persistence.entity.listener.EmpleadoListener;

@EntityListeners(EmpleadoListener.class)
@Entity
@Table(name="tb_empleado")
public class Empleado {
	
	@Id
	@Column(name="COD_EMP",unique=true,nullable=false)
	@GeneratedValue(strategy= GenerationType.AUTO, generator="generador")
    @TableGenerator(name="generador", table="tb_secuencia", pkColumnName="descripcion",valueColumnName="valor",
                    pkColumnValue="empleado", allocationSize=1)
	private int id;

	@Basic(optional=true)
	@Column(name="APE_EMP", length=45, nullable=false, insertable=true, updatable=true)
	private String apellido;
	
	@Basic
	@Column(name="NOM_EMP",length=45, columnDefinition="unsigned NOT NULL", insertable=true, updatable=true)
	private String nombre;
	
	@Basic
	@Column(name="EDA_EMP",nullable=false, insertable=true, updatable=true)
	private int edad;
	
	@Basic
	@Column(name="ARE_EMP",length=45, nullable=false, insertable=true, updatable=true)
	private String area;
	
	@Basic
	@Column(name="FEC_ING_EMP", nullable=false, insertable=true, updatable=true)
	private Date fechaIngreso;
	
	@ManyToOne
	@JoinColumn(name="COD_CAR")
	private Cargo cargo;
	
	@OneToOne
	@JoinColumn(name="COD_CAS")
	private Casillero casillero;
	
	@Transient
	private String nombreCompleto;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	
	public String getNombreCompleto() {
		return getNombre().concat(" ").concat(getApellido());
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public Cargo getCargo() {
		return cargo;
	}
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	public Casillero getCasillero() {
		return casillero;
	}
	public void setCasillero(Casillero casillero) {
		this.casillero = casillero;
	}
	@Override
	public String toString() {
		return "Empleado [id=" + id + ", apellido=" + apellido + ", nombre="
				+ nombre + ", edad=" + edad + ", area=" + area
				+ ", fechaIngreso=" + fechaIngreso + ",  nombreCompleto="
				+ nombreCompleto + "]";
	}

}