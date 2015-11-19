package ru.jblab.subscribe.service.impl;

import com.google.common.collect.Lists;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ru.jblab.subscribe.dto.EventFull;
import ru.jblab.subscribe.dto.EventSimple;
import ru.jblab.subscribe.form.FilterForm;
import ru.jblab.subscribe.model.MasterClass;
import ru.jblab.subscribe.model.UpdateTime;
import ru.jblab.subscribe.repository.MasterClassRepository;
import ru.jblab.subscribe.repository.UpdateTimeRepository;
import ru.jblab.subscribe.service.MasterClassService;
import ru.jblab.subscribe.util.Mappers;
import ru.jblab.subscribe.util.Utils;
import ru.jblab.subscribe.util.XlsUtil;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ainurminibaev on 25.10.15.
 */
@Service
public class MasterClassServiceImpl implements MasterClassService {

    @Autowired
    MasterClassRepository masterClassRepository;

    @Autowired
    UpdateTimeRepository updateTimeRepository;

    @Override
    public List<MasterClass> findAll() {
        return Lists.newArrayList(masterClassRepository.findAll());
    }

    @Override
    @Transactional
    public List<EventSimple> filter(FilterForm filterForm) {
        filterForm = Utils.fixForm(filterForm);
        List<MasterClass> eventsFiltered = masterClassRepository.findEventsFiltered(filterForm);
        return eventsFiltered
                .stream()
                .map(Mappers::mapEventToSimple)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void updateMkData(MultipartFile multipartFile) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("DD.MM.yyyy HH:mm:ss");
        Long lastUpdateTime = getLastUpdateTime();
        Workbook workbook = null;
        try {
            workbook = XlsUtil.getWorkbook(multipartFile);
            Sheet sheet = workbook.getSheetAt(0);

            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            Row row = null;
            Long rowTime = null;
            //skip first at all
            if (rowIterator.hasNext()) {
                rowIterator.next();
            }
            while (rowIterator.hasNext()) {
                row = rowIterator.next();
                try {
                    if (row.getCell(0).getStringCellValue().equals("")) {
                        continue;
                    }
                } catch (Exception ignored) {
                }

                Date insertDate = row.getCell(0).getDateCellValue();
                rowTime = insertDate.getTime();
                if (insertDate.getTime() <= lastUpdateTime) {
                    continue;
                }
                cleanRow(row);
                if (row.getCell(33) != null) {
                    String validation = row.getCell(33).getStringCellValue();
                    if (validation.equalsIgnoreCase("нет")) {
                        continue;
                    }
                }
                MasterClass masterClass = new MasterClass();
                masterClass.setName(row.getCell(1).getStringCellValue());
                masterClass.setType(row.getCell(2).getStringCellValue());
                masterClass.setForm(row.getCell(3).getStringCellValue());
                masterClass.setShortDescr(row.getCell(4).getStringCellValue());
                masterClass.setOrganizerFIO(row.getCell(5).getStringCellValue());
                masterClass.setOrganizerEmail(row.getCell(6).getStringCellValue());
                masterClass.setOrganizerEmail(row.getCell(6).getStringCellValue());
                Date startDate = row.getCell(7).getDateCellValue();
                if (startDate != null) {
                    masterClass.setStartDate(startDate.getTime());
                }
                Date endDate = row.getCell(8).getDateCellValue();
                if (endDate != null) {
                    masterClass.setEndDate(endDate.getTime());
                }
                masterClass.setEmployment(row.getCell(9).getStringCellValue());
                Date closeDate = row.getCell(10).getDateCellValue();
                if (endDate != null) {
                    masterClass.setCloseDate(closeDate.getTime());
                }
                masterClass.setLocation(row.getCell(11).getStringCellValue());
                masterClass.setCheckExams(row.getCell(12).getStringCellValue());
                masterClass.setPassExams(row.getCell(13).getStringCellValue());
                masterClass.setCost(row.getCell(14).getStringCellValue());
                masterClass.setAge(row.getCell(15).getStringCellValue());
                masterClass.setEduLevel(row.getCell(16).getStringCellValue());
                masterClass.setTargetGroup(row.getCell(17).getStringCellValue());
                masterClass.setCountConstraint(row.getCell(18).getStringCellValue());
                masterClass.setCompletionDoc(row.getCell(19).getStringCellValue());
                masterClass.setAdditionalReq(row.getCell(20).getStringCellValue());
                masterClass.setMarks(row.getCell(21).getStringCellValue());
                masterClass.setWhoFill(row.getCell(23).getStringCellValue());
                masterClass.setLiving(row.getCell(24).getStringCellValue());
                masterClass.setEating(row.getCell(25).getStringCellValue());
                masterClass.setCar(row.getCell(26).getStringCellValue());
                masterClass.setChannel(row.getCell(27).getStringCellValue());
                masterClass.setImg(row.getCell(28).getStringCellValue());
                masterClass.setInfoLink(row.getCell(29).getStringCellValue());
                masterClass.setCompetences(row.getCell(30).getStringCellValue());
                if (row.getCell(31) != null) {
                    masterClass.setEventLink(row.getCell(31).getStringCellValue());
                } else {
                    masterClass.setEventLink("#");
                }
                if (row.getCell(32) != null) {
                    masterClass.setOrganazerPhone(row.getCell(32).getStringCellValue());
                }
                masterClassRepository.save(masterClass);
            }
            if (row != null) {
                UpdateTime updateTime = new UpdateTime();
                updateTime.setLastUpdate(rowTime);
                updateTimeRepository.save(updateTime);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public EventFull findOne(Long id) {
        return Mappers.mapEventToFull(masterClassRepository.findOne(id));
    }

    private void cleanRow(Row row) {
        List<Integer> toStrIds = Lists.newArrayList(14, 15, 18);
        int i = 0;
        Iterator<Cell> cellIterator = row.cellIterator();
        while (cellIterator.hasNext()) {
            Cell next = cellIterator.next();
            if (next.getCellType() == Cell.CELL_TYPE_NUMERIC && toStrIds.contains(i)) {
                System.out.println("switched string: " + i);
                next.setCellType(Cell.CELL_TYPE_STRING);
            }
            i++;
        }

    }

    private Long getLastUpdateTime() {
        List<UpdateTime> lastList = Lists.newArrayList(updateTimeRepository.findAll(new PageRequest(0, 1, Sort.Direction.DESC, "lastUpdate")));
        if (lastList.size() == 0) {
            return -1L;
        }
        return lastList.get(0).getLastUpdate();
    }
}
