package com.atharv.valoagent.features.agent_list.domain.di

import com.atharv.valoagent.features.agent_list.domain.repository.AgentRemoteRepository
import com.atharv.valoagent.features.agent_list.domain.usecase.GetAgentListRemotelyUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AgentDomainModule {
    fun provideAgentRemoteUseCase(agentRemoteRepository: AgentRemoteRepository) : GetAgentListRemotelyUseCase{
        return GetAgentListRemotelyUseCase(agentRemoteRepository)
    }
}