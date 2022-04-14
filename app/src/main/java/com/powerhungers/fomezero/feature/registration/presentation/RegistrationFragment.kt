package com.powerhungers.fomezero.feature.registration.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.powerhungers.fomezero.R
import com.powerhungers.fomezero.common.utils.ViewState
import com.powerhungers.fomezero.databinding.FragmentRegistrationBinding
import com.powerhungers.fomezero.domain.model.UserType
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegistrationFragment : Fragment() {

    private val binding by lazy { FragmentRegistrationBinding.inflate(layoutInflater) }
    private val viewModel: RegistrationViewModel by viewModel()
    private var userType = ""


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        handleClickListener()
        userType = checkRadioButton()
        addRegistrationObserver()
        addObserver()
        clearError()
    }

    private fun handleClickListener() {
        with(binding) {
            finishRegisterButton.setOnClickListener {
                viewModel.registration(
                    name = nameEditText.text.toString(),
                    userType = userType,
                    email = emailEditText.text.toString(),
                    password = passwordEditText.text.toString()
                )
            }
        }
    }

    private fun checkRadioButton(): String {
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

    private fun addRegistrationObserver() {
        observeNameLiveData()
        observeUserTypeLiveData()
        observeEmailLiveData()
        observePasswordLiveData()
    }

    private fun observeNameLiveData() {
        viewModel.nameLiveData.observe(viewLifecycleOwner) { state ->
            with(binding) {
                if (state is ViewState.Error) {
                    progressDialog.isGone = true
                    nameInputLayout.error = state.throwable.message

                } else {
                    progressDialog.isGone = true
                    nameInputLayout.error = null
                }
            }
        }
    }

    private fun observeUserTypeLiveData() {
        viewModel.userTypeLiveData.observe(viewLifecycleOwner) { state ->
            with(binding) {
                if (state is ViewState.Error) {
                    progressDialog.isGone = true
                    Toast.makeText(context, R.string.usertype_not_selected, Toast.LENGTH_LONG).show()

                } else {
                    progressDialog.isGone = true
                }
            }
        }
    }

    private fun observeEmailLiveData() {
        viewModel.emailLiveData.observe(viewLifecycleOwner) { state ->
            with(binding) {
                if (state is ViewState.Error) {
                    progressDialog.isGone = true
                    emailInputLayout.error = state.throwable.message
                } else {
                    progressDialog.isGone = true
                    emailInputLayout.error = null
                }
            }
        }
    }

    private fun observePasswordLiveData() {
        viewModel.passwordLiveData.observe(viewLifecycleOwner) { state ->
            with(binding) {
                if (state is ViewState.Error) {
                    progressDialog.isGone = true
                    passwordInputLayout.error = state.throwable.message
                } else {
                    progressDialog.isGone = true
                    passwordInputLayout.error = null
                }
            }
        }
    }

    private fun addObserver() {
        viewModel.registrationLiveData.observe(viewLifecycleOwner) { state ->
            with(binding) {
                when (state) {
                    is ViewState.Loading ->
                        progressDialog.isVisible = true
                    is ViewState.Success -> {
                        progressDialog.isGone = true
                        Toast.makeText(context, R.string.account_created, Toast.LENGTH_LONG).show()
                    }
                    is ViewState.Error ->
                        progressDialog.isGone = true
                    else -> Unit
                }
            }
        }
    }

    private fun clearError() {
        with(binding) {
            nameEditText.setOnFocusChangeListener { _, hasFocus ->
                if (hasFocus) {
                    viewModel.clearViewState()
                }
            }
            emailEditText.setOnFocusChangeListener { _, hasFocus ->
                if (hasFocus) {
                    viewModel.clearViewState()
                }
            }
            passwordEditText.setOnFocusChangeListener { _, hasFocus ->
                if (hasFocus) {
                    viewModel.clearViewState()
                }
            }
        }
    }
}