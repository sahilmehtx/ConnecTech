package com.cs407.connectech.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cs407.connectech.databinding.ItemCompanyListBinding
import com.cs407.connectech.model.Match

class CompanyListAdapter(
    private val onDeleteClicked: (Match) -> Unit,
    private val onNotifyClicked: (Match) -> Unit
) : ListAdapter<Match, CompanyListAdapter.CompanyListViewHolder>(MatchDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompanyListViewHolder {
        val binding = ItemCompanyListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CompanyListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CompanyListViewHolder, position: Int) {
        val company = getItem(position)
        holder.bind(company)
    }

    inner class CompanyListViewHolder(private val binding: ItemCompanyListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(company: Match) {
            binding.matchName.text = company.name
            binding.matchRating.text = "Rating: ${company.rating}"
            binding.matchCategory.text = "Category: ${company.category}"
            binding.matchLocation.text = "Location: ${company.location}"
            binding.matchEmail.text = "Email: ${company.email}"
            binding.matchPhone.text = "Phone: ${company.phone}"
            binding.matchDescription.text = company.description

            binding.deleteButton.setOnClickListener {
                onDeleteClicked(company)
            }
            binding.notifyButton.setOnClickListener {
                onNotifyClicked(company)
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
