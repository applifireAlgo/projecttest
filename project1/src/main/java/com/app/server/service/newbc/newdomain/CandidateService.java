package com.app.server.service.newbc.newdomain;
import com.app.config.annotation.Complexity;
import com.app.config.annotation.SourceCodeAuthorClass;
import com.athena.server.pluggable.utils.bean.ResponseBean;
import org.springframework.http.HttpEntity;
import com.app.shared.newbc.newdomain.Candidate;
import java.util.List;
import com.athena.server.pluggable.utils.bean.FindByBean;

@SourceCodeAuthorClass(createdBy = "taran2789@gmail.com", updatedBy = "taran2789@gmail.com", versionNumber = "2", comments = "Service for Candidate Transaction table", complexity = Complexity.MEDIUM)
public abstract class CandidateService {

    public HttpEntity<ResponseBean> findAll() throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> save(Candidate entity) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> save(List<Candidate> entity, boolean isArray) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> delete(String id) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> update(Candidate entity) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> update(List<Candidate> entity, boolean isArray) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> findByInterviewere(FindByBean findByBean) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> findById(FindByBean findByBean) throws Exception {
        return null;
    }
}
