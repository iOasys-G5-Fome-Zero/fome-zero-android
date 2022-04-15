package com.powerhungers.fomezero.feature.donation

import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.powerhungers.fomezero.databinding.FragmentDonationBinding

class DonationFragment : Fragment() {

    private val binding by lazy { FragmentDonationBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.progressBarLeft.max = 1000
        val currentProgress = 600

        ObjectAnimator.ofInt(binding.progressBarLeft,"progress",currentProgress)
            .setDuration(2000)
            .start()
    }
}