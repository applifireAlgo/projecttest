package com.app.server.service.organization.contactmanagement;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.organization.contactmanagement.CoreContactsRepository;
import com.app.shared.organization.contactmanagement.CoreContacts;
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
import com.app.shared.organization.contactmanagement.Title;
import com.app.server.repository.organization.contactmanagement.TitleRepository;
import com.app.shared.organization.contactmanagement.Gender;
import com.app.server.repository.organization.contactmanagement.GenderRepository;
import com.app.shared.organization.locationmanagement.Language;
import com.app.server.repository.organization.locationmanagement.LanguageRepository;
import com.app.shared.organization.locationmanagement.Timezone;
import com.app.server.repository.organization.locationmanagement.TimezoneRepository;
import com.app.shared.organization.locationmanagement.Address;
import com.app.server.repository.organization.locationmanagement.AddressRepository;
import com.app.shared.organization.locationmanagement.Country;
import com.app.server.repository.organization.locationmanagement.CountryRepository;
import com.app.shared.organization.locationmanagement.AddressType;
import com.app.server.repository.organization.locationmanagement.AddressTypeRepository;
import com.app.shared.organization.locationmanagement.City;
import com.app.server.repository.organization.locationmanagement.CityRepository;
import com.app.shared.organization.locationmanagement.State;
import com.app.server.repository.organization.locationmanagement.StateRepository;
import com.app.shared.organization.contactmanagement.CommunicationData;
import com.app.shared.organization.contactmanagement.CommunicationType;
import com.app.server.repository.organization.contactmanagement.CommunicationTypeRepository;
import com.app.shared.organization.contactmanagement.CommunicationGroup;
import com.app.server.repository.organization.contactmanagement.CommunicationGroupRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class CoreContactsTestCase extends EntityTestCriteria {

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

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

    private CoreContacts createCoreContacts(Boolean isSave) throws Exception {
        Title title = new Title();
        title.setTitles("M1bxirRDRAg8N88MpgAd3McGoSHQ7JfSDUFMItsGpq0LgS5K89");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        Gender gender = new Gender();
        gender.setGender("UKfMJzPSs086MDr5jHV4LXjp7tiriWzgddVgbyQo0XTYnPvxPS");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        Language language = new Language();
        language.setLanguageDescription("FLtpQKg8TbOwqhEAmRXGj2L9PykA7P769fhyoKLGAq4orWkfml");
        language.setAlpha2("Bc");
        language.setAlpha3("CtZ");
        language.setLanguageIcon("oHqpCORDWFhCu8hQXd0CEpGITkPZw2yOHCMzHVaffQ8GFSHTWf");
        language.setAlpha4("wHG8");
        language.setAlpha4parentid(4);
        language.setLanguageType("e4UXQUKvZ88HfaQMNVh3yFU5iaxE8RZ1");
        language.setLanguage("HWd2ffFei2ChyQi0HUGiYFvHsNfndhOerH6Iygfu4UZXjE2yEm");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        Timezone timezone = new Timezone();
        timezone.setTimeZoneLabel("3c3QWSHKgObeVAqSmzPYEZCwQqNrMO2fpWV7gpZb6shtC8Bk3F");
        timezone.setCountry("ALLLob170DpztGsxq5ZRAFgLDNEjOPXkOu6j3wHNeuJYiC2WeW");
        timezone.setUtcdifference(5);
        timezone.setGmtLabel("p2sfRvV8fTNZO3TNvDtc9nEceyi6rp4qsT3Y2fAqc4ctsmUs7K");
        timezone.setCities("Kw2o6ZsfP2WBCgUw9wTTv5XMmkgTSzQ8Ypr4XfCm8tWPUebD8Y");
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setDateofbirth(new java.sql.Timestamp(1465554016463l));
        corecontacts.setAge(42);
        corecontacts.setNativeTitle("g75ZbplZQtfQn9duxsCENAqfleIW8OZmuR9HWUeAee62IMpVxh");
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setMiddleName("ZSfWilcFdFxMCnaULTiXVwBMAZrv7xnYHIuOVJHjMGrpDqEQTo");
        corecontacts.setLastName("cJv4OZUNwtHco5KGCQACliPKRefVijHFxLT6yYYu1h8QNFQ46I");
        corecontacts.setPhoneNumber("Y2Erx1PTWjk5XzfBRTWS");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeMiddleName("EYxHMVg5dz1lmHcCDbkwsyoXDwDub12jUhtNXSuBg7l2TgZmJh");
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1465554016970l));
        corecontacts.setNativeLastName("RwJQ3SLr2RvuGVAChQlQwtconpQrsW80AGzIv1Xtm3KA0kA34Y");
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        if (isSave) {
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        }
        corecontacts.setFirstName("mH7d8D3WrfG7ytTCIoFnnJGsJkNkXTQxopzRweUqWjnw90RZLB");
        corecontacts.setEmailId("nxZwXclBtckkXEqWQlZwbI3mQgNJX5Cmf2W8LelkDOCwG0cnjl");
        corecontacts.setNativeFirstName("IEC88WgZ4V9hUzkxJjEHGDbOv8RJyffTevhFQuY5xuusQnKjJh");
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        address.setLatitude("2xzp4eRcdkxmhz6MQAg9bTgcEDpJS5gcO96TMnAQ2KWdSCpcKV");
        address.setZipcode("n9ypFi");
        address.setAddress2("lovbkJOErInsiFhGOyXB9uealOPDEdFnmeiWZMsmdYpvDcO3CD");
        Country country = new Country();
        country.setCurrencyName("9YJ1bMxoTFGkgBHxXfZPPtwXnFlotMYrkT5xXhS46vN5kwlWAi");
        country.setCapital("L602RXLWyRWNepH3eUvAmvKxUUVdzF0p");
        country.setCountryFlag("7vHTRqD7lqGDrMZebDY4viilyHBKUyHtKrewmZqexrfTL1X7dY");
        country.setCapitalLongitude(3);
        country.setCountryCode1("H28");
        country.setCapitalLatitude(2);
        country.setIsoNumeric(495);
        country.setCountryName("0YfDGFy9eOi5nr6StX2fBUACmFqC0XFmrHq261pY4V525EOqwl");
        country.setCurrencyCode("Fmw");
        country.setCurrencySymbol("6DRC95w7BvOnvU1bvY307tf9xZx53HD4");
        country.setCountryCode2("1a3");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeDesc("mM4qHx5EDPBOurEmBsx5bsUxVcUt670LwjD6JxYqd15GXnHN4R");
        addresstype.setAddressTypeIcon("OPDorUHnUuwegKH0GannP99OY5WrSC78kR2eDCO11j2mEKS1QH");
        addresstype.setAddressType("9wbixxiQ25agzGCrGAVzcVhkDIifNtdKVez9ntCSNVQAHj63Xv");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        City city = new City();
        city.setCityName("jVbPsVCtKwJRoBQ9KM8knh7QVbF2tD1JOWMAEsiLI43WcF8Gso");
        city.setCityCode(3);
        city.setCityLatitude(10);
        city.setCityDescription("jXpKKmszzOjD4NwEL1VH6Be6uUyfD9Grwz9KaMK9laicHyqAh6");
        State state = new State();
        state.setStateCodeChar2("34Gbt3hVvb6zFiKFfRhvk2Jqfe8RlthN");
        state.setStateCapitalLongitude(2);
        state.setStateDescription("zgJe4WrPgDE8czONz3kDAyWTS8vAKG6pnt0jGcEK1Yn0waclc7");
        state.setStateCodeChar2("4jKQ8QJZK8CG6I7RiRRYaCbjvWDqD2NJ");
        state.setStateCapitalLongitude(4);
        state.setStateDescription("RLxhhpJpt8DFbW4nVvLhdcFKCtTA8gP0TH3VCwtwoyBeZ9cVqC");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCode(1);
        state.setStateCapital("9VomsD94IpHk5R4LWN8ISUalKhQYwx3osFWkKZvqfBHLESFeg4");
        state.setStateCodeChar3("NKjN03giNSa9avjpkxC8ubada3LBzQiY");
        state.setStateCapitalLatitude(7);
        state.setStateFlag("JdJm0oMUXn1nMbjG4o1t67KCUvKR60YeHQUFQ5O9gaYybv8ICW");
        state.setStateName("AXoURFFg1SFikOwbLU5NBA6waeujo1nM8o25sFxMJi8SwxqCIP");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        city.setCityName("FkuJ1wzKgbCMzT548oNlJ9bFScCRK4hDMW7HdN9HtdECI9heMf");
        city.setCityCode(2);
        city.setCityLatitude(11);
        city.setCityDescription("CxsAiMsCJR7uvECr2b4FM0JJPUYS2qF8GwPcIVYRxmHubRz27j");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityCodeChar2("23xrs0jhtrv8iiYOyLXp862TbjATUSuy");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityLongitude(1);
        city.setCityFlag("94nv9HlRmaCHnilgLthNTZOP3T1Ix222izzZAlVqiUVOrrkMxH");
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        address.setLatitude("tsax6ymt8qpxm2TISkw0g7WqlaQ8V2koLr0HGaZAQ7ij6yt7dW");
        address.setZipcode("Oxs1WM");
        address.setAddress2("VRwlX8tnjfHiLlyDOGN4qEJQxAsOP68FL1I4ZR6vu6MmWnc7dB");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressLabel("KpFibRFZ1lx");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress3("bMHJUksKF7H58TXJpdz80TIlPuHxuIw9JlftujnwReUM5pxynQ");
        address.setAddress1("AHyuS1aiqIGsABTttudUeWNuLDJITEuL8oxpWJLQ9iBIb0RjZo");
        address.setLongitude("C51A0XbV4U3crDEPmc1U2AFWqKVONdCWiI1wEF2l7SHSynecOl");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationType communicationtype = new CommunicationType();
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("PIpSznw9lFVCIvcFHVbZDpvKARDSNWKfPVqJEeTV5cZl8D51pH");
        communicationgroup.setCommGroupName("ZZZofIgPrLNYSKfh3YBFUCHtJXx10wDaWygzKGziBq9FDIX8Qt");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationtype.setCommTypeDescription("b9tSKs71bQqwo3iKkO7oSX7AcTFVYSpAXpb5kysNxh2b0slMyi");
        communicationtype.setCommTypeName("HuOeSIC7ih1OACbZEIP7p0d4J7Vf5ZNmJdRFHU9WXG6zHxgGTJ");
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey());
        communicationdata.setCommData("xNipP0GJ61");
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        corecontacts.setEntityValidator(entityValidator);
        return corecontacts;
    }

    @Test
    public void test1Save() {
        try {
            CoreContacts corecontacts = createCoreContacts(true);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            corecontacts.isValid();
            corecontactsRepository.save(corecontacts);
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setDateofbirth(new java.sql.Timestamp(1465554018849l));
            corecontacts.setVersionId(1);
            corecontacts.setAge(59);
            corecontacts.setNativeTitle("uthQ25dSAdOWkyxHAAjpveefm94k87se7hRvmyTd6KGkh2bQjO");
            corecontacts.setMiddleName("IKZBWLHxtGyHF6vgsa0UNHZ21558wwDRXio0Q9enTPUnTHCPkJ");
            corecontacts.setLastName("yv0tCQCz7W8lqO9c1ryfTMPUh7jWXNNvFUMbdRT9YTIGDoHOhT");
            corecontacts.setPhoneNumber("QYhR49LUtF9uonn1ZRzA");
            corecontacts.setNativeMiddleName("r0bXdu2aU79coksLVdgnpWWpC39YBXENtWrArNYxGMuodniJBJ");
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1465554019345l));
            corecontacts.setNativeLastName("NUHojO7wD7ivgBds9Iyr7MrUHj0IbqwVkUTpaRXH3OHA7xFPL5");
            corecontacts.setFirstName("NouCgj9dD5NDtmraDpXlFSKLJupmcZ0pMOGXy2g7lmy2LTH4TX");
            corecontacts.setEmailId("EPKsar3vc1Zr8q1gNmpWvx80iemXfzrf1ZluXSbCk402ofByz8");
            corecontacts.setNativeFirstName("tjwTSr5ywqgORHyG8FskeZNoeAcAF2eFDQapMT70yX3THcrNpk");
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            corecontactsRepository.update(corecontacts);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBytitleId() {
        try {
            java.util.List<CoreContacts> listoftitleId = corecontactsRepository.findByTitleId((java.lang.String) map.get("TitlePrimaryKey"));
            if (listoftitleId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBygenderId() {
        try {
            java.util.List<CoreContacts> listofgenderId = corecontactsRepository.findByGenderId((java.lang.String) map.get("GenderPrimaryKey"));
            if (listofgenderId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBynativeLanguageCode() {
        try {
            java.util.List<CoreContacts> listofnativeLanguageCode = corecontactsRepository.findByNativeLanguageCode((java.lang.String) map.get("LanguagePrimaryKey"));
            if (listofnativeLanguageCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.delete((java.lang.String) map.get("CoreContactsPrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateCoreContacts(EntityTestCriteria contraints, CoreContacts corecontacts) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            corecontacts.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            corecontacts.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            corecontacts.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            corecontactsRepository.save(corecontacts);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "firstName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "firstName", "8KCHUqk4HvjpiOYPXjkBjZDDtIVcmrtfD3bA9bYXzWlhX7DdKPDDDCgo5o47Z3ZUptksz8OspJS4N6EPYe8BgmxJ5QygsIQ2nJiRIntI5puBljt0wEqP8WcdgQF1FaIGx1B1LjSfamMcG0nHiZcgyxGmyXI8cQj73LXD8313je4vyY7euY5VGetJm7E1p19SUuzAW6Tbl5opGjd0jgjzfdKNvCHElMrjm8pQixZEpXfi7QkM4HYEwzEotVNbGmAlk"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "middleName", "i2d8XzjyrEc9oD2tGWxtTnfdKkKpNvTm5Czlf5jDR1SpGDiyn1DSG01b9Xs9y3Rq9LKeZIgGmQoNrl5cPJujR9MxKvQ0wEZvOKD3qPATpm4D5YB6IuSQCFvmNm1ZKoexhBciRg2nv1plFDgln9gzCXbtNsBr9suuczOj8bq6QOnx27UlDE9Mq7ER3kcGvOPJtbbiEfIMh1IvnJQrqtOZrVvzrIymDWVvqrTGWfaouyeZrANf4V0UcEBWomhraOIpr"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "lastName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "lastName", "xPoju9oXmSNnBCU5Q2itXrvEMKFTLy0gzF82ICBAEytXKRYLELe7wlLOeYQNH1m2o1p0vemKIAROqfEjzZqLEUByEekIEV6j4dSsqhgPuhpDMP9fPwtiujjNQ4U9oWiLF7rwI0ikRnx4O7eb23HHEcOu72VaOy1IR89ZmQZzDEVNMQCZOofkuYyxYKtjdzqQuNgA4PA2krZPxXeC7GlQ3fIiWLvI45sEuqqbwiWulEOEup1uvPyu4ya8CEJv1qJC0"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "nativeTitle", "jn7VAEuJ909Gms7yJUBRPfbfuoNUGeCGGr4ZV5QQ3uPly63WpDa34jDtjmEGe4i0B"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "nativeFirstName", "KVn8OjwCpUFJcYEk9miXtUNnMdEQ08RtQeIQcimuFldW55ybYukpLINuWJn4r8qihrQIS3afFa6nrHtnUiXbCDp2qSXzSlhW5vE2S9e0Cj8knGJTRh5UDGie2DwCKzGSwWSkrM5OKPMKPjUkvQsErz4Z22JEieDAezlMFRkyfVMGmlhYUlCUTqePONphbvV7jaGb9szIRbOVkKytXHHdmBEmYSs2GNhD3tBhdR0h2u8vyfuiUZbPJAE4sHO60K9iY"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "nativeMiddleName", "WGkkrisj54BQ8XK8mDEOUPzahOhGvhUX4kX5gb95B60WCvBj1xTwDcUu0pAzQMPuZK7z48gAHhETi5Kmxwah1fbu5JsVLY4GAwn3pafpCYcyHaMTRpzeqImxNHfNb7o2q3oKV2Eh0GPQDGoT3MkXsC21f6Avi3z4s5WRgnUsmvMmBp4rynDTvLJt4WMsv0NjEMBtGE8ddlrxja03VLUA1sCiIDdEJIAIV2Q1wmI4WGIqXxoy7pUjd1Vm4KEmx3yZw"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "nativeLastName", "a8CmYB9Axan33bN95CC3wAebSWZ4X2E2H4Zy7O5Z5zaZFR4doUyDmHRWd0wum096OtEPVMOuL9SIiqhYxlYoy8PSQcj8UlUT61nuxhVqQ8sgn19TWlJqEajXKlyinVmcNnZxcJaGKuqBfEVvFhmbCQgODQaywIi7KQu1tQBP31j3V1nBVggnX0qcz5qoHXEHfQ9ikbGbZ9fQCvGljeeCtylYRpaQQEkZrl5Dtcf9FWihTWDOdQfi32ov89Qjsv67r"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "age", 178));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 11, "emailId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "emailId", "Aegs58rogB8Q8iLoB4fB2EsYxZ7IMhavlPwjF0lTL1hc2alfIRQD9R8UIaQs9xC2Yu2rMthidH0j6IzOY1h21qHJF0CwxUNAt6GSLijLKZjRCUvtRskSTMJhgVJhd1HJOmotoJa4Wn6zgnip7rFOfrKOsGGLta6NZl76WEyDBZg61pvXP4atPIH9IpvK349Yq2oTQkkIT3RW7GNBW6AjPV8hEBWnJ5g4F51tfHFUPorpAsdsV1VepnyAHqhN1Vm2j"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 13, "phoneNumber", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 14, "phoneNumber", "otcReH1qZamzDgdfyFu5W"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                CoreContacts corecontacts = createCoreContacts(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = corecontacts.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 2:
                        corecontacts.setFirstName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 3:
                        corecontacts.setMiddleName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 4:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 5:
                        corecontacts.setLastName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 6:
                        corecontacts.setNativeTitle(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 7:
                        corecontacts.setNativeFirstName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 8:
                        corecontacts.setNativeMiddleName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 9:
                        corecontacts.setNativeLastName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 10:
                        corecontacts.setAge(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 11:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 12:
                        corecontacts.setEmailId(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 13:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 14:
                        corecontacts.setPhoneNumber(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
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
