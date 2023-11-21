package com.example.taskapi.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Users(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var userId: Int? = null,
    var username: String,
    var role: String,
)

// TODO
//    - Add a field assign task to show all the assigned task under that user