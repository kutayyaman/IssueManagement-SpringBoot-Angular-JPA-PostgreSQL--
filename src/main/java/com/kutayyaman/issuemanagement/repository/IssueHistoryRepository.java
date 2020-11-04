package com.kutayyaman.issuemanagement.repository;

import com.kutayyaman.issuemanagement.entity.IssueHistory;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository //Spring IoC container icerisine bu IssueHistoryRepository'den 1 tane ornek konulacak ve biz bunu Autowired veya kurucu fonksiyon ile istedigimiz yere injecte edebilecez. Ama artik JpaRepository'den extends ediyorsa kendisi ekliyor bunu zaten.
public interface IssueHistoryRepository extends JpaRepository<IssueHistory,Long> {

}
