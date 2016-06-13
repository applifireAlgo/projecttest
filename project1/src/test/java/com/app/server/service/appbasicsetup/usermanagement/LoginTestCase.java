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
import com.app.server.repository.appbasicsetup.usermanagement.LoginRepository;
import com.app.shared.appbasicsetup.usermanagement.Login;
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
import com.app.shared.appbasicsetup.usermanagement.User;
import com.app.server.repository.appbasicsetup.usermanagement.UserRepository;
import com.app.shared.appbasicsetup.usermanagement.UserAccessLevel;
import com.app.server.repository.appbasicsetup.usermanagement.UserAccessLevelRepository;
import com.app.shared.appbasicsetup.usermanagement.UserAccessDomain;
import com.app.server.repository.appbasicsetup.usermanagement.UserAccessDomainRepository;
import com.app.shared.appbasicsetup.usermanagement.PassRecovery;
import com.app.shared.appbasicsetup.usermanagement.Question;
import com.app.server.repository.appbasicsetup.usermanagement.QuestionRepository;
import com.app.shared.appbasicsetup.usermanagement.UserData;
import com.app.shared.organization.contactmanagement.CoreContacts;
import com.app.server.repository.organization.contactmanagement.CoreContactsRepository;
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
public class LoginTestCase extends EntityTestCriteria {

    @Autowired
    private LoginRepository<Login> loginRepository;

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

