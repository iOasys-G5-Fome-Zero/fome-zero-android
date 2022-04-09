package com.powerhungers.fomezero.feature.registration.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import org.koin.androidx.viewmodel.ext.android.viewModel
import android.view.ViewGroup
import android.widget.RadioGroup
import com.powerhungers.fomezero.common.exception.EmptyUserTypeException
import com.powerhungers.fomezero.databinding.FragmentRegistrationBinding

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
                    nameEditText.text.toString(),
                    "radioSelected",
                    emailEditText.text.toString(),
                    passwordEditText.text.toString()
                )
            }
        }
    }

    private fun addObserver() {
    }
}