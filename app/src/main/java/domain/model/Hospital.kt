package com.prathvik.arogyanidhi.domain.model

data class Hospital(

    val name: String,
    val specialty: String,
    val location: String,
    val emergencyAvailable: Boolean
)