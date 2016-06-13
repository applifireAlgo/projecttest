package com.app.shared.newbc.newdomain;
import com.athena.server.pluggable.interfaces.EntityValidatorInterface;
import com.athena.server.pluggable.utils.helper.EntityValidatorHelper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import java.sql.Timestamp;
import com.athena.config.jsonHandler.CustomSqlTimestampJsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.athena.config.jsonHandler.CustomSqlTimestampJsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.ArrayList;
import java.lang.Override;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TestVd implements EntityValidatorInterface {

    @Transient
    @JsonIgnore
    private EntityValidatorHelper<Object> dtoValidator;

    @Min(1)
    @Max(65535)
    private String candidateName;

    @Min(1)
    @Max(65535)
    private String interviewere;

    @Min(1)
    @Max(65535)
    private String emailid;

    @JsonSerialize(using = CustomSqlTimestampJsonSerializer.class)
    @JsonDeserialize(using = CustomSqlTimestampJsonDeserializer.class)
    private Timestamp datee;

    @Min(1)
    @Max(65535)
    private String note;

    @Min(1)
    @Max(65535)
    private ArrayList<String> skillFit;

    @Min(1)
    @Max(65535)
    private ArrayList<String> cultureFit;

    @Min(1)
    @Max(65535)
    private ArrayList<String> grothPotential;

    @Min(1)
    @Max(65535)
    private ArrayList<String> star;

    @Min(1)
    @Max(65535)
    private ArrayList<String> RecommendHire;

    @Transient
    @JsonIgnore
    private boolean isDtoValidated = false;

    @JsonIgnore
    @Override
    public boolean isEntityValidated() {
        return isDtoValidated;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String _candidateName) {
        this.candidateName = _candidateName;
    }

    public String getInterviewere() {
        return interviewere;
    }

    public void setInterviewere(String _interviewere) {
        this.interviewere = _interviewere;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String _emailid) {
        this.emailid = _emailid;
    }

    public Timestamp getDatee() {
        return datee;
    }

    public void setDatee(Timestamp _datee) {
        this.datee = _datee;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String _note) {
        this.note = _note;
    }

    public ArrayList<String> getSkillFit() {
        return skillFit;
    }

    public void setSkillFit(ArrayList<String> _skillFit) {
        this.skillFit = _skillFit;
    }

    public TestVd addSkillFit(String _skillFit) {
        if (this.skillFit == null) {
            this.skillFit = new java.util.ArrayList<java.lang.String>();
        }
        if (_skillFit != null) {
            this.skillFit.add(_skillFit);
        }
        return this;
    }

    public TestVd addAllSkillFit(List<String> _skillFit) {
        if (this.skillFit == null) {
            this.skillFit = new java.util.ArrayList<java.lang.String>();
        }
        if (_skillFit != null) {
            this.skillFit.addAll(_skillFit);
        }
        return this;
    }

    public TestVd removeSkillFit(String _skillFit) {
        if (this.skillFit != null) {
            this.skillFit.remove(_skillFit);
        }
        return this;
    }

    public Integer sizeOfSkillFit() {
        if (this.skillFit != null) {
            return this.skillFit.size();
        }
        return 0;
    }

    public ArrayList<String> getCultureFit() {
        return cultureFit;
    }

    public void setCultureFit(ArrayList<String> _cultureFit) {
        this.cultureFit = _cultureFit;
    }

    public TestVd addCultureFit(String _cultureFit) {
        if (this.cultureFit == null) {
            this.cultureFit = new java.util.ArrayList<java.lang.String>();
        }
        if (_cultureFit != null) {
            this.cultureFit.add(_cultureFit);
        }
        return this;
    }

    public TestVd addAllCultureFit(List<String> _cultureFit) {
        if (this.cultureFit == null) {
            this.cultureFit = new java.util.ArrayList<java.lang.String>();
        }
        if (_cultureFit != null) {
            this.cultureFit.addAll(_cultureFit);
        }
        return this;
    }

    public TestVd removeCultureFit(String _cultureFit) {
        if (this.cultureFit != null) {
            this.cultureFit.remove(_cultureFit);
        }
        return this;
    }

    public Integer sizeOfCultureFit() {
        if (this.cultureFit != null) {
            return this.cultureFit.size();
        }
        return 0;
    }

    public ArrayList<String> getGrothPotential() {
        return grothPotential;
    }

    public void setGrothPotential(ArrayList<String> _grothPotential) {
        this.grothPotential = _grothPotential;
    }

    public TestVd addGrothPotential(String _grothPotential) {
        if (this.grothPotential == null) {
            this.grothPotential = new java.util.ArrayList<java.lang.String>();
        }
        if (_grothPotential != null) {
            this.grothPotential.add(_grothPotential);
        }
        return this;
    }

    public TestVd addAllGrothPotential(List<String> _grothPotential) {
        if (this.grothPotential == null) {
            this.grothPotential = new java.util.ArrayList<java.lang.String>();
        }
        if (_grothPotential != null) {
            this.grothPotential.addAll(_grothPotential);
        }
        return this;
    }

    public TestVd removeGrothPotential(String _grothPotential) {
        if (this.grothPotential != null) {
            this.grothPotential.remove(_grothPotential);
        }
        return this;
    }

    public Integer sizeOfGrothPotential() {
        if (this.grothPotential != null) {
            return this.grothPotential.size();
        }
        return 0;
    }

    public ArrayList<String> getStar() {
        return star;
    }

    public void setStar(ArrayList<String> _star) {
        this.star = _star;
    }

    public TestVd addStar(String _star) {
        if (this.star == null) {
            this.star = new java.util.ArrayList<java.lang.String>();
        }
        if (_star != null) {
            this.star.add(_star);
        }
        return this;
    }

    public TestVd addAllStar(List<String> _star) {
        if (this.star == null) {
            this.star = new java.util.ArrayList<java.lang.String>();
        }
        if (_star != null) {
            this.star.addAll(_star);
        }
        return this;
    }

    public TestVd removeStar(String _star) {
        if (this.star != null) {
            this.star.remove(_star);
        }
        return this;
    }

    public Integer sizeOfStar() {
        if (this.star != null) {
            return this.star.size();
        }
        return 0;
    }

    public ArrayList<String> getRecommendHire() {
        return RecommendHire;
    }

    public void setRecommendHire(ArrayList<String> _RecommendHire) {
        this.RecommendHire = _RecommendHire;
    }

    public TestVd addRecommendHire(String _RecommendHire) {
        if (this.RecommendHire == null) {
            this.RecommendHire = new java.util.ArrayList<java.lang.String>();
        }
        if (_RecommendHire != null) {
            this.RecommendHire.add(_RecommendHire);
        }
        return this;
    }

    public TestVd addAllRecommendHire(List<String> _RecommendHire) {
        if (this.RecommendHire == null) {
            this.RecommendHire = new java.util.ArrayList<java.lang.String>();
        }
        if (_RecommendHire != null) {
            this.RecommendHire.addAll(_RecommendHire);
        }
        return this;
    }

    public TestVd removeRecommendHire(String _RecommendHire) {
        if (this.RecommendHire != null) {
            this.RecommendHire.remove(_RecommendHire);
        }
        return this;
    }

    public Integer sizeOfRecommendHire() {
        if (this.RecommendHire != null) {
            return this.RecommendHire.size();
        }
        return 0;
    }

    @Override
    public void setEntityValidator(EntityValidatorHelper<Object> _validateFactory) {
        this.dtoValidator = _validateFactory;
    }

    @JsonIgnore
    @Override
    public boolean isValid() throws SecurityException {
        boolean isValid = false;
        if (this.dtoValidator != null) {
            isValid = this.dtoValidator.validateEntity(this);
            this.isDtoValidated = true;
        } else {
            throw new SecurityException();
        }
        return isValid;
    }
}
