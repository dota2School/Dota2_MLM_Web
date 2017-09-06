package org.dota2school.mlm.web.respository;


import org.dota2school.mlm.web.domain.SignUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author xujq
 * @time 2017-7-26
 */
public interface SignRespository  extends JpaRepository<SignUser,Integer> {

}
