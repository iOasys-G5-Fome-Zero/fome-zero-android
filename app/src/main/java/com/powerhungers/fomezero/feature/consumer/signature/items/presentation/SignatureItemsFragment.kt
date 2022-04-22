package com.powerhungers.fomezero.feature.consumer.signature.items.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.powerhungers.fomezero.databinding.FragmentSignatureItemsBinding
import com.powerhungers.fomezero.databinding.FragmentSignatureOrderBinding

class SignatureItemsFragment : Fragment() {
    private val binding by lazy { FragmentSignatureItemsBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }
}