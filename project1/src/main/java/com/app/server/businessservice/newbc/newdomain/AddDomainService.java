package com.app.server.businessservice.newbc.newdomain;
import com.app.server.repository.newbc.newdomain.AdditionRepository;
import com.app.shared.newbc.newdomain.Addition;
import com.athena.server.pluggable.utils.helper.RuntimeLogInfoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddDomainService {

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private AdditionRepository<Addition> additionRepository;

    public void addM(Addition entity) throws Exception {
        entity.setTotal(entity.getNum1() + entity.getNum2());
        com.app.shared.newbc.newdomain.Addition addition1 = additionRepository.save(entity);
    }
}
