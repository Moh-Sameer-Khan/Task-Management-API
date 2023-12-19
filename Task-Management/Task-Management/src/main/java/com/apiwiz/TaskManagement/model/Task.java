package com.apiwiz.TaskManagement.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer taskId;

    @NotBlank(message = "Task description can not be blank")
    @Column(nullable = false)
    private String taskDescription;

    @NotBlank(message = "Post Title can not be blank")
    @Column(nullable = false)
    private String postTitle;

//    @JsonProperty(access = JsonProperty.Access.READ_ONLY) // hide this in json but not in database table column
    private LocalDateTime taskDueDate;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY) // hide this in json but not in database table column
    private boolean status; /// Pending , progress and completed

    @ManyToOne
//    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JoinColumn(name = "fk_task_user_id")
    private User taskOwner;
}
