package com.powerhungers.fomezero.feature.consumer.signature.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.powerhungers.fomezero.databinding.FragmentOrderSignatureBinding

class OrderSignatureFragment : Fragment() {

    private val binding by lazy { FragmentOrderSignatureBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }
}