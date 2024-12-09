// File: BestMatchesFragment.kt
package com.cs407.connectech.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.cs407.connectech.databinding.FragmentBestMatchesBinding
import com.cs407.connectech.model.Match
import com.cs407.connectech.viewmodel.MatchViewModel
import com.cs407.connectech.viewmodel.MatchViewModelFactory
import com.cs407.connectech.repository.FakeMatchRepository
import com.cs407.connectech.ui.main.adapter.MatchAdapter
//import dagger.hilt.android.AndroidEntryPoint
import androidx.navigation.fragment.navArgs

//@AndroidEntryPoint
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
    ): View? {
        _binding = FragmentBestMatchesBinding.inflate(inflater, container, false)

        // Initialize ViewModel with Factory (Hilt will provide dependencies if properly set up)
        matchViewModel = ViewModelProvider(this, MatchViewModelFactory(FakeMatchRepository()))
            .get(MatchViewModel::class.java)

        setupRecyclerView()
        observeData()

        // Fetch best matches based on the selected tag
        val selectedTag = args.SELECTEDTAG
        matchViewModel.fetchBestMatches(selectedTag)

        return binding.root
    }

    private fun setupRecyclerView() {
        // Initialize RecyclerView adapter
        matchAdapter = MatchAdapter()
        binding.bestMatchesRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = matchAdapter  // Set adapter to RecyclerView
        }
    }

    private fun observeData() {
        // Observe the best matches LiveData from ViewModel
        matchViewModel.bestMatches.observe(viewLifecycleOwner) { matches ->
            if (matches.isNotEmpty()) {
                matchAdapter.submitList(matches)  // Update adapter with match data
                updateUI(matches)
            } else {
                Toast.makeText(context, "No matches found for the selected category.", Toast.LENGTH_SHORT).show()
                // Optionally, navigate back or show a placeholder
            }
        }

        // Observe error LiveData from ViewModel
        matchViewModel.error.observe(viewLifecycleOwner) { errorMessage ->
            Toast.makeText(context, "Error: $errorMessage", Toast.LENGTH_SHORT).show()
        }
    }

    private fun updateUI(matches: List<Match>) {
        // Update the title and subtitle based on the selected tag
        binding.bestMatchesTitle.text = "Top ${args.SELECTEDTAG} Companies"
        binding.bestMatchesSubtitle.text = "Here are ${matches.size} companies that excel in ${args.SELECTEDTAG}"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
