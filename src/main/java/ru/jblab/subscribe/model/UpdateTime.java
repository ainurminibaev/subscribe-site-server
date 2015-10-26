package ru.jblab.subscribe.model;

import javax.persistence.*;

/**
 * Created by ainurminibaev on 25.10.15.
 */
@Entity
@Table(name = "update_time")
public class UpdateTime {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "last_update")
    private Long lastUpdate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Long lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
