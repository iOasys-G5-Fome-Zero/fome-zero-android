package com.powerhungers.fomezero.feature.consumer.home.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.powerhungers.fomezero.common.extension.openExternalUrl
import com.powerhungers.fomezero.databinding.FragmentConsumerBinding
import com.powerhungers.fomezero.feature.consumer.main.presentation.ConsumerSharedViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

const val FOME_ZERO_URL = "https://powerhungers.netlify.app/"

class ConsumerHomeFragment : Fragment() {

    private val binding by lazy { FragmentConsumerBinding.inflate(layoutInflater) }
    private val sharedViewModel: ConsumerSharedViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.homeToolbar.title.text = "exibir nome"
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
                sharedViewModel.navigateToSignature()
            }
        }
    }
}
