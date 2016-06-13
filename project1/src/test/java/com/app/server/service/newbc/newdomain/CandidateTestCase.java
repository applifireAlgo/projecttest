package com.app.server.service.newbc.newdomain;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.newbc.newdomain.CandidateRepository;
import com.app.shared.newbc.newdomain.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.server.pluggable.utils.helper.RuntimeLogInfoHelper;
import com.athena.server.pluggable.utils.helper.EntityValidatorHelper;
import com.app.server.service.RandomValueGenerator;
import java.util.HashMap;
import java.util.List;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.springframework.mock.web.MockServletContext;
import com.spartan.pluggable.logger.api.LogManagerFactory;
import com.athena.server.pluggable.utils.AppLoggerConstant;
import com.spartan.pluggable.logger.api.LogManager;
import com.spartan.pluggable.logger.event.RequestHeaderBean;
import com.spartan.pluggable.logger.api.RuntimeLogUserInfoBean;
import com.athena.server.pluggable.interfaces.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import com.app.shared.newbc.newdomain.Interviewer;
import com.app.server.repository.newbc.newdomain.InterviewerRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class CandidateTestCase extends EntityTestCriteria {

    @Autowired
    private CandidateRepository<Candidate> candidateRepository;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private EntityValidatorHelper<Object> entityValidator;

    private RandomValueGenerator valueGenerator = new RandomValueGenerator();

    private static HashMap<String, Object> map = new HashMap<String, Object>();

    private static List<EntityTestCriteria> entityContraint;

    @Autowired
    private ArtMethodCallStack methodCallStack;

    protected MockHttpSession session;

    protected MockHttpServletRequest request;

    protected MockHttpServletResponse response;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        MockServletContext mockServletContext = new MockServletContext("file:src/main/webapp");
        try {
            String _path = mockServletContext.getRealPath("/WEB-INF/conf/");
            LogManagerFactory.createLogManager(_path, AppLoggerConstant.LOGGER_ID);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void startSession() {
        session = new MockHttpSession();
    }

    protected void endSession() {
        session.clearAttributes();
        session.invalidate();
        session = null;
    }

    protected void startRequest() {
        request = new MockHttpServletRequest();
        request.setSession(session);
        org.springframework.web.context.request.RequestContextHolder.setRequestAttributes(new org.springframework.web.context.request.ServletRequestAttributes(request));
    }

    protected void endRequest() {
        ((org.springframework.web.context.request.ServletRequestAttributes) org.springframework.web.context.request.RequestContextHolder.getRequestAttributes()).requestCompleted();
        org.springframework.web.context.request.RequestContextHolder.resetRequestAttributes();
        request = null;
    }

    @Before
    public void before() {
        startSession();
        startRequest();
        setBeans();
    }

    @After
    public void after() {
        endSession();
        endRequest();
    }

    private void setBeans() {
        runtimeLogInfoHelper.createRuntimeLogUserInfo("customer", "AAAAA", request.getRemoteHost());
        org.junit.Assert.assertNotNull(runtimeLogInfoHelper);
        methodCallStack.setRequestId(java.util.UUID.randomUUID().toString().toUpperCase());
        entityContraint = addingListOfFieldForNegativeTesting();
        runtimeLogInfoHelper.setRequestHeaderBean(new RequestHeaderBean(new RuntimeLogUserInfoBean("AAAA", "AAAA", request.getRemoteHost(), 0, 0, 0), "", methodCallStack.getRequestId()));
    }

    private Candidate createCandidate(Boolean isSave) throws Exception {
        Interviewer interviewer = new Interviewer();
        interviewer.setInterviewerr("LpjFyubwijAvyK9EkhOI2Q9bYHnQ4Y5HsfCBohMu7pjCCfIkXp");
        Interviewer InterviewerTest = new Interviewer();
        if (isSave) {
            InterviewerTest = interviewerRepository.save(interviewer);
            map.put("InterviewerPrimaryKey", interviewer._getPrimarykey());
        }
        Candidate candidate = new Candidate();
        candidate.setCandidateName("5GgpY2gPbWlv1FxZiio4grX4TkEPiGUcLWt06d4aAdp6tfKd21");
        candidate.setEmailid("xMUoRi14qqr7HFR9izASYLd8dcbxbLqPQTV9FCz4LGRBThRM29");
        candidate.setCultureFit("QkIwwysgUxxIAVQLbWg5wHDhi2f1to2NsoHdh3649nmsqzYXNN");
        candidate.setStar("kS0IYPxuzJHCS6lpJjmAHwb2sp8UJm1ittmayD7gyoxTZ2Rfa8");
        candidate.setRecommendHire("DOO5y0CKKfkg04K1pj8SxCTyT1lS81bKwkyDpR9XRDEyLxKh1c");
        candidate.setGrowthPotential("3FI86v6XODhRJdVJJm4P9uExAtlXfhmosG16b2vamvQgcuwzyW");
        candidate.setNote("GMuTF7k2Bu9MaOZsnfY6QNZFOzSZPRmfpPtNvIubPMKdvR42fV");
        candidate.setDatee(new java.sql.Date(123456789));
        candidate.setSkillFit("MM0fXUIaoQ8S57OAeFr1whwR5pKMDAQ9L3IICclMX4zxfq4FBZ");
        candidate.setInterviewere((java.lang.String) InterviewerTest._getPrimarykey());
        candidate.setEntityValidator(entityValidator);
        return candidate;
    }

    @Test
    public void test1Save() {
        try {
            Candidate candidate = createCandidate(true);
            candidate.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            candidate.isValid();
            candidateRepository.save(candidate);
            map.put("CandidatePrimaryKey", candidate._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private InterviewerRepository<Interviewer> interviewerRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CandidatePrimaryKey"));
            Candidate candidate = candidateRepository.findById((java.lang.String) map.get("CandidatePrimaryKey"));
            candidate.setCandidateName("V32481bjuB1P5BmNok1Mq3Gz9f2r4aldUP0WiT9zSvkM3R5A1V");
            candidate.setEmailid("Iq2Y2RebtWZLKEdFXFcd6YfKoWF5SzpK5kUQXzbXNDmJo9Jyym");
            candidate.setCultureFit("fb9hqRE5cgHHOqfiW8u8JuTMPK88DOOHFAU36KF9tbnJOUHTtm");
            candidate.setStar("1Kcgh9AE8yfewlQSkHetEVj0UG7Ier89oE3l5a8b1kXPVeQrbT");
            candidate.setRecommendHire("4zYEj5WSYZNkDCVJRXoAabjTu7AN6ntsYnZaiqNYdinlEBHdkZ");
            candidate.setGrowthPotential("05YG5ul5b6JB6r7FcMWoP3bAumKiCjqdtpIjxfA6PU5sVjSaHI");
            candidate.setNote("NTxQ15YURxLhcNACGI8lUcambBpRyhPiR9xiJwdcO48MBSwAz7");
            candidate.setVersionId(1);
            candidate.setDatee(new java.sql.Date(123456789));
            candidate.setSkillFit("OD8UTm762ChhQS8fQn2otF2o6mBzdiWjtKSNG2XQKGxjdx0xQI");
            candidate.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            candidateRepository.update(candidate);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CandidatePrimaryKey"));
            candidateRepository.findById((java.lang.String) map.get("CandidatePrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByinterviewere() {
        try {
            java.util.List<Candidate> listofinterviewere = candidateRepository.findByInterviewere((java.lang.String) map.get("InterviewerPrimaryKey"));
            if (listofinterviewere.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("CandidatePrimaryKey"));
            candidateRepository.delete((java.lang.String) map.get("CandidatePrimaryKey")); /* Deleting refrenced data */
            interviewerRepository.delete((java.lang.String) map.get("InterviewerPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateCandidate(EntityTestCriteria contraints, Candidate candidate) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            candidate.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            candidate.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            candidate.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            candidateRepository.save(candidate);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "candidateName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "candidateName", "ElHkNtb1OhafnJ3rycq5Gmo81DdtXvVcoZChrIIcR9VVMkzkluC3GiVHqffS65G4BzPhsh7nVrvDIcj4O5vqYO9GKeEctUn7Q5Ly78QQUXz4bWcItDm4GTtFxwdpWKbWA5fsGgTa7wqQ7fQrBT0fWcO5uxcmCxPdtTtHhLugF7qWenE2UIgjJ9aOS71b6Y3lbPGk6H2YOFYBMPU2fX1W6OUovre4S5sXScnjdgVtMhmj54aYxlWVPz4rwW5L45jCP"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "recommendHire", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "recommendHire", "KZJcNKc6r8UX7aQqaAgwAKq4RXQ8cWLwv8FuA4ibwbmmoosb6ah6rrl5YvhhCf8kWAWlV3y5xhPsF6eQG1Phax3RmsgcfiEaCEzPBPFFM0c398rpeER4cTI14i4x9D4uTuW7KoKmiXVVSgtDAdbjLbloAsva9Xluwyg3Qkhsc90FYWblSv0uUr7M6sFoKzmJScRPYpt94ZJDLJ2oBBc6B1g8Jvfocrh6fKXQWpHOHEfXzYD2cEV8sn5vd1PKKq5pW"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "emailid", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "emailid", "T2vkIxq466Io9DZogecJAH1uVcs7NLFiHFQV07FZCnvCvpidOXYAi5S1aUQ0EcYo6ChtFmWPq1gC89cu46Pu8CtNzNjZArFDlBJkroyTzZP7hqcahVh6gIj6JNewhkR7uwHep8Rz2QPSSJMJGMW8M6yz7jj7D0iA4zrCjtpAqGg08UuYklnCiSwAM1EtlAVrFVJIEzR95CCTTqAIsehytqyCVum7V98zOKuislyawGgBnZpT4CcONc7YB4PusC9rL"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 7, "datee", null));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 8, "skillFit", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "skillFit", "g2hok0c8uJwu6FiqJur5SYyNBtq6MVCft7lOjXE8epWYHo21Du5K71BKM06nip27fCeSzeB3Vm118gkbHQ1YxIoglkvdsqMegqJ8PILEh7vJkaC0h0LbZGegMOZAHgfRg7EuQVQoukrSh4q3ibRJ26jKzlouoJFBYVrsGIG80gDaOtKoNMOkTT6nmIEGJuQXK7t6CIYpN7fxFxhS4vu04JShZAVu7ONoux4kRtygUh8gc9N7PuBLew5diNc1nuGjr"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 10, "cultureFit", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "cultureFit", "74gOKogLPlXUuml70RtRf4XChVvmKbZqKG6z11KvBbd1aVbA7cqNXgRll7U5uyJzPuoXyqDZ0Aosav1h6lP02ruX185Br99HuMI8daFWJP3NMbtRhXZPY2tdj6EnyWuYrRQqIOdJO3gV8BM3oEU2o8TIs2qrFn4ZTz3lZol29yaPLk3cIEzRDpdqxq8Mm4eqEWLIrR2y03AFw1dAspy59oAQ8q6RMJOIhylXNW2j8H8Icu9QcH8n9ShYl6ePKw9uo"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 12, "growthPotential", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 13, "growthPotential", "p03uLAnqxSDPiBeWdBNqgm0SFIrK5RCv0MgowbrCPsvhyAchNcB8yj3gbojFtGIHEGObIK6shSJGreShHtH1R9tkCsi4IvRBNBa3rnW9uwum5C8NeO4Mas9Kv6HnwLlj5VQx1gMHQC7lRbPvwPBebRwMSw7OoDJJKCJk60K0h4IG1jRH2CyZRMpVdwPupifEIyZRsgu93oyZqfA4I1PglcN4I7NGvzhaKVLgpChp4dET9J4d029gL7ORi4YWPJ5B7"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 14, "star", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 15, "star", "Dm75mhMuiUVGVcevZYtGIFkWtTzo0UOmyuQkpOq7nppBSUnbwVZzgWP7Z5GlknMVFSB0UIgcn7qQn97qX7rugZpfwPLd8O9wJ5O3wxW68kulnCaeziCaKudcaB4yIpxnEOQ7VJDQCsTKPOiT09002ATcoiCknqdxDazgYqETLPFdO0C8ZhrAaxF22NeiXpyFAsIwHr4P8osY1CBe2L8f4Gi9tfu3LZRWiSO7DY2m9rsdPbJw0IomrkiWnxRWzQl8F"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 16, "note", "Hj2gL9Ox1oQpt4oXL8NkqnBWMnkAijBCKo9rtT1clbf2YF0B52XCLKCspRz1lz9pmuuxWOhYWXsVg8yyConQp0nX6mGPz9X0c7wtxCChh2sY6d9dZH8l5321g0U1XdnREVM4t4X64CHYK1CZFEj1tbso8MVeJ7FwHPVfo5AtaFHno3wseSOvfl0Z6upz5TG9asb5AU9dGXRiEBng91Xe03oMfuHBVLUWUCBreKhAXdShuJBrI7FBoKOKOhR3lWLB6"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Candidate candidate = createCandidate(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = candidate.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(candidate, null);
                        validateCandidate(contraints, candidate);
                        failureCount++;
                        break;
                    case 2:
                        candidate.setCandidateName(contraints.getNegativeValue().toString());
                        validateCandidate(contraints, candidate);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(candidate, null);
                        validateCandidate(contraints, candidate);
                        failureCount++;
                        break;
                    case 4:
                        candidate.setRecommendHire(contraints.getNegativeValue().toString());
                        validateCandidate(contraints, candidate);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(candidate, null);
                        validateCandidate(contraints, candidate);
                        failureCount++;
                        break;
                    case 6:
                        candidate.setEmailid(contraints.getNegativeValue().toString());
                        validateCandidate(contraints, candidate);
                        failureCount++;
                        break;
                    case 7:
                        field.setAccessible(true);
                        field.set(candidate, null);
                        validateCandidate(contraints, candidate);
                        failureCount++;
                        break;
                    case 8:
                        field.setAccessible(true);
                        field.set(candidate, null);
                        validateCandidate(contraints, candidate);
                        failureCount++;
                        break;
                    case 9:
                        candidate.setSkillFit(contraints.getNegativeValue().toString());
                        validateCandidate(contraints, candidate);
                        failureCount++;
                        break;
                    case 10:
                        field.setAccessible(true);
                        field.set(candidate, null);
                        validateCandidate(contraints, candidate);
                        failureCount++;
                        break;
                    case 11:
                        candidate.setCultureFit(contraints.getNegativeValue().toString());
                        validateCandidate(contraints, candidate);
                        failureCount++;
                        break;
                    case 12:
                        field.setAccessible(true);
                        field.set(candidate, null);
                        validateCandidate(contraints, candidate);
                        failureCount++;
                        break;
                    case 13:
                        candidate.setGrowthPotential(contraints.getNegativeValue().toString());
                        validateCandidate(contraints, candidate);
                        failureCount++;
                        break;
                    case 14:
                        field.setAccessible(true);
                        field.set(candidate, null);
                        validateCandidate(contraints, candidate);
                        failureCount++;
                        break;
                    case 15:
                        candidate.setStar(contraints.getNegativeValue().toString());
                        validateCandidate(contraints, candidate);
                        failureCount++;
                        break;
                    case 16:
                        candidate.setNote(contraints.getNegativeValue().toString());
                        validateCandidate(contraints, candidate);
                        failureCount++;
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (failureCount > 0) {
            org.junit.Assert.fail();
        }
    }
}
