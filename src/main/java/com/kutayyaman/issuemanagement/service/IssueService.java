package com.kutayyaman.issuemanagement.service;

import com.kutayyaman.issuemanagement.dto.IssueDto;
import com.kutayyaman.issuemanagement.entity.Issue;
import com.kutayyaman.issuemanagement.util.TPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IssueService {

    IssueDto save(IssueDto issue);

    IssueDto getById(Long id);

    TPage<IssueDto> getAllPageable(Pageable pageable);

    Boolean delete(IssueDto issue);

}
