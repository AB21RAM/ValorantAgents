package com.atharv.valoagent.features.agent_list.domain.repository

import com.atharv.valoagent.features.agent_list.remote.model.AgentListResponse
import retrofit2.Response

interface AgentRemoteRepository {
    suspend fun getAgentList(): Response<AgentListResponse>
}