package com.powerhungers.fomezero.base_app.feature.login.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.powerhungers.fomezero.databinding.FragmentLoginBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment() {

    private val binding by lazy { FragmentLoginBinding.inflate(layoutInflater) }
    private val loginViewModel: LoginViewModel by viewModel()

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
                loginViewModel.login(
                    editTxtEmail.text.toString(),
                    editTxtPasswd.text.toString()
                )
            }
        }
    }

    private fun addObserver() {
        loginViewModel.loginLiveData.observe(viewLifecycleOwner) { state ->
            with(binding) {
                when (state) {
                    is ViewState.Loading -> Unit
                    is ViewState.Success -> {
                        findNavController()
                    }
                    is ViewState.Error -> Unit
                    else -> {
                        Unit
                    }
                }
            }
        }
    }
}

