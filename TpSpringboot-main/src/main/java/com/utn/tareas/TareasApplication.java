package com.utn.tareas;

import com.utn.tareas.model.Prioridad;
import com.utn.tareas.service.MensajeService;
import com.utn.tareas.service.TareaService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TareasApplication implements CommandLineRunner {

    private final TareaService tareaService;
    private final MensajeService mensajeService;

    public TareasApplication(TareaService tareaService, MensajeService mensajeService) {
        this.tareaService = tareaService;
        this.mensajeService = mensajeService;
    }

    public static void main(String[] args) {
        SpringApplication.run(TareasApplication.class, args);
    }

    @Override
    public void run(String... args) {
        mensajeService.mostrarBienvenida();

        tareaService.mostrarConfiguracion();

        System.out.println("\nTareas iniciales:");
        tareaService.listarTodas().forEach(System.out::println);

        tareaService.agregarTarea("Preparar el parcial de Sistemas", Prioridad.ALTA);

        System.out.println("\nTareas pendientes:");
        tareaService.listarPendientes().forEach(System.out::println);

        tareaService.marcarCompletada(1L);

        System.out.println("\n" + tareaService.obtenerEstadisticas());

        System.out.println("\nTareas completadas:");
        tareaService.listarCompletadas().forEach(System.out::println);

        mensajeService.mostrarDespedida();
    }
}
