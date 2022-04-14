package com.powerhungers.fomezero.feature.registration.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.powerhungers.fomezero.R
import com.powerhungers.fomezero.common.exception.EmptyUserTypeException
import com.powerhungers.fomezero.common.utils.ViewState
import com.powerhungers.fomezero.databinding.FragmentRegistrationBinding
import com.powerhungers.fomezero.domain.model.UserType
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

        handleClickListener()
        addObserver()
    }

    private fun handleClickListener() {
        with(binding) {
            finishRegisterButton.setOnClickListener {
                viewModel.registration(
                    name = nameEditText.text.toString(),
                    userType = checkRadioButton(),
                    email = emailEditText.text.toString(),
                    password = passwordEditText.text.toString()
                )
            }
        }
    }

    private fun checkRadioButton(): String {
        var userType = ""
        binding.radioGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.consumerRadioButton ->
                    userType = UserType.CONSUMER.value
                R.id.producerRadioButton ->
                    userType = UserType.PRODUCER.value
            }
        }
        return userType
    }

    private fun addObserver() {
        viewModel.registrationLiveData.observe(viewLifecycleOwner) { state ->
            with(binding) {
                when (state) {
                    is ViewState.Loading ->
                        progressDialog.isVisible = true
                    is ViewState.Success ->
                        progressDialog.isGone = true
                    is ViewState.Error ->
                        progressDialog.isGone = true
                    else -> Unit
                }
            }
        }
    }
}