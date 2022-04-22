package com.powerhungers.fomezero.feature.consumer.home.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.fragment.app.Fragment
import com.powerhungers.fomezero.R
import com.powerhungers.fomezero.common.extension.openExternalUrl
import com.powerhungers.fomezero.common.utils.ViewState
import com.powerhungers.fomezero.databinding.FragmentConsumerBinding
import com.powerhungers.fomezero.feature.consumer.main.presentation.ConsumerSharedViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

const val FOME_ZERO_URL = "https://powerhungers.netlify.app/"

class ConsumerHomeFragment : Fragment() {

    private val binding by lazy { FragmentConsumerBinding.inflate(layoutInflater) }
    private val sharedViewModel: ConsumerSharedViewModel by sharedViewModel()
    private val viewModel: ConsumerHomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.homeToolbar.backButton.isGone = true
        addObserver()
        handleButtonClick()
    }

    private fun handleButtonClick() {
        with(binding) {
            leftOngImageView.setOnClickListener {
                openExternalUrl(FOME_ZERO_URL)
            }

            rightOngImageView.setOnClickListener {
                openExternalUrl(FOME_ZERO_URL)
            }

            makeYourSignature.setOnClickListener {
                sharedViewModel.navigateToSignaturePlan()
            }
        }
    }

    private fun addObserver() {
        observeUserNameLiveData()
    }

    private fun observeUserNameLiveData() {
        viewModel.userNameLiveData.observe(viewLifecycleOwner) { state ->
            if (state is ViewState.Success) {
                binding.homeToolbar.title.text = getString(R.string.hello_user, state.data)
            } else {
                binding.homeToolbar.title.text = getString(R.string.hello_user)
            }
        }
    }

}
