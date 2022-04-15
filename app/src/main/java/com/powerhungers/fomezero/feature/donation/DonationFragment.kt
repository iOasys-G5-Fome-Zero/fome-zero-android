package com.powerhungers.fomezero.feature.donation

import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.powerhungers.fomezero.common.extension.openExternalUrl
import com.powerhungers.fomezero.databinding.FragmentDonationBinding

const val FOME_ZERO_URL = "https://powerhungers.netlify.app/"

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

        setupProgressBar()

        binding.websiteButtonTextView.setOnClickListener {
            openExternalUrl(FOME_ZERO_URL)
        }
    }

    private fun setupProgressBar() {
        with(binding) {
            progressBarLeft.max = 1000
            progressBarRight.max = 1000
            val currentLeftProgress = 600
            val currentRightProgress = 600

            ObjectAnimator.ofInt(progressBarLeft, "progress", currentLeftProgress)
                .setDuration(2000)
                .start()
            ObjectAnimator.ofInt(progressBarRight, "progress", currentRightProgress)
                .setDuration(2000)
                .start()
        }
    }
}