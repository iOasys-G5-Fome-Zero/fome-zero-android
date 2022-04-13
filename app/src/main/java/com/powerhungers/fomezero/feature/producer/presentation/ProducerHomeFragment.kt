package com.powerhungers.fomezero.feature.producer.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.powerhungers.fomezero.databinding.FragmentProducerHomeBinding
import com.powerhungers.fomezero.feature.standbyClass.ProducerHomeFragmentDirections

class ProducerHomeFragment : Fragment() {

    private val binding by lazy { FragmentProducerHomeBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleClickListener()
    }

    private fun handleClickListener() {
        with(binding) {
            btnMyBasketsProducer.setOnClickListener {
                findNavController().navigate(
                    ProducerHomeFragmentDirections.navigateToBasketFragment()
                )
            }
            btnIncome.setOnClickListener {
                findNavController().navigate(
                    ProducerHomeFragmentDirections.navigateToFinancesFragment()
                )
            }
            btnPixCadastre.setOnClickListener {
                findNavController().navigate(
                    ProducerHomeFragmentDirections.navigateToPaymentFragment()
                )
            }
        }
    }

}