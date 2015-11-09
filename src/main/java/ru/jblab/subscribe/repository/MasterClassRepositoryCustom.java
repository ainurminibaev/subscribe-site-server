package ru.jblab.subscribe.repository;

import ru.jblab.subscribe.form.FilterForm;
import ru.jblab.subscribe.model.MasterClass;

import java.util.List;

/**
 * Created by ainurminibaev on 06.11.15.
 */
public interface MasterClassRepositoryCustom {

    List<MasterClass> findEventsFiltered(FilterForm filterForm);
}
