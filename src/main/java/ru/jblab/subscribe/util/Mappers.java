package ru.jblab.subscribe.util;

import ru.jblab.subscribe.dto.EventFull;
import ru.jblab.subscribe.dto.EventSimple;
import ru.jblab.subscribe.model.MasterClass;

/**
 * Created by ainurminibaev on 06.11.15.
 */
public class Mappers {

    public static EventSimple mapEventToSimple(MasterClass masterClass) {
        EventSimple eventSimple = new EventSimple();
        mapSimple(masterClass, eventSimple);
        return eventSimple;
    }

    private static <T extends EventSimple> void mapSimple(MasterClass masterClass, T eventSimple) {
        eventSimple.setId(masterClass.getId());
        eventSimple.setAlias(Translit.toTranslit(masterClass.getName()));
        eventSimple.setCost(masterClass.getCost() + "Р");
        eventSimple.setForWhom(masterClass.getTargetGroup());
        eventSimple.setImg(masterClass.getImg());
        eventSimple.setName(masterClass.getName());
        eventSimple.setPlace(masterClass.getLocation());
//        eventSimple.setWhen("18 сентября 2015 г., 10:00 – 17:00");
        eventSimple.setWhen(Utils.toRusString(masterClass.getStartDate()) + " - " + Utils.toRusString(masterClass.getEndDate()));
        eventSimple.setType(masterClass.getType());
    }

    public static EventFull mapEventToFull(MasterClass masterClass) {
        EventFull eventFull = new EventFull();
        mapSimple(masterClass, eventFull);
        eventFull.setOrganizerFIO("АО \"ТЕРМОПОЛИО\"");
        eventFull.setOrganizerEmail("Test@mail.ru");
        eventFull.setOrganizerPhone("8800553535");
        eventFull.setLink("/");
        //TODO map others
        return eventFull;
    }
}
