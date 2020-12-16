package com.kutayyaman.issuemanagement.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Project Data Transfer Object") //Swagger icin
public class ProjectDto {

    @ApiModelProperty(value = "Id Of Project") //Swagger icin
    private Long id;

    @NotNull
    @ApiModelProperty(required = true,value = "Name Of Project")
    private String projectName;

    @NotNull
    @ApiModelProperty(required = true,value = "Code Of Project")
    private String projectCode;

    @NotNull
    @ApiModelProperty(required = true,value = "Project Manager ID")
    private String managerId;

}
