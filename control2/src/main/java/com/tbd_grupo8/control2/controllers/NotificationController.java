package com.tbd_grupo8.control2.controllers;

import com.tbd_grupo8.control2.config.JwtFilter;
import com.tbd_grupo8.control2.entities.Tarea;
import com.tbd_grupo8.control2.services.TareaService;
import com.tbd_grupo8.control2.config.SecurityConfig;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class NotificationController {

    private TareaService tareaService;
    private SimpMessagingTemplate messagingTemplate;

    private SecurityConfig securityConfig;

    @Scheduled(fixedRate = 60000) // Cada 60 segundos
    public void verificarTareasCaducadas() {
        String username = securityConfig.obtenerUsuarioAutenticado();
        List<Tarea> tareasCaducadas = tareaService.getTareasCaducadasByUsername(username);
        if (!tareasCaducadas.isEmpty()) {
            messagingTemplate.convertAndSend("/topic/tareas-caducadas", tareasCaducadas);
        }
    }
}
