package hub.forum.api.topico;

import java.time.LocalDateTime;

public record DadosDetalhamentoTopico(
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,
        String autor,
        String curso,
        Boolean ativo,
        EstadoTopico estadoTopico
) {
    public DadosDetalhamentoTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataCriacao(),
                topico.getAutor(),
                topico.getCurso(),
                topico.getAtivo(),
                topico.getEstadoTopico()
        );
    }
}
