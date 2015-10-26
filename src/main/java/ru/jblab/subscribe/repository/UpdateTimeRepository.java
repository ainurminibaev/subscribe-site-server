package ru.jblab.subscribe.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.jblab.subscribe.model.UpdateTime;

/**
 * Created by ainurminibaev on 25.10.15.
 */
public interface UpdateTimeRepository extends PagingAndSortingRepository<UpdateTime, Long> {
}
