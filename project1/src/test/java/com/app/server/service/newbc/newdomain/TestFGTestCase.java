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
import com.app.server.repository.newbc.newdomain.TestFGRepository;
import com.app.shared.newbc.newdomain.TestFG;
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
import com.app.shared.newbc.newdomain.FGPT;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class TestFGTestCase extends EntityTestCriteria {

    @Autowired
    private TestFGRepository<TestFG> testfgRepository;

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

    private TestFG createTestFG(Boolean isSave) throws Exception {
        TestFG testfg = new TestFG();
        testfg.setFgDate(new java.sql.Date(123456789));
        testfg.setFgName("b1YqkHcTrIQ0ARR27Ly2zVBlBj66sgut4TacT50IKw40vNFGax");
        testfg.setFgDatetime(new java.sql.Timestamp(1465554087101l));
        java.util.List<FGPT> listOfFGPT = new java.util.ArrayList<FGPT>();
        FGPT fgpt = new FGPT();
        fgpt.setPtDate(new java.sql.Date(123456789));
        fgpt.setPtDatetime(new java.sql.Timestamp(1465554087224l));
        fgpt.setPtDate(new java.sql.Date(123456789));
        fgpt.setPtDatetime(new java.sql.Timestamp(1465554087261l));
        fgpt.setTestFG(testfg);
        fgpt.setPtName("vgIwuIXhQi7k7AlaptcPWt07l1y8DxGgsB999bouJ03Iqpk7Ur");
        listOfFGPT.add(fgpt);
        testfg.addAllFGPT(listOfFGPT);
        testfg.setEntityValidator(entityValidator);
        return testfg;
    }

    @Test
    public void test1Save() {
        try {
            TestFG testfg = createTestFG(true);
            testfg.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            testfg.isValid();
            testfgRepository.save(testfg);
            map.put("TestFGPrimaryKey", testfg._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("TestFGPrimaryKey"));
            TestFG testfg = testfgRepository.findById((java.lang.String) map.get("TestFGPrimaryKey"));
            testfg.setFgDate(new java.sql.Date(123456789));
            testfg.setFgName("9DX5Lo6tGgpgnjAljfKzJnMozk4JCDqGPPx6k6qUbjEtExnpE2");
            testfg.setVersionId(1);
            testfg.setFgDatetime(new java.sql.Timestamp(1465554087583l));
            testfg.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            testfgRepository.update(testfg);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("TestFGPrimaryKey"));
            testfgRepository.findById((java.lang.String) map.get("TestFGPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("TestFGPrimaryKey"));
            testfgRepository.delete((java.lang.String) map.get("TestFGPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateTestFG(EntityTestCriteria contraints, TestFG testfg) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            testfg.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            testfg.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            testfg.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            testfgRepository.save(testfg);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "fgName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "fgName", "d5ruVxdtUaEi028oTDQUuhdeNjqekZGYbD2SDjDJ8WcylOq979twxuLForXxZUCjcZAk8xAeX0GYGoguPlmgUN1nTWwPBzgKBnmQ1GrPq4NDcQKuuMuTMEocQNTtji65hmp45RakpfYae0g6S41xFNVQ3ajrmRR8IJdFJajtuGZOKiMtm2jQBnvpAuh7fXvy7IP5lCJakF0TBR8jUnzG9Axf7kzXnWp7jzQGLdaq0HYstbCAuA0SpOebUXFUl5kRs"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "fgDate", null));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "fgDatetime", null));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                TestFG testfg = createTestFG(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = testfg.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(testfg, null);
                        validateTestFG(contraints, testfg);
                        failureCount++;
                        break;
                    case 2:
                        testfg.setFgName(contraints.getNegativeValue().toString());
                        validateTestFG(contraints, testfg);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(testfg, null);
                        validateTestFG(contraints, testfg);
                        failureCount++;
                        break;
                    case 4:
                        field.setAccessible(true);
                        field.set(testfg, null);
                        validateTestFG(contraints, testfg);
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
