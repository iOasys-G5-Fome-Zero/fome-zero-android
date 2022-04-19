package com.powerhungers.fomezero.feature.consumer.donation.presentation

import android.app.Dialog
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.powerhungers.fomezero.databinding.FragmentDonationDialogBinding

class DonationDialogFragment : DialogFragment() {

    private var _binding: FragmentDonationDialogBinding? = null
    private val binding get() = _binding!!

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.run {
            _binding = FragmentDonationDialogBinding.inflate(layoutInflater).apply {
            }
            AlertDialog.Builder(this).apply {
                setView(binding.root)
            }.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setWindowFeatures()

    }

    private fun setWindowFeatures() {
        dialog?.apply {
            window?.decorView?.setBackgroundResource(android.R.color.transparent)
            val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
            val height = (resources.displayMetrics.heightPixels * 0.85).toInt()
            window?.setLayout(
                width,height
            )
        }
    }
}