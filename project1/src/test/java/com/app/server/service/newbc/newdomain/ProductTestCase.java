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
import com.app.server.repository.newbc.newdomain.ProductRepository;
import com.app.shared.newbc.newdomain.Product;
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
public class ProductTestCase extends EntityTestCriteria {

    @Autowired
    private ProductRepository<Product> productRepository;

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

    private Product createProduct(Boolean isSave) throws Exception {
        Product product = new Product();
        product.setpDate(new java.sql.Date(123456789));
        product.setImage("fG4xEAozLiR5tsNdIpdCMJPtaFNu7t7A1dWKI11vskIUVhmLYy");
        product.setPdatetime(new java.sql.Timestamp(1465554088808l));
        product.setpName("wQ5U9dVPQf4DTuSL1iGbnpAzWkq1GUrecLjG8oijr1IwzYAf9D");
        product.setEntityValidator(entityValidator);
        return product;
    }

    @Test
    public void test1Save() {
        try {
            Product product = createProduct(true);
            product.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            product.isValid();
            productRepository.save(product);
            map.put("ProductPrimaryKey", product._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("ProductPrimaryKey"));
            Product product = productRepository.findById((java.lang.String) map.get("ProductPrimaryKey"));
            product.setVersionId(1);
            product.setpDate(new java.sql.Date(123456789));
            product.setImage("4gaiU0LRJkwtgvlB9IOuCNJOqQPqHf3BlpGNdGF1sMvsr0voro");
            product.setPdatetime(new java.sql.Timestamp(1465554088899l));
            product.setpName("5GaS5oWpnWwbuBF79xJXde5YXoOfrBrXburVIj0eyskm72Mfl5");
            product.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            productRepository.update(product);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("ProductPrimaryKey"));
            productRepository.findById((java.lang.String) map.get("ProductPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("ProductPrimaryKey"));
            productRepository.delete((java.lang.String) map.get("ProductPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateProduct(EntityTestCriteria contraints, Product product) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            product.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            product.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            product.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            productRepository.save(product);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "pName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "pName", "REA2703UE2pWMJydPEjiLbuzKjFw29gvruZEc00ts6lxPvOqgULBYKQlo5xLvd00Kvk46vY81AmCUuhdLwRiDQQTwmezfhxvmsMumb96xjAj9TC19VeNChvElXluFy5bsa0GdkqJ27E1R4PqxjPqMNjj8JJJrSbllgb2nsoWt7T8kbDAjxRglYDBZSoeFvRfNfPDMjnGduUEs1oPfGVpPtLOI7GVLiIKfnQHUudF6w8x0K5hIODlT9r1JVoO0TUhJ"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "pDate", null));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "pdatetime", null));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "image", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "image", "85C00iykQqHhamDfIIsbFx1cySx1ggVplf659NtafjJnmMVOjo41B7DvFAZQsUFirzTVvYlDu2lKcA63Vcx9JyApZJWknzHzDSy6a8mF9Y5JqatFfAO1Ri8BgTcx1Em5QmvlsVmNBwRmyid5YD9rai6QrRJ7bJ9wWtPT48Aa2TLOOShLS68uFJD6zaHfRcfKHYn6Ir2uTQHTPYdsQiB0VhItPbbePpflA6K6mcrbbwTPK6s3hIWnWYKDpVHO7qU9l"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Product product = createProduct(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = product.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(product, null);
                        validateProduct(contraints, product);
                        failureCount++;
                        break;
                    case 2:
                        product.setpName(contraints.getNegativeValue().toString());
                        validateProduct(contraints, product);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(product, null);
                        validateProduct(contraints, product);
                        failureCount++;
                        break;
                    case 4:
                        field.setAccessible(true);
                        field.set(product, null);
                        validateProduct(contraints, product);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(product, null);
                        validateProduct(contraints, product);
                        failureCount++;
                        break;
                    case 6:
                        product.setImage(contraints.getNegativeValue().toString());
                        validateProduct(contraints, product);
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
