package com.jailtoncode.todolistyoutube.service;

import com.jailtoncode.todolistyoutube.model.Task;
import com.jailtoncode.todolistyoutube.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {


    private TaskRepository taskRepository;

    public Task creaTask(Task task){
        return taskRepository.save(task);
    }

    public List<Task> listAllTasks(){
        return taskRepository.findAll();
    }

    public ResponseEntity<Task> finTaskById(Long id){
        return taskRepository.findById(id)
                .map(task -> ResponseEntity.ok().body(task))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Task> updadeTaskById(Task task, Long id){
        return taskRepository.findById(id)
                .map(taskToUpadte -> {
                    taskToUpadte.setTitle(task.getTitle());
                    taskToUpadte.setDescription(task.getDescription());
                    taskToUpadte.setDeadLine(task.getDeadLine());
                    Task updated = taskRepository.save(taskToUpadte);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Object> deleteById(Long id){
        return taskRepository.findById(id)
                .map(taskTodlete ->{
                    taskRepository.deleteById(id);
                    return ResponseEntity.noContent().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
