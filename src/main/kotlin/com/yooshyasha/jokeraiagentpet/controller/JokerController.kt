package com.yooshyasha.jokeraiagentpet.controller

import com.yooshyasha.jokeraiagentpet.dto.RequestGenerateJoke
import com.yooshyasha.jokeraiagentpet.dto.ResponseGenerateJoke
import com.yooshyasha.jokeraiagentpet.service.JokerService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/joke")
class JokerController(
    private val jokerService: JokerService,
) {
    @GetMapping("/generate")
    suspend fun generateJoke(@RequestBody generateData: RequestGenerateJoke): ResponseEntity<ResponseGenerateJoke> {
        return ResponseEntity.ok(jokerService.generateJoke(generateData.theme, generateData.audience))
    }
}