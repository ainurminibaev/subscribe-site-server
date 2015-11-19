package ru.jblab.subscribe.service.impl;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import ru.jblab.subscribe.model.Archive;
import ru.jblab.subscribe.repository.ArchiveRepository;
import ru.jblab.subscribe.service.ArchiveService;

import java.util.List;

/**
 * Created by ainurminibaev on 19.11.15.
 */
public class ArchiveServiceImpl implements ArchiveService {

    @Autowired
    ArchiveRepository archiveRepository;

    @Override
    public List<Archive> findAll() {
        return Lists.newArrayList(archiveRepository.findAll());
    }

    @Override
    public Archive findOne(Long id) {
        return archiveRepository.findOne(id);
    }
}
