package com.app.server.repository.newbc.newdomain;
import com.app.server.repository.core.SearchInterfaceImpl;
import com.app.shared.newbc.newdomain.Candidate;
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
@SourceCodeAuthorClass(createdBy = "taran2789@gmail.com", updatedBy = "taran2789@gmail.com", versionNumber = "2", comments = "Repository for Candidate Transaction table", complexity = Complexity.MEDIUM)
public class CandidateRepositoryImpl extends SearchInterfaceImpl implements CandidateRepository<Candidate> {

    @Autowired
    private ResourceFactoryManagerHelper emfResource;

    private LogManager Log = LogManagerFactory.getInstance(AppLoggerConstant.LOGGER_ID);

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Override
    @Transactional
    public List<Candidate> findAll() throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        java.util.List<com.app.shared.newbc.newdomain.Candidate> query = emanager.createQuery("select u from Candidate u where u.systemInfo.activeStatus=1").getResultList();
        Log.out.println("LKJLJ324100200", runtimeLogInfoHelper.getRequestHeaderBean(), "CandidateRepositoryImpl", "findAll", "Total Records Fetched = " + query.size());
        return query;
    }

    @Override
    @Transactional
    public Candidate save(Candidate entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        emanager.persist(entity);
        Log.out.println("LKJLJ322100200", runtimeLogInfoHelper.getRequestHeaderBean(), "CandidateRepositoryImpl", "save", entity);
        return entity;
    }

    @Override
    @Transactional
    public List<Candidate> save(List<Candidate> entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        for (int i = 0; i < entity.size(); i++) {
            com.app.shared.newbc.newdomain.Candidate obj = entity.get(i);
            emanager.persist(obj);
        }
        Log.out.println("LKJLJ322100200", runtimeLogInfoHelper.getRequestHeaderBean(), "CandidateRepositoryImpl", "saveAll", "Total Records saved = " + entity.size());
        return entity;
    }

    @Transactional
    @Override
    public void delete(String id) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        com.app.shared.newbc.newdomain.Candidate s = emanager.find(com.app.shared.newbc.newdomain.Candidate.class, id);
        emanager.remove(s);
        Log.out.println("LKJLJ328100200", runtimeLogInfoHelper.getRequestHeaderBean(), "CandidateRepositoryImpl", "delete", "Record Deleted");
    }

    @Override
    @Transactional
    public void update(Candidate entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        emanager.merge(entity);
        Log.out.println("LKJLJ321100200", runtimeLogInfoHelper.getRequestHeaderBean(), "CandidateRepositoryImpl", "update", entity);
    }

    @Override
    @Transactional
    public void update(List<Candidate> entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        for (int i = 0; i < entity.size(); i++) {
            com.app.shared.newbc.newdomain.Candidate obj = entity.get(i);
            emanager.merge(obj);
        }
        Log.out.println("LKJLJ321100200", runtimeLogInfoHelper.getRequestHeaderBean(), "CandidateRepositoryImpl", "updateAll", "Total Records updated = " + entity.size());
    }

    @Transactional
    public List<Candidate> findByInterviewere(String interviewere) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        javax.persistence.Query query = emanager.createNamedQuery("Candidate.findByInterviewere");
        query.setParameter("interviewere", interviewere);
        java.util.List<com.app.shared.newbc.newdomain.Candidate> listOfCandidate = query.getResultList();
        Log.out.println("LKJLJ324100200", runtimeLogInfoHelper.getRequestHeaderBean(), "CandidateRepositoryImpl", "findByInterviewere", "Total Records Fetched = " + listOfCandidate.size());
        return listOfCandidate;
    }

    @Transactional
    public Candidate findById(String candidateId) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        javax.persistence.Query query = emanager.createNamedQuery("Candidate.findById");
        query.setParameter("candidateId", candidateId);
        com.app.shared.newbc.newdomain.Candidate listOfCandidate = (com.app.shared.newbc.newdomain.Candidate) query.getSingleResult();
        Log.out.println("LKJLJ324100200", runtimeLogInfoHelper.getRequestHeaderBean(), "CandidateRepositoryImpl", "findById", "Total Records Fetched = " + listOfCandidate);
        return listOfCandidate;
    }
}
