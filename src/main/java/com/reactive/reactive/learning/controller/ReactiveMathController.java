package com.reactive.reactive.learning.controller;

import com.reactive.reactive.learning.dto.MultiplyRequestDTO;
import com.reactive.reactive.learning.dto.ResponseDTO;
import com.reactive.reactive.learning.service.ReactiveMathService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@RestController
@RequestMapping("reactive/math")
public class ReactiveMathController {
    private ReactiveMathService reactiveMathService;

    @GetMapping("square/{input}")
    public Mono<ResponseDTO> findSquare(@PathVariable int input) {
        return reactiveMathService.findSquare(input);
    }

    @GetMapping("table/{input}")
    public Flux<ResponseDTO> multiplicationTable(@PathVariable int input) {
        return reactiveMathService.multiplicationTable(input);
    }

    @GetMapping(value = "table/{input}/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ResponseDTO> multiplicationTableStream(@PathVariable int input) {
        return reactiveMathService.multiplicationTable(input);
    }

    @PostMapping
    public Mono<ResponseDTO> multiply(@RequestBody Mono<MultiplyRequestDTO> multiplyRequestDTOMono) {
        return reactiveMathService.multiply(multiplyRequestDTOMono);
    }
}
