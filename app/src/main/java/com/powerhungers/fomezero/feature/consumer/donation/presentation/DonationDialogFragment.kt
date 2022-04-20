package com.powerhungers.fomezero.feature.consumer.donation.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.powerhungers.fomezero.databinding.FragmentDonationDialogBinding

class DonationDialogFragment : DialogFragment() {

    private lateinit var binding: FragmentDonationDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDonationDialogBinding.inflate(inflater,container,false)
        return binding.root
    }
}