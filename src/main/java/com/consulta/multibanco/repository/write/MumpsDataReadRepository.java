package com.consulta.multibanco.repository.write;

import com.consulta.multibanco.model.DataMumps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MumpsDataReadRepository extends JpaRepository<DataMumps, Long> {
}
