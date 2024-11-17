package com.tbd_grupo8.control2.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.tbd_grupo8.control2.entities.Usuario;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Configuration
public class JwtUtil {

    // Este es el código secreto que está en la fase de firma del JWT
    // En un ambiente de producción, este valor debe ser guardado en un lugar seguro
    private static String SECRET = "voidojos";
    private static Algorithm ALGORITHM = Algorithm.HMAC256(SECRET);

    // Este método crea un JWT con el nombre de usuario
    public String create(Usuario usuario) {
        return JWT.create()
                .withSubject(usuario.getUsername())
                .withClaim("id_usuario", usuario.getId_usuario())
                .withClaim("username", usuario.getUsername())
                .withClaim("direccion", usuario.getDireccion())
                .withClaim("email", usuario.getEmail())
                .withClaim("telefono", usuario.getTelefono())
                .withIssuer("tbdgrupo8")
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(5)))
                .sign(ALGORITHM);
    }

    // Este método verifica si un JWT es válido
    public boolean isValid(String jwt){
        try {
            JWT.require(ALGORITHM)
                    .build()
                    .verify(jwt);
            return true;
        } catch (JWTVerificationException e) {
            return false;
        }
    }

    // Este método extrae el nombre de usuario de un JWT
    public String getUsername(String jwt){
        return JWT.require(ALGORITHM)
                .build()
                .verify(jwt)
                .getSubject();
    }
}
