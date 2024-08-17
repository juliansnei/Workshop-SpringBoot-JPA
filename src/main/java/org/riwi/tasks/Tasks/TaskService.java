package org.riwi.tasks.Tasks;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {
    private final TaskRepository repository;
    private final TaskMapper taskMapper;

    public TaskService(TaskRepository repository, TaskMapper taskMapper) {
        this.repository = repository;
        this.taskMapper = taskMapper;
    }

    public TaskResponseDto saveTask(TasksDto taskDto){
        var task = taskMapper.toTask(taskDto);
        var savedTask = repository.save(task);
        return taskMapper.toTaskResponseDto(savedTask);
    }

    public List<TaskResponseDto> findAllTasks(){
        return repository.findAll()
                .stream()
                .map(taskMapper::toTaskResponseDto)
                .collect(Collectors.toList());
    }

    public TaskResponseDto findTaskById(Integer id){
        return repository.findById(id)
                .map(taskMapper::toTaskResponseDto)
                .orElse(null);
    }

    public List<TaskResponseDto> findTasksByTitle(String title){
        return repository.findAllByTitleContaining(title)
                .stream()
                .map(taskMapper::toTaskResponseDto)
                .collect(Collectors.toList());
    }

    public void delete(Integer id){
        repository.deleteById(id);
    }
}
