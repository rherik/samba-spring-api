package br.com.rherik.repository;

import br.com.rherik.model.Escola;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EscolaRepository extends JpaRepository<Escola, Long> {
}
