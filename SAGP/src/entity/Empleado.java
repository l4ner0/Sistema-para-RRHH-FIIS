/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.FileInputStream;

/**
 *
 * @author diego
 */
public class Empleado {
  private String idEmpleado;
  private String nombres;
  private String apellidoPaterno;
  private String apellidoMaterno;
  private String sexo;
  private String DNI;
  private String fechaNacimiento;
  private String DistritoResidencia;
  private String direccion;
  private String telefono;
  private String correoElectronico;
  private String asignacionFamiliar;
  private int idArea;
  private int idPuesto;
  private int idRetencion;
  private double sueld_total;
  private FileInputStream fotoEmpleado;
    
    public Empleado(){
       this.idEmpleado="";
       this.nombres="";
       this.apellidoPaterno="";
       this.apellidoMaterno="";
       this.sexo="";
       this.DNI="";
       this.fechaNacimiento="";
       this.DistritoResidencia="";
       this.direccion="";
       this.telefono="";
       this.correoElectronico="";
       this.asignacionFamiliar="";
       this.idArea=0;
       this.idPuesto=0;
       this.idRetencion=0;
       this.sueld_total=0;
       this.fotoEmpleado=null;
    }

   

    public FileInputStream getFotoEmpleado() {
        return fotoEmpleado;
    }

    public void setFotoEmpleado(FileInputStream fotoEmpleado) {
        this.fotoEmpleado = fotoEmpleado;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDistritoResidencia() {
        return DistritoResidencia;
    }

    public void setDistritoResidencia(String DistritoResidencia) {
        this.DistritoResidencia = DistritoResidencia;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getAsignacionFamiliar() {
        return asignacionFamiliar;
    }

    public void setAsignacionFamiliar(String asignacionFamiliar) {
        this.asignacionFamiliar = asignacionFamiliar;
    }

    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }

    public int getIdPuesto() {
        return idPuesto;
    }

    public void setIdPuesto(int idPuesto) {
        this.idPuesto = idPuesto;
    }

    public int getIdRetencion() {
        return idRetencion;
    }

    public void setIdRetencion(int idRetencion) {
        this.idRetencion = idRetencion;
    }
    
    public double getSueld_total() {
        return sueld_total;
    }

    public void setSueld_total(double sueld_total) {
        this.sueld_total = sueld_total;
    }
}
