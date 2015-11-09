package ru.jblab.subscribe.repository.impl;

import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import ru.jblab.subscribe.form.FilterForm;
import ru.jblab.subscribe.model.MasterClass;
import ru.jblab.subscribe.repository.MasterClassRepositoryCustom;
import ru.jblab.subscribe.util.DataSourceAdapter;
import ru.jblab.subscribe.util.QueryManager;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by ainurminibaev on 06.11.15.
 */
public class MasterClassRepositoryImpl implements MasterClassRepositoryCustom {

    @Autowired
    DataSourceAdapter dataSourceAdapter;

    @PersistenceContext
    EntityManager em;

    @Override
    public List<MasterClass> findEventsFiltered(FilterForm filterForm) {
        ImmutableMap<String, Object> params =
                new ImmutableMap.Builder<String, Object>()
                        .put("filter", filterForm)
                        .put("limit", 10)
                        .build();
        List<Long> matchedIds = dataSourceAdapter.query(
                QueryManager.getQuery(
                        "querySQL/filterSql.ftl", params),
                new SingleColumnRowMapper<Long>());
        Query query = em.createQuery("FROM MasterClass mc WHERE mc.id IN (:ids)");
        query.setParameter("ids", matchedIds);
        return query.getResultList();

    }
}
