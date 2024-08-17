package org.riwi.tasks.Tasks;

import org.riwi.tasks.Users.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class TaskMapper {
    public TaskEntity toTask(TasksDto taskDto){
        var task = new TaskEntity();
        task.setTitle(taskDto.title());
        task.setDescription(taskDto.description());
        task.setCreationDate(taskDto.creationDate());
        task.setCreationTime(taskDto.creationTime());
        task.setState(taskDto.state());

        var user = new UserEntity();
        user.setId(taskDto.id_user());

        task.setUser(user);
        return task;
    }

    public TaskResponseDto toTaskResponseDto(TaskEntity task){
        return new TaskResponseDto(
                task.getTitle(),
                task.getDescription(),
                task.getCreationDate(),
                task.getCreationTime(),
                task.getState()
        );
    }
}
