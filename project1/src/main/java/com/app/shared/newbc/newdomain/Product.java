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
import com.athena.server.pluggable.utils.helper.EntityValidatorHelper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Version;
import com.app.shared.EntityAudit;
import javax.persistence.Embedded;
import com.app.shared.SystemInfo;
import java.lang.Override;
import javax.persistence.NamedQueries;

@Table(name = "ast_Product_M")
@Entity
@Cache(type = CacheType.CACHE)
@SourceCodeAuthorClass(createdBy = "taran2789@gmail.com", updatedBy = "taran2789@gmail.com", versionNumber = "2", comments = "Product", complexity = Complexity.LOW)
@NamedQueries({ @javax.persistence.NamedQuery(name = "Product.findById", query = "select e from Product e where e.systemInfo.activeStatus=1 and e.productId =:productId") })
public class Product implements Serializable, CommonEntityInterface, Comparator<Product> {

    @Column(name = "pName")
    @JsonProperty("pName")
    @NotNull
    @Size(min = 1, max = 256)
    private String pName;

    @Column(name = "pDate")
    @JsonProperty("pDate")
    @NotNull
    @JsonSerialize(using = CustomSqlDateJsonSerializer.class)
    @JsonDeserialize(using = CustomSqlDateJsonDeserializer.class)
    private Date pDate;

    @Column(name = "pdatetime")
    @JsonProperty("pdatetime")
    @NotNull
    @JsonSerialize(using = CustomSqlTimestampJsonSerializer.class)
    @JsonDeserialize(using = CustomSqlTimestampJsonDeserializer.class)
    private Timestamp pdatetime;

    @Column(name = "image")
    @JsonProperty("image")
    @NotNull
    @Size(min = 1, max = 256)
    private String image;

    @Transient
    private String primaryKey;

    @Id
    @Column(name = "productId")
    @JsonProperty("productId")
    @GeneratedValue(generator = "UUIDGenerator")
    private String productId;

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

    public String getpName() {
        return pName;
    }

    public void setpName(String _pName) {
        if (_pName != null) {
            this.pName = _pName;
        }
    }

    public Date getpDate() {
        return pDate;
    }

    public void setpDate(Date _pDate) {
        if (_pDate != null) {
            this.pDate = _pDate;
        }
    }

    public Timestamp getPdatetime() {
        return pdatetime;
    }

    public void setPdatetime(Timestamp _pdatetime) {
        if (_pdatetime != null) {
            this.pdatetime = _pdatetime;
        }
    }

    public String getImage() {
        return image;
    }

    public void setImage(String _image) {
        if (_image != null) {
            this.image = _image;
        }
    }

    public String getPrimaryKey() {
        return productId;
    }

    public void setPrimaryKey(String _primaryKey) {
        this.primaryKey = _primaryKey;
    }

    public String _getPrimarykey() {
        return productId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String _productId) {
        this.productId = _productId;
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
    public int compare(Product object1, Product object2) {
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
        if (productId == null) {
            return super.hashCode();
        } else {
            return productId.hashCode();
        }
    }

    public boolean equals(Object obj) {
        try {
            com.app.shared.newbc.newdomain.Product other = (com.app.shared.newbc.newdomain.Product) obj;
            if (productId == null) {
                return false;
            } else if (!productId.equals(other.productId)) {
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
