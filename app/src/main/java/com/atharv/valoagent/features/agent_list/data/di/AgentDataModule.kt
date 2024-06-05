package com.atharv.valoagent.features.agent_list.data.di


import AgentRemoteRepositoryImpl
import com.atharv.valoagent.features.agent_list.remote.api.ApiService
import com.atharv.valoagent.features.agent_list.domain.repository.AgentRemoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AgentDataModule {
//    @Provides
//    @Singleton
//    fun provideApiService(): ApiService {
//        return Retrofit.Builder()
//            .baseUrl("https://valorant-api.com/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(ApiService::class.java)
//    }

    @Provides
    @Singleton
    fun provideAgentRemoteRepository(apiService: ApiService): AgentRemoteRepository {
        return AgentRemoteRepositoryImpl(apiService)
    }
}