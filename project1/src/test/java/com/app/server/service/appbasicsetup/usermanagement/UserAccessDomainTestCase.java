package com.app.server.service.appbasicsetup.usermanagement;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.appbasicsetup.usermanagement.UserAccessDomainRepository;
import com.app.shared.appbasicsetup.usermanagement.UserAccessDomain;
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

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class UserAccessDomainTestCase extends EntityTestCriteria {

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

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

    private UserAccessDomain createUserAccessDomain(Boolean isSave) throws Exception {
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setDomainDescription("UlGKqND8DIk1c3kbfwDC5EH8lnHEKa8VvPN6mSKjCUfQeLmpNa");
        useraccessdomain.setDomainHelp("IwV9d4ErR5MiQeFeA04lXejHo0EsWXEqTp4KlYuj5g0Pa1wlxu");
        useraccessdomain.setDomainName("jUnWeivqFyTkehcy6oHv0KuEevbImr5qWzDlq17cnJPhvTcXsH");
        useraccessdomain.setDomainIcon("8yJnWQXQPSZakNXXUSbLYng24NXwStJNwChA3qyqPtwFdZI1Zm");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setEntityValidator(entityValidator);
        return useraccessdomain;
    }

    @Test
    public void test1Save() {
        try {
            UserAccessDomain useraccessdomain = createUserAccessDomain(true);
            useraccessdomain.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            useraccessdomain.isValid();
            useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessDomainPrimaryKey"));
            UserAccessDomain useraccessdomain = useraccessdomainRepository.findById((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
            useraccessdomain.setDomainDescription("w6aOhr9r9XCUcrfZhHZN9e2txvwxdt4I6E0vszFSBGkxqZFbWf");
            useraccessdomain.setDomainHelp("bgVU63MjZsXLu4oyeoKltBvXYyNcrXCAineNuFBuG2xRYngaK5");
            useraccessdomain.setVersionId(1);
            useraccessdomain.setDomainName("61egSoQNC3wNyw30fEDLcRzN7ZcFZRmgYUSSvJr6QurBzyseO1");
            useraccessdomain.setDomainIcon("5UATb1r7z9jMLmrVkveuVHIeIU7xBGhiVRhrLnz2SOK8Ju18vK");
            useraccessdomain.setUserAccessDomain(37132);
            useraccessdomain.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            useraccessdomainRepository.update(useraccessdomain);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessDomainPrimaryKey"));
            useraccessdomainRepository.findById((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessDomainPrimaryKey"));
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateUserAccessDomain(EntityTestCriteria contraints, UserAccessDomain useraccessdomain) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            useraccessdomain.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            useraccessdomain.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            useraccessdomain.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            useraccessdomainRepository.save(useraccessdomain);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "userAccessDomain", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessDomain", 111804));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "domainName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "domainName", "mvcEZ9EQ2tKYpAwzryleMzZKk268uVtnTb1PWp2KjkhxoGZp0MlZB2Ghe7PeuNN3obRYvTgCz5LktsSHUiVbeFjiWBayfxoRFALZ5KBKCkWtA9WX9stKlllPjCYH8HoMhBvifXQjVHcRwNMuKqoGtdgMxwbDxVAMHJqZV6l74diaUTsKF1g1I8dqErx6LmVVdUzyLNRQcZILcslpaOKyx2EzN9yRnDTyltoMQchpNF7ub0ooa7Y7NJwi42MyeAXke"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "domainDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "domainDescription", "CBRA7JRkZrYYY3fUiKBsScTCFyoT0GqV1MWa2KWwi47YYdJEul0bkippoINCmSxExXUl8zEJZnRS2nRj3ZBFvpkdv3B4cQdGupnBFp211TugFNM97EmTamrsJ7aK4NW5bQe362aFLxAH2Ia4Nils95XjPiQvtrtEZV4PWx67a0v1Qr3RW96turVG9lHiyFQFewjNz1fQoZ1Czx8MYgZvzTmkli5hwOahOFR9qKX5NVQ6TqCsBQUii0pcrT8vNIZRH"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "domainHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "domainIcon", "l7Djo2rno7WqzlTIrTcmVbFMNsiF37sydMA17ATxXCOYLtuQeus3wPdwtRdWMvSmDet14YA5ch3MzBxbxxgvlfHBx23NmJZvesKXyr3mR7eCy275mAT2e1wrOfkq0RxGshnLYFICHPi6lIBZZyRpMjNdCJzqVC0DhTlSHoZgYopY2JHAfCqbon59MhAeiCDAL53vA3WnrRvOb1pvO3jgzNHvMQXEi71SndKXArsoWA5kjoqy5upDr4vwrBX1IueZ3"));
        entityContraints.add(new EntityTestCriteria(UNIQUE, 9, "CombineUniqueKey", ""));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        UserAccessDomain useraccessdomainUnique = useraccessdomainRepository.findById((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                UserAccessDomain useraccessdomain = createUserAccessDomain(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = useraccessdomain.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(useraccessdomain, null);
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 2:
                        useraccessdomain.setUserAccessDomain(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(useraccessdomain, null);
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 4:
                        useraccessdomain.setDomainName(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(useraccessdomain, null);
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 6:
                        useraccessdomain.setDomainDescription(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 7:
                        useraccessdomain.setDomainHelp(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 8:
                        useraccessdomain.setDomainIcon(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 9:
                        useraccessdomain.setUserAccessDomain(useraccessdomainUnique.getUserAccessDomain());
                        validateUserAccessDomain(contraints, useraccessdomain);
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
