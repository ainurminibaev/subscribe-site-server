package ru.jblab.subscribe.model;

import javax.persistence.*;

/**
 * Created by ainurminibaev on 25.10.15.
 */
@Entity
@Table(name = "master_class")
public class MasterClass {
    @Id
    @GeneratedValue
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String name;

    private Long startDate;

    private Long endDate;

    @Column(columnDefinition = "TEXT")
    private String type;

    @Column(columnDefinition = "TEXT")
    private String form;

    @Column(columnDefinition = "TEXT")
    private String shortDescr;

    @Column(columnDefinition = "TEXT")
    private String organizerFIO;

    private String organizerEmail;

    private String organazerPhone;

    private String employment;

    private Long closeDate;
    @Column(columnDefinition = "TEXT")
    private String location;


    private String checkExams;

    private String passExams;

    private String cost;

    private String age;

    private String eduLevel;

    @Column(columnDefinition = "TEXT")
    private String targetGroup;

    @Column(columnDefinition = "TEXT")
    private String countConstraint;

    @Column(columnDefinition = "TEXT")
    private String completionDoc;

    @Column(columnDefinition = "TEXT")
    private String additionalReq;

    private String marks;

    private String status;

    @Column(columnDefinition = "TEXT")
    private String whoFill;

    @Column(columnDefinition = "TEXT")
    private String living;

    private String eating;

    private String car;

    @Column(columnDefinition = "TEXT")
    private String channel;

    @Column(columnDefinition = "TEXT")
    private String img;

    @Column(columnDefinition = "TEXT")
    private String infoLink;

    @Column(columnDefinition = "TEXT")
    private String competences;

    @Column(columnDefinition = "TEXT")
    private String eventLink;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getStartDate() {
        return startDate;
    }

    public void setStartDate(Long startDate) {
        this.startDate = startDate;
    }

    public Long getEndDate() {
        return endDate;
    }

    public void setEndDate(Long endDate) {
        this.endDate = endDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getShortDescr() {
        return shortDescr;
    }

    public void setShortDescr(String shortDescr) {
        this.shortDescr = shortDescr;
    }

    public String getOrganizerFIO() {
        return organizerFIO;
    }

    public void setOrganizerFIO(String organizerFIO) {
        this.organizerFIO = organizerFIO;
    }

    public String getOrganizerEmail() {
        return organizerEmail;
    }

    public void setOrganizerEmail(String organizerEmail) {
        this.organizerEmail = organizerEmail;
    }

    public String getOrganazerPhone() {
        return organazerPhone;
    }

    public void setOrganazerPhone(String organazerPhone) {
        this.organazerPhone = organazerPhone;
    }

    public String getEmployment() {
        return employment;
    }

    public void setEmployment(String employment) {
        this.employment = employment;
    }

    public Long getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Long closeDate) {
        this.closeDate = closeDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCheckExams() {
        return checkExams;
    }

    public void setCheckExams(String checkExams) {
        this.checkExams = checkExams;
    }

    public String getPassExams() {
        return passExams;
    }

    public void setPassExams(String passExams) {
        this.passExams = passExams;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEduLevel() {
        return eduLevel;
    }

    public void setEduLevel(String eduLevel) {
        this.eduLevel = eduLevel;
    }

    public String getTargetGroup() {
        return targetGroup;
    }

    public void setTargetGroup(String targetGroup) {
        this.targetGroup = targetGroup;
    }

    public String getCountConstraint() {
        return countConstraint;
    }

    public void setCountConstraint(String countConstraint) {
        this.countConstraint = countConstraint;
    }

    public String getCompletionDoc() {
        return completionDoc;
    }

    public void setCompletionDoc(String completionDoc) {
        this.completionDoc = completionDoc;
    }

    public String getAdditionalReq() {
        return additionalReq;
    }

    public void setAdditionalReq(String additionalReq) {
        this.additionalReq = additionalReq;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getWhoFill() {
        return whoFill;
    }

    public void setWhoFill(String whoFill) {
        this.whoFill = whoFill;
    }

    public String getLiving() {
        return living;
    }

    public void setLiving(String living) {
        this.living = living;
    }

    public String getEating() {
        return eating;
    }

    public void setEating(String eating) {
        this.eating = eating;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getInfoLink() {
        return infoLink;
    }

    public void setInfoLink(String infoLink) {
        this.infoLink = infoLink;
    }

    public String getCompetences() {
        return competences;
    }

    public void setCompetences(String competences) {
        this.competences = competences;
    }

    public String getEventLink() {
        return eventLink;
    }

    public void setEventLink(String eventLink) {
        this.eventLink = eventLink;
    }
}
