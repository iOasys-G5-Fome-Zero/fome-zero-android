package com.powerhungers.fomezero.feature.login.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.core.view.isVisible
import com.powerhungers.fomezero.common.extension.openExternalUrl
import androidx.navigation.fragment.findNavController
import com.powerhungers.fomezero.common.extension.hasEditTextFocusChanged
import com.powerhungers.fomezero.common.utils.ViewState
import com.powerhungers.fomezero.databinding.FragmentLoginBinding
import com.powerhungers.fomezero.domain.model.UserType
import com.powerhungers.fomezero.feature.consumer.home.presentation.FOME_ZERO_URL
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment() {

    private val binding by lazy { FragmentLoginBinding.inflate(layoutInflater) }
    private val viewModel: LoginViewModel by viewModel()

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
        clearError()
    }

    private fun handleClickListener() {
        with(binding) {
            btnEnter.setOnClickListener {
                viewModel.login(
                    phoneEditText.text.toString(), passwordEditText.text.toString()
                )
            }
            txtCadastre.setOnClickListener {
                findNavController().navigate(
                    LoginFragmentDirections.navigateToRegistrationFragment()
                )
            }
            websiteButton.setOnClickListener{
                openExternalUrl(FOME_ZERO_URL)
            }
        }
    }

    private fun addObserver() {
        observeLoginLiveData()
        observeEmailLiveData()
        observePasswordLiveData()
    }

    private fun observeLoginLiveData() {
        viewModel.loginLiveData.observe(viewLifecycleOwner) { state ->
            with(binding) {
                when (state) {
                    is ViewState.Loading ->
                        progressDialog.isVisible = true
                    is ViewState.Success -> {
                        progressDialog.isGone = true
                        navigateToOnboarding(state.data)
                    }
                    is ViewState.Error -> {
                        progressDialog.isGone = true
                    }
                    else -> Unit
                }
            }
        }
    }

    private fun observeEmailLiveData() {
        viewModel.phoneLiveData.observe(viewLifecycleOwner) { state ->
            with(binding) {
                if (state is ViewState.Error) {
                    progressDialog.isGone = true
                    phoneInputLayout.error = state.throwable.message
                } else {
                    progressDialog.isGone = true
                    phoneInputLayout.error = null
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

    private fun clearError() {
        with(binding) {
            phoneEditText.hasEditTextFocusChanged { viewModel.clearViewState() }
            passwordEditText.hasEditTextFocusChanged { viewModel.clearViewState() }
        }
    }

    private fun navigateToOnboarding(userType: UserType) {
        val destination = when (userType) {
            UserType.CONSUMER -> LoginFragmentDirections.navigateToConsumerNavGraph()
            UserType.PRODUCER -> LoginFragmentDirections.navigateToProducerNavGraph()
        }
        findNavController().navigate(destination)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.clearViewState()
    }
}
