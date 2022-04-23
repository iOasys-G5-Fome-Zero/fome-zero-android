package com.powerhungers.fomezero.feature.consumer.signature.plan.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.powerhungers.fomezero.R
import com.powerhungers.fomezero.databinding.FragmentSignaturePlanBinding
import com.powerhungers.fomezero.feature.consumer.main.presentation.ConsumerSharedViewModel
import com.powerhungers.fomezero.feature.consumer.signature.domain.model.BasketType
import com.powerhungers.fomezero.feature.consumer.signature.plan.presentation.adapter.SignatureBasketDateAdapter
import com.powerhungers.fomezero.feature.consumer.signature.plan.presentation.adapter.SignatureBasketSizeAdapter
import com.powerhungers.fomezero.feature.consumer.signature.plan.presentation.model.BasketDate
import com.powerhungers.fomezero.feature.consumer.signature.plan.presentation.model.BasketSize
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class SignaturePlanFragment : Fragment() {

    private val binding by lazy { FragmentSignaturePlanBinding.inflate(layoutInflater) }
    private val sharedViewModel: ConsumerSharedViewModel by sharedViewModel()
    private val basketSizeAdapter = SignatureBasketSizeAdapter()
    private val basketDateAdapter = SignatureBasketDateAdapter()
    private lateinit var basketType: BasketType

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configureToolbar()
        setupSizeAdapter()
        setupDateAdapter()
        handleButtonClickListener()
    }

    private fun configureToolbar() {
        with(binding.signatureToolbar) {
            title.text = getString(R.string.signature)
            backButton.setOnClickListener {
                sharedViewModel.navigateToConsumerHome()
            }
        }
    }

    private fun setupSizeAdapter() {
        binding.basketSizeRecyclerView.adapter = basketSizeAdapter
        basketSizeAdapter.submitList(BasketSize().list)
        basketSizeAdapter.itemClickListener = {
            basketType = it
        }
    }

    private fun setupDateAdapter() {
        binding.basketDateRecyclerView.adapter = basketDateAdapter
        basketDateAdapter.submitList(BasketDate().list)
    }

    private fun handleButtonClickListener() {
        binding.nextButton.setOnClickListener {
            sharedViewModel.navigateToSignatureItem(basketType)
        }
    }
}