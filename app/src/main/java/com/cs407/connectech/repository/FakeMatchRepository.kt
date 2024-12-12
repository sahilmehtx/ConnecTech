package com.cs407.connectech.repository

import com.cs407.connectech.model.Match

class FakeMatchRepository {

    // Predefined data pools by tag
    // Each list contains companies specialized in different categories or general solutions.
    private val aiMlCompanies = listOf(
        Match(
            id = 1,
            name = "AI Corp",
            rating = 4.5,
            city = "New York",
            location = "123 AI Ave, New York, NY",
            email = "contact@ai-corp.com",
            phone = "+1-555-1234",
            category = "Enterprise",
            description = "Leading provider of AI solutions for large-scale enterprise clients."
        ),
        Match(
            id = 2,
            name = "Machine Learning Inc.",
            rating = 4.7,
            city = "San Francisco",
            location = "456 ML Blvd, San Francisco, CA",
            email = "info@ml-inc.com",
            phone = "+1-555-5678",
            category = "Medium Business",
            description = "ML-driven products tailored for medium businesses looking to automate workflows."
        ),
        Match(
            id = 3,
            name = "NeuralWave Innovations",
            rating = 4.8,
            city = "Chicago",
            location = "789 Neural Ln, Chicago, IL",
            email = "hello@neuralwave.ai",
            phone = "+1-555-9999",
            category = "Startup",
            description = "Cutting-edge AI solutions for startups and innovative private projects."
        ),
        Match(
            id = 4,
            name = "DeepMindful Tech",
            rating = 4.6,
            city = "Boston",
            location = "321 Deep Rd, Boston, MA",
            email = "contact@deepmindfultech.com",
            phone = "+1-555-3456",
            category = "Other",
            description = "General AI consulting and model optimization services."
        ),
        Match(
            id = 5,
            name = "Cognitive Hive",
            rating = 4.4,
            city = "Austin",
            location = "654 Hive St, Austin, TX",
            email = "support@cognitivehive.com",
            phone = "+1-555-2345",
            category = "None",
            description = "Flexible AI solutions with no strict category alignment, suitable for diverse needs."
        )
    )

    private val dataScienceCompanies = listOf(
        Match(
            id = 6,
            name = "Data Solutions",
            rating = 4.6,
            city = "Chicago",
            location = "789 Data Dr, Chicago, IL",
            email = "hello@datasolutions.com",
            phone = "+1-555-9012",
            category = "Enterprise",
            description = "Experts in large-scale data analytics and enterprise insights."
        ),
        Match(
            id = 7,
            name = "Analytics LLC",
            rating = 4.8,
            city = "Boston",
            location = "321 Analytics Ln, Boston, MA",
            email = "contact@analyticsllc.com",
            phone = "+1-555-3456",
            category = "Medium Business",
            description = "Advanced analytics offerings for medium businesses making data-driven decisions."
        ),
        Match(
            id = 8,
            name = "InsightGen",
            rating = 4.7,
            city = "Seattle",
            location = "101 Insight Rd, Seattle, WA",
            email = "info@insightgen.com",
            phone = "+1-555-7777",
            category = "Startup",
            description = "Specialized in data science solutions for lean startups."
        ),
        Match(
            id = 9,
            name = "DataCraft Labs",
            rating = 4.5,
            city = "Denver",
            location = "202 Craft St, Denver, CO",
            email = "support@datacraftlabs.com",
            phone = "+1-555-2222",
            category = "Other",
            description = "Flexible analytics solutions, from private projects to large enterprises."
        ),
        Match(
            id = 10,
            name = "Quantify Co.",
            rating = 4.3,
            city = "San Jose",
            location = "303 Quant Ln, San Jose, CA",
            email = "sales@quantifyco.com",
            phone = "+1-555-8888",
            category = "None",
            description = "Offers data science packages suitable for a variety of projects, no strict category needed."
        )
    )

