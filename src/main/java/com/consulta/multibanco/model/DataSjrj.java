package com.consulta.multibanco.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(schema = "test2", name = "tb_data_sjrj")
public class DataSjrj {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_DATA_SJRJ")
    private Long idDataSjrj;

    @Column(name = "DS_SITUACAO")
    private String situacao;
}
