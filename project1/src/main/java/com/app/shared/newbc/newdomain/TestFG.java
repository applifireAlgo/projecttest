package com.app.shared.newbc.newdomain;
import com.app.config.annotation.Complexity;
import com.app.config.annotation.SourceCodeAuthorClass;
import com.athena.server.pluggable.interfaces.CommonEntityInterface;
import java.io.Serializable;
import java.util.Comparator;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheType;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;
import com.athena.config.jsonHandler.CustomSqlDateJsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.athena.config.jsonHandler.CustomSqlDateJsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.sql.Timestamp;
import com.athena.config.jsonHandler.CustomSqlTimestampJsonSerializer;
import com.athena.config.jsonHandler.CustomSqlTimestampJsonDeserializer;
import javax.persistence.Transient;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import com.athena.server.pluggable.utils.helper.EntityValidatorHelper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Version;
import com.app.shared.EntityAudit;
import javax.persistence.Embedded;
import com.app.shared.SystemInfo;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;
import java.lang.Override;
import javax.persistence.NamedQueries;

@Table(name = "ast_TestFG_T")
@Entity
@Cache(type = CacheType.CACHE)
@SourceCodeAuthorClass(createdBy = "taran2789@gmail.com", updatedBy = "taran2789@gmail.com", versionNumber = "2", comments = "TestFG", complexity = Complexity.LOW)
@JsonIdentityInfo(generator = PropertyGenerator.class, property = "testFGid")
@NamedQueries({ @javax.persistence.NamedQuery(name = "TestFG.findById", query = "select e from TestFG e where e.systemInfo.activeStatus=1 and e.testFGid =:testFGid") })
public class TestFG implements Serializable, CommonEntityInterface, Comparator<TestFG> {

    @Column(name = "fgName")
    @JsonProperty("fgName")
    @NotNull
    @Size(min = 1, max = 256)
    private String fgName;

    @Column(name = "fgDate")
    @JsonProperty("fgDate")
    @NotNull
    @JsonSerialize(using = CustomSqlDateJsonSerializer.class)
    @JsonDeserialize(using = CustomSqlDateJsonDeserializer.class)
    private Date fgDate;

    @Column(name = "fgDatetime")
    @JsonProperty("fgDatetime")
    @NotNull
    @JsonSerialize(using = CustomSqlTimestampJsonSerializer.class)
    @JsonDeserialize(using = CustomSqlTimestampJsonDeserializer.class)
    private Timestamp fgDatetime;

    @Transient
    private String primaryKey;

