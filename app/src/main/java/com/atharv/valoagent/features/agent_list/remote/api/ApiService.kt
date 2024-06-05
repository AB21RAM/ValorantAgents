package com.atharv.valoagent.features.agent_list.remote.api

import com.atharv.valoagent.features.agent_list.remote.model.AgentListResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("v1/agents")
    suspend fun getAgentList(): Response<AgentListResponse>
}