package br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.carteiraDigital;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarteiraDigitalRepository extends JpaRepository<CarteiraDigital, String> {

    @Query("SELECT f FROM CarteiraDigital f WHERE f.cartao.id = :idCartao "
            + "AND f.emissor = :carteira")
    Optional<CarteiraDigital> findByCarteiraAtiva(String idCartao, TipoCarteira carteira);
}
