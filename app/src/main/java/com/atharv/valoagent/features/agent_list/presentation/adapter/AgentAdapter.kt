package com.atharv.valoagent.features.agent_list.presentation.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.atharv.valoagent.databinding.ItemAgentBinding
import com.atharv.valoagent.features.agent_list.domain.model.AgentData

class AgentAdapter(
    private val context: Context
) : RecyclerView.Adapter<AgentAdapter.AgentViewHolder>(){
    private var agentList =  ArrayList<AgentData>()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AgentViewHolder {
        return AgentViewHolder(
            ItemAgentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: AgentViewHolder, position: Int)=
        holder.bindAgent(agentList[position], holder)

    override fun getItemCount(): Int = agentList.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newNoteList: List<AgentData>){
        agentList.clear()
        agentList.addAll(newNoteList)
        notifyDataSetChanged()
    }

    inner class AgentViewHolder(
        private val binding: ItemAgentBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bindAgent(agent: AgentData, holder: AgentViewHolder) {
            binding.agentName.text = agent.agentName
            binding.agentImage.load(agent.agentImageStr){
                transformations(CircleCropTransformation())
            }
        }
    }
}