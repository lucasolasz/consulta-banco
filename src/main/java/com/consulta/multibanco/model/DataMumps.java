package com.consulta.multibanco.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(schema = "test", name = "tb_data_mumps")
public class DataMumps {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_DATA_MUMPS")
    private Long idDataMumps;

    @Column(name = "DESC_SITUACAO")
    private String situacao;
}
