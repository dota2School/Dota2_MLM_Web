package org.dota2school.mlm.web.respository;


import org.dota2school.mlm.web.domain.StudentCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 *
 * @author xujq
 * @time 2017-7-30
 */
public interface StudentCountRespository extends
        JpaRepository<StudentCount,String>,
        JpaSpecificationExecutor<StudentCount> {
}
