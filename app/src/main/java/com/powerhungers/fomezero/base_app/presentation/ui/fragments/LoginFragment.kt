package com.powerhungers.fomezero.base_app.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.powerhungers.fomezero.base_app.presentation.viewmodel.LoginViewModel
import com.powerhungers.fomezero.databinding.FragmentLoginBinding
import org.koin.androidx.viewmodel.ext.android.getViewModel
import com.powerhungers.fomezero.base_app.util.ViewState

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding: FragmentLoginBinding get() = _binding!!

    private val loginViewModel: LoginViewModel by lazy {
        getViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentLoginBinding.inflate(inflater, container, false).apply {
        _binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListener()
        //addObserver()     ERRO
    }

    private fun setListener() {
        binding.btnEnter.setOnClickListener {
            binding.run {
                loginViewModel.login(
                    editTxtEmail.text.toString(),
                    editTxtPasswd.text.toString()
                )
            }
        }
    }

//    private fun addObserver() {                                                               ERRO
//        loginViewModel.loggedUserViewState.observe(viewLifecycleOwner) { state ->
//            when (state) {
//                is ViewState.Success -> {
//                    findNavController().navigate(
//                        WelcomeFragmentDirections.actionWelcomeFragmentToLoginFragment()
//                    )
//                }
//                else -> Unit
//            }
//        }
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        loginViewModel.resetViewState()
        _binding = null
    }
}

