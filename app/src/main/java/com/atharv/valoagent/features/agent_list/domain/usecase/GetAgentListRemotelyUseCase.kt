package com.atharv.valoagent.features.agent_list.domain.usecase

import com.atharv.valoagent.common.helper.NetworkResult
import com.atharv.valoagent.features.agent_list.domain.model.AgentData
import com.atharv.valoagent.features.agent_list.domain.model.AgentList
import com.atharv.valoagent.features.agent_list.domain.repository.AgentRemoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetAgentListRemotelyUseCase @Inject constructor(
    private val agentRemoteRepository: AgentRemoteRepository
) {
    operator fun invoke(): Flow<NetworkResult<AgentList>> =
        flow<NetworkResult<AgentList>> {
            emit(NetworkResult.Loading())
            if(agentRemoteRepository.getAgentList().isSuccessful){
                val data = agentRemoteRepository.getAgentList().body()?.data?.map { data->
                    AgentData(agentImageStr = data?.displayIcon, agentName = data?.displayName)
                }
                emit(NetworkResult.Success(data = AgentList(data)))
            }


        }.catch {
            emit(NetworkResult.Error(it.message.toString()))
        }.flowOn(Dispatchers.IO)
}