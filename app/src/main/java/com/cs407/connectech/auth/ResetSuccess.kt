package com.cs407.connectech.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.cs407.connectech.databinding.FragmentResetSuccessBinding

class ResetSuccessFragment : Fragment() {

    private var _binding: FragmentResetSuccessBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SuccessMessageViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResetSuccessBinding.inflate(inflater, container, false)

        // Bind the ViewModel to the layout
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
