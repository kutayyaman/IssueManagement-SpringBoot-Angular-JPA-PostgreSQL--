package com.kutayyaman.issuemanagement.service.impl;

import com.kutayyaman.issuemanagement.dto.ProjectDto;
import com.kutayyaman.issuemanagement.entity.Project;
import com.kutayyaman.issuemanagement.repository.ProjectRepository;
import com.kutayyaman.issuemanagement.service.ProjectService;
import com.kutayyaman.issuemanagement.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.List;


@Service//IoC contanerda singleton instancelari olusturacak bu anatasyon boylelikle @Autowired diyerek veya kurucu ile injecti edebilecez
public class ProjectServiceImpl implements ProjectService {

    private  final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;

    public ProjectServiceImpl(ProjectRepository projectRepository, ModelMapper modelMapper){

        this.projectRepository = projectRepository;
        this.modelMapper = modelMapper;
    }

    private void projectCodeValidation(String projectCode) {
        if(projectRepository.getByProjectCode(projectCode) != null){
            throw new IllegalArgumentException("Project Code Already Exist");
        }
    }

    @Override
    public ProjectDto save(ProjectDto projectDto) {
        projectCodeValidation(projectDto.getProjectCode());

        Project project = modelMapper.map(projectDto, Project.class);

        project = projectRepository.save(project);

        projectDto.setId(project.getId());

        return projectDto;
    }

    @Override
    public ProjectDto getById(Long id) {
        Project project = projectRepository.getOne(id);
        ProjectDto projectDto = modelMapper.map(project, ProjectDto.class);
        return projectDto;
    }

    @Override
    public ProjectDto getByProjectCode(String projectCode) {

        return null;
    }

    @Override
    public List<Project> getByProjectCodeContains(String projectCode) {

        return projectRepository.getByProjectCodeContains(projectCode);
    }

    @Override
    public TPage<ProjectDto> getAllPageable(Pageable pageable) {

        Page<Project> data = projectRepository.findAll(pageable);
        TPage<ProjectDto> response = new TPage<ProjectDto>(data, Arrays.asList(modelMapper.map(data.getContent(), ProjectDto[].class)));
        return response;
    }

    @Override
    public Boolean delete(Project project) {

        projectRepository.delete(project);
        return Boolean.TRUE;

    }

    public Boolean delete(Long id){
        projectRepository.deleteById(id);
        return Boolean.TRUE;
    }

    @Override
    public ProjectDto update(Long id, ProjectDto projectDto) {
        Project project = projectRepository.getOne(id);
        if(project == null){
            throw new IllegalArgumentException("Project Does Not Exist ID:" +id);
        }

        Project projectCheck = projectRepository.getByProjectCodeAndIdNot(projectDto.getProjectCode(),id);
        if(projectCheck != null){
            throw new IllegalArgumentException("Project Code Already Exist");
        }

        project.setProjectCode(projectDto.getProjectCode());
        project.setProjectName(projectDto.getProjectName());

        project = projectRepository.save(project); //id'si ile beraber gittigi icin bu sefer ekleme degil update modunda calisacak bu save methodu.
        return modelMapper.map(project,ProjectDto.class);
    }
}
