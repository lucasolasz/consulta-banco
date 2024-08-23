package com.consulta.multibanco.repository.read;

import com.consulta.multibanco.model.DataSjrj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SjrjDataReadRepository extends JpaRepository<DataSjrj, Long> {
}
