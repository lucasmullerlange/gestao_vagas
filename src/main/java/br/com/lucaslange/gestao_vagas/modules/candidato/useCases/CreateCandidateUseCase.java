package br.com.lucaslange.gestao_vagas.modules.candidato.useCases;

import org.postgresql.translation.messages_pt_BR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lucaslange.gestao_vagas.exceptions.UserFoundException;
import br.com.lucaslange.gestao_vagas.modules.candidato.CandidateEntity;
import br.com.lucaslange.gestao_vagas.modules.candidato.CandidateRepository;


@Service
public class CreateCandidateUseCase {
  @Autowired
  private CandidateRepository candidateRepository;

  public CandidateEntity execute(CandidateEntity candidateEntity) {
    this.candidateRepository.findByUsernameOrEmail(candidateEntity.getUsername(),
        candidateEntity.getEmail()).ifPresent(user -> {
          throw new UserFoundException("já registrado");
        });

    return this.candidateRepository.save(candidateEntity);
  }
}