    private val webDevCompanies = listOf(
        Match(
            id = 11,
            name = "Web Masters",
            rating = 4.2,
            city = "Los Angeles",
            location = "404 Web Dr, Los Angeles, CA",
            email = "contact@webmasters.com",
            phone = "+1-555-1111",
            category = "Enterprise",
            description = "Enterprise-level web platforms and e-commerce solutions."
        ),
        Match(
            id = 12,
            name = "FrontEnd Pros",
            rating = 4.6,
            city = "Portland",
            location = "505 Front St, Portland, OR",
            email = "hello@frontendpros.com",
            phone = "+1-555-3333",
            category = "Medium Business",
            description = "Tailored front-end development for SMBs looking to refresh their digital presence."
        ),
        Match(
            id = 13,
            name = "StartupWeb",
            rating = 4.7,
            city = "Miami",
            location = "606 Startup Ln, Miami, FL",
            email = "info@startupweb.com",
            phone = "+1-555-6666",
            category = "Startup",
            description = "Quick MVP development and UX optimization for new ventures."
        ),
        Match(
            id = 14,
            name = "PrivatePixel",
            rating = 4.5,
            city = "Atlanta",
            location = "707 Pixel Ave, Atlanta, GA",
            email = "support@privatepixel.com",
            phone = "+1-555-4444",
            category = "Private Project",
            description = "Custom web solutions for private projects and personal portfolios."
        ),
        Match(
            id = 15,
            name = "AnySite Solutions",
            rating = 4.4,
            city = "Detroit",
            location = "808 AnySite St, Detroit, MI",
            email = "contact@anysitesolutions.com",
            phone = "+1-555-9990",
            category = "None",
            description = "General web development services suitable for any category."
        )
    )

    private val mobileDevCompanies = listOf(
        Match(
            id = 16,
            name = "AppSmith",
            rating = 4.6,
            city = "San Diego",
            location = "909 App Blvd, San Diego, CA",
            email = "hello@appsmith.com",
            phone = "+1-555-0001",
            category = "Medium Business",
            description = "Mobile apps tailored for SMB growth and user engagement."
        ),
        Match(
            id = 17,
            name = "MobiStart",
            rating = 4.7,
            city = "Houston",
            location = "1010 Mobi Ln, Houston, TX",
            email = "info@mobistart.com",
            phone = "+1-555-0002",
            category = "Startup",
            description = "High-quality mobile MVPs for startups entering the market."
        ),
        // ... Add more entries as needed
    )

    private val cloudCompanies = listOf(
        // Add a variety of cloud computing providers
        Match(
            id = 18,
            name = "Cloud Nexus",
            rating = 4.8,
            city = "Seattle",
            location = "123 Cloud St, Seattle, WA",
            email = "contact@cloudnexus.com",
            phone = "+1-555-7001",
            category = "Enterprise",
            description = "Experts in enterprise-grade cloud computing and migration solutions."
        ),
        Match(
            id = 19,
            name = "SkyHigh Cloud",
            rating = 4.6,
            city = "San Francisco",
            location = "456 Sky Rd, San Francisco, CA",
            email = "info@skyhighcloud.com",
            phone = "+1-555-7002",
            category = "Medium Business",
            description = "Cloud solutions tailored for medium businesses seeking scalability."
        ),
        Match(
            id = 20,
            name = "Nimbus Start",
            rating = 4.7,
            city = "Austin",
            location = "789 Nimbus Ln, Austin, TX",
            email = "hello@nimbusstart.com",
            phone = "+1-555-7003",
            category = "Startup",
            description = "Affordable cloud services for startups building scalable apps."
        ),
        Match(
            id = 21,
            name = "Cloudify Solutions",
            rating = 4.5,
            city = "Denver",
            location = "321 Cloudify St, Denver, CO",
            email = "support@cloudifysolutions.com",
            phone = "+1-555-7004",
            category = "Other",
            description = "Flexible cloud infrastructure and consulting for unique needs."
        ),
        Match(
            id = 22,
            name = "ElasticSky",
            rating = 4.4,
            city = "New York",
            location = "654 Elastic Ln, New York, NY",
            email = "sales@elasticsky.com",
            phone = "+1-555-7005",
            category = "None",
            description = "General-purpose cloud hosting for businesses of all sizes."
        )
    )

