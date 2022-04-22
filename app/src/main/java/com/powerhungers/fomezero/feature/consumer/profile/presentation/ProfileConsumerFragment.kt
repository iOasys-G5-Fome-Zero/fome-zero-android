package com.powerhungers.fomezero.feature.consumer.profile.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.powerhungers.fomezero.R
import com.powerhungers.fomezero.databinding.FragmentProfileBinding
import com.powerhungers.fomezero.databinding.FragmentProfileConsumerBinding

class ProfileConsumerFragment : Fragment() {
    private val binding by lazy { FragmentProfileConsumerBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }
}