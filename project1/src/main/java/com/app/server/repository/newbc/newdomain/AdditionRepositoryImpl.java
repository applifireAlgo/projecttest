package com.app.server.repository.newbc.newdomain;
import com.app.server.repository.core.SearchInterfaceImpl;
import com.app.shared.newbc.newdomain.Addition;
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

@Repository
@SourceCodeAuthorClass(createdBy = "taran2789@gmail.com", updatedBy = "taran2789@gmail.com", versionNumber = "2", comments = "Repository for Addition Master table Entity", complexity = Complexity.LOW)
public class AdditionRepositoryImpl extends SearchInterfaceImpl implements AdditionRepository<Addition> {

    @Autowired
    private ResourceFactoryManagerHelper emfResource;

    private LogManager Log = LogManagerFactory.getInstance(AppLoggerConstant.LOGGER_ID);

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Override
    @Transactional
    public List<Addition> findAll() throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        java.util.List<com.app.shared.newbc.newdomain.Addition> query = emanager.createQuery("select u from Addition u where u.systemInfo.activeStatus=1").getResultList();
        Log.out.println("LKJLJ324100200", runtimeLogInfoHelper.getRequestHeaderBean(), "AdditionRepositoryImpl", "findAll", "Total Records Fetched = " + query.size());
        return query;
    }

    @Override
    @Transactional
    public Addition save(Addition entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        emanager.persist(entity);
        Log.out.println("LKJLJ322100200", runtimeLogInfoHelper.getRequestHeaderBean(), "AdditionRepositoryImpl", "save", entity);
        return entity;
    }

    @Override
    @Transactional
    public List<Addition> save(List<Addition> entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        for (int i = 0; i < entity.size(); i++) {
            com.app.shared.newbc.newdomain.Addition obj = entity.get(i);
            emanager.persist(obj);
        }
        Log.out.println("LKJLJ322100200", runtimeLogInfoHelper.getRequestHeaderBean(), "AdditionRepositoryImpl", "saveAll", "Total Records saved = " + entity.size());
        return entity;
    }

    @Transactional
    @Override
    public void delete(String id) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        com.app.shared.newbc.newdomain.Addition s = emanager.find(com.app.shared.newbc.newdomain.Addition.class, id);
        emanager.remove(s);
        Log.out.println("LKJLJ328100200", runtimeLogInfoHelper.getRequestHeaderBean(), "AdditionRepositoryImpl", "delete", "Record Deleted");
    }

    @Override
    @Transactional
    public void update(Addition entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        emanager.merge(entity);
        Log.out.println("LKJLJ321100200", runtimeLogInfoHelper.getRequestHeaderBean(), "AdditionRepositoryImpl", "update", entity);
    }

    @Override
    @Transactional
    public void update(List<Addition> entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        for (int i = 0; i < entity.size(); i++) {
            com.app.shared.newbc.newdomain.Addition obj = entity.get(i);
            emanager.merge(obj);
        }
        Log.out.println("LKJLJ321100200", runtimeLogInfoHelper.getRequestHeaderBean(), "AdditionRepositoryImpl", "updateAll", "Total Records updated = " + entity.size());
    }

    @Transactional
    public Addition findById(String additionId) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        javax.persistence.Query query = emanager.createNamedQuery("Addition.findById");
        query.setParameter("additionId", additionId);
        com.app.shared.newbc.newdomain.Addition listOfAddition = (com.app.shared.newbc.newdomain.Addition) query.getSingleResult();
        Log.out.println("LKJLJ324100200", runtimeLogInfoHelper.getRequestHeaderBean(), "AdditionRepositoryImpl", "findById", "Total Records Fetched = " + listOfAddition);
        return listOfAddition;
    }
}
