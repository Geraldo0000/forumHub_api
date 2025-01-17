package hub.forum.api.topico;

import io.micrometer.observation.ObservationFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    boolean existsByTituloAndMensagem(String titulo, String mensagem);
    @Query("SELECT t FROM Topico t WHERE t.curso = :curso AND YEAR(t.dataCriacao) = :ano")
    Page<Topico> findByCursoAndAno(String curso, int ano, Pageable paginacao);

    Page<Topico> findAllByAtivoTrue(Pageable paginacao);
}
