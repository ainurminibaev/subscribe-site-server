package ru.jblab.subscribe.service;

import org.springframework.web.multipart.MultipartFile;
import ru.jblab.subscribe.model.MasterClass;

import java.util.List;

/**
 * Created by ainurminibaev on 25.10.15.
 */
public interface MasterClassService {
    List<MasterClass> findAll();

    void updateMkData(MultipartFile multipartFile);
}
