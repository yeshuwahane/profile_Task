package com.yeshuwahane.connect.data.remote.dto

data class ProfileModel(
    val `data`: List<Data>,
    val page: Int,
    val per_page: Int,
    val support: Support,
    val total: Int,
    val total_pages: Int
)




