package com.yooshyasha.jokeraiagentpet.agent.common

import ai.koog.agents.core.agent.AIAgent

interface IAgentProvider<Output> {
    fun provideAgent(
        handleException: suspend (String) -> Unit,
    ): AIAgent<String, Output>
}