package br.com.lucaslange.gestao_vagas.modules.candidato;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;


public interface CandidateRepository extends JpaRepository<CandidateEntity, UUID> {

    // busca no banco se já existe o usuario com username e email  //
    Optional <CandidateEntity> findByUsernameOrEmail(String username, String email);
}

