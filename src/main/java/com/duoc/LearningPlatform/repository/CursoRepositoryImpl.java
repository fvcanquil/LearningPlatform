package com.duoc.LearningPlatform.repository;

import com.duoc.LearningPlatform.model.Curso;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CursoRepositoryImpl implements CursoRepository {

    private final List<Curso> cursos = new ArrayList<>();

    public CursoRepositoryImpl() {
        // Datos de ejemplo precargados
        cursos.add(new Curso(1L, "Desarrollo Backend I", "Aprende a desarrollar APIs REST con Spring Boot", "Prof. José Riquelme", true, 72));
        cursos.add(new Curso(2L, "Base de Datos", "Fundamentos de SQL y modelado de datos", "Prof. María López", true, 54));
        cursos.add(new Curso(3L, "Programación Web Frontend", "HTML, CSS y JavaScript moderno", "Prof. Carlos Pérez", true, 60));
        cursos.add(new Curso(4L, "Arquitectura de Software", "Patrones de diseño y microservicios", "Prof. Ana Torres", true, 48));
        cursos.add(new Curso(5L, "Curso Antiguo de Cobol", "Programación en Cobol", "Prof. Juan Díaz", false, 36));
        cursos.add(new Curso(6L, "Inteligencia Artificial", "Machine Learning y Deep Learning", "Prof. Laura Soto", true, 80));
    }

    @Override
    public List<Curso> findAll() {
        return new ArrayList<>(cursos);
    }

    @Override
    public List<Curso> findByActivo(boolean activo) {
        return cursos.stream()
                .filter(curso -> curso.isActivo() == activo)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Curso> findById(Long id) {
        return cursos.stream()
                .filter(curso -> curso.getId().equals(id))
                .findFirst();
    }

    @Override
    public Curso save(Curso curso) {
        cursos.removeIf(c -> c.getId().equals(curso.getId()));
        cursos.add(curso);
        return curso;
    }

    @Override
    public void deleteById(Long id) {
        cursos.removeIf(curso -> curso.getId().equals(id));
    }
}

