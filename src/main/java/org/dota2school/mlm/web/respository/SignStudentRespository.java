package org.dota2school.mlm.web.respository;


import org.dota2school.mlm.web.domain.SignStudentUser;
import org.dota2school.mlm.web.domain.SignStudentPK;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author xujq
 * @time 2017-7-26
 */
public interface SignStudentRespository extends JpaRepository<SignStudentUser,SignStudentPK>{

}
