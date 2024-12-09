package com.cs407.connectech.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.cs407.connectech.databinding.FragmentCompanySelectedBinding

class CompanySelectedFragment : Fragment() {

    private var _binding: FragmentCompanySelectedBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentCompanySelectedBinding.inflate(inflater, container, false)

        // Set up the "Select Partner" button
        binding.selectPartnerButton.setOnClickListener {
            showAlertDialog()
        }

        return binding.root
    }

    private fun showAlertDialog() {
        AlertDialog.Builder(requireContext())
            .setTitle("Notification Sent")
            .setMessage("The company has been notified about your selection.")
            .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
            .create()
            .show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
