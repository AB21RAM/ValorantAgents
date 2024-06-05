package com.atharv.valoagent.features.agent_list.presentation.screens.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.atharv.valoagent.databinding.FragmentAgentListBinding
import com.atharv.valoagent.features.agent_list.domain.model.AgentData
import com.atharv.valoagent.features.agent_list.presentation.adapter.AgentAdapter
import com.atharv.valoagent.features.agent_list.presentation.viewmodel.AgentListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AgentListFragment : Fragment() {
    private lateinit var binding: FragmentAgentListBinding
    private lateinit var agentAdapter: AgentAdapter
    private val agentListViewModel: AgentListViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  FragmentAgentListBinding.inflate(inflater, container, false)

        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
    }
    private fun setupObservers() {

//        noteListViewModel.notesList.observe(viewLifecycleOwner){
//            setupRecyclerView(it)
//        }
//
//        noteListViewModel.noteListFromResponse.observe(viewLifecycleOwner){
////            setupRecyclerView(it)
//        }

        agentListViewModel.uiState.observe(viewLifecycleOwner) { uiState ->
            when {
                uiState.isLoading -> {
                    // Show loading indicator
                    showLoading(true)
                }
                uiState.errorMsg.isNotEmpty() -> {
                    // Show error message
                    showError(uiState.errorMsg)
                }
                else -> {
                    // Show data
                    setupRecyclerView(uiState.data)
                }
            }
        }
    }
    private fun setupRecyclerView(notes: List<AgentData>) {
        binding.progressBar.visibility = View.GONE
        binding.errorTextView.visibility = View.GONE
        binding.agentRv.visibility = View.VISIBLE

        agentAdapter = AgentAdapter(requireContext())
        binding.agentRv.setHasFixedSize(true)
        binding.agentRv.adapter = agentAdapter
        agentAdapter.updateList(notes)
    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
        binding.errorTextView.visibility = View.GONE
        binding.agentRv.visibility = if (isLoading) View.GONE else View.VISIBLE
    }

    private fun showError(errorMsg: String) {
        binding.progressBar.visibility = View.GONE
        binding.errorTextView.visibility = View.VISIBLE
        binding.agentRv.visibility = View.GONE
        binding.errorTextView.text = errorMsg
    }
}