package org.dota2school.mlm.web.respository;


import org.dota2school.mlm.web.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 *
 * @author xujq
 * @time 2017-7-10
 */
public interface UserRespository  extends JpaRepository<User,String>,JpaSpecificationExecutor<User> {
}
