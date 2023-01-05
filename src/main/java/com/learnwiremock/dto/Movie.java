package com.learnwiremock.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Movie implements Serializable {

    private Long movie_id;

    private String name;

    private Integer year;

    private String cast;

//    @JsonSerialize(using = ToStringSerializer.class)
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private String release_date;
}
