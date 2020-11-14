package com.kutayyaman.issuemanagement.dto;

import com.kutayyaman.issuemanagement.entity.IssueStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Issue Data Transfer Object") //Swagger icin
public class IssueDto {

    @ApiModelProperty(value = "Id Of Issue") //Swagger icin
    private Long id;
    @ApiModelProperty(required = true, value = "description Of Issue") //Swagger icin
    private String description;
    @ApiModelProperty(required = true, value = "details Of Issue") //Swagger icin
    private String details;
    @ApiModelProperty(required = true, value = "date Of Issue") //Swagger icin
    private Date date;
    @ApiModelProperty(required = true, value = "issueStatus Of Issue") //Swagger icin
    private IssueStatus issueStatus;
    @ApiModelProperty(required = true, value = "assignee Of Issue") //Swagger icin
    private UserDto assignee;
    @ApiModelProperty(required = true, value = "project Of Issue") //Swagger icin
    private ProjectDto project;


}
