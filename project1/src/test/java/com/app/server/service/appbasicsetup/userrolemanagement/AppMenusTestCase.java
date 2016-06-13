package com.app.server.service.appbasicsetup.userrolemanagement;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.appbasicsetup.userrolemanagement.AppMenusRepository;
import com.app.shared.appbasicsetup.userrolemanagement.AppMenus;
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
public class AppMenusTestCase extends EntityTestCriteria {

    @Autowired
    private AppMenusRepository<AppMenus> appmenusRepository;

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

    private AppMenus createAppMenus(Boolean isSave) throws Exception {
        AppMenus appmenus = new AppMenus();
        appmenus.setAutoSave(true);
        appmenus.setAppType(2);
        appmenus.setAppId("5Zj53bQpxZ5A554RWzBq2crSfaEOt01IWso87gKbUNL6rsJbs1");
        appmenus.setRefObjectId("xJHkqnZjHU8fJeGGVUzBl40MsZ3tjqq3F3kXAbR44jaMTBrghZ");
        appmenus.setMenuTreeId("cFtKpT3SGzi42ibFOGn5m0jfmev0okLS8jACMpiObQwRNpTqwR");
        appmenus.setMenuDisplay(true);
        appmenus.setMenuIcon("rVExmjDO4sNV5mDhMykLOeqw8Jhuw20d1n0cnqnju0X5jkwMyO");
        appmenus.setMenuHead(true);
        appmenus.setMenuLabel("JuAUbu9qnOB6z6YeGO4Iju9PnARTylHPwwkcdxnO97QxdBaI20");
        appmenus.setMenuAccessRights(7);
        appmenus.setMenuAction("n8RDPCh8ivSwHpgWLt7Rs8RfHJFmfr9Lx3GtgoQJBQzsKoDbHD");
        appmenus.setUiType("9dv");
        appmenus.setMenuCommands("8L3xvbUDddHjk00wN5ULxEk1RIGlk5rCMOubciczRH5vb0K9r2");
        appmenus.setEntityValidator(entityValidator);
        return appmenus;
    }

