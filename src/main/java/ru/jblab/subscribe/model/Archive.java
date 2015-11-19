package ru.jblab.subscribe.model;

import javax.lang.model.type.ArrayType;
import javax.persistence.*;
import java.util.Date;

/**
 * Created by ainurminibaev on 19.11.15.
 */
@Entity
@Table(name = "archives")
public class Archive {

    @Id
    @GeneratedValue
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Column(name = "template_path")
    private String templatePath;

    private ArrayType arrayType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getTemplatePath() {
        return templatePath;
    }

    public void setTemplatePath(String templatePath) {
        this.templatePath = templatePath;
    }

    public ArrayType getArrayType() {
        return arrayType;
    }

    public void setArrayType(ArrayType arrayType) {
        this.arrayType = arrayType;
    }
}
