package com.cs407.connectech.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cs407.connectech.databinding.ItemMatchBinding
import com.cs407.connectech.model.Match

class MatchAdapter(private val onClick: (Match) -> Unit) : ListAdapter<Match, MatchAdapter.MatchViewHolder>(MatchDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        val binding = ItemMatchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MatchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        val match = getItem(position)
        holder.bind(match)
    }

    inner class MatchViewHolder(private val binding: ItemMatchBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(match: Match) {
            binding.matchName.text = match.name
            binding.matchRating.text = "Rating: ${match.rating}"
            binding.matchCategory.text = "Category: ${match.category}"
            binding.matchLocation.text = "Location: ${match.location}"
            binding.matchEmail.text = "Email: ${match.email}"
            binding.matchPhone.text = "Phone: ${match.phone}"
            binding.matchDescription.text = match.description

            binding.root.setOnClickListener {
                onClick(match)
            }
        }
    }

    class MatchDiffCallback : DiffUtil.ItemCallback<Match>() {
        override fun areItemsTheSame(oldItem: Match, newItem: Match): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Match, newItem: Match): Boolean {
            return oldItem == newItem
        }
    }
}
