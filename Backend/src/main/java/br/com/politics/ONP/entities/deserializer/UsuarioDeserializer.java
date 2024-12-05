package br.com.politics.ONP.entities.deserializer;

import br.com.politics.ONP.entities.Usuario;
import br.com.politics.ONP.repositories.UsuarioRepository;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.node.IntNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class UsuarioDeserializer extends JsonDeserializer<Usuario> {

    @Autowired
    private UsuarioRepository usuarioRepository;  // Certifique-se de que o repositório está sendo injetado corretamente

    @Override
    public Usuario deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        IntNode node = jp.getCodec().readTree(jp);
        Long usuarioId = node.asLong();  // ID do usuário vindo do JSON

        // Verifica se o Usuario existe
        return usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com ID: " + usuarioId));  // Caso não encontre o Usuario, lança uma exceção
    }
}