    private val blockchainCompanies = listOf(
        // Add a variety of blockchain-focused companies
        Match(
            id = 23,
            name = "BlockBuild Inc.",
            rating = 4.7,
            city = "San Francisco",
            location = "123 Block St, San Francisco, CA",
            email = "info@blockbuild.com",
            phone = "+1-555-8001",
            category = "Enterprise",
            description = "Enterprise-grade blockchain solutions for supply chain and finance."
        ),
        Match(
            id = 24,
            name = "CryptoWare",
            rating = 4.6,
            city = "Chicago",
            location = "456 Crypto Ln, Chicago, IL",
            email = "support@cryptoware.com",
            phone = "+1-555-8002",
            category = "Medium Business",
            description = "Secure and scalable blockchain solutions for medium businesses."
        ),
        Match(
            id = 25,
            name = "LedgerStart",
            rating = 4.8,
            city = "Austin",
            location = "789 Ledger Rd, Austin, TX",
            email = "contact@ledgerstart.com",
            phone = "+1-555-8003",
            category = "Startup",
            description = "Blockchain MVP development for startups exploring the decentralized space."
        ),
        Match(
            id = 26,
            name = "ChainFlex",
            rating = 4.5,
            city = "Denver",
            location = "101 Chain Ln, Denver, CO",
            email = "hello@chainflex.com",
            phone = "+1-555-8004",
            category = "Other",
            description = "Flexible blockchain solutions for private and public applications."
        ),
        Match(
            id = 27,
            name = "OpenChain Solutions",
            rating = 4.4,
            city = "Miami",
            location = "505 Open Rd, Miami, FL",
            email = "contact@openchainsolutions.com",
            phone = "+1-555-8005",
            category = "None",
            description = "Custom blockchain services without strict category alignment."
        )
    )

    private val cybersecurityCompanies = listOf(
        // Add a variety of cybersecurity-focused companies
        Match(
            id = 28,
            name = "SecureNet",
            rating = 4.8,
            city = "Boston",
            location = "123 Secure Ln, Boston, MA",
            email = "info@securenet.com",
            phone = "+1-555-9001",
            category = "Enterprise",
            description = "Enterprise-grade cybersecurity solutions to protect critical systems."
        ),
        Match(
            id = 29,
            name = "CyberShield LLC",
            rating = 4.7,
            city = "Seattle",
            location = "456 Shield St, Seattle, WA",
            email = "contact@cybershield.com",
            phone = "+1-555-9002",
            category = "Medium Business",
            description = "Comprehensive cybersecurity services for medium-sized businesses."
        ),
        Match(
            id = 30,
            name = "StartupSec",
            rating = 4.6,
            city = "San Diego",
            location = "789 Security Rd, San Diego, CA",
            email = "support@startupsec.com",
            phone = "+1-555-9003",
            category = "Startup",
            description = "Affordable and scalable cybersecurity solutions for startups."
        ),
        Match(
            id = 31,
            name = "SafeHaven",
            rating = 4.5,
            city = "Denver",
            location = "321 Haven St, Denver, CO",
            email = "hello@safehaven.com",
            phone = "+1-555-9004",
            category = "Other",
            description = "Custom cybersecurity services for unique and private projects."
        ),
        Match(
            id = 32,
            name = "Protectify",
            rating = 4.4,
            city = "Los Angeles",
            location = "654 Protect Ln, Los Angeles, CA",
            email = "sales@protectify.com",
            phone = "+1-555-9005",
            category = "None",
            description = "General cybersecurity solutions suitable for all categories."
        )
    )

    // Map the tag to its list of companies
    private val companyDataByTag = mapOf(
        "AI/ML" to aiMlCompanies,
        "Data Science" to dataScienceCompanies,
        "Web Dev" to webDevCompanies,
        "Mobile Dev" to mobileDevCompanies,
        "Cloud Computing" to cloudCompanies,
        "Blockchain" to blockchainCompanies,
        "Cybersecurity" to cybersecurityCompanies
    )

    fun getBestMatches(tag: String, category: String): List<Match> {
        // Get the list of companies for the given tag
        val companies = companyDataByTag[tag] ?: emptyList()

        if (companies.isEmpty()) {
            // If no companies match the tag, return an empty list or some fallback
            return emptyList()
        }

        // First, filter by category (exact match)
        val filteredByCategory = companies.filter {
            it.category.equals(category, ignoreCase = true)
        }

        // If we got fewer than 5 matches by category, we add more from the general tag pool
        // to ensure the user sees enough options.
        return if (filteredByCategory.size < 5) {
            // Add general (non-category-specific) matches by taking those that do not match the category,
            // or use a 'None' category as a fallback
            val nonCategoryMatches = companies.filterNot { it.category.equals(category, ignoreCase = true) }
            // Combine and limit to a reasonable number (e.g., top 10)
            (filteredByCategory + nonCategoryMatches).take(10)
        } else {
            // We have enough category-specific matches
            filteredByCategory.take(10)
        }
    }

    fun getCompanyById(id: Int): Match {
        // Search all companies in all tags
        val allCompanies = companyDataByTag.values.flatten()
        return allCompanies.firstOrNull { it.id == id }
            ?: throw IllegalArgumentException("Company with id $id not found.")
    }

}
