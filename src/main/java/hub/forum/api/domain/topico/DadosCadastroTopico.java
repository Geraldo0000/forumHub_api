package hub.forum.api.domain.topico;

import org.hibernate.validator.constraints.NotBlank;

import java.time.LocalDateTime;

public record DadosCadastroTopico(

        @NotBlank
        String titulo,
        @NotBlank
        String mensagem,
        @NotBlank
        String autor,
        @NotBlank
        String curso,

        LocalDateTime dataCriacao,

        EstadoTopico estadoTopico) {

        public DadosCadastroTopico{
            if (dataCriacao == null) {
                dataCriacao = LocalDateTime.now();
            }

            if (estadoTopico == null) {
                estadoTopico = estadoTopico.ABERTO;
            }
        }
}
