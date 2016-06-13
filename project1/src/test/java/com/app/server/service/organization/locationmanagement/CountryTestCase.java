package com.app.server.service.organization.locationmanagement;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.organization.locationmanagement.CountryRepository;
import com.app.shared.organization.locationmanagement.Country;
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
public class CountryTestCase extends EntityTestCriteria {

    @Autowired
    private CountryRepository<Country> countryRepository;

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

    private Country createCountry(Boolean isSave) throws Exception {
        Country country = new Country();
        country.setCurrencyName("7RfHEAiUrAyxcMz0y2ixz5F0UWd0TdJ5hUBoGquazV14WUvOcC");
        country.setCapital("ORSDfW2lrQx6BxgkC97g0bWsMpTkJ36I");
        country.setCountryFlag("1ccFAGpHSQY0s2ztzMaRiuLUkOjhtL85uClx49reuqJKwuOSWx");
        country.setCapitalLongitude(4);
        country.setCountryCode1("Jmp");
        country.setCapitalLatitude(10);
        country.setIsoNumeric(748);
        country.setCountryName("hYogv3vTHMhXNlC5i8TkWooRgSkMgGyVv4fR0Fk9k1tgSjI46v");
        country.setCurrencyCode("5kc");
        country.setCurrencySymbol("t7lYtz8dyZ26NPwDTYV8s5eozHFEXvfQ");
        country.setCountryCode2("rmC");
        country.setEntityValidator(entityValidator);
        return country;
    }

    @Test
    public void test1Save() {
        try {
            Country country = createCountry(true);
            country.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            country.isValid();
            countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CountryPrimaryKey"));
            Country country = countryRepository.findById((java.lang.String) map.get("CountryPrimaryKey"));
            country.setCurrencyName("2QuUPxxYEGlFBKlAqGcqBxb1OqFUx8pnXsAgkloo0kgq4FKSIH");
            country.setCapital("YlsfAi5qk49xovGvLhER5GXqoaGczemF");
            country.setVersionId(1);
            country.setCountryFlag("t9yEP94jd3Ym9Ij1m3DWP5lduDRZE8lLHVLRxAwtEjehoFVz2o");
            country.setCapitalLongitude(9);
            country.setCountryCode1("5Ur");
            country.setCapitalLatitude(11);
            country.setIsoNumeric(582);
            country.setCountryName("eJvBdB9iy6wD726Eygm2YvXgvXY9ljZhZySJ9kQVjpwY4Ameat");
            country.setCurrencyCode("Dsy");
            country.setCurrencySymbol("QvoksyOVLA5VliFpDruVcTduLfhax5tu");
            country.setCountryCode2("z9g");
            country.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            countryRepository.update(country);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CountryPrimaryKey"));
            countryRepository.findById((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("CountryPrimaryKey"));
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateCountry(EntityTestCriteria contraints, Country country) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            country.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            country.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            country.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            countryRepository.save(country);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "countryName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "countryName", "JhU4g5npZJAC4GUhHpCsCPvnWp0xJ0tFyrRcHZF8L58wdvVcQVebw2dpasgeexkwnzhys4UKV15MN0ljUhlZqEuVSAA1QKkY6jknKKsv3oahjdR8UjOs92MaszllKKM3T"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "countryCode1", "cpQs"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "countryCode2", "Kw4L"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "countryFlag", "LdYmNngvzQOiAFWIeqreH45ALfb1NXhQXknBgzyZUPHIGeb9jHGXJkoNQghvgfENZ"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "capital", "OKfS0MC45bUmBoKPya9wz9UJTrHsMa2r0"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "currencyCode", "dDNo"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "currencyName", "IkDJuWLOT5LgioIK9DlnjqbdrOcY9wJJUdeqGiNu0NYEzzbBHA2quT6OZedjYn1kcIbm9DVSpRquvMnght88Foz0Ju5Skofut8VPTi8Sc3YCLtFO0EZeYNKRvTN9kx6jj"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "currencySymbol", "Xu6w8vGygInSNTvRhcNIXxlJl2OX3tb1G"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "capitalLatitude", 15));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "capitalLongitude", 22));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "isoNumeric", 1916));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Country country = createCountry(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = country.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(country, null);
                        validateCountry(contraints, country);
                        failureCount++;
                        break;
                    case 2:
                        country.setCountryName(contraints.getNegativeValue().toString());
                        validateCountry(contraints, country);
                        failureCount++;
                        break;
                    case 3:
                        country.setCountryCode1(contraints.getNegativeValue().toString());
                        validateCountry(contraints, country);
                        failureCount++;
                        break;
                    case 4:
                        country.setCountryCode2(contraints.getNegativeValue().toString());
                        validateCountry(contraints, country);
                        failureCount++;
                        break;
                    case 5:
                        country.setCountryFlag(contraints.getNegativeValue().toString());
                        validateCountry(contraints, country);
                        failureCount++;
                        break;
                    case 6:
                        country.setCapital(contraints.getNegativeValue().toString());
                        validateCountry(contraints, country);
                        failureCount++;
                        break;
                    case 7:
                        country.setCurrencyCode(contraints.getNegativeValue().toString());
                        validateCountry(contraints, country);
                        failureCount++;
                        break;
                    case 8:
                        country.setCurrencyName(contraints.getNegativeValue().toString());
                        validateCountry(contraints, country);
                        failureCount++;
                        break;
                    case 9:
                        country.setCurrencySymbol(contraints.getNegativeValue().toString());
                        validateCountry(contraints, country);
                        failureCount++;
                        break;
                    case 10:
                        country.setCapitalLatitude(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateCountry(contraints, country);
                        failureCount++;
                        break;
                    case 11:
                        country.setCapitalLongitude(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateCountry(contraints, country);
                        failureCount++;
                        break;
                    case 12:
                        country.setIsoNumeric(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateCountry(contraints, country);
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
