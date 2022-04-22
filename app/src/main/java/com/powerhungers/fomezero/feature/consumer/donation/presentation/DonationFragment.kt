package com.powerhungers.fomezero.feature.consumer.donation.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.powerhungers.fomezero.R
import com.powerhungers.fomezero.common.extension.openExternalUrl
import com.powerhungers.fomezero.common.extension.setAnimationDuration
import com.powerhungers.fomezero.databinding.FragmentDonationBinding
import com.powerhungers.fomezero.feature.consumer.main.presentation.ConsumerSharedViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

private const val FOME_ZERO_URL = "https://cestou.netlify.app"
private const val LEFT_PROGRESS = 400
private const val RIGHT_PROGRESS = 600

class DonationFragment : Fragment() {

    private val binding by lazy { FragmentDonationBinding.inflate(layoutInflater) }
    private val sharedViewModel: ConsumerSharedViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.donationToolbar.title.text = getString(R.string.donation)

        setupProgressBar()
        handleImageClick()

        binding.websiteButton.setOnClickListener {
            openExternalUrl(FOME_ZERO_URL)
        }
    }

    private fun handleImageClick() {
        binding.leftOngImageView.setOnClickListener {
            DonationDialogFragment().show(childFragmentManager, javaClass.name)
        }
    }

    private fun setupProgressBar() {
        with(binding) {
            progressBarLeft.setAnimationDuration(LEFT_PROGRESS)
            progressBarRight.setAnimationDuration(RIGHT_PROGRESS)
        }
    }
}