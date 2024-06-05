package com.atharv.valoagent.features.agent_list.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atharv.valoagent.common.helper.NetworkResult
import com.atharv.valoagent.features.agent_list.domain.model.AgentData
import com.atharv.valoagent.features.agent_list.domain.usecase.GetAgentListRemotelyUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class AgentListViewModel @Inject constructor(
    private val getAgentListRemotelyUseCase: GetAgentListRemotelyUseCase
) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState

    init {
        getAllNotesFromRemote()
    }
    fun getAllNotesFromRemote() {
        getAgentListRemotelyUseCase().onEach {
            when (it) {
                is NetworkResult.Loading -> {
                    _uiState.value = _uiState.value?.copy(isLoading = true) ?: UiState(true, "", emptyList())
                }
                is NetworkResult.Success -> {
                    it.data?.agentData.let { list ->
                        _uiState.value = _uiState.value?.copy(isLoading = false, data = list as List<AgentData>) ?: UiState(false, "", list as List<AgentData>)
                    }
                }
                is NetworkResult.Error -> {
                    _uiState.value = _uiState.value?.copy(isLoading = false, errorMsg = it.message.toString()) ?: UiState(false, it.message.toString(), emptyList())
                }
            }
        }.launchIn(viewModelScope)
    }
}
data class UiState (var isLoading : Boolean, var errorMsg : String, var data : List<AgentData> )