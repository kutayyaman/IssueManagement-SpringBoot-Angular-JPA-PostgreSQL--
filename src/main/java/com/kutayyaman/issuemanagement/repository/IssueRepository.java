package com.kutayyaman.issuemanagement.repository;

import com.kutayyaman.issuemanagement.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository //Spring IoC container icerisine bu IssueRepository'den 1 tane ornek konulacak ve biz bunu Autowired veya kurucu fonksiyon ile istedigimiz yere injecte edebilecez. Ama artik JpaRepository'den extends ediyorsa kendisi ekliyor bunu zaten.
public interface IssueRepository extends JpaRepository<Issue,Long> {

}
