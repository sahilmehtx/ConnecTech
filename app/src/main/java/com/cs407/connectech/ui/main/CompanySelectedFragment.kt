package com.cs407.connectech.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.cs407.connectech.databinding.FragmentCompanySelectedBinding
import com.cs407.connectech.model.Match
import com.cs407.connectech.repository.CompanyListRepository
import com.cs407.connectech.repository.FakeMatchRepository

class CompanySelectedFragment : Fragment() {

    private var _binding: FragmentCompanySelectedBinding? = null
    private val binding get() = _binding!!
    private val args: CompanySelectedFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCompanySelectedBinding.inflate(inflater, container, false)

        // Get companyId from Safe Args
        val companyId = args.companyId

        // Fetch company details from repository
        val match = fetchCompanyDetails(companyId)

        // Check if match is found
        if (match != null) {
            // Populate UI with company details
            binding.companyName.text = match.name
            binding.companyDetails.text = """
                Ranking: ${match.ranking}
                Name: ${match.name}
                Market Cap: ${match.marketCap}
                Stock Symbol: ${match.stockSymbol}
                Country: ${match.country}
                Sector: ${match.sector}
                Industry: ${match.industry}
            """.trimIndent()
        } else {
            // Handle case where company details are not found
            binding.companyName.text = "Company Not Found"
            binding.companyDetails.text = "Could not find details for this company."
        }

        // Set up the "Select Partner" button
        binding.selectPartnerButton.setOnClickListener {
            showAlertDialog()
        }

        return binding.root
    }

    private fun fetchCompanyDetails(companyId: Int): Match? {
        val repository = FakeMatchRepository(requireContext())
        return repository.getCompanyById(companyId)
    }

    private fun showAlertDialog() {
        AlertDialog.Builder(requireContext())
            .setTitle("Partner Selected!")
            .setMessage("This partner has been added to your list!")
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
                val match = fetchCompanyDetails(args.companyId)
                if (match != null) {
                    CompanyListRepository.addCompany(match)
                }

                // Navigate back
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