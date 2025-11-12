package com.utn.tareas.repository;

import com.utn.tareas.model.Tarea;
import com.utn.tareas.model.Prioridad;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class TareaRepository {

    private List<Tarea> tareas = new ArrayList<>();
    private AtomicLong contador = new AtomicLong(1);

    public TareaRepository() {
        tareas.add(new Tarea(contador.getAndIncrement(), "Estudiar Spring Boot", false, Prioridad.ALTA));
        tareas.add(new Tarea(contador.getAndIncrement(), "Ir al gimnasio", true, Prioridad.MEDIA));
        tareas.add(new Tarea(contador.getAndIncrement(), "Lavar la ropa", false, Prioridad.BAJA));
    }

    public void guardar(Tarea tarea) {
        tarea.setId(contador.getAndIncrement());
        tareas.add(tarea);
    }

    public List<Tarea> obtenerTodas() {
        return tareas;
    }

    public Optional<Tarea> buscarPorId(Long id) {
        return tareas.stream().filter(t -> t.getId() == id).findFirst();
    }

    public void eliminarPorId(Long id) {
        tareas.removeIf(t -> t.getId() == id);
    }
}
