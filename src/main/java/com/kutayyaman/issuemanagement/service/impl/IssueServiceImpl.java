package com.kutayyaman.issuemanagement.service.impl;

import com.kutayyaman.issuemanagement.dto.IssueDto;
import com.kutayyaman.issuemanagement.entity.Issue;
import com.kutayyaman.issuemanagement.repository.IssueRepository;
import com.kutayyaman.issuemanagement.service.IssueService;
import com.kutayyaman.issuemanagement.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;


@Service//IoC contanerda singleton instancelari olusturacak bu anatasyon boylelikle @Autowired diyerek veya kurucu ile injecti edebilecez
public class IssueServiceImpl implements IssueService {

    /*@Autowired //@Autowired anatasyonunun gorevi IoC container'i icerisinde bulunan o classin instance'ini getirip ilgili property'e injecte ediyor.
    private IssueRepository issueRepository;
    //bu 1. injecte etme yontemimiz buda olur veya kurucuya parametre olarak verirsek oda olur.
    //best practice olan kurucuda injecte etmektir.
    */

    private final IssueRepository issueRepository;
    private final ModelMapper modelMapper;

    //@Autowired eskiden bunu buraya yazmamiz gerekiyordu ama artik springin yeni versiyonlarinda gerek yok.
    public IssueServiceImpl(IssueRepository issueRepository,ModelMapper modelMapper){
        this.issueRepository = issueRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public IssueDto save(IssueDto issue) {

        if(issue.getDate() == null){
            throw new IllegalArgumentException("Issue Date Cannot Be Null");
        }

        Issue issueDb = modelMapper.map(issue, Issue.class);

        issueDb = issueRepository.save(issueDb);

        return modelMapper.map(issueDb,IssueDto.class);
    }

    @Override
    public IssueDto getById(Long id) {
        Issue issueDb = issueRepository.getOne(id);

        return modelMapper.map(issueDb,IssueDto.class);
    }

    @Override
    public TPage<IssueDto> getAllPageable(Pageable pageable) {

        Page<Issue> page = issueRepository.findAll(pageable);

        IssueDto[] dtos = modelMapper.map(page.getContent(), IssueDto[].class);

        return new TPage<IssueDto>(page, Arrays.asList(dtos));
    }

    @Override
    public Boolean delete(IssueDto issue) {
        Issue issueDb = modelMapper.map(issue,Issue.class);
        issueRepository.delete(issueDb);
        return Boolean.TRUE;

    }

    @Override
    public Boolean deleteById(Long id) {
        issueRepository.deleteById(id);
        return true;
    }

    @Override
    public IssueDto update(Long id, IssueDto issueDto) {

        return null;
    }


}
