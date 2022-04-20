package com.powerhungers.fomezero.feature.producer.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.powerhungers.fomezero.databinding.FragmentProducerHomeBinding
import com.powerhungers.fomezero.feature.producer.home.presentation.ProducerHomeFragmentDirections
import com.powerhungers.fomezero.feature.producer.main.presentation.ProducerSharedViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class ProducerHomeFragment : Fragment() {

    private val binding by lazy { FragmentProducerHomeBinding.inflate(layoutInflater) }
    private val sharedViewModel: ProducerSharedViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleButtonClick()
    }

    private fun handleButtonClick() {
        with(binding) {
            btnMyBasketsProducer.setOnClickListener {
                findNavController().navigate(
                    ProducerHomeFragmentDirections.navigateToBasket()
                )
            }
            btnIncome.setOnClickListener {
                sharedViewModel.navigateToFinances()
            }
            btnPixCadastre.setOnClickListener {
                findNavController().navigate(
                        ProducerHomeFragmentDirections.navigateToPayment()
                )
            }
        }
    }

}