package org.riwi.tasks.Tasks;


import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/tasks")
    public TaskResponseDto post(
            @Valid @RequestBody TasksDto taskDto
    ){
        return taskService.saveTask(taskDto);
    }

    @GetMapping("/tasks/{task-id}")
    public TaskResponseDto findTaskById(
            @PathVariable("task-id") Integer id
    ) {
        return taskService.findTaskById(id);
    }

    @GetMapping("/tasks")
    public List<TaskResponseDto> findAllTasks(){
        return taskService.findAllTasks();
    }

    @GetMapping("/tasks/search/{task-title}")
    public List<TaskResponseDto> findTasksByTitle(
            @PathVariable("task-title") String title
    ){
        return taskService.findTasksByTitle(title);
    }

    @DeleteMapping("task/{task-id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(
            @PathVariable("task-id") Integer id
    ){
        taskService.delete(id);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exp
    ) {
        var errors = new HashMap<String, String>();
        exp.getBindingResult().getAllErrors()
                .forEach(error -> {
                    var fieldName = ((FieldError) error).getField();
                    var errorMessage = error.getDefaultMessage();
                    errors.put(fieldName, errorMessage);
                });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
