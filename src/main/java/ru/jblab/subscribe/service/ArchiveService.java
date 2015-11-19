package ru.jblab.subscribe.service;

import ru.jblab.subscribe.model.Archive;

import java.util.List;

/**
 * Created by ainurminibaev on 19.11.15.
 */
public interface ArchiveService {

    List<Archive> findAll();

    Archive findOne(Long id);


}
