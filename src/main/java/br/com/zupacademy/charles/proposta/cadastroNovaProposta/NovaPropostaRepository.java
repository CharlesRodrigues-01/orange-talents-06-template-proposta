package br.com.zupacademy.charles.proposta.cadastroNovaProposta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NovaPropostaRepository extends JpaRepository<NovaProposta, Long> {
}
