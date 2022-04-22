package com.powerhungers.fomezero.feature.producer.payment.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.powerhungers.fomezero.R
import com.powerhungers.fomezero.databinding.FragmentBasketBinding
import com.powerhungers.fomezero.databinding.FragmentPaymentBinding

class PaymentFragment : Fragment() {

    private val binding by lazy { FragmentPaymentBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

}