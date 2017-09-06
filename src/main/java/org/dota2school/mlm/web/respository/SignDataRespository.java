package org.dota2school.mlm.web.respository;

import org.dota2school.mlm.web.domain.SignData;
import org.dota2school.mlm.web.domain.SignStudentPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 *
 * @author xujq
 * @time 2017-7-26
 */
public interface SignDataRespository extends
        JpaRepository<SignData,SignStudentPK>,
        JpaSpecificationExecutor<SignData> {
}
