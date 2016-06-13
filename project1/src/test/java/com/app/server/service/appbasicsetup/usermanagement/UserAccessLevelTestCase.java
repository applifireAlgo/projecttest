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
import com.app.server.repository.appbasicsetup.usermanagement.UserAccessLevelRepository;
import com.app.shared.appbasicsetup.usermanagement.UserAccessLevel;
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
public class UserAccessLevelTestCase extends EntityTestCriteria {

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

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

    private UserAccessLevel createUserAccessLevel(Boolean isSave) throws Exception {
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelName("7k1pWrdhuaML2HI1nCLSPd1P1dG9mLBDDyxMXfqXT8YhIwt6be");
        useraccesslevel.setLevelIcon("qkTgqClJVljnKY9SvwFndkGIjs4rv24PDbPqfwKRmm6hd9dw9Z");
        useraccesslevel.setLevelDescription("dRLPgTU33oMWs6lgj1O2ZEdbHtRjcTKftz6ZyHcilFJorShJwB");
        useraccesslevel.setLevelHelp("XuNTsXTXZCPVIxJPfmI5xlxFtiE6jMnkIhpzXlLH3oT9AONFH6");
        useraccesslevel.setEntityValidator(entityValidator);
        return useraccesslevel;
    }

    @Test
    public void test1Save() {
        try {
            UserAccessLevel useraccesslevel = createUserAccessLevel(true);
            useraccesslevel.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            useraccesslevel.isValid();
            useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessLevelPrimaryKey"));
            UserAccessLevel useraccesslevel = useraccesslevelRepository.findById((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
            useraccesslevel.setUserAccessLevel(45113);
            useraccesslevel.setLevelName("HRfDhzEforG2mKAItFmtKWmfi3FqMrCbmic3k3cslotffl2fUA");
            useraccesslevel.setLevelIcon("tBgNjHNWYRPTdwhYOtg0NfeCMtM9G31P3mQgGsZPyCnVzwzkmr");
            useraccesslevel.setLevelDescription("R5GZgqWddYCUStKNlk0TQ1p9gPfyDrY1KyKZUFBOFWNWkcaif1");
            useraccesslevel.setLevelHelp("kZZwMIOHI6nEGOfkRT9awY6Ch2ivBrwcpxdkVgpaAWqXYJurRH");
            useraccesslevel.setVersionId(1);
            useraccesslevel.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            useraccesslevelRepository.update(useraccesslevel);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessLevelPrimaryKey"));
            useraccesslevelRepository.findById((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessLevelPrimaryKey"));
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateUserAccessLevel(EntityTestCriteria contraints, UserAccessLevel useraccesslevel) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            useraccesslevel.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            useraccesslevel.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            useraccesslevel.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            useraccesslevelRepository.save(useraccesslevel);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "userAccessLevel", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessLevel", 131601));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "levelName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "levelName", "T7WjbTnDco17Grezkke4bcWY5CVCBTVSgPQEsVWahuFghVqxHhce9Yei4vF7ZdPNRUyrpRsTmZ96IyCobGZKgi8eGAwHYtCiHBhMOTaQoA1AMKMFocMDAdszw8qiWaX49gBNpzTnFyr7HRfujtVgvJ05Z2daAqEFUG6MU4cSRIDtYbE5ndsPXPtpBF8rwHq2YIkJ7QkzAa2S6KKXE5tCCSr23w6hZtQY6NrIDAoTtUIxmuAb7ZLeRy72aABmZKz7M"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "levelDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "levelDescription", "aq9PAv2uX0GKxujhewr6lC8UhQqpxUdP4P85g71roZYCf7CbIHZx3pomEix0EUZqiUBJsjnhCyRQ683N6gddmE4gKhxLE4IlBVKS6OI1k8jfDGSkIHymemWzmWi0FYE0k2KZ4nA2ivNfsmJTd5asbDIAiXMrTjO3psLAICYpAaO2mk5gaYJCi3II5Lg5tcKmIZj21MZA3dEz9XxswaNOmsnkpxGkHbpvIrpMFRThKQTmIDHVrJzGFLMAbWeUKb4it"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "levelHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "levelIcon", "ZA3byj5yLrGbNp4p0dhVCrYJJDieGPWF3q6vJHABgRc7irTIoOw596ljJJcUbbWKAbEknPPdt2ui7DXQydl4fNdXmjciNxfQGkC450Si50QtAQ5mkXRNtjXxMd0Tjcm6cRPqZJ8E1k0MgsgUSDKptVo57DUvndHMzSf3dllH36sMyLVcV1Ha67EGVgce2sNyPoNWn3kBRWy4mcnmpj8llXl83HqQVHjfCXkGD3s9DqaS1BliXULTGOEkLQw2SOsGr"));
        entityContraints.add(new EntityTestCriteria(UNIQUE, 9, "CombineUniqueKey", ""));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        UserAccessLevel useraccesslevelUnique = useraccesslevelRepository.findById((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                UserAccessLevel useraccesslevel = createUserAccessLevel(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = useraccesslevel.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(useraccesslevel, null);
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 2:
                        useraccesslevel.setUserAccessLevel(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(useraccesslevel, null);
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 4:
                        useraccesslevel.setLevelName(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(useraccesslevel, null);
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 6:
                        useraccesslevel.setLevelDescription(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 7:
                        useraccesslevel.setLevelHelp(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 8:
                        useraccesslevel.setLevelIcon(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 9:
                        useraccesslevel.setUserAccessLevel(useraccesslevelUnique.getUserAccessLevel());
                        validateUserAccessLevel(contraints, useraccesslevel);
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
