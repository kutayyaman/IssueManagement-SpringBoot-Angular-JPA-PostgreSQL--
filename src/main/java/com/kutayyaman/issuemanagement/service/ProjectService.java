package com.kutayyaman.issuemanagement.service;

import com.kutayyaman.issuemanagement.dto.ProjectDto;
import com.kutayyaman.issuemanagement.entity.Project;
import com.kutayyaman.issuemanagement.util.TPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectService {

    ProjectDto save(ProjectDto project);

    ProjectDto getById(Long id);

    ProjectDto getByProjectCode(String projectCode);

    List<Project> getByProjectCodeContains(String projectCode);

    TPage<ProjectDto> getAllPageable(Pageable pageable);

    Boolean delete(Project project);

    Boolean delete(Long id);

    ProjectDto update(Long id, ProjectDto projectDto);


}
