package works.jean.gemini.agent

import works.jean.tools.ToolItem

data class Agent(
    val systemPrompt: String,
    val welcomeMessage: String,
    val toolItems: List<ToolItem>,
)