package com.trindade.microservices.repository.db.postgres;

import com.trindade.microservices.repository.db.postgres.orm.PessoaOrm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaOrmRepository extends JpaRepository<PessoaOrm, String> {

    PessoaOrm findByCpf(String cpf);
}
