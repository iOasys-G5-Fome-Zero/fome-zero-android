package com.powerhungers.fomezero.feature.onboarding.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.powerhungers.fomezero.databinding.FragmentOnboardingBinding

class OnboardingFragment : Fragment() {

    private val binding by lazy { FragmentOnboardingBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnNext.setOnClickListener {
            findNavController().navigate(OnboardingFragmentDirections.navigateToHome())
        }
    }
}