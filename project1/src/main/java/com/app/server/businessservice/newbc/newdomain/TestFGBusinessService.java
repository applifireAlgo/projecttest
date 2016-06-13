package com.app.server.businessservice.newbc.newdomain;
import com.app.server.repository.newbc.newdomain.TestFGRepository;
import com.app.shared.newbc.newdomain.TestFG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class TestFGBusinessService {

    @Autowired
    private TestFGRepository testFGRepository;

    public void update(TestFG entity) throws Exception {
        if (entity.isHardDelete()) {
            testFGRepository.delete(entity.getTestFGid());
        } else {
            testFGRepository.deleteFGPT(entity.getDeletedFGPTList());
            testFGRepository.update(entity);
        }
    }

    public void update(List<TestFG> entity) throws Exception {
        for (TestFG _testfg : entity) {
            if (_testfg.isHardDelete()) {
                testFGRepository.delete(_testfg.getTestFGid());
            } else {
                testFGRepository.deleteFGPT(_testfg.getDeletedFGPTList());
                testFGRepository.update(_testfg);
            }
        }
    }
}
