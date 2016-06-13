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
import javax.persistence.Transient;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import com.athena.server.pluggable.utils.helper.EntityValidatorHelper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Version;
import com.app.shared.EntityAudit;
import javax.persistence.Embedded;
import com.app.shared.SystemInfo;
import java.lang.Override;
import javax.persistence.NamedQueries;

@Table(name = "ast_Candidate_T")
@Entity
@Cache(type = CacheType.CACHE)
@SourceCodeAuthorClass(createdBy = "taran2789@gmail.com", updatedBy = "taran2789@gmail.com", versionNumber = "2", comments = "Candidate", complexity = Complexity.LOW)
@NamedQueries({ @javax.persistence.NamedQuery(name = "Candidate.findByInterviewere", query = "select e from Candidate e where e.systemInfo.activeStatus=1 and e.interviewere=:interviewere"), @javax.persistence.NamedQuery(name = "Candidate.findById", query = "select e from Candidate e where e.systemInfo.activeStatus=1 and e.candidateId =:candidateId") })
public class Candidate implements Serializable, CommonEntityInterface, Comparator<Candidate> {

    @Column(name = "candidateName")
    @JsonProperty("candidateName")
    @NotNull
    @Size(min = 1, max = 256)
    private String candidateName;

    @Column(name = "recommendHire")
    @JsonProperty("recommendHire")
    @NotNull
    @Size(min = 1, max = 256)
    private String recommendHire;

    @Column(name = "emailid")
    @JsonProperty("emailid")
    @NotNull
    @Size(min = 1, max = 256)
    private String emailid;

    @Column(name = "datee")
    @JsonProperty("datee")
    @NotNull
    @JsonSerialize(using = CustomSqlDateJsonSerializer.class)
    @JsonDeserialize(using = CustomSqlDateJsonDeserializer.class)
    private Date datee;

    @Column(name = "skillFit")
    @JsonProperty("skillFit")
    @NotNull
    @Size(min = 1, max = 256)
    private String skillFit;

    @Column(name = "cultureFit")
    @JsonProperty("cultureFit")
    @NotNull
    @Size(min = 1, max = 256)
    private String cultureFit;

    @Column(name = "growthPotential")
    @JsonProperty("growthPotential")
    @NotNull
    @Size(min = 1, max = 256)
    private String growthPotential;

    @Column(name = "star")
    @JsonProperty("star")
    @NotNull
    @Size(min = 1, max = 256)
    private String star;

    @Column(name = "note")
    @JsonProperty("note")
    @Size(min = 1, max = 256)
    private String note;

    @Transient
    private String primaryKey;

    @Id
    @Column(name = "candidateId")
    @JsonProperty("candidateId")
    @GeneratedValue(generator = "UUIDGenerator")
    private String candidateId;

    @Column(name = "interviewere")
    @JsonProperty("interviewere")
    private String interviewere;

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

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String _candidateName) {
        if (_candidateName != null) {
            this.candidateName = _candidateName;
        }
    }

    public String getRecommendHire() {
        return recommendHire;
    }

    public void setRecommendHire(String _recommendHire) {
        if (_recommendHire != null) {
            this.recommendHire = _recommendHire;
        }
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String _emailid) {
        if (_emailid != null) {
            this.emailid = _emailid;
        }
    }

    public Date getDatee() {
        return datee;
    }

    public void setDatee(Date _datee) {
        if (_datee != null) {
            this.datee = _datee;
        }
    }

    public String getSkillFit() {
        return skillFit;
    }

    public void setSkillFit(String _skillFit) {
        if (_skillFit != null) {
            this.skillFit = _skillFit;
        }
    }

    public String getCultureFit() {
        return cultureFit;
    }

    public void setCultureFit(String _cultureFit) {
        if (_cultureFit != null) {
            this.cultureFit = _cultureFit;
        }
    }

    public String getGrowthPotential() {
        return growthPotential;
    }

    public void setGrowthPotential(String _growthPotential) {
        if (_growthPotential != null) {
            this.growthPotential = _growthPotential;
        }
    }

    public String getStar() {
        return star;
    }

    public void setStar(String _star) {
        if (_star != null) {
            this.star = _star;
        }
    }

    public String getNote() {
        return note;
    }

    public void setNote(String _note) {
        this.note = _note;
    }

    public String getPrimaryKey() {
        return candidateId;
    }

    public void setPrimaryKey(String _primaryKey) {
        this.primaryKey = _primaryKey;
    }

    public String _getPrimarykey() {
        return candidateId;
    }

    public String getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(String _candidateId) {
        this.candidateId = _candidateId;
    }

    public String getInterviewere() {
        return interviewere;
    }

    public void setInterviewere(String _interviewere) {
        this.interviewere = _interviewere;
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
            this.systemInfo.setActiveStatus(0);
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
    public int compare(Candidate object1, Candidate object2) {
        return 0;
    }

    public String getPrimaryDisplay() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        return sb.toString();
    }

    public String toString() {
        return getPrimaryDisplay();
    }

    public int hashCode() {
        if (candidateId == null) {
            return super.hashCode();
        } else {
            return candidateId.hashCode();
        }
    }

    public boolean equals(Object obj) {
        try {
            com.app.shared.newbc.newdomain.Candidate other = (com.app.shared.newbc.newdomain.Candidate) obj;
            if (candidateId == null) {
                return false;
            } else if (!candidateId.equals(other.candidateId)) {
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
