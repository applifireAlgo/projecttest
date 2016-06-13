package com.app.server.repository.newbc.newdomain;
import com.app.server.repository.core.SearchInterfaceImpl;
import com.app.shared.newbc.newdomain.Product;
import org.springframework.stereotype.Repository;
import com.app.config.annotation.Complexity;
import com.app.config.annotation.SourceCodeAuthorClass;
import com.athena.server.pluggable.utils.helper.ResourceFactoryManagerHelper;
import org.springframework.beans.factory.annotation.Autowired;
import com.spartan.pluggable.logger.alarms.AppAlarm;
import com.spartan.pluggable.logger.api.LogManagerFactory;
import com.athena.server.pluggable.utils.AppLoggerConstant;
import com.spartan.pluggable.logger.api.LogManager;
import com.athena.server.pluggable.utils.helper.RuntimeLogInfoHelper;
import java.lang.Override;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Repository
@SourceCodeAuthorClass(createdBy = "taran2789@gmail.com", updatedBy = "taran2789@gmail.com", versionNumber = "2", comments = "Repository for Product Master table Entity", complexity = Complexity.LOW)
public class ProductRepositoryImpl extends SearchInterfaceImpl implements ProductRepository<Product> {

    @Autowired
    private ResourceFactoryManagerHelper emfResource;

    private LogManager Log = LogManagerFactory.getInstance(AppLoggerConstant.LOGGER_ID);

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Override
    @Transactional
    public List<Product> findAll() throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        java.util.List<com.app.shared.newbc.newdomain.Product> query = emanager.createQuery("select u from Product u where u.systemInfo.activeStatus=1").getResultList();
        Log.out.println("LKJLJ324100200", runtimeLogInfoHelper.getRequestHeaderBean(), "ProductRepositoryImpl", "findAll", "Total Records Fetched = " + query.size());
        return query;
    }

    @Override
    @Transactional
    public Product save(Product entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        emanager.persist(entity);
        Log.out.println("LKJLJ322100200", runtimeLogInfoHelper.getRequestHeaderBean(), "ProductRepositoryImpl", "save", entity);
        return entity;
    }

    @Override
    @Transactional
    public List<Product> save(List<Product> entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        for (int i = 0; i < entity.size(); i++) {
            com.app.shared.newbc.newdomain.Product obj = entity.get(i);
            emanager.persist(obj);
        }
        Log.out.println("LKJLJ322100200", runtimeLogInfoHelper.getRequestHeaderBean(), "ProductRepositoryImpl", "saveAll", "Total Records saved = " + entity.size());
        return entity;
    }

    @Transactional
    @Override
    public void delete(String id) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        com.app.shared.newbc.newdomain.Product s = emanager.find(com.app.shared.newbc.newdomain.Product.class, id);
        emanager.remove(s);
        Log.out.println("LKJLJ328100200", runtimeLogInfoHelper.getRequestHeaderBean(), "ProductRepositoryImpl", "delete", "Record Deleted");
    }

    @Override
    @Transactional
    public void update(Product entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        emanager.merge(entity);
        Log.out.println("LKJLJ321100200", runtimeLogInfoHelper.getRequestHeaderBean(), "ProductRepositoryImpl", "update", entity);
    }

    @Override
    @Transactional
    public void update(List<Product> entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        for (int i = 0; i < entity.size(); i++) {
            com.app.shared.newbc.newdomain.Product obj = entity.get(i);
            emanager.merge(obj);
        }
        Log.out.println("LKJLJ321100200", runtimeLogInfoHelper.getRequestHeaderBean(), "ProductRepositoryImpl", "updateAll", "Total Records updated = " + entity.size());
    }

    @Transactional
    public Product findById(String productId) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        javax.persistence.Query query = emanager.createNamedQuery("Product.findById");
        query.setParameter("productId", productId);
        com.app.shared.newbc.newdomain.Product listOfProduct = (com.app.shared.newbc.newdomain.Product) query.getSingleResult();
        Log.out.println("LKJLJ324100200", runtimeLogInfoHelper.getRequestHeaderBean(), "ProductRepositoryImpl", "findById", "Total Records Fetched = " + listOfProduct);
        return listOfProduct;
    }
}
