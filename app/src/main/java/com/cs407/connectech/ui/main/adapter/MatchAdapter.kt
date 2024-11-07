package com.cs407.connectech.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cs407.connectech.R
import com.cs407.connectech.model.Match  // Model representing each tech provider

class MatchAdapter : ListAdapter<Match, MatchAdapter.MatchViewHolder>(MatchDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_match, parent, false)
        return MatchViewHolder(view)
    }

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        val match = getItem(position)
        holder.bind(match)
    }

    class MatchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val providerName: TextView = itemView.findViewById(R.id.providerName)
        private val providerRating: TextView = itemView.findViewById(R.id.providerRating)

        // Bind the data to the view elements
        fun bind(match: Match) {
            providerName.text = match.name  // Name of the tech provider
            providerRating.text = "Rating: ${match.rating}"  // Rating of the provider
        }
    }

    // DiffUtil for efficiently updating the RecyclerView
    class MatchDiffCallback : DiffUtil.ItemCallback<Match>() {
        override fun areItemsTheSame(oldItem: Match, newItem: Match): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Match, newItem: Match): Boolean {
            return oldItem == newItem
        }
    }
}
