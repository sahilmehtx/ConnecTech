package com.cs407.connectech.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.cs407.connectech.databinding.FragmentBestMatchesBinding
import com.cs407.connectech.auth.AuthViewModel  // Reuse existing ViewModel
import com.cs407.connectech.ui.main.adapter.MatchAdapter  // Adapter to display match list

class BestMatchesFragment : Fragment() {

    private var _binding: FragmentBestMatchesBinding? = null
    private val binding get() = _binding!!
    private lateinit var authViewModel: AuthViewModel
    private lateinit var matchAdapter: MatchAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBestMatchesBinding.inflate(inflater, container, false)

        // Initialize ViewModel
        authViewModel = ViewModelProvider(this).get(AuthViewModel::class.java)

        setupRecyclerView()
        observeData()

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
        // **Variable Needed in AuthViewModel**: `bestMatches: LiveData<List<Match>>`
        // **Integrates With**: `MatchRepository` to fetch data from backend
        authViewModel.bestMatches.observe(viewLifecycleOwner) { matches ->
            if (matches != null) {
                matchAdapter.submitList(matches)  // Update adapter with match data
            } else {
                Toast.makeText(context, "No matches found.", Toast.LENGTH_SHORT).show()
            }
        }

        // **Function Needed in AuthViewModel**: `fetchBestMatches()`
        // **Integrates With**: `MatchRepository` to retrieve match data from backend
        // **Expected Outcome**: Fetch list of tech providers matching user requirements
        authViewModel.fetchBestMatches()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
