package com.powerhungers.fomezero.feature.manufacturer.home.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.powerhungers.fomezero.databinding.FragmentManufacturerHomeBinding

class ManufacturerHomeFragment : Fragment() {

    private val binding by lazy { FragmentManufacturerHomeBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }
}