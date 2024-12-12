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
            binding.matchName.text = "Name: ${match.name}"
            binding.matchRating.text = "Ranking: ${match.ranking}"
            binding.matchCategory.text = "Category: ${match.industry}"
            binding.matchLocation.text = "Location: ${match.country}"
            binding.matchSector.text = "Sector: ${match.sector}"
            binding.matchMarketCap.text = "Market Cap: ${match.marketCap}"
            binding.matchStockSymbol.text = "Stock Symbol: ${match.stockSymbol}"
            

            binding.root.setOnClickListener {
                onClick(match)
            }
        }
    }

    class MatchDiffCallback : DiffUtil.ItemCallback<Match>() {
        override fun areItemsTheSame(oldItem: Match, newItem: Match): Boolean {
            return oldItem.ranking == newItem.ranking
        }

        override fun areContentsTheSame(oldItem: Match, newItem: Match): Boolean {
            return oldItem == newItem
        }
    }
}
