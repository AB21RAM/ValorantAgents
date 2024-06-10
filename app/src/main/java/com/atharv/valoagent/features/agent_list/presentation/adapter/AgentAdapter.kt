package com.atharv.valoagent.features.agent_list.presentation.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.atharv.valoagent.R
import com.atharv.valoagent.databinding.ItemAgentBinding
import com.atharv.valoagent.features.agent_list.domain.model.AgentData
import com.atharv.valoagent.features.agent_list.domain.model.AgentList
import com.bumptech.glide.Glide

class AgentAdapter(
    private val context: Context,
    val onClick: (AgentData) -> Unit
//    private val data : List<AgentData>
) : RecyclerView.Adapter<AgentAdapter.AgentViewHolder>(){
    private var agentList  = mutableListOf<AgentData>()
//    private val diffCallback = object : DiffUtil.ItemCallback<AgentData>() {
//        override fun areItemsTheSame(
//            oldItem: AgentData,
//            newItem: AgentData
//        ): Boolean {
//            return oldItem.agentName == newItem.agentName
//        }
//
//        override fun areContentsTheSame(
//            oldItem: AgentData,
//            newItem: AgentData
//        ): Boolean {
//            return oldItem == newItem
//        }
//    }
//
//    val differ = AsyncListDiffer(this, diffCallback)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AgentViewHolder {


        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_agent, parent, false)
        return AgentViewHolder(view)
//        return AgentViewHolder(
//            ItemAgentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        )
    }

    override fun onBindViewHolder(holder: AgentViewHolder, position: Int)=
        holder.bindAgent(agentList[position])

    override fun getItemCount(): Int = agentList.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newAgents: List<AgentData>){
        agentList.clear()
        agentList.addAll(newAgents)
        notifyDataSetChanged()
    }

    inner class AgentViewHolder(
        private val binding: View
    ) : RecyclerView.ViewHolder(binding) {
        private val nameTextView: TextView = itemView.findViewById(R.id.agentName)
        private val agentImageView: ImageView = itemView.findViewById(R.id.agentImage)
        private val cardView : CardView = itemView.findViewById(R.id.agentCard)
        fun bindAgent(agent: AgentData) {
            nameTextView.text = agent.agentName
//            agentImageView.load(agent.agentImageStr){
//                transformations(CircleCropTransformation())
//            }
            Glide.with(itemView.context).load(agent.agentImageStr).into(agentImageView)
            cardView.apply {
                setOnClickListener { onClick(agent) }
            }
        }
    }
}