package com.atharv.valoagent.features.agent_list.domain.model

data class AgentList(
    var agentData: List<AgentData?>?
)
data class AgentData(val agentName : String? , val agentImageStr : String?)
