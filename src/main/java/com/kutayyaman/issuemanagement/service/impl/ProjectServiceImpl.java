package com.kutayyaman.issuemanagement.service.impl;

import com.kutayyaman.issuemanagement.entity.Project;
import com.kutayyaman.issuemanagement.repository.ProjectRepository;
import com.kutayyaman.issuemanagement.service.ProjectService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service//IoC contanerda singleton instancelari olusturacak bu anatasyon boylelikle @Autowired diyerek veya kurucu ile injecti edebilecez
public class ProjectServiceImpl implements ProjectService {

    private  final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository){
        this.projectRepository = projectRepository;
    }

    @Override
    public Project save(Project project) {

        if(project.getProjectCode() == null){
            throw new IllegalArgumentException("Project Code Cannot Be Null");
        }

        return projectRepository.save(project);

    }

    @Override
    public Project getById(Long id) {

        return projectRepository.getOne(id);
    }

    @Override
    public List<Project> getByProjectCode(String projectCode) {

        return projectRepository.getByProjectCode(projectCode);
    }

    @Override
    public List<Project> getByProjectCodeContains(String projectCode) {

        return projectRepository.getByProjectCodeContains(projectCode);
    }

    @Override
    public Page<Project> getAllPageable(Pageable pageable) {

        return projectRepository.findAll(pageable);
    }

    @Override
    public Boolean delete(Project project) {

        projectRepository.delete(project);
        return Boolean.TRUE;

    }
}
