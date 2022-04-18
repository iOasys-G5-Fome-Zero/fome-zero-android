package com.powerhungers.fomezero.feature.producer.basket.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.checkbox.MaterialCheckBox
import com.powerhungers.fomezero.R
import com.powerhungers.fomezero.databinding.FragmentBasketBinding
import com.powerhungers.fomezero.domain.model.UserType
import com.powerhungers.fomezero.feature.registration.presentation.RegistrationViewModel
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
        onCheckboxClicked(view)
        addObserver()
        //handleClickListener()
    }

    private fun onCheckboxClicked(view: View) {
        if (view is MaterialCheckBox) {
            val checked: Boolean = view.isChecked
            when (view.id) {
                R.id.checkbox_small_basket -> {
                    if (checked) {
                        viewModel.basket(smallBasket = true,medianBasket = false,bigBasket = false)
                    } else {
                        // test
                    }
                }
                R.id.checkbox_median_basket -> {
                    if (checked) {
                        viewModel.basket(smallBasket = false, medianBasket = true, bigBasket = false)
                    } else {
                        // test
                    }
                }
                R.id.checkbox_big_basket -> {
                    if (checked) {
                        viewModel.basket(smallBasket = false, medianBasket = false,bigBasket = true)
                    } else {
                        // test
                    }
                }
            }
        }
    }

    private fun addObserver() {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.clearViewState()
    }

//    private fun handleClickListener() {
//        with(binding) {
//            btnConfirmSelection.setOnClickListener {
//                findNavController().navigate(
//                    ProducerHomeFragmentDirections.navigateToBasketFragment()
//                )
//            }
//        }
//    }

}