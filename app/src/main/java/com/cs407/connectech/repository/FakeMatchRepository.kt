package com.cs407.connectech.repository

import com.cs407.connectech.model.Match

class FakeMatchRepository {

    // AI/ML Companies
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
        ),
        Match(
            id = 33,
            name = "AlphaBrain",
            rating = 4.9,
            city = "Los Angeles",
            location = "101 AI Way, Los Angeles, CA",
            email = "contact@alphabrain.ai",
            phone = "+1-555-1112",
            category = "Enterprise",
            description = "State-of-the-art AI algorithms for enterprise-scale data processing."
        ),
        Match(
            id = 34,
            name = "ML Solutions Pro",
            rating = 4.5,
            city = "Denver",
            location = "202 ML Dr, Denver, CO",
            email = "info@mlsolutionspro.com",
            phone = "+1-555-1122",
            category = "Medium Business",
            description = "Practical machine learning implementations for medium-sized operations."
        ),
        Match(
            id = 35,
            name = "Visionary AI",
            rating = 4.6,
            city = "Seattle",
            location = "303 Vision Ln, Seattle, WA",
            email = "hello@visionaryai.com",
            phone = "+1-555-1133",
            category = "Startup",
            description = "Computer vision and NLP models crafted for emerging tech startups."
        ),
        Match(
            id = 36,
            name = "DataBrain Tech",
            rating = 4.7,
            city = "Houston",
            location = "404 Data St, Houston, TX",
            email = "support@databraintech.com",
            phone = "+1-555-1144",
            category = "Medium Business",
            description = "Robust data-centric AI solutions for medium enterprises."
        ),
        Match(
            id = 37,
            name = "NeuroCode",
            rating = 4.3,
            city = "Phoenix",
            location = "505 Neuro Rd, Phoenix, AZ",
            email = "contact@neurocode.ai",
            phone = "+1-555-1155",
            category = "Other",
            description = "Custom AI software development for unique industry applications."
        ),
        Match(
            id = 38,
            name = "Smartify",
            rating = 4.2,
            city = "Portland",
            location = "606 Smart Ave, Portland, OR",
            email = "info@smartify.com",
            phone = "+1-555-1166",
            category = "Enterprise",
            description = "Enterprise AI integration and advisory services."
        ),
        Match(
            id = 39,
            name = "ThinkAI",
            rating = 4.5,
            city = "Dallas",
            location = "707 Think Ln, Dallas, TX",
            email = "hello@thinkai.co",
            phone = "+1-555-1177",
            category = "Startup",
            description = "Accelerated AI prototyping for early-stage companies."
        )
    )

    // Data Science Companies
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
        ),
        Match(
            id = 40,
            name = "DataMinds",
            rating = 4.4,
            city = "Atlanta",
            location = "404 DataMinds Ave, Atlanta, GA",
            email = "info@dataminds.io",
            phone = "+1-555-2233",
            category = "Medium Business",
            description = "Data analysis and visualization services for SMBs."
        ),
        Match(
            id = 41,
            name = "StatSense",
            rating = 4.7,
            city = "Miami",
            location = "505 Stat Ln, Miami, FL",
            email = "contact@statsense.com",
            phone = "+1-555-2244",
            category = "Startup",
            description = "Statistical modeling and forecasting for emerging ventures."
        ),
        Match(
            id = 42,
            name = "BigDataPro",
            rating = 4.6,
            city = "New York",
            location = "606 BigData Dr, New York, NY",
            email = "hello@bigdatapro.com",
            phone = "+1-555-2255",
            category = "Enterprise",
            description = "End-to-end big data engineering solutions for large corporations."
        ),
        Match(
            id = 43,
            name = "Predictify",
            rating = 4.5,
            city = "Los Angeles",
            location = "707 Predict Ln, Los Angeles, CA",
            email = "support@predictify.ai",
            phone = "+1-555-2266",
            category = "Other",
            description = "Predictive analytics tailored to unique business cases."
        ),
        Match(
            id = 44,
            name = "DataDrive",
            rating = 4.8,
            city = "Austin",
            location = "808 Drive Ave, Austin, TX",
            email = "info@datadrive.com",
            phone = "+1-555-2277",
            category = "Medium Business",
            description = "Data pipelines and ETL solutions for mid-sized companies."
        ),
        Match(
            id = 45,
            name = "GigaAnalytics",
            rating = 4.2,
            city = "Portland",
            location = "909 Giga Rd, Portland, OR",
            email = "contact@gigaanalytics.com",
            phone = "+1-555-2288",
            category = "None",
            description = "General analytics consulting for varied project scopes."
        ),
        Match(
            id = 46,
            name = "DataInsights Pro",
            rating = 4.3,
            city = "Phoenix",
            location = "1010 Insights Dr, Phoenix, AZ",
            email = "hello@datainsightspro.com",
            phone = "+1-555-2299",
            category = "Other",
            description = "Custom insight generation for complex data challenges."
        )
    )

    // Web Dev Companies
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
        ),
        Match(
            id = 47,
            name = "CodeCraft Web",
            rating = 4.6,
            city = "Houston",
            location = "909 Code St, Houston, TX",
            email = "info@codecraftweb.com",
            phone = "+1-555-5555",
            category = "Enterprise",
            description = "High-performance web apps for large-scale deployments."
        ),
        Match(
            id = 48,
            name = "PixelPioneers",
            rating = 4.3,
            city = "Seattle",
            location = "1010 Pioneer Ln, Seattle, WA",
            email = "contact@pixelpioneers.com",
            phone = "+1-555-3334",
            category = "Medium Business",
            description = "UI/UX revamps and responsive design for medium businesses."
        ),
        Match(
            id = 49,
            name = "RapidWeb",
            rating = 4.5,
            city = "Denver",
            location = "1111 Rapid Rd, Denver, CO",
            email = "hello@rapidweb.dev",
            phone = "+1-555-5556",
            category = "Startup",
            description = "Fast turnaround web prototypes for startups."
        ),
        Match(
            id = 50,
            name = "CustomSites",
            rating = 4.2,
            city = "Chicago",
            location = "1212 Custom St, Chicago, IL",
            email = "support@customsites.com",
            phone = "+1-555-5557",
            category = "Private Project",
            description = "Fully customized web solutions for unique needs."
        ),
        Match(
            id = 51,
            name = "Webify",
            rating = 4.8,
            city = "New York",
            location = "1313 Webify Ln, New York, NY",
            email = "info@webify.io",
            phone = "+1-555-5558",
            category = "Enterprise",
            description = "Scalable enterprise web solutions integrating with legacy systems."
        ),
        Match(
            id = 52,
            name = "DevHive",
            rating = 4.4,
            city = "Boston",
            location = "1414 Hive Rd, Boston, MA",
            email = "contact@devhive.com",
            phone = "+1-555-5559",
            category = "None",
            description = "General web consulting and development services."
        ),
        Match(
            id = 53,
            name = "WebGenius",
            rating = 4.7,
            city = "Phoenix",
            location = "1515 Genius Ave, Phoenix, AZ",
            email = "hello@webgenius.com",
            phone = "+1-555-5560",
            category = "Startup",
            description = "Innovative web solutions targeting tech-savvy startups."
        )
    )

    // Mobile Dev Companies
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
        Match(
            id = 54,
            name = "PocketApps",
            rating = 4.5,
            city = "Chicago",
            location = "111 Pocket Dr, Chicago, IL",
            email = "contact@pocketapps.com",
            phone = "+1-555-0003",
            category = "Enterprise",
            description = "Enterprise mobile solutions integrating complex systems."
        ),
        Match(
            id = 55,
            name = "SwiftlyCode",
            rating = 4.3,
            city = "New York",
            location = "222 Swift St, New York, NY",
            email = "hello@swiftlycode.com",
            phone = "+1-555-0004",
            category = "Medium Business",
            description = "iOS and Android development for mid-sized enterprises."
        ),
        Match(
            id = 56,
            name = "AppVentures",
            rating = 4.8,
            city = "Boston",
            location = "333 App Ave, Boston, MA",
            email = "info@appventures.io",
            phone = "+1-555-0005",
            category = "Startup",
            description = "Rapid iteration on mobile prototypes for early-stage companies."
        ),
        Match(
            id = 57,
            name = "MobileMatrix",
            rating = 4.4,
            city = "San Francisco",
            location = "444 Matrix Ln, San Francisco, CA",
            email = "support@mobilematrix.com",
            phone = "+1-555-0006",
            category = "None",
            description = "General mobile development for diverse industry verticals."
        ),
        Match(
            id = 58,
            name = "Appify",
            rating = 4.5,
            city = "Seattle",
            location = "555 Appify St, Seattle, WA",
            email = "contact@appify.com",
            phone = "+1-555-0007",
            category = "Other",
            description = "Custom mobile solutions for unique platform requirements."
        ),
        Match(
            id = 59,
            name = "MobiPros",
            rating = 4.6,
            city = "Denver",
            location = "666 Mobi Rd, Denver, CO",
            email = "hello@mobipros.dev",
            phone = "+1-555-0008",
            category = "Medium Business",
            description = "Optimized apps and performance tuning for SMBs."
        ),
        Match(
            id = 60,
            name = "AppNexus",
            rating = 4.7,
            city = "Los Angeles",
            location = "777 Nexus Blvd, Los Angeles, CA",
            email = "info@appnexus.co",
            phone = "+1-555-0009",
            category = "Enterprise",
            description = "Scalable mobile architectures for large-scale deployments."
        ),
        Match(
            id = 61,
            name = "OneTap Solutions",
            rating = 4.2,
            city = "Austin",
            location = "888 OneTap Ln, Austin, TX",
            email = "support@onetapsolutions.com",
            phone = "+1-555-0010",
            category = "Other",
            description = "Niche mobile apps with custom integrations."
        ),
        Match(
            id = 62,
            name = "MobiCraft",
            rating = 4.3,
            city = "Portland",
            location = "999 Craft St, Portland, OR",
            email = "contact@mobicraft.com",
            phone = "+1-555-0011",
            category = "Startup",
            description = "Fast-launch mobile products tailored to startup budgets."
        ),
        Match(
            id = 63,
            name = "TapTech",
            rating = 4.5,
            city = "Phoenix",
            location = "1010 Tap Rd, Phoenix, AZ",
            email = "hello@taptech.io",
            phone = "+1-555-0012",
            category = "None",
            description = "General mobile development with a focus on user experience."
        )
    )

    // Cloud Computing Companies
    private val cloudCompanies = listOf(
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
        ),
        Match(
            id = 64,
            name = "CloudSynergy",
            rating = 4.9,
            city = "Boston",
            location = "111 Cloud Ln, Boston, MA",
            email = "info@cloudsynergy.com",
            phone = "+1-555-7006",
            category = "Enterprise",
            description = "Seamless cloud integration for large-scale enterprises."
        ),
        Match(
            id = 65,
            name = "ScalableCloud",
            rating = 4.7,
            city = "Chicago",
            location = "222 Scale Rd, Chicago, IL",
            email = "contact@scalablecloud.io",
            phone = "+1-555-7007",
            category = "Medium Business",
            description = "Easily expandable cloud environments for mid-tier businesses."
        ),
        Match(
            id = 66,
            name = "CloudLaunch",
            rating = 4.6,
            city = "Los Angeles",
            location = "333 Launch St, Los Angeles, CA",
            email = "hello@cloudlaunch.com",
            phone = "+1-555-7008",
            category = "Startup",
            description = "Low-cost cloud solutions ideal for new ventures."
        ),
        Match(
            id = 67,
            name = "SkyVault",
            rating = 4.3,
            city = "Houston",
            location = "444 Vault Ln, Houston, TX",
            email = "support@skyvault.tech",
            phone = "+1-555-7009",
            category = "None",
            description = "General cloud storage and backup services."
        ),
        Match(
            id = 68,
            name = "CloudWorx",
            rating = 4.5,
            city = "Miami",
            location = "555 Worx Rd, Miami, FL",
            email = "info@cloudworx.com",
            phone = "+1-555-7010",
            category = "Other",
            description = "Custom cloud orchestration for specialized needs."
        ),
        Match(
            id = 69,
            name = "CloudNova",
            rating = 4.6,
            city = "San Diego",
            location = "666 Nova Ave, San Diego, CA",
            email = "contact@cloudnova.co",
            phone = "+1-555-7011",
            category = "Medium Business",
            description = "Managed cloud environments for growing organizations."
        ),
        Match(
            id = 70,
            name = "CloudEdge",
            rating = 4.8,
            city = "Phoenix",
            location = "777 Edge St, Phoenix, AZ",
            email = "hello@cloudedge.com",
            phone = "+1-555-7012",
            category = "Enterprise",
            description = "High-reliability, secure cloud platforms for large clients."
        )
    )

    // Blockchain Companies
    private val blockchainCompanies = listOf(
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
        ),
        Match(
            id = 71,
            name = "Blockify",
            rating = 4.7,
            city = "New York",
            location = "111 Blockify St, New York, NY",
            email = "info@blockify.io",
            phone = "+1-555-8006",
            category = "Enterprise",
            description = "Enterprise blockchain integration for complex workflows."
        ),
        Match(
            id = 72,
            name = "ChainCore",
            rating = 4.5,
            city = "Los Angeles",
            location = "222 ChainCore Ln, Los Angeles, CA",
            email = "hello@chaincore.com",
            phone = "+1-555-8007",
            category = "Medium Business",
            description = "Simplified blockchain solutions for mid-sized companies."
        ),
        Match(
            id = 73,
            name = "DigiChain",
            rating = 4.8,
            city = "Seattle",
            location = "333 DigiChain Rd, Seattle, WA",
            email = "contact@digichain.dev",
            phone = "+1-555-8008",
            category = "Startup",
            description = "Next-gen blockchain frameworks for new ventures."
        ),
        Match(
            id = 74,
            name = "BlockLink",
            rating = 4.3,
            city = "Boston",
            location = "444 Link St, Boston, MA",
            email = "support@blocklink.com",
            phone = "+1-555-8009",
            category = "Other",
            description = "Flexible linking solutions across multiple blockchain platforms."
        ),
        Match(
            id = 75,
            name = "ChainVerse",
            rating = 4.6,
            city = "Houston",
            location = "555 ChainVerse Ln, Houston, TX",
            email = "info@chainverse.io",
            phone = "+1-555-8010",
            category = "None",
            description = "General blockchain development and smart contract auditing."
        ),
        Match(
            id = 76,
            name = "BlockEngine",
            rating = 4.4,
            city = "Phoenix",
            location = "666 Engine Rd, Phoenix, AZ",
            email = "contact@blockengine.com",
            phone = "+1-555-8011",
            category = "Medium Business",
            description = "Blockchain-based optimization of existing data flows."
        ),
        Match(
            id = 77,
            name = "Cryptovation",
            rating = 4.5,
            city = "Atlanta",
            location = "777 Crypto Ave, Atlanta, GA",
            email = "hello@cryptovation.io",
            phone = "+1-555-8012",
            category = "Startup",
            description = "Innovative blockchain pilots and proof-of-concept services."
        )
    )

    // Cybersecurity Companies
    private val cybersecurityCompanies = listOf(
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
        ),
        Match(
            id = 78,
            name = "SecureOps",
            rating = 4.8,
            city = "New York",
            location = "111 Ops Ln, New York, NY",
            email = "info@secureops.com",
            phone = "+1-555-9006",
            category = "Enterprise",
            description = "Operational security management and threat monitoring for large enterprises."
        ),
        Match(
            id = 79,
            name = "VulnScan",
            rating = 4.7,
            city = "Houston",
            location = "222 Vuln St, Houston, TX",
            email = "contact@vulnscan.io",
            phone = "+1-555-9007",
            category = "Medium Business",
            description = "Vulnerability scanning and penetration testing for mid-sized firms."
        ),
        Match(
            id = 80,
            name = "CyberGuard",
            rating = 4.6,
            city = "Chicago",
            location = "333 Guard Ln, Chicago, IL",
            email = "hello@cyberguard.com",
            phone = "+1-555-9008",
            category = "Startup",
            description = "Cost-effective cybersecurity packages for new startups."
        ),
        Match(
            id = 81,
            name = "ShieldTech",
            rating = 4.5,
            city = "Phoenix",
            location = "444 Shield Ave, Phoenix, AZ",
            email = "support@shieldtech.com",
            phone = "+1-555-9009",
            category = "Other",
            description = "Customizable security solutions for non-standard projects."
        ),
        Match(
            id = 82,
            name = "CyberPro",
            rating = 4.4,
            city = "Portland",
            location = "555 Pro Rd, Portland, OR",
            email = "sales@cyberpro.net",
            phone = "+1-555-9010",
            category = "None",
            description = "General cybersecurity advisory and risk assessment."
        ),
        Match(
            id = 83,
            name = "DataDefend",
            rating = 4.3,
            city = "Atlanta",
            location = "666 Defend Dr, Atlanta, GA",
            email = "contact@datadefend.com",
            phone = "+1-555-9011",
            category = "Medium Business",
            description = "Data-focused security solutions for SMEs."
        ),
        Match(
            id = 84,
            name = "SecuPrime",
            rating = 4.7,
            city = "Miami",
            location = "777 Prime Ln, Miami, FL",
            email = "hello@secuprime.io",
            phone = "+1-555-9012",
            category = "Startup",
            description = "Rapid security deployments for emerging digital products."
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
            // If no companies match the tag, return empty list
            return emptyList()
        }

        // First, filter by category (exact match)
        val filteredByCategory = companies.filter {
            it.category.equals(category, ignoreCase = true)
        }

        // If fewer than 5 matches by category, add more from the general tag pool
        return if (filteredByCategory.size < 5) {
            val nonCategoryMatches = companies.filterNot {
                it.category.equals(category, ignoreCase = true)
            }
            (filteredByCategory + nonCategoryMatches).take(10)
        } else {
            filteredByCategory.take(10)
        }
    }

    fun getCompanyById(id: Int): Match {
        val allCompanies = companyDataByTag.values.flatten()
        return allCompanies.firstOrNull { it.id == id }
            ?: throw IllegalArgumentException("Company with id $id not found.")
    }

}
