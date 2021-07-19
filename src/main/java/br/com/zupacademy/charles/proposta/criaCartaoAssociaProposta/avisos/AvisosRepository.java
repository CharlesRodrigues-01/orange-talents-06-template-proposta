package br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.avisos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvisosRepository extends JpaRepository<Avisos, Long> {
}
