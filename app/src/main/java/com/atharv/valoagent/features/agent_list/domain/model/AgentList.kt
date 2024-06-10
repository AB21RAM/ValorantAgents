package com.atharv.valoagent.features.agent_list.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AgentList(
    var agentData: List<AgentData?>?
) : Parcelable
@Parcelize

data class AgentData(
    val agentName : String? ,
    val agentImageStr : String? ,
    val description : String? ,
    val fullPortrait: String?,
    val fullPortraitV2 : String?,
//    val abilities : List<AgentListResponse.Data.Ability?>?
) :Parcelable
