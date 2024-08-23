package com.consulta.multibanco.start;

import com.consulta.multibanco.repository.read.SjrjDataReadRepository;
import com.consulta.multibanco.repository.write.MumpsDataReadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartApp implements CommandLineRunner {

    @Autowired
    private MumpsDataReadRepository mumpsDataReadRepository;

    @Autowired
    private SjrjDataReadRepository sjrjDataReadRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(mumpsDataReadRepository.findAll());
        System.out.println(sjrjDataReadRepository.findAll());
    }
}
