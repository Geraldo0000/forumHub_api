package hub.forum.api.topico;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
//import org.springframework.data.annotation.Id;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
@Table(name = "topicos")
@Entity(name="Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;
    private String autor;
    private String curso;
    private Boolean ativo;
    @Enumerated(EnumType.STRING)
    private EstadoTopico estadoTopico;

    public Topico() {

    }

    public Topico(DadosCadastroTopico dados) {
        this.ativo = true;
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.dataCriacao = dados.dataCriacao();
        this.autor = dados.autor();
        this.curso = dados.curso();
        this.estadoTopico = dados.estadoTopico();

    }
    public void atualizarInformacoes(@Valid DadosAtualizacaoTopico dados) {
        if (dados.titulo() != null && !dados.titulo().isBlank()) {
            this.titulo = dados.titulo();
        }
        if (dados.mensagem() != null && !dados.mensagem().isBlank()) {
            this.mensagem = dados.mensagem();
        }
        if (dados.curso() != null && !dados.curso().isBlank()) {
            this.curso = dados.curso();
        }
        if (dados.autor() != null && !dados.autor().isBlank()) {
            this.autor = dados.autor();
        }


    }


    public int getAno() {
        return this.dataCriacao.getYear();
    }


    public void excluir() {
        this.ativo = false;
    }


    public Long getId() {
        return this.id;
    }

    public boolean getAtivo() {
        return this.ativo;
    }

    public @NotBlank String getTitulo() {
        return this.titulo;
    }

    public @NotBlank String getMensagem() {
        return this.mensagem;
    }

    public @NotBlank String getCurso() {
        return this.curso;
    }

    public EstadoTopico getEstadoTopico() {
        return this.estadoTopico;
    }

    public @NotBlank String getAutor() {
        return this.autor;
    }

    public LocalDateTime getDataCriacao() {
        return this.dataCriacao;
    }

}
