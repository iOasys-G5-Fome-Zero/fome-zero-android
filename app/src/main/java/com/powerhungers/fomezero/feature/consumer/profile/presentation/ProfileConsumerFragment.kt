package com.powerhungers.fomezero.feature.consumer.profile.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.powerhungers.fomezero.R
import com.powerhungers.fomezero.common.utils.ViewState
import com.powerhungers.fomezero.databinding.FragmentProfileBinding
import com.powerhungers.fomezero.databinding.FragmentProfileConsumerBinding
import com.powerhungers.fomezero.feature.consumer.home.presentation.ConsumerHomeViewModel
import com.powerhungers.fomezero.feature.consumer.main.presentation.ConsumerSharedViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfileConsumerFragment : Fragment() {
    private val binding by lazy { FragmentProfileConsumerBinding.inflate(layoutInflater) }
    private val sharedViewModel: ConsumerSharedViewModel by sharedViewModel()
    private val viewModel: ProfileConsumerViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureToolbar()
        addObserver()
    }


    private fun configureToolbar() {
        with(binding) {
            profileTextView.text = getString(com.powerhungers.fomezero.R.string.profile)
            backButton.setOnClickListener {
                sharedViewModel.navigateToDonation()
            }
        }
    }

    private fun addObserver() {
        observeUserNameLiveData()
    }

    private fun observeUserNameLiveData() {
        viewModel.userNameLiveData.observe(viewLifecycleOwner) { state ->
            if (state is ViewState.Success) {
                binding.userNameTextView.text = state.data
            }
        }
    }
}
