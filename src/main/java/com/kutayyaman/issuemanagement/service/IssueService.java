package com.kutayyaman.issuemanagement.service;

import com.kutayyaman.issuemanagement.dto.IssueDto;
import com.kutayyaman.issuemanagement.util.TPage;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IssueService {

    IssueDto save(IssueDto issue);

    IssueDto getById(Long id);

    TPage<IssueDto> getAllPageable(Pageable pageable);

    Boolean delete(IssueDto issue);

    Boolean deleteById(Long id);

    IssueDto update(Long id, IssueDto issueDto);

    List<IssueDto> getAll();

}
