package br.com.zupacademy.charles.proposta.cadastroNovaProposta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NovaPropostaRepository extends JpaRepository<NovaProposta, Long> {
    boolean existsByDocumento(String documento);
    List<NovaProposta> findByStatusProposta(StatusProposta statusProposta);

}
