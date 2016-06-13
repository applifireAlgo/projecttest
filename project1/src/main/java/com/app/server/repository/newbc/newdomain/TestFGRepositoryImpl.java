package com.app.server.repository.newbc.newdomain;
import com.app.server.repository.core.SearchInterfaceImpl;
import com.app.shared.newbc.newdomain.TestFG;
import org.springframework.stereotype.Repository;
import com.app.config.annotation.Complexity;
import com.app.config.annotation.SourceCodeAuthorClass;
import com.athena.server.pluggable.utils.helper.ResourceFactoryManagerHelper;
import org.springframework.beans.factory.annotation.Autowired;
import com.spartan.pluggable.logger.alarms.AppAlarm;
import com.spartan.pluggable.logger.api.LogManagerFactory;
import com.athena.server.pluggable.utils.AppLoggerConstant;
import com.spartan.pluggable.logger.api.LogManager;
import com.athena.server.pluggable.utils.helper.RuntimeLogInfoHelper;
import java.lang.Override;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import com.app.shared.newbc.newdomain.FGPT;

@Repository
@SourceCodeAuthorClass(createdBy = "taran2789@gmail.com", updatedBy = "taran2789@gmail.com", versionNumber = "2", comments = "Repository for TestFG Transaction table", complexity = Complexity.MEDIUM)
public class TestFGRepositoryImpl extends SearchInterfaceImpl implements TestFGRepository<TestFG> {

    @Autowired
    private ResourceFactoryManagerHelper emfResource;

    private LogManager Log = LogManagerFactory.getInstance(AppLoggerConstant.LOGGER_ID);

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Override
    @Transactional
    public List<TestFG> findAll() throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        java.util.List<com.app.shared.newbc.newdomain.TestFG> query = emanager.createQuery("select u from TestFG u where u.systemInfo.activeStatus=1").getResultList();
        Log.out.println("LKJLJ324100200", runtimeLogInfoHelper.getRequestHeaderBean(), "TestFGRepositoryImpl", "findAll", "Total Records Fetched = " + query.size());
        return query;
    }

    @Override
    @Transactional
    public TestFG save(TestFG entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        emanager.persist(entity);
        Log.out.println("LKJLJ322100200", runtimeLogInfoHelper.getRequestHeaderBean(), "TestFGRepositoryImpl", "save", entity);
        return entity;
    }

    @Override
    @Transactional
    public List<TestFG> save(List<TestFG> entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        for (int i = 0; i < entity.size(); i++) {
            com.app.shared.newbc.newdomain.TestFG obj = entity.get(i);
            emanager.persist(obj);
        }
        Log.out.println("LKJLJ322100200", runtimeLogInfoHelper.getRequestHeaderBean(), "TestFGRepositoryImpl", "saveAll", "Total Records saved = " + entity.size());
        return entity;
    }

    @Transactional
    @Override
    public void delete(String id) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        com.app.shared.newbc.newdomain.TestFG s = emanager.find(com.app.shared.newbc.newdomain.TestFG.class, id);
        emanager.remove(s);
        Log.out.println("LKJLJ328100200", runtimeLogInfoHelper.getRequestHeaderBean(), "TestFGRepositoryImpl", "delete", "Record Deleted");
    }

    @Override
    @Transactional
    public void deleteFGPT(List<FGPT> fgpt) {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        for (com.app.shared.newbc.newdomain.FGPT _fgpt : fgpt) {
            com.app.shared.newbc.newdomain.FGPT s = emanager.find(com.app.shared.newbc.newdomain.FGPT.class, _fgpt.getPtPk());
            emanager.remove(s);
        }
    }

    @Override
    @Transactional
    public void update(TestFG entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        emanager.merge(entity);
        Log.out.println("LKJLJ321100200", runtimeLogInfoHelper.getRequestHeaderBean(), "TestFGRepositoryImpl", "update", entity);
    }

    @Override
    @Transactional
    public void update(List<TestFG> entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        for (int i = 0; i < entity.size(); i++) {
            com.app.shared.newbc.newdomain.TestFG obj = entity.get(i);
            emanager.merge(obj);
        }
        Log.out.println("LKJLJ321100200", runtimeLogInfoHelper.getRequestHeaderBean(), "TestFGRepositoryImpl", "updateAll", "Total Records updated = " + entity.size());
    }

    @Transactional
    public TestFG findById(String testFGid) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        javax.persistence.Query query = emanager.createNamedQuery("TestFG.findById");
        query.setParameter("testFGid", testFGid);
        com.app.shared.newbc.newdomain.TestFG listOfTestFG = (com.app.shared.newbc.newdomain.TestFG) query.getSingleResult();
        Log.out.println("LKJLJ324100200", runtimeLogInfoHelper.getRequestHeaderBean(), "TestFGRepositoryImpl", "findById", "Total Records Fetched = " + listOfTestFG);
        return listOfTestFG;
    }
}
