package com.kutayyaman.issuemanagement.repository;

import com.kutayyaman.issuemanagement.entity.Project;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;

import java.util.List;

//@Repository //Spring IoC container icerisine bu ProjectRepository'den 1 tane ornek konulacak ve biz bunu Autowired veya kurucu fonksiyon ile istedigimiz yere injecte edebilecez. Ama artik JpaRepository'den extends ediyorsa kendisi ekliyor bunu zaten.
public interface ProjectRepository extends JpaRepository<Project,Long> {

    Project getByProjectCode(String projectCode);

    List<Project> getByProjectCodeContains(String projectCode);

    Page<Project> findAll(Pageable pageable);

    List<Project> findAll(Sort sort);

    Project getByProjectCodeAndIdNot(String projectCode,Long id); //verdigmiz projecode'una sahip ve id'si verdigmiz id olmayani getir demis olduk.

}
