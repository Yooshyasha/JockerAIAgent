package com.yooshyasha.jokeraiagentpet.agent.joker

import ai.koog.agents.core.agent.AIAgent
import com.yooshyasha.jokeraiagentpet.agent.common.IAgentProvider

class JokerProvider : IAgentProvider<String> {
    override fun provideAgent(handleException: suspend (String) -> Unit): AIAgent<String, String> {
        TODO("Not yet implemented")
    }
}