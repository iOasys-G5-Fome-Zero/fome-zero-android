package com.powerhungers.fomezero.feature.standbyClass

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.powerhungers.fomezero.databinding.FragmentConsumerBinding

class ConsumerFragment : Fragment() {

    private val binding by lazy { FragmentConsumerBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        handleButtonClick()
    }

    private fun handleButtonClick() {
        with(binding){
            leftOngImageView.setOnClickListener {
                val intent =
                    Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://powerhungers.netlify.app/"))
                startActivity(intent)
            }

            rightOngImageView.setOnClickListener {
                val intent =
                    Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://powerhungers.netlify.app/"))
                startActivity(intent)
            }

            makeYourSignature.setOnClickListener {
                findNavController().navigate(ConsumerFragmentDirections.navigateToSignatureFragment3())
            }
        }
    }
}
