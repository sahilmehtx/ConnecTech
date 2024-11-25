package com.cs407.connectech.inbox

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.cs407.connectech.databinding.FragmentInboxBinding

class InboxFragment : Fragment() {
    private lateinit var binding: FragmentInboxBinding
    private val totalPages = 5 // Example total pages

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInboxBinding.inflate(inflater, container, false)
        setupPagination()
        return binding.root
    }

    private fun setupPagination() {
        val paginationAdapter = PaginationAdapter(totalPages) { page ->
            // Handle page click
            Toast.makeText(requireContext(), "Page $page clicked", Toast.LENGTH_SHORT).show()
        }

        binding.paginationRecyclerView.apply {
            adapter = paginationAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }
    }
}
