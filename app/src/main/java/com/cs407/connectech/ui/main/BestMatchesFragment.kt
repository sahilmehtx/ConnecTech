package com.cs407.connectech.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.navigation.fragment.navArgs
import com.cs407.connectech.databinding.FragmentBestMatchesBinding
import com.cs407.connectech.model.Match
import com.cs407.connectech.repository.FakeMatchRepository
import com.cs407.connectech.ui.main.adapter.MatchAdapter
import com.cs407.connectech.viewmodel.MatchViewModel
import com.cs407.connectech.viewmodel.MatchViewModelFactory

class BestMatchesFragment : Fragment() {

    private var _binding: FragmentBestMatchesBinding? = null
    private val binding get() = _binding!!
    private lateinit var matchViewModel: MatchViewModel
    private lateinit var matchAdapter: MatchAdapter

    // Retrieve arguments using Safe Args
    private val args: BestMatchesFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentBestMatchesBinding.inflate(inflater, container, false)

        matchViewModel = ViewModelProvider(
            this,
            MatchViewModelFactory(FakeMatchRepository())
        ).get(MatchViewModel::class.java)

        setupRecyclerView()
        observeData()

        // Fetch best matches based on the selected tag and category
        val selectedTag = args.selectedTag
        val selectedCategory = args.selectedCategory
        matchViewModel.fetchBestMatches(selectedTag, selectedCategory)

        return binding.root
    }

    private fun setupRecyclerView() {
        // Initialize RecyclerView adapter with a click listener
        matchAdapter = MatchAdapter { selectedMatch ->
            // Navigate to CompanySelectedFragment with the selected company's ID
            val action = BestMatchesFragmentDirections
                .actionBestMatchesFragmentToCompanySelectedFragment(companyId = selectedMatch.id)
            findNavController().navigate(action)
        }

        binding.bestMatchesRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = matchAdapter
        }
    }

    private fun observeData() {
        matchViewModel.bestMatches.observe(viewLifecycleOwner) { matches ->
            if (matches.isNotEmpty()) {
                matchAdapter.submitList(matches)
                updateUI(matches)
            } else {
                Toast.makeText(context, "No matches found for the selected category.", Toast.LENGTH_SHORT).show()
                // Optionally navigate back or show placeholder UI
            }
        }

        matchViewModel.error.observe(viewLifecycleOwner) { errorMessage ->
            Toast.makeText(context, "Error: $errorMessage", Toast.LENGTH_SHORT).show()
        }
    }

    private fun updateUI(matches: List<Match>) {
        binding.bestMatchesTitle.text = "Top ${args.selectedTag} Companies"
        binding.bestMatchesSubtitle.text = "Here are ${matches.size} companies that excel in ${args.selectedTag}"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
