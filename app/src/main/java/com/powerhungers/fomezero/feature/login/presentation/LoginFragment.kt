package com.powerhungers.fomezero.feature.login.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.powerhungers.fomezero.common.utils.ViewState
import com.powerhungers.fomezero.databinding.FragmentLoginBinding
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
    }

    private fun handleClickListener() {
        with(binding) {
            btnEnter.setOnClickListener {
                viewModel.login(
                    "teste@api.com", "Ab1234567!"
                )
            }
            txtCadastre.setOnClickListener {
                findNavController().navigate(
                    LoginFragmentDirections.actionLoginFragmentToRegistrationFragment())
            }
        }
    }

    private fun addObserver() {
        viewModel.loginLiveData.observe(viewLifecycleOwner) { state ->
            with(binding) {
                when (state) {
                    is ViewState.Loading ->
                        progressDialog.visibility = View.VISIBLE
                    is ViewState.Success -> {
                        findNavController().navigate(
                            LoginFragmentDirections.actionLoginFragmentToOnboardFragment())
                    }
                    is ViewState.Error ->
                        progressDialog.visibility = View.GONE
                    else -> {
                        Unit
                    }
                }
            }
        }
    }
}