    @Id
    @Column(name = "testFGid")
    @JsonProperty("testFGid")
    @GeneratedValue(generator = "UUIDGenerator")
    private String testFGid;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "testFG")
    private List<FGPT> fGPT;

    @Transient
    @JsonIgnore
    private EntityValidatorHelper<Object> entityValidator;

    @Version
    @Column(name = "versionId")
    @JsonProperty("versionId")
    private int versionId;

    @Embedded
    @JsonIgnore
    private EntityAudit entityAudit = new EntityAudit();

    @Embedded
    private SystemInfo systemInfo = new SystemInfo();

    @Transient
    private String primaryDisplay;

    public String getFgName() {
        return fgName;
    }

    public void setFgName(String _fgName) {
        if (_fgName != null) {
            this.fgName = _fgName;
        }
    }

    public Date getFgDate() {
        return fgDate;
    }

    public void setFgDate(Date _fgDate) {
        if (_fgDate != null) {
            this.fgDate = _fgDate;
        }
    }

    public Timestamp getFgDatetime() {
        return fgDatetime;
    }

    public void setFgDatetime(Timestamp _fgDatetime) {
        if (_fgDatetime != null) {
            this.fgDatetime = _fgDatetime;
        }
    }

    public String getPrimaryKey() {
        return testFGid;
    }

    public void setPrimaryKey(String _primaryKey) {
        this.primaryKey = _primaryKey;
    }

    public String _getPrimarykey() {
        return testFGid;
    }

    public String getTestFGid() {
        return testFGid;
    }

    public void setTestFGid(String _testFGid) {
        this.testFGid = _testFGid;
    }

    public int getVersionId() {
        return versionId;
    }

    public void setVersionId(int _versionId) {
        this.versionId = _versionId;
    }

    public void setPrimaryDisplay(String _primaryDisplay) {
        this.primaryDisplay = _primaryDisplay;
    }

    public SystemInfo getSystemInfo() {
        return systemInfo;
    }

    public void setSystemInfo(SystemInfo _systemInfo) {
        this.systemInfo = _systemInfo;
    }

    public TestFG addFGPT(FGPT _fGPT) {
        if (this.fGPT == null) {
            this.fGPT = new java.util.ArrayList<com.app.shared.newbc.newdomain.FGPT>();
        }
        if (_fGPT != null) {
            _fGPT.setTestFG(this);
            this.fGPT.add(_fGPT);
        }
        return this;
    }

    public TestFG removeFGPT(FGPT _fGPT) {
        if (this.fGPT != null) {
            this.fGPT.remove(_fGPT);
        }
        return this;
    }

    public TestFG addAllFGPT(List<FGPT> _fGPT) {
        if (this.fGPT == null) {
            this.fGPT = new java.util.ArrayList<com.app.shared.newbc.newdomain.FGPT>();
        }
        if (_fGPT != null) {
            for (int i = 0; i < _fGPT.size(); i++) {
                _fGPT.get(i).setTestFG(this);
            }
            this.fGPT.addAll(_fGPT);
        }
        return this;
    }

    @JsonIgnore
    public Integer getTotalNumberOfFGPT() {
        if (this.fGPT != null) {
            return this.fGPT.size();
        }
        return 0;
    }

    public List<FGPT> getfGPT() {
        return fGPT;
    }

    public void setfGPT(List<FGPT> _fGPT) {
        for (int i = 0; i < _fGPT.size(); i++) {
            if (_fGPT.get(i).getTestFG() == null) {
                _fGPT.get(i).setTestFG(this);
            }
        }
        this.fGPT = _fGPT;
    }

    @JsonIgnore
    public List<FGPT> getDeletedFGPTList() {
        List<FGPT> fgptToRemove = new java.util.ArrayList<FGPT>();
        for (FGPT _fgpt : fGPT) {
            if (_fgpt.isHardDelete()) {
                fgptToRemove.add(_fgpt);
            }
        }
        fGPT.removeAll(fgptToRemove);
        return fgptToRemove;
    }

    @JsonIgnore
    public boolean isHardDelete() {
        if (this.systemInfo == null) {
            this.systemInfo = new SystemInfo();
        }
        if (this.systemInfo.getActiveStatus() == -1) {
            return true;
        } else {
            return false;
        }
    }

    @JsonIgnore
    @Override
    public boolean isValid() throws SecurityException {
        boolean isValid = false;
        if (this.entityValidator != null) {
            isValid = this.entityValidator.validateEntity(this);
            this.systemInfo.setEntityValidated(true);
        } else {
            throw new java.lang.SecurityException();
        }
        return isValid;
    }

    @Override
    public void setEntityValidator(EntityValidatorHelper<Object> _validateFactory) {
        this.entityValidator = _validateFactory;
        setValidatorfGPT(_validateFactory);
    }

    private void setValidatorfGPT(EntityValidatorHelper<Object> _validateFactory) {
        for (int i = 0; i < fGPT.size(); i++) {
            fGPT.get(i).setEntityValidator(_validateFactory);
        }
    }

    @Override
    public void setEntityAudit(int customerId, String userId, RECORD_TYPE recordType) {
        System.out.println("Setting logged in user info for " + recordType);
        if (entityAudit == null) {
            entityAudit = new EntityAudit();
        }
        if (recordType == RECORD_TYPE.ADD) {
            this.entityAudit.setCreatedBy(userId);
            this.entityAudit.setUpdatedBy(userId);
        } else {
            this.entityAudit.setUpdatedBy(userId);
        }
        setSystemInformation(recordType);
        if (this.fGPT == null) {
            this.fGPT = new java.util.ArrayList<FGPT>();
        }
        for (FGPT _fGPT : fGPT) {
            _fGPT.setEntityAudit(customerId, userId, recordType);
            _fGPT.setSystemInformation(recordType);
        }
    }

    @Override
    public void setEntityAudit(int customerId, String userId) {
        if (entityAudit == null) {
            entityAudit = new EntityAudit();
        }
        if (getPrimaryKey() == null) {
            this.entityAudit.setCreatedBy(userId);
            this.entityAudit.setUpdatedBy(userId);
            this.systemInfo.setActiveStatus(1);
        } else {
            this.entityAudit.setUpdatedBy(userId);
        }
        if (this.fGPT == null) {
            this.fGPT = new java.util.ArrayList<FGPT>();
        }
        for (FGPT _fGPT : fGPT) {
            _fGPT.setEntityAudit(customerId, userId);
        }
    }

    @JsonIgnore
    public String getLoggedInUserInfo() {
        String auditInfo = "";
        if (this.entityAudit != null) {
            auditInfo = entityAudit.toString();
        }
        return auditInfo;
    }

    @Override
    @JsonIgnore
    public void setSystemInformation(RECORD_TYPE recordType) {
        if (systemInfo == null) {
            systemInfo = new SystemInfo();
        }
        if (recordType == RECORD_TYPE.DELETE) {
            this.systemInfo.setActiveStatus(-1);
        } else {
            this.systemInfo.setActiveStatus(1);
        }
    }

    @JsonIgnore
    public void setSystemInformation(Integer activeStatus) {
        this.systemInfo.setActiveStatus(activeStatus);
    }

    @JsonIgnore
    public String getSystemInformation() {
        String systemInfo = "";
        if (this.systemInfo != null) {
            systemInfo = systemInfo.toString();
        }
        return systemInfo;
    }

    @Override
    @JsonIgnore
    public void setSystemTxnCode(Integer transactionAccessCode) {
        if (systemInfo == null) {
            systemInfo = new SystemInfo();
        }
        this.systemInfo.setTxnAccessCode(transactionAccessCode);
    }

    @Override
    public int compare(TestFG object1, TestFG object2) {
        return 0;
    }

    public String getPrimaryDisplay() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append((fgName == null ? " " : fgName));
        return sb.toString();
    }

    public String toString() {
        return getPrimaryDisplay();
    }

    public int hashCode() {
        if (testFGid == null) {
            return super.hashCode();
        } else {
            return testFGid.hashCode();
        }
    }

    public boolean equals(Object obj) {
        try {
            com.app.shared.newbc.newdomain.TestFG other = (com.app.shared.newbc.newdomain.TestFG) obj;
            if (testFGid == null) {
                return false;
            } else if (!testFGid.equals(other.testFGid)) {
                return false;
            }
        } catch (java.lang.Exception ignore) {
            return false;
        }
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEntityValidated() {
        return this.systemInfo.isEntityValidated();
    }
}
