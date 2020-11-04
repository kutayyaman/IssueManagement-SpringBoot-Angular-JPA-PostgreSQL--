package com.kutayyaman.issuemanagement.repo;

import com.kutayyaman.issuemanagement.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue,Long> {
    
}
