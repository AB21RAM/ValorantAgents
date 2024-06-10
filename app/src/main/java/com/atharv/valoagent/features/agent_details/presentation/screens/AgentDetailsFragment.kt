package com.atharv.valoagent.features.agent_details.presentation.screens

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.atharv.valoagent.R
import com.atharv.valoagent.databinding.FragmentAgentDetailsBinding
import com.atharv.valoagent.databinding.FragmentAgentListBinding
import com.atharv.valoagent.features.agent_details.presentation.viewmnodel.AgentDetailsViewModel
import com.atharv.valoagent.features.agent_list.domain.model.AgentData
import com.atharv.valoagent.features.agent_list.presentation.screens.fragments.AgentListFragment
import com.atharv.valoagent.features.agent_list.presentation.viewmodel.AgentListViewModel
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AgentDetailsFragment : Fragment() {
    private lateinit var binding: FragmentAgentDetailsBinding
    private val viewModel: AgentDetailsViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding =  FragmentAgentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val getAgentData =
            arguments?.getParcelable<AgentData>(AgentListFragment.AGENT_DATA)

        if (getAgentData != null) {
            viewModel.getAgentsDetails(getAgentData)
        }

        setupUI()

        setUpObservers()
    }
    private fun setUpObservers() {
        viewModel.agentDetails.observe(viewLifecycleOwner) {
            it?.let { agentData ->
                Log.e("Data", "setUpObservers: $agentData")
                binding.agentName.text = agentData.agentName
                binding.description.text = agentData.description

                Glide
                    .with(this)
                    .load(agentData.fullPortraitV2)
                    .into(binding.agentImage)
            }
        }
    }
    private fun setupUI() {

        requireActivity().window.statusBarColor = requireActivity().resources.getColor(com.google.android.material.R.color.m3_ref_palette_dynamic_neutral0)
        handleOnBackPress()
    }
    private fun handleOnBackPress() {
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    findNavController().popBackStack()
                }
            })
    }

//    private fun showLoading(isLoading: Boolean) {
//        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
//        binding.errorTextView.visibility = View.GONE
//        binding.agentRv.visibility = if (isLoading) View.GONE else View.VISIBLE
//    }
//
//    private fun showError(errorMsg: String) {
//        binding.progressBar.visibility = View.GONE
//        binding.errorTextView.visibility = View.VISIBLE
//        binding.agentRv.visibility = View.GONE
//        binding.errorTextView.text = errorMsg
//    }
//
}