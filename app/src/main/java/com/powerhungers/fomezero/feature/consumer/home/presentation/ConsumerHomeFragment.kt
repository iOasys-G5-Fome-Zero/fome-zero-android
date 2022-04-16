package com.powerhungers.fomezero.feature.consumer.home.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.powerhungers.fomezero.common.extension.openExternalUrl
import com.powerhungers.fomezero.databinding.FragmentConsumerBinding

const val FOME_ZERO_URL = "https://powerhungers.netlify.app/"

class ConsumerHomeFragment : Fragment() {

    private val binding by lazy { FragmentConsumerBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
                findNavController().navigate(
                    ConsumerHomeFragmentDirections.navigateToSignatureFragment()
                )
            }
        }
    }
}
