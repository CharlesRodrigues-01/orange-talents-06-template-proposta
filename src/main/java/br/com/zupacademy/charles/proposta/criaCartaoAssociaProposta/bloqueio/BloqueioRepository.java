package br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.bloqueio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BloqueioRepository extends JpaRepository<Bloqueio, String> {

    @Query("SELECT f FROM Bloqueio f WHERE f.cartao.id = :id "
            + "AND f.ativo = :ativo")
    Optional<Bloqueio> findByCartaoAtivo(String id, boolean ativo);
}
