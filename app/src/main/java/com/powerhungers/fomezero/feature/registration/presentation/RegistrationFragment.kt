package com.powerhungers.fomezero.feature.registration.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.powerhungers.fomezero.R
import com.powerhungers.fomezero.common.utils.ViewState
import com.powerhungers.fomezero.databinding.FragmentRegistrationBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class RegistrationFragment : Fragment() {

    private val binding by lazy { FragmentRegistrationBinding.inflate(layoutInflater) }
    private val viewModel: RegistrationViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        checkRadioButton(binding.radioGroup)
        addObserver()
    }

    private fun checkRadioButton(radio: RadioGroup) {

        radio.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.consumerRadioButton -> {
                    handleClickListener("consumer")
                }
                R.id.producerRadioButton -> {
                    handleClickListener("producer")
                }
            }
        }
    }

    private fun handleClickListener(usertype: String) {
        with(binding) {
            finishRegisterButton.setOnClickListener {
                viewModel.registration(
                    nameEditText.text.toString(),
                    usertype,
                    emailEditText.text.toString(),
                    passwordEditText.text.toString()
                )
            }
        }
    }

    private fun addObserver() {
        viewModel.registrationLiveData.observe(viewLifecycleOwner){state ->
            with(binding){
                when(state){
                    is ViewState.Loading ->
                        progressDialog.isVisible = true
                    is ViewState.Success ->{
                        progressDialog.isGone = true
                    }
                    is ViewState.Error ->
                        progressDialog.isGone = true
                    else -> {Unit}
                }
            }
        }
    }
}