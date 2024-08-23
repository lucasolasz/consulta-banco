package com.consulta.multibanco.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/games")
@AllArgsConstructor
public class GameController {

//    private final MumpsDataReadRepository mumpsDataReadRepository;
//    private final SjrjDataReadRepository sjrjDataReadRepository;
//
//    @PostMapping
//    @Transactional
//    public ResponseEntity<?> create(@RequestBody DataMumps dataMumps) {
//        mumpsDataReadRepository.save(dataMumps);
//        return ResponseEntity.status(HttpStatus.CREATED).body(dataMumps);
//    }
//
//    @GetMapping
//    public ResponseEntity<?> list() {
//        List<DataMumps> response = mumpsDataReadRepository.findAll();
//        return ResponseEntity.status(HttpStatus.OK).body(response);
//    }
}
