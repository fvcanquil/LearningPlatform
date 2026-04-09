package com.duoc.LearningPlatform.repository;

import com.duoc.LearningPlatform.model.Curso;
import java.util.List;
import java.util.Optional;

/**
 * Interfaz de repositorio para la interaccion con el almacenamiento de cursos.
 * Define las operaciones de acceso a datos para la entidad Curso.
 */
public interface CursoRepository {
    List<Curso> findAll();
    List<Curso> findByActivo(boolean activo);
    Optional<Curso> findById(Long id);
    Curso save(Curso curso);
    void deleteById(Long id);
}