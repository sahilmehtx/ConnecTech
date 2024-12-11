package com.cs407.connectech.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.cs407.connectech.databinding.FragmentCompanySelectedBinding
import com.cs407.connectech.model.Match
import com.cs407.connectech.repository.FakeMatchRepository

class CompanySelectedFragment : Fragment() {

    private var _binding: FragmentCompanySelectedBinding? = null
    private val binding get() = _binding!!
    private val args: CompanySelectedFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentCompanySelectedBinding.inflate(inflater, container, false)

        val companyId = args.companyId
        val match = fetchCompanyDetails(companyId)

        // Populate UI with company details
        binding.companyName.text = match.name
        binding.companyDetails.text = """
            Rating: ${match.rating}
            Location: ${match.location}
            Email: ${match.email}
            Phone: ${match.phone}
            
            ${match.description}
        """.trimIndent()

        // Set up the "Select Partner" button
        binding.selectPartnerButton.setOnClickListener {
            showAlertDialog()
        }

        return binding.root
    }

    private fun fetchCompanyDetails(companyId: Int): Match {
        // Retrieve the company details from the repository
        // Ensure you have a method in FakeMatchRepository to fetch by ID
        val repository = FakeMatchRepository()
        return repository.getCompanyById(companyId)
    }

    private fun showAlertDialog() {
        AlertDialog.Builder(requireContext())
            .setTitle("Notification Sent")
            .setMessage("The company has been notified about your selection.")
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
                // Optionally navigate somewhere else after notification
                // For example, navigate back to BestMatchesFragment:
                requireActivity().onBackPressedDispatcher.onBackPressed()
            }
            .create()
            .show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}