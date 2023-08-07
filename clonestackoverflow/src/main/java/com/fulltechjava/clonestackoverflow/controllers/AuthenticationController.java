package com.fulltechjava.clonestackoverflow.controllers;


import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

@RestController
public class AuthenticationController {

    @PostMapping("/auth/google")
    public ResponseEntity<String> authenticateWithGoogle(@RequestParam String idToken) {
        try {
            // Verificar a autenticidade do token usando a biblioteca google-auth-library-java
            GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), null)
                    .setAudience(Collections.singletonList("100246644784-m2g46vmhi5nq0i8prpkrn8f5ataid5ae.apps.googleusercontent.com"))
                    .build();

            GoogleIdToken token = verifier.verify(idToken);
            if (token != null) {
                Payload payload = token.getPayload();
                String email = payload.getEmail();
                String name = (String) payload.get("name");
                // Outras informações do usuário podem ser obtidas da carga útil (Payload) do token

                // Aqui você pode implementar a lógica para autenticar o usuário e conceder acesso

                return ResponseEntity.ok("Usuário autenticado com sucesso!");
            } else {
                // Token inválido ou não verificado
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Falha na autenticação");
            }
        } catch (GeneralSecurityException | IOException e) {
            // Algum erro ocorreu durante a verificação do token
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro no servidor");
        }
    }
}
