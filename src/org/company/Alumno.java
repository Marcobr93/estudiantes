package org.company;

import java.util.Comparator;
import java.util.Objects;

/**
 * Created by marco on 26/4/17.
 */
public class Alumno implements Comparable{
    private String nombre;
    private String apellidos;
    private String direccion;
    private String email;
    private String dni;

    // Constructores

    public Alumno() {
    }

    public Alumno(String dni) {
        this.dni = dni;
    }

    public Alumno(String dni, String nombre, String apellidos, String direccion, String email) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.email = email;
        this.dni = dni;
    }

    // Accesores


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", direccion='" + direccion + '\'' +
                ", email='" + email + '\'' +
                ", dni='" + dni + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {

        if(this == obj) { return true; }

        if (obj == null) { return false; }

        if (this.getClass() != obj.getClass()) { return false; }

        Alumno alum = (Alumno) obj;

        return Objects.equals(this.dni, alum.dni);
    }


    public static Comparator<Alumno> comparadorPorApellidosNombre = new Comparator<Alumno>() {
        @Override
        public int compare(Alumno alumno1, Alumno alumno2) {
            int res;

            res = alumno1.getApellidos().compareToIgnoreCase(alumno2.getApellidos());
            if(res != 0){
                return res;
            }
            return alumno1.getNombre().compareToIgnoreCase(alumno2.getNombre());
        }
    };

    public static Comparator<Alumno> comparadorPorLongitudNombre = new Comparator<Alumno>() {
        @Override
        public int compare(Alumno alumno1, Alumno alumno2) {
            return alumno1.getNombre().length() - alumno2.getNombre().length();
        }
    };


    @Override
    public int compareTo(Object obj){
        Alumno alumno = (Alumno) obj;
        int res;

        // Restamos los nombres para saber cuál tiene una longitud mayor.
        return this.getNombre().length() - alumno.getNombre().length();
    }
}

/*
@Override
    public int compareTo(Object obj){
        Alumno alumno = (Alumno) obj;
        int res;
        // Compara por apellidos, si res es distinto de 0 entonces los ordena alfabeticamente por los apellidos,
        // y cuando res sea igual que 0, entonces los ordena alfabeticamente por el nombre.
        res = this.getApellidos().compareToIgnoreCase(alumno.getApellidos());
        if(res != 0){
            return res;
        }
        return this.getNombre().compareToIgnoreCase(alumno.getNombre());
    }
 */


