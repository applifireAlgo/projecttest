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
import com.app.server.repository.organization.locationmanagement.AddressRepository;
import com.app.shared.organization.locationmanagement.Address;
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
import com.app.shared.organization.locationmanagement.Country;
import com.app.server.repository.organization.locationmanagement.CountryRepository;
import com.app.shared.organization.locationmanagement.AddressType;
import com.app.server.repository.organization.locationmanagement.AddressTypeRepository;
import com.app.shared.organization.locationmanagement.City;
import com.app.server.repository.organization.locationmanagement.CityRepository;
import com.app.shared.organization.locationmanagement.State;
import com.app.server.repository.organization.locationmanagement.StateRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class AddressTestCase extends EntityTestCriteria {

    @Autowired
    private AddressRepository<Address> addressRepository;

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

    private Address createAddress(Boolean isSave) throws Exception {
        Country country = new Country();
        country.setCurrencyName("7L2wFqHDa540I3JvuMgmK0tMy26k28ndchNsewXX0PWcCbWKjs");
        country.setCapital("a8HyXRRpq5oHakiDSOYr1IgizuLnY7g3");
        country.setCountryFlag("15TvexVY6h8dlQXrGaieK8yeSoiHfCQwWUUKgGzhmVxO4RcUNS");
        country.setCapitalLongitude(1);
        country.setCountryCode1("dds");
        country.setCapitalLatitude(2);
        country.setIsoNumeric(612);
        country.setCountryName("xF6ERUTAhXVqii5heg01vDgtBxnvEeY0ZnCLOKebyFjrogaeKk");
        country.setCurrencyCode("NtA");
        country.setCurrencySymbol("LEPwh16KG4IRPtQT16iaDHS9oQPRYI97");
        country.setCountryCode2("bQX");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeDesc("nsRkg2KKyBSkP0VjxXiN7F3sOOuCQMmRIyVh0jUdz2Ix72R9de");
        addresstype.setAddressTypeIcon("3ONuJIH8xES0C1AXAiLMXN6SF3bzQvzkH4TomiFJKYAmIkP9PQ");
        addresstype.setAddressType("JrDdlC0nmNuJDz72KP2WVH2x3VehR0Gky9t4G5XYxfh2Z1HtvN");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        City city = new City();
        city.setCityName("o8a9urpyREYjjOu2SePIHmNLnuQqmxVxl1oVDGlq4CT49L3clZ");
        city.setCityCode(2);
        city.setCityLatitude(3);
        city.setCityDescription("imkj7ZHXtUUKuLPiM0EfJToEid4gUHw2LuVpJffYCKXPKnQbv5");
        State state = new State();
        state.setStateCodeChar2("9go7kg5l1EHcyJz0QNXebgzgPSKWJi9w");
        state.setStateCapitalLongitude(1);
        state.setStateDescription("TmXGO3ZfBOkGhMJOMsJcprC7KfCRF3P2QrspoVhRws3ISC3V48");
        state.setStateCodeChar2("NMbBXsXpO2gLsrVpTbz7oyF8KzPIfHu8");
        state.setStateCapitalLongitude(10);
        state.setStateDescription("CWXUSgPXVOF4GPvjus6fIMuRv9RBHsx1cF83bHn3A49y9EcuLP");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCode(1);
        state.setStateCapital("kv91wotJC9hQZ3Hqqj1Tf88lLg43lXiz85bpQcfG8Vte7DUlGC");
        state.setStateCodeChar3("zpl3f9OA9MinNrFVmhuUNwqnOcIYm0xs");
        state.setStateCapitalLatitude(8);
        state.setStateFlag("lPlF9MdUa5d8zbST0UoIiMehqw679CCEn1lj3F2TBfGV70cWcf");
        state.setStateName("q5LHAEflejArQelNJc61uqgclJhJtiENmuq0DEt3xGIPcic4Vt");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        city.setCityName("0K9XLyYFYYB2e8d1xVIGRgwyCR8E9NYbhvxSfrLaSjh1BMl9ek");
        city.setCityCode(1);
        city.setCityLatitude(3);
        city.setCityDescription("n2h4GyOG6Q4ZshWzZiCwc5zIFen9HzAQlKNQQFfFAPEfQ9juXM");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityCodeChar2("rX13XQMPdcsLKt9A7X8Dh6xdFEN6h4ja");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityLongitude(4);
        city.setCityFlag("WIyVJxD6BUnjVyCSRseju5ocvk2mMPjKtgBi4z8w1gVOHHzsv7");
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        Address address = new Address();
        address.setLatitude("rI48eOSfCc7FtFJZRcgKhPNU84t0jVZtw278koZqU5Pt3rtODf");
        address.setZipcode("gK06Gg");
        address.setAddress2("qaV9QsEGK0Ln4iKRaTaCla2O08ma7uJvabxq91H2JUksiL1soX");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressLabel("nqhpHJzq3sp");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress3("iwMee1tPCuc62qrEHqQTNWpGuJwdJDfPwYg3DycTat5NeIx3r2");
        address.setAddress1("f2SAwjBgKiJ8MUVByp8VO4JX3DINLHo2QepWqY9XvAjaHQF6cC");
        address.setLongitude("6rmw5s14071XwwYBm6elpsHKU68upNJGfmwJLE9wziMcHwXzDw");
        address.setStateId((java.lang.String) StateTest._getPrimarykey());
        address.setEntityValidator(entityValidator);
        return address;
    }

    @Test
    public void test1Save() {
        try {
            Address address = createAddress(true);
            address.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            address.isValid();
            addressRepository.save(address);
            map.put("AddressPrimaryKey", address._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            Address address = addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
            address.setLatitude("Jlo3CeK8Bb86uRsBNZ5F8btznGIGwuOf9LxCx5kj1s3Nn6aTU6");
            address.setZipcode("UiILiX");
            address.setAddress2("1kQOhpi7b5v0hhornC2QqDhmjjUljZZ8Ct3s4XdVgi5rPGJy5P");
            address.setVersionId(1);
            address.setAddressLabel("G20KqjXj2Us");
            address.setAddress3("7MJk1jxgsKYil2x6htiERobVU7lg0EDAYWJGtPhFaiYNUhoBjS");
            address.setAddress1("fChzHRRURYvGA9sDNdsCcC9vcM014GVWizNtaTzt8weDXJJvGX");
            address.setLongitude("CjIIRUNCSCOO6zDhHIQSLxbRiZFlgS9M4eyfJy0nZLg3FZZkvJ");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            addressRepository.update(address);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Address> listofcountryId = addressRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
            if (listofcountryId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByaddressTypeId() {
        try {
            java.util.List<Address> listofaddressTypeId = addressRepository.findByAddressTypeId((java.lang.String) map.get("AddressTypePrimaryKey"));
            if (listofaddressTypeId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycityId() {
        try {
            java.util.List<Address> listofcityId = addressRepository.findByCityId((java.lang.String) map.get("CityPrimaryKey"));
            if (listofcityId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBystateId() {
        try {
            java.util.List<Address> listofstateId = addressRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
            if (listofstateId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.delete((java.lang.String) map.get("AddressPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateAddress(EntityTestCriteria contraints, Address address) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            address.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            address.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            address.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            addressRepository.save(address);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 1, "addressLabel", "QCp01jIe0fjD"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "address1", "iA9maJ5ny7Q6YH7uBI21eVT3sHpnw4yyez0rUqz5sJLK0TdRJPLDc4AEZ"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "address2", "i1Po4TuOjbCiXIYvYslIdYQCTjWmfITPEPoTvRDFhnT2teKfiI072yIsa"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "address3", "YcKEJPg2UqzgSnaCFFLQvkV6463IBxJpfRJIoU10sOLmWeiizfvoSB05b"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "zipcode", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "zipcode", "qBBDFb0"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "latitude", "HABI1RggUgJ5wJZvQq3LX3PRASsdthAogagAYySAnKBvq2Mf1OjqWRnx94zKU3lal"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "longitude", "Y6g0VBGeLeZe2eEkr7q88OVEFEjRKyiLanVoY1uXlYt5Mf6eplHJSfX8ygjMhSIWr"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Address address = createAddress(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = address.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        address.setAddressLabel(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 2:
                        address.setAddress1(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 3:
                        address.setAddress2(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 4:
                        address.setAddress3(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(address, null);
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 6:
                        address.setZipcode(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 7:
                        address.setLatitude(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 8:
                        address.setLongitude(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
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
