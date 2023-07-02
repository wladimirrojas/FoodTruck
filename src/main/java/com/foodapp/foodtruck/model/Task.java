package com.foodapp.foodtruck.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("tasks")
public class Task {

    @Id
    private String id;
    private String title;
    private String description;
    @JsonProperty("creation_date")
    private LocalDateTime creationDate;
    private boolean completed;
    @JsonProperty("creator_rut")
    private String creatorRut;

}
