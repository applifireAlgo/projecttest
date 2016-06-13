package com.app.server.repository.newbc.newdomain;
import com.app.server.repository.core.SearchInterface;
import com.app.config.annotation.Complexity;
import com.app.config.annotation.SourceCodeAuthorClass;
import java.util.List;
import com.app.shared.newbc.newdomain.FGPT;

@SourceCodeAuthorClass(createdBy = "taran2789@gmail.com", updatedBy = "taran2789@gmail.com", versionNumber = "2", comments = "Repository for TestFG Transaction table", complexity = Complexity.MEDIUM)
public interface TestFGRepository<T> extends SearchInterface {

    public List<T> findAll() throws Exception;

    public T save(T entity) throws Exception;

    public List<T> save(List<T> entity) throws Exception;

    public void delete(String id) throws Exception;

    public void deleteFGPT(List<FGPT> fgpt);

    public void update(T entity) throws Exception;

    public void update(List<T> entity) throws Exception;

    public T findById(String testFGid) throws Exception;
}
