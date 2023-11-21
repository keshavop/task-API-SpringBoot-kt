package com.example.taskapi.model

import jakarta.persistence.*

@Entity
data class Task(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var taskId: Int,
    var heading: String,
    var description: String,
    var priority: Int,
    var assignedUsers : Int

//    @ManyToOne
//    @JoinColumn(name = "assigned_user_id")
//    val assignedUser: Users? = null
)