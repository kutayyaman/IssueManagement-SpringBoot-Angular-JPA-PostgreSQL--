package com.kutayyaman.issuemanagement.service.impl;

import com.kutayyaman.issuemanagement.entity.IssueHistory;
import com.kutayyaman.issuemanagement.repository.IssueHistoryRepository;
import com.kutayyaman.issuemanagement.service.IssueHistoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service //IoC contanerda singleton instancelari olusturacak bu anatasyon boylelikle @Autowired diyerek veya kurucu ile injecti edebilecez
public class IssueHistoryServiceImpl implements IssueHistoryService {

    private final IssueHistoryRepository issueHistoryRepository;

    public IssueHistoryServiceImpl(IssueHistoryRepository issueHistoryRepository){
        this.issueHistoryRepository = issueHistoryRepository;
    }


    @Override
    public IssueHistory save(IssueHistory issueHistory) {

        if(issueHistory.getDate() == null){
            throw new IllegalArgumentException("Date Cannot Be Null");
        }

        return issueHistoryRepository.save(issueHistory);

    }

    @Override
    public IssueHistory getById(Long id) {
        return issueHistoryRepository.getOne(id);
    }

    @Override
    public Page<IssueHistory> getAllPageable(Pageable pageable) {
        return issueHistoryRepository.findAll(pageable);
    }

    @Override
    public Boolean delete(IssueHistory issueHistory) {
        issueHistoryRepository.delete(issueHistory);
        return Boolean.TRUE;
    }
}
