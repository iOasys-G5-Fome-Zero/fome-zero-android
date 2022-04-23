package com.powerhungers.fomezero.feature.consumer.signature.items.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.powerhungers.fomezero.R
import com.powerhungers.fomezero.databinding.FragmentSignatureItemsBinding
import com.powerhungers.fomezero.feature.consumer.main.presentation.ConsumerSharedViewModel
import com.powerhungers.fomezero.feature.consumer.signature.domain.model.BasketOptions
import com.powerhungers.fomezero.feature.consumer.signature.items.presentation.adapter.FoodItemsAdapter
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class SignatureItemsFragment : Fragment() {

    private val binding by lazy { FragmentSignatureItemsBinding.inflate(layoutInflater) }
    private val sharedViewModel: ConsumerSharedViewModel by sharedViewModel()
    private val foodItemAdapter = FoodItemsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureToolbar()
        setupAdapter()
    }


    private fun configureToolbar() {
        with(binding.signatureItemToolbar) {
            title.text = getString(R.string.signature)
            backButton.setOnClickListener {
                sharedViewModel.navigateToSignaturePlan()
            }
        }
    }

    private fun setupAdapter() {
        binding.foodItemRecyclerView.adapter = foodItemAdapter
        foodItemAdapter.submitList(BasketOptions.small())
    }

}