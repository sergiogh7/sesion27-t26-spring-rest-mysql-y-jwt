package app.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

import static java.util.Collections.emptyList;

public class JwtUtil {
//  Metodo que crea el JWT y lo envia al header de la respuesta al cliente
    static void addAuthentication(HttpServletResponse res, String username) {
        String token = Jwts.builder()
            .setSubject(username)

//          Asigna un tiempo de 1 minuto
            .setExpiration(new Date(System.currentTimeMillis() + 60000))

//          Hash que firma la clave
            .signWith(SignatureAlgorithm.HS512, "H4rdc0r3!")
            .compact();

//      Encabezado del token
        res.addHeader("Authorization", "Bearer " + token);
        
    }

    
//  Metodo que valida el token llegado del cliente
    static Authentication getAuthentication(HttpServletRequest request) {
//      Obtiene el token del encabezado de la peticion
        String token = request.getHeader("Authorization");

//      Si hay token lo valida
        if (token != null) {
            String user = Jwts.parser()
                    .setSigningKey("H4rdc0r3!")
                    .parseClaimsJws(token.replace("Bearer", ""))
                    .getBody()
                    .getSubject();

//          Para todas las peticiones que no sean login no requiere autentificacion
//          asi que se devuelve una autentificacion sin un password
            return user != null ?
                    new UsernamePasswordAuthenticationToken(user, null, emptyList()) :
                    null;
            
        }
        return null;
        
    }
    
}