    @Test
    public void test1Save() {
        try {
            AppMenus appmenus = createAppMenus(true);
            appmenus.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            appmenus.isValid();
            appmenusRepository.save(appmenus);
            map.put("AppMenusPrimaryKey", appmenus._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            AppMenus appmenus = appmenusRepository.findById((java.lang.String) map.get("AppMenusPrimaryKey"));
            appmenus.setAppType(1);
            appmenus.setAppId("ref4EJuHQQ0ClIn7eT4tI4JOMTzd7Jp5HwLv4EveFsa9AADsVY");
            appmenus.setRefObjectId("Q3AOHsxNvuBk1MbAAnOgdVexlrulYXjbn61p4cHHDWNqyLdHKb");
            appmenus.setVersionId(1);
            appmenus.setMenuTreeId("Yjs4OGawymjZ3wfgQ4SvM388jfea4aspnCuDc8nrnOujYZru3r");
            appmenus.setMenuIcon("3ZlWK7B63P1BV2JiLuhxPQ2yVde1iNvy4ctDWOFvGNfqfIyrnv");
            appmenus.setMenuLabel("h632QZTfrZpVbhHwBgJuuSPl9CPUi1V6zvvXbuAjfzcm5AAnuT");
            appmenus.setMenuAccessRights(5);
            appmenus.setMenuAction("lsU0St4wmgW3q7abgEsVuUr6uVmpEaZi47D4bApiiN0BesjxbA");
            appmenus.setUiType("Lhm");
            appmenus.setMenuCommands("IEPCR0xBy9LFw7CgCmyakh1Z9v1yC6sEkwimxkalLuIcuiS2qI");
            appmenus.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            appmenusRepository.update(appmenus);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            appmenusRepository.findById((java.lang.String) map.get("AppMenusPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            appmenusRepository.delete((java.lang.String) map.get("AppMenusPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateAppMenus(EntityTestCriteria contraints, AppMenus appmenus) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            appmenus.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            appmenus.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            appmenus.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            appmenusRepository.save(appmenus);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "menuTreeId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "menuTreeId", "HLacBHwLkkJx8uyV1n35uCIomBZkvUqCkFk2NRIwMEy1mGHC3qoOVHUrtJitdmZj03lIDlXU1GUylbh19xoX42tkA5mYMyjTD26UHrCes9Qx3R0N1dCvgBybWdmP7YYxRGwldy9nSSJZGqW7gbCQn3VvHSGALMK7Vg2LRaZxgK07dlDBCZb2eOGnAp1Gs9VXerWeL9Af6TW2wGxspOqZVWJ6nwXZY7rX6zcubH0Qc6leF1qZhpe7COE37CHoawMyL"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "menuIcon", "lHQIJvbfOC4fjc509kJi6xttG0Wox8w9gxC8LCncblWLMLXyedjnIPYnLTRDgzCW6qlLX4Vq4tctkzitpmhcjxv34V9nQFOEcom6yMGztS5RyS39fsTtFWlopJleX3GIHKCAmzKl5fn2mREeWKrSWJKHK8VxTnK9AI4Dfjc7lYfU6YCXonyjBwfC0ADoTKZjm6unqa5pmlEveYikmCgW4FWQc0xaO83AlvlYYamYJ7ISLne8uj5SZy1lB2ZylGtOX"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "menuAction", "2nvWKuxopVkmgfgEzfC5J3qwbDC7CgRxoaxSThw6osX0BRqIUU5gv36t5tAlbzfMurmBXUajJn9xjWyMF6PysvDlPyGY6IXLD86tPInQLi779jZviSFxRDJY5kz4VKZpugGJvmQuDzVyN5kbWU67S5j9Ip4DUKYAIGdRfjopNuO1xAiKsophUGUFOefmf7xCgNBfLpLovvO33O7jv6Hyn5SOk6mPo40i8McGc17wYHx53FnJEKns3k6yxjAzpYYcH"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "menuCommands", "dkMg2FGLkitpm9IcxuZm1vT6Mx4qeaUv9A3wlIUjYqrhygNA3lLWXhxkVxgiGiqhy"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 6, "menuDisplay", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "menuDisplay", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 8, "menuHead", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "menuHead", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 10, "menuLabel", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "menuLabel", "PLUVUBSnTdyDqXDyPSrs2Lop3QoFO5diL1yCscdjjv1tT7qGCJ3W34FMaoeCxmWT0D4fQZpZFKCsfTIDFdcwDzSFQgFFEkZXTLLXzRPVFw6FGnsNCrO0IyUjlSETHdbTn8bLEXcrmVptwBblnjcVhuRwSqP8YwW7OcvONjzRusQMeOaHfvfnW00qZbTkC4QlQvxgzqgLl7PWoQ5TNpTnGtR0vy87uFyXDsvcU55nqPZSrtBmLSluMj7f7nmhUqPnE"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "uiType", "h2ms"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 13, "refObjectId", "Z5IveYKMQI7npAM26o7aaLRbUeYCUMOyGx4Dk8PpaJWInkUDGp37DihmTSKjYM8vwhZLKvunwImgqiOf0DzDOPgbADj3feQOV1XTktBlj2nnKUiGUJE52ZxcKzNaNhthU0s70WdFbMdeLuUbCheaDWTmyJuDwVb2b19DsI3rlnxEQiKFpNSTzXfymz6PLGXMgX82oLeSYOf7ZQfqw2lw38B8wowW58aIiGb3z7PFGiyJSC9trRnE5aYPoKCL3rj3G"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 14, "menuAccessRights", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 15, "menuAccessRights", 17));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 16, "appType", 4));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 17, "appId", "3OoQCJyAAtyWEVp9x2emxHcBMaE7b3zlBlnuKh9OD1ZTC0CfTZfmTZ9naXJYSiOTJmIJYfPDAlpp6jLiz88V8byi7mBjQrz3zE2XMYZkqh4YEdWzfXCG120Lj168vNO2sb8Y5LA5YmG5Sq9sQiomUusje37necMs2HitRKgGICWwuHA6XnzwQkgnPY6S8DKgUzZR5Y5RBPZLWBV3hamd7xPlTIVLlUMjjm5tRh4KnpL1J60GOT7GEZEaBO1HA4JgG"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 18, "autoSave", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 19, "autoSave", true));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                AppMenus appmenus = createAppMenus(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = appmenus.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 2:
                        appmenus.setMenuTreeId(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 3:
                        appmenus.setMenuIcon(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 4:
                        appmenus.setMenuAction(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 5:
                        appmenus.setMenuCommands(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 6:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 7:
                        break;
                    case 8:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 9:
                        break;
                    case 10:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 11:
                        appmenus.setMenuLabel(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 12:
                        appmenus.setUiType(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 13:
                        appmenus.setRefObjectId(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 14:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 15:
                        appmenus.setMenuAccessRights(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 16:
                        appmenus.setAppType(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 17:
                        appmenus.setAppId(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 18:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 19:
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
