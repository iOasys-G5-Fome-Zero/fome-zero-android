package com.powerhungers.fomezero.feature.producer.basket.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.powerhungers.fomezero.R
import com.powerhungers.fomezero.common.extension.showToast
import com.powerhungers.fomezero.common.utils.ViewState
import com.powerhungers.fomezero.databinding.FragmentBasketBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class BasketFragment : Fragment() {

    private val binding by lazy { FragmentBasketBinding.inflate(layoutInflater) }
    private val viewModel: BasketViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.basketToolbar.title.text = getString(R.string.my_baskets)
        handleClickListener()
        addObserver()
    }

    private fun handleClickListener() {
        with(binding) {
            btnConfirmSelection.setOnClickListener {
                viewModel.basket(
                    checkboxSmallBasket.isChecked,
                    checkboxMediumBasket.isChecked,
                    checkboxBigBasket.isChecked
                )
            }
        }
    }

    private fun addObserver() {
        observeBasketLiveData()
    }

    private fun observeBasketLiveData() {
        viewModel.basketLiveData.observe(viewLifecycleOwner) { state ->
            when (state) {
                is ViewState.Success -> {
//                    findNavController().navigate(
//                        BasketFragmentDirections.navigateToProducerHome()
//                    )
                }
                is ViewState.Error -> {
                    showToast(R.string.something_is_wrong)
                }
                else -> Unit
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.clearViewState()
    }

}