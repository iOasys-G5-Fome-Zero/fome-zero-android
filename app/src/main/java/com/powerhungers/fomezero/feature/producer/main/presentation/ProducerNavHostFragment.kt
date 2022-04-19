package com.powerhungers.fomezero.feature.producer.main.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.powerhungers.fomezero.R
import com.powerhungers.fomezero.databinding.FragmentFinancesBinding
import com.powerhungers.fomezero.databinding.FragmentProducerNavHostBinding

class ProducerNavHostFragment : Fragment() {

    private val binding by lazy { FragmentProducerNavHostBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }
}