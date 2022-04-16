package com.powerhungers.fomezero.feature.consumer.signature.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.powerhungers.fomezero.databinding.FragmentSignatureBinding
import com.powerhungers.fomezero.feature.consumer.main.presentation.ConsumerSharedViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class SignatureFragment : Fragment() {

    private val binding by lazy { FragmentSignatureBinding.inflate(layoutInflater) }
    private val sharedViewModel: ConsumerSharedViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }
}