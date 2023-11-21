package com.example.taskapi.controller

import com.example.taskapi.dao.TaskRepository
import com.example.taskapi.model.Task
import com.example.taskapi.service.TaskService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/tasks")
class TaskController(private val taskService: TaskService) {

    @GetMapping
    fun getAllTask(): List<Task>{
        return taskService.getAllTasks()
    }

    @GetMapping("/{taskId}")
    fun getTaskById(@PathVariable taskId: Int):Task?{
        return taskService.getTasksById(taskId)
    }

    @PostMapping
    fun addTask(@RequestBody task: Task):Task{
        return taskService.addTask(task)
    }

//    @PutMapping("/{taskId}")
//    fun updateTask(@PathVariable taskId: Int, @RequestBody updateTask: Task):Task?{
//        return taskService.updateTask(taskId, updateTask)
//    }

    @PutMapping("/{taskId}")
    fun updateTask(@PathVariable taskId: Int, @RequestBody updatedTask: Task): Task? {
        return taskService.updateTask(taskId, updatedTask)
    }

    @PatchMapping("/{taskId}")
    fun partialUpdateTask(@PathVariable taskId: Int, @RequestBody updatedTask: Task): Task? {
        return taskService.partialUpdateTask(taskId, updatedTask)
    }

    @DeleteMapping("/{taskId}")
    fun deleteTask(@PathVariable taskId:Int): Boolean{
        return taskService.deleteTask(taskId)
    }

    @PostMapping("/{taskId}/assign/{userId}")
    fun assignTask(@PathVariable taskId: Int, @PathVariable assignedUsers: Int): Task? {
        return taskService.assignTask(taskId, assignedUsers)
    }
}