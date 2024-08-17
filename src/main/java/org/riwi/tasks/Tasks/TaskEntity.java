package org.riwi.tasks.Tasks;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.riwi.tasks.Users.UserEntity;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, nullable = false)
    private String title;
    @Column(length = 255, nullable = true)
    private String description;
    @Column(nullable = false)
    private LocalDate creationDate;
    @Column(nullable = false)
    private LocalTime creationTime;
    @Column(length = 50, nullable = false)
    private String state;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user")
    @JsonBackReference
    private UserEntity user;

    public TaskEntity() {
    }

    public TaskEntity(Long id, String title, String description, LocalDate creationDate, LocalTime creationTime, String state) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
        this.creationTime = creationTime;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalTime creationTime) {
        this.creationTime = creationTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "TaskEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", creationDate=" + creationDate +
                ", creationTime=" + creationTime +
                ", state='" + state + '\'' +
                '}';
    }
}
