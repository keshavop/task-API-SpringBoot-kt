package com.example.taskapi.dao

import com.example.taskapi.model.Users
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository:JpaRepository<Users,Int> {
}