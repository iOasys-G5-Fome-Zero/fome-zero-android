package com.powerhungers.fomezero.feature.consumer.signature.order.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.powerhungers.fomezero.databinding.FragmentSignatureOrderBinding

class SignatureOrderFragment : Fragment() {

    private val binding by lazy { FragmentSignatureOrderBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }
}