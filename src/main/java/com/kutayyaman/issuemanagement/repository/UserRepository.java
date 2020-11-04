package com.kutayyaman.issuemanagement.repository;

import com.kutayyaman.issuemanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository //Spring IoC container icerisine bu UserRepository'den 1 tane ornek konulacak ve biz bunu Autowired veya kurucu fonksiyon ile istedigimiz yere injecte edebilecez. Ama artik JpaRepository'den extends ediyorsa kendisi ekliyor bunu zaten.
public interface UserRepository extends JpaRepository<User,Long> {

}
