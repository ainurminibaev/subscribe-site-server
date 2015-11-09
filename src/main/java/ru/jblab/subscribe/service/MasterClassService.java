package ru.jblab.subscribe.service;

import org.springframework.web.multipart.MultipartFile;
import ru.jblab.subscribe.dto.EventFull;
import ru.jblab.subscribe.dto.EventSimple;
import ru.jblab.subscribe.form.FilterForm;
import ru.jblab.subscribe.model.MasterClass;

import java.util.List;

/**
 * Created by ainurminibaev on 25.10.15.
 */
public interface MasterClassService {
    List<MasterClass> findAll();

    List<EventSimple> filter(FilterForm filterForm);

    void updateMkData(MultipartFile multipartFile);

    EventFull findOne(Long id);
}
