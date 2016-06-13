package com.app.server.repository.newbc.newdomain;
import com.app.server.repository.core.SearchInterfaceImpl;
import com.app.shared.newbc.newdomain.Interviewer;
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
@SourceCodeAuthorClass(createdBy = "taran2789@gmail.com", updatedBy = "taran2789@gmail.com", versionNumber = "2", comments = "Repository for Interviewer Master table Entity", complexity = Complexity.LOW)
public class InterviewerRepositoryImpl extends SearchInterfaceImpl implements InterviewerRepository<Interviewer> {

    @Autowired
    private ResourceFactoryManagerHelper emfResource;

    private LogManager Log = LogManagerFactory.getInstance(AppLoggerConstant.LOGGER_ID);

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Override
    @Transactional
    public List<Interviewer> findAll() throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        java.util.List<com.app.shared.newbc.newdomain.Interviewer> query = emanager.createQuery("select u from Interviewer u where u.systemInfo.activeStatus=1").getResultList();
        Log.out.println("LKJLJ324100200", runtimeLogInfoHelper.getRequestHeaderBean(), "InterviewerRepositoryImpl", "findAll", "Total Records Fetched = " + query.size());
        return query;
    }

    @Override
    @Transactional
    public Interviewer save(Interviewer entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        emanager.persist(entity);
        Log.out.println("LKJLJ322100200", runtimeLogInfoHelper.getRequestHeaderBean(), "InterviewerRepositoryImpl", "save", entity);
        return entity;
    }

    @Override
    @Transactional
    public List<Interviewer> save(List<Interviewer> entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        for (int i = 0; i < entity.size(); i++) {
            com.app.shared.newbc.newdomain.Interviewer obj = entity.get(i);
            emanager.persist(obj);
        }
        Log.out.println("LKJLJ322100200", runtimeLogInfoHelper.getRequestHeaderBean(), "InterviewerRepositoryImpl", "saveAll", "Total Records saved = " + entity.size());
        return entity;
    }

    @Transactional
    @Override
    public void delete(String id) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        com.app.shared.newbc.newdomain.Interviewer s = emanager.find(com.app.shared.newbc.newdomain.Interviewer.class, id);
        emanager.remove(s);
        Log.out.println("LKJLJ328100200", runtimeLogInfoHelper.getRequestHeaderBean(), "InterviewerRepositoryImpl", "delete", "Record Deleted");
    }

    @Override
    @Transactional
    public void update(Interviewer entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        emanager.merge(entity);
        Log.out.println("LKJLJ321100200", runtimeLogInfoHelper.getRequestHeaderBean(), "InterviewerRepositoryImpl", "update", entity);
    }

    @Override
    @Transactional
    public void update(List<Interviewer> entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        for (int i = 0; i < entity.size(); i++) {
            com.app.shared.newbc.newdomain.Interviewer obj = entity.get(i);
            emanager.merge(obj);
        }
        Log.out.println("LKJLJ321100200", runtimeLogInfoHelper.getRequestHeaderBean(), "InterviewerRepositoryImpl", "updateAll", "Total Records updated = " + entity.size());
    }

    @Transactional
    public Interviewer findById(String interviewrId) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        javax.persistence.Query query = emanager.createNamedQuery("Interviewer.findById");
        query.setParameter("interviewrId", interviewrId);
        com.app.shared.newbc.newdomain.Interviewer listOfInterviewer = (com.app.shared.newbc.newdomain.Interviewer) query.getSingleResult();
        Log.out.println("LKJLJ324100200", runtimeLogInfoHelper.getRequestHeaderBean(), "InterviewerRepositoryImpl", "findById", "Total Records Fetched = " + listOfInterviewer);
        return listOfInterviewer;
    }
}
