package com.cs407.connectech.repository

import com.cs407.connectech.model.Match

object CompanyListRepository {
    private val companyList = mutableListOf<Match>()

    fun addCompany(company: Match) {
        if (!companyList.contains(company)) {
            companyList.add(company)
        }
    }

    fun removeCompany(company: Match) {
        companyList.remove(company)
    }

    fun getSelectedCompanies(): List<Match> {
        return companyList
    }
}
