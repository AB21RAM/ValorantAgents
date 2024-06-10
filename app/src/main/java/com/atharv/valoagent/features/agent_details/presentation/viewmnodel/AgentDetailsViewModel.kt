package com.atharv.valoagent.features.agent_details.presentation.viewmnodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.atharv.valoagent.features.agent_list.domain.model.AgentData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AgentDetailsViewModel @Inject constructor() : ViewModel(){
    private val _agentDetails = MutableLiveData<AgentData>()
    val agentDetails : LiveData<AgentData> get() = _agentDetails

    fun getAgentsDetails(agentDetails :AgentData){
        agentDetails.let {data ->
            _agentDetails.postValue(data)
        }
    }
}