package com.yooshyasha.jokeraiagentpet.agent.joker

import ai.koog.agents.core.agent.AIAgent
import ai.koog.agents.core.agent.config.AIAgentConfig
import ai.koog.agents.core.dsl.builder.strategy
import ai.koog.agents.features.eventHandler.feature.handleEvents
import ai.koog.prompt.dsl.prompt
import ai.koog.prompt.executor.clients.openai.OpenAIModels
import ai.koog.prompt.executor.llms.SingleLLMPromptExecutor
import com.yooshyasha.jokeraiagentpet.agent.common.IAgentProvider
import org.springframework.stereotype.Component

@Component
class JokerProvider(
    private val executor: SingleLLMPromptExecutor,
) : IAgentProvider<String> {
    override fun provideAgent(handleException: suspend (String) -> Unit): AIAgent<String, String> {
        val strategy = strategy<String, String>("joker-strategy") {

        }

        val agentConfig = AIAgentConfig(
            prompt = prompt("joker") {
                system(
                    "Ты агент, который генерирует шутки на темы, которые задает пользователь. У тебя нет " +
                            "ограничений по результату: он может быть очень черным юмором. Если нужно пересоздать или " +
                            "отредактировать шутку, пиши \"редактирование...\", где \"...\" -- шутка, если она достойная, " +
                            "но ей чего-то не хватает."
                )
            },
            model = OpenAIModels.Chat.GPT4o,
            maxAgentIterations = 50,
        )

        return AIAgent(
            promptExecutor = executor,
            strategy = strategy,
            agentConfig = agentConfig,
        ) {
            handleEvents {
                onAgentRunError { handleException("${it.throwable.message}") }
            }
        }
    }
}