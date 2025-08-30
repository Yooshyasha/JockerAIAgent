package com.yooshyasha.jokeraiagentpet.service

import com.yooshyasha.jokeraiagentpet.agent.joker.JokerProvider
import com.yooshyasha.jokeraiagentpet.dto.ResponseGenerateJoke
import org.springframework.stereotype.Service

@Service
class JokerService(
    private val jokerAIAgentProvider: JokerProvider,
) {
    suspend fun generateJoke(theme: String, audience: String): ResponseGenerateJoke {
        val agent = jokerAIAgentProvider.provideAgent { }

        return ResponseGenerateJoke(agent.run("Тема: $theme\nАудитория: $audience"))
    }
}