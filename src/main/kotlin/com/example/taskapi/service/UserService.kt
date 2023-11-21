package com.example.taskapi.service

import com.example.taskapi.dao.UserRepository
import com.example.taskapi.model.Users
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    fun getAllUsers(): List<Users> {
        return userRepository.findAll()
    }

    fun getUserById(userId: Int): Users? {
        return userRepository.findById(userId).orElse(null)
    }

    fun addUser(user: Users): Users {
        return userRepository.save(user)
    }

//    fun updateUser(userId: Int, updatedUser: Users): Users? {
//        val existingUser = getUserById(userId)
//        return if (existingUser != null) {
//            existingUser.username = updatedUser.username
//            userRepository.save(existingUser)
//        } else {
//            null
//        }
//    }

    fun updateUser(userId: Int, updatedUser: Users): Users? {
        val existingUser = userRepository.findById(userId)
        if (existingUser.isPresent) {
            val userToUpdate = existingUser.get()
            userToUpdate.apply {
                username = updatedUser.username
                role = updatedUser.role
                // Add other properties you want to update
            }
            return userRepository.save(userToUpdate)
        }
        return null // User not found
    }

    fun partialUpdateUser(userId: Int, updatedUser: Users): Users? {
        val existingUser = userRepository.findById(userId)
        if (existingUser.isPresent) {
            val userToUpdate = existingUser.get()
            userToUpdate.apply {
                username = updatedUser.username ?: username
                role = updatedUser.role ?: role
                // Add other properties you want to partially update
            }
            return userRepository.save(userToUpdate)
        }
        return null // User not found
    }


    fun deleteUser(userId: Int): Boolean {
        return if (userRepository.existsById(userId)) {
            userRepository.deleteById(userId)
            true
        } else {
            false
        }
    }
}