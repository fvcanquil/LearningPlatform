package com.duoc.LearningPlatform.model;

/**
 * Modelo que representa un Curso dentro de la plataforma de aprendizaje.
 * Se utiliza almacenamiento temporal en ArrayList (sin persistencia JPA).
 */
public class Curso {
    private Long id;
    private String nombre;
    private String descripcion;
    private String docente;
    private boolean activo;
    private int duracionHoras;

    public Curso() {}

    public Curso(Long id, String nombre, String descripcion, String docente, boolean activo, int duracionHoras) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.docente = docente;
        this.activo = activo;
        this.duracionHoras = duracionHoras;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getDocente() { return docente; }
    public void setDocente(String docente) { this.docente = docente; }

    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }

    public int getDuracionHoras() { return duracionHoras; }
    public void setDuracionHoras(int duracionHoras) { this.duracionHoras = duracionHoras; }

    @Override
    public String toString() {
        return "Curso{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", docente='" + docente + '\'' +
                ", activo=" + activo +
                ", duracionHoras=" + duracionHoras +
                '}';
    }
}