    private Login createLogin(Boolean isSave) throws Exception {
        User user = new User();
        user.setGenTempOneTimePassword(1);
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelName("jYcHRInrvtMvrrxiim94auQ4Z7hyyB3ARPd3zLosXL6ncs1jIw");
        useraccesslevel.setLevelIcon("hji3aqdv6I8LlPw2B6C4kbswj2iWAcPrG9fZnDGgYOQQ3esmoM");
        useraccesslevel.setLevelDescription("359moOyjr3eelVteajoY1TbnHDck1d4lxJoQsiD43W3f5WkvDm");
        useraccesslevel.setLevelHelp("JJOKZ0dBkAKesvSOGkAweyEZBevZh2AWEFBq7SZGvmMJRFdT3P");
        UserAccessLevel UserAccessLevelTest = new UserAccessLevel();
        if (isSave) {
            UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        }
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setDomainDescription("9qsFQl6i7sr5dyTbPzFtReR949NMrhE2NWo9YJ49sECKE4YGVL");
        useraccessdomain.setDomainHelp("AdM3eXAVG5EjIpXUIk2fp7f8L57urm1GsQyCQPpJRUI9VQTSyO");
        useraccessdomain.setDomainName("jMJRgrNNUgQM3uDTnigYwxHwSojw4Mn4tgElByvu7IV1yGGff1");
        useraccessdomain.setDomainIcon("NhcSkil0USeHx8CRrHHHy5MdmPJUaHx1psNQKoLlhDu3AZ72SL");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        UserAccessDomain UserAccessDomainTest = new UserAccessDomain();
        if (isSave) {
            UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
        }
        user.setGenTempOneTimePassword(1);
        user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setIsDeleted(1);
        user.setUserAccessCode(11434);
        user.setLastPasswordChangeDate(new java.sql.Timestamp(1465554064649l));
        user.setSessionTimeout(2926);
        user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setAllowMultipleLogin(1);
        user.setIsLocked(1);
        user.setMultiFactorAuthEnabled(1);
        user.setChangePasswordNextLogin(1);
        user.setPasswordAlgo("a9DOFRAf5a3XfUACdV8YAtYaLibdAAMxW0HRxDLWQul1QV9MXh");
        user.setPasswordExpiryDate(new java.sql.Timestamp(1465554064803l));
        java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
        PassRecovery passrecovery = new PassRecovery();
        Question question = new Question();
        question.setQuestionIcon("q0Q9tnSUFOUtS1IUrpOEwpNi1nQFPYaoAUSxA4KlgHOmCTUfWU");
        question.setQuestionDetails("BhMYOdvD46");
        question.setQuestion("XBD6hlyXQ4sYMaCiEBfsqguLBPcPhegE5uFz4A3aHDV3EJ3Ebt");
        question.setLevelid(5);
        Question QuestionTest = new Question();
        if (isSave) {
            QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
        }
        passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey()); /* ******Adding refrenced table data */
        passrecovery.setAnswer("5nMpOqVXt2gtwsJZVsJrR5cfeKGS0dAbnr5eRlbGyeFLMwYL8B");
        passrecovery.setUser(user);
        listOfPassRecovery.add(passrecovery);
        user.addAllPassRecovery(listOfPassRecovery);
        UserData userdata = new UserData();
        userdata.setLast5Passwords("uZRsF0UVlx1C99n1YJqDOcvh80UrVpuEofJPhdY1zDQTZYQ6Ou");
        userdata.setLast5Passwords("YPct4ejA8QSPVa5k75Vrj8Gj9bbyt9sqxSiA2F3rGXwY4GeM7q");
        userdata.setUser(user);
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1465554065855l));
        userdata.setOneTimePassword("tjrjZpMfRl3QVftG5sC8MQ0jPDn4pXhQ");
        userdata.setPassword("sfrDrZ3Id6XiabIqL6Z9W6OGoHdJSHhoiMbyCBulooYrOtYR04");
        userdata.setOneTimePasswordExpiry(3);
        user.setUserData(userdata);
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setDateofbirth(new java.sql.Timestamp(1465554066204l));
        corecontacts.setAge(69);
        corecontacts.setNativeTitle("3qlRHTqDodX3wAAM41QSOoL3dYu60XgsKkB9ruq6UCXpcKP4nN");
        Title title = new Title();
        title.setTitles("o7LQFq1IfFComyoKkrsW05n6DXrroIaJ2uQ7SaMuSuQmZvfB3u");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        Gender gender = new Gender();
        gender.setGender("4PySn7Dc69qow8YIKPnQ0H4FJi7rnLtsdbOQExvGzxLziSBzNZ");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        Language language = new Language();
        language.setLanguageDescription("DiI4hsaFe9aNi4sxqJADDpB7bgsXTy451BR9YMm8ux1ewdJE4M");
        language.setAlpha2("FT");
        language.setAlpha3("7sw");
        language.setLanguageIcon("CzIhFKFl87OWQncJsgpBm9vBoxRW7WV9aYwt1gqaX3WHVHuuBe");
        language.setAlpha4("ESIs");
        language.setAlpha4parentid(8);
        language.setLanguageType("oe0uPxK9OOheEe0iiR46zzquDgL2gpPy");
        language.setLanguage("f3P37sd4sK1JKzX1ZBlcpJ1YYNsmiMsgIt4hnGi9gpin1OJupF");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        Timezone timezone = new Timezone();
        timezone.setTimeZoneLabel("BQtxVRbPf6NQ869XGJwAuQzn3BkVN75Sp9CGcCC6n0kPIkZdAM");
        timezone.setCountry("ZdhYJPoewxpKsCZyaDVSuMnTKyubTlvWS5y7Fz3CrGioMSd583");
        timezone.setUtcdifference(5);
        timezone.setGmtLabel("bYnzQVWWk4pjqtBS4cX62mM0gnOA6Up5hWHO9NHSQ5vVMBgaQ3");
        timezone.setCities("EC9qJi7bxeuc7qhUbVXMN70rqh2EJIywJmXG9Z3TvqDgt5BfPS");
        corecontacts.setDateofbirth(new java.sql.Timestamp(1465554066303l));
        corecontacts.setAge(44);
        corecontacts.setNativeTitle("jxc6Ds0M8SlLw3btAVklKxvybGN2IcZ4T241SxeDut2Rz18LtI");
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setMiddleName("UJaFXaYyhnAzIDWvSOFk0tchTxfmUUgt6Rqfrq4rNnWuZvlHGT");
        corecontacts.setLastName("Fs2cSZsfiCIYbrL2b7RgUzUnIL1r0W3VWClO3BcU4gbJzFVk9a");
        corecontacts.setPhoneNumber("GxRmU5U2o8DBuwQZP2Qk");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeMiddleName("Jah7MeE3izCH0xd6AI0b7SD8RY6ojkWMw9BzcxoeopmLgBD5hQ");
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1465554066807l));
        corecontacts.setNativeLastName("gLJny43WTbG9F9HJrcAamJkIfUA2j04ZUwOI1T51rnAuaz6MSx");
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        if (isSave) {
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        }
        corecontacts.setFirstName("WaRY0QZrGcgAsIvjjUxCPlAgLwKeFD5NNZkQY0PzXJTAnwAldO");
        corecontacts.setEmailId("XA34q8icgIP5A42uX5bkCH6OwPOakQjucMp1GM3fbdcdCsjcGU");
        corecontacts.setNativeFirstName("vvrlGgKM7G9y1NvxdmbWII2gOv8LOXOPWXWHMV98djPtuA4cVJ");
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        address.setLatitude("GaKObj5I6B1g2Z7k2c2XBsF5bNPXg6XC35ORilJBKkiR2yI3LR");
        address.setZipcode("HePQ9G");
        address.setAddress2("tCIeAuASISTd7HDUp7QbB5EsxwoUiEStTnjZqhuyRfBPFUN56c");
        Country country = new Country();
        country.setCurrencyName("09KQAbJ4BYRPs2XF2ilaIlDR7by3SHrpg6Hquc87NgEmWOcxXk");
        country.setCapital("9PncVyEFeOCy4AXSVuHNr3P2nhcNQMCf");
        country.setCountryFlag("a5WJ0OjgjjBmYE2Q2c7yom2YYWUv93B7MKE9mAt1xQkX7ZSVg8");
        country.setCapitalLongitude(10);
        country.setCountryCode1("O7t");
        country.setCapitalLatitude(10);
        country.setIsoNumeric(187);
        country.setCountryName("tRvfaDIKfoc1HeAiK9nTZPpgytvtDoJSOZREGagAazTZ4q9EKX");
        country.setCurrencyCode("ov6");
        country.setCurrencySymbol("bcNdNeX4xsdEgdwMADfVQebv59KTDLZo");
        country.setCountryCode2("6y9");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeDesc("VpzT0EPZKgWBgrDZkwmpTAYNkw6nUzthNd31aIAGbXxfuf5uKw");
        addresstype.setAddressTypeIcon("nEpqqksJahm1GRNLrBK9R7AgZcbUBjwuorJxRb5Z95AX1QEt63");
        addresstype.setAddressType("4581jBcEWdQBY3hRHrRRxGMd25HKguYZzqlD02eu3DEqq1nFcI");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        City city = new City();
        city.setCityName("fLg50XyXO0iw3XOZTSf8L8SNZmk64WSZ9guMOicXc8aIZcYSGY");
        city.setCityCode(1);
        city.setCityLatitude(7);
        city.setCityDescription("owOaRAY8dDSsIISUDTcRekZYgcRxO53syQjWZ1haKGPudAbeDD");
        State state = new State();
        state.setStateCodeChar2("PByDX1V5UNLDhH1EtyjALudTZ2yi9BmW");
        state.setStateCapitalLongitude(11);
        state.setStateDescription("fwuqj3lsRN1MQOeOoMWFaPYSRJsqtNG5vm5LqzAGung0EWE5Mq");
        state.setStateCodeChar2("u5a2PEzeG952L7K4ieMdVaEwdzGg6pDL");
        state.setStateCapitalLongitude(4);
        state.setStateDescription("RKGd1Rhv0bb7l5uTFTLnsjzbaikwHbBn2ly61ADpjZCbdU7eUJ");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCode(1);
        state.setStateCapital("8NU9qyA7qSmOFbAbILeUE3JRTsFGfIzBcR7TCUx6GGUmydMIAG");
        state.setStateCodeChar3("JZMmqvAEEpwOulC7Nx9b1y1CPGhi5yss");
        state.setStateCapitalLatitude(11);
        state.setStateFlag("YQr7gzNZdgy1ZeePziAgEgiq8YKyLo3eov22NRIDZqX99Aoscl");
        state.setStateName("Qb6C0KDz46Noi2CnoEFxTNaj50Oho0UsVBA2pPIUe7jwGndagH");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        city.setCityName("6UxvUxeJtfoVVdVELf4KFxSq2tYijqoMZdRjBpxAnHYYMga7IX");
        city.setCityCode(2);
        city.setCityLatitude(8);
        city.setCityDescription("XQrYPWNY0dSDEGVnfev17Kkh78YwDYCTnpNyGSIv62dhEtx2dI");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityCodeChar2("3nzMdwwl2ANyA4uFIXbDNjQo7hpreisA");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityLongitude(5);
        city.setCityFlag("V82YrXqKhpZcbz4Y0BKBy3rKFa50Wb9cRzFEv0FbF7etSDnlCO");
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        address.setLatitude("MNgNDiNsQrRLC9iZpYRZVWjV12l4ClergVhb7ZRNA4qd8YViUj");
        address.setZipcode("IzraGa");
        address.setAddress2("jhGLxgQM2sHQQ7zXxQCER8YdPRnj64IYxiseXg3PhKNzp1HHtj");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressLabel("bX1PUGRBqZl");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress3("O7wGM26JYzHiUy4dcn2tr5XyJhs4cRgZWxdes7CGbM0pd01nFP");
        address.setAddress1("h7eity6yKMIj3fXqeQLYLgpqo0JDEIOX9zM3nAJW4zRGVyxqiV");
        address.setLongitude("dwV63bEBZuiQZ9QmYnLnkfVA2pwAOAPsGYmZZfRziy9cxn3zuX");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationType communicationtype = new CommunicationType();
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("pVCjIYO2yuEviD7FykPYbR8HRIXBXKCxHKqiK4jsHknzk0EexI");
        communicationgroup.setCommGroupName("byJwztzW5zWGVLwZHSGeCPp8YECwzOgvLdusin19VlPPCAw6Hz");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationtype.setCommTypeDescription("OYy4RBDAd4VBDdQF9tJUYhxHzI0NTmaRdq1HPQq9Ej5IueLfbQ");
        communicationtype.setCommTypeName("iBLXj3V2nZi9yCu1WZt3cBWhwm6qmxI4Rhr5Y1QZg1uHkgwEyC");
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey());
        communicationdata.setCommData("Achs7yNwrX");
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        Login login = new Login();
        login.setServerAuthImage("lTIVYPyzPYzG6h7ovQWvPivTjR6MYoZV");
        user.setUserId(null);
        login.setUser(user);
        login.setFailedLoginAttempts(8);
        login.setServerAuthText("kuCE5KWMq9KnNGy5");
        login.setLoginId("7aG16yJbbndT3E3VP1ZYkvb9Tc1qlXa8QoQMRisWh0yTfmrqyg");
        login.setIsAuthenticated(true);
        corecontacts.setContactId(null);
        login.setCoreContacts(corecontacts);
        login.setEntityValidator(entityValidator);
        return login;
    }

    @Test
    public void test1Save() {
        try {
            Login login = createLogin(true);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            login.isValid();
            loginRepository.save(login);
            map.put("LoginPrimaryKey", login._getPrimarykey());
            map.put("UserPrimaryKey", login.getUser()._getPrimarykey());
            map.put("CoreContactsPrimaryKey", login.getCoreContacts()._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private QuestionRepository<Question> questionRepository;

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

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
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            Login login = loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
            login.setServerAuthImage("ruP8j4jDbhxYmJ3vR82WY5BqraUZW00X");
            login.setFailedLoginAttempts(8);
            login.setServerAuthText("eUq85mTcGPFx75Eq");
            login.setVersionId(1);
            login.setLoginId("U0YQTOk1DBGKDQCLHP7WoogDYhAAEQFQrrLwRAYSP82M3hnxfu");
            login.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            loginRepository.update(login);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testNQFindUnMappedUser() {
        try {
            loginRepository.FindUnMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNQFindMappedUser() {
        try {
            loginRepository.FindMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.delete((java.lang.String) map.get("LoginPrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            questionRepository.delete((java.lang.String) map.get("QuestionPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateLogin(EntityTestCriteria contraints, Login login) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            login.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            login.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            login.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            loginRepository.save(login);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "loginId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "loginId", "23EFU6uRt5CvkH0HogGsdiHQNkdzFtaXge0iXpxRzQ45wYBXwST7ZmyfdqCyH8SL7z1JBdjCL9imtpsJml1mxh4ull7XxzUlT8FVx0a2e9EFmse7NC5m7kjksTytJ6O70WPRlvsEoxfJSy6nhQ22ieeH77SGnzmnwUQ42wwuWfa3pGJaB5I8bMh8pw1DTGjtoEm4RD8P7"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "serverAuthImage", "5MV3SNZGXPEoH0ROUwUz69lMfgG3xGlez"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "serverAuthText", "k53QEJR5GRRJCoNBa"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "failedLoginAttempts", 15));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "isAuthenticated", true));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Login login = createLogin(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = login.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(login, null);
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 2:
                        login.setLoginId(contraints.getNegativeValue().toString());
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 3:
                        login.setServerAuthImage(contraints.getNegativeValue().toString());
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 4:
                        login.setServerAuthText(contraints.getNegativeValue().toString());
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 5:
                        login.setFailedLoginAttempts(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 6:
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
