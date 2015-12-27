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
import java.util.*;
import java.util.function.Function;
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
                    if (!validation.equalsIgnoreCase("да")) {
                        continue;
                    }
                }
                MasterClass masterClass = new MasterClass();
                Function<Cell, String> str = this::cellToStr;
                masterClass.setName(Optional.ofNullable(row.getCell(1)).map(str).orElse(null));
                masterClass.setType(Optional.ofNullable(row.getCell(2)).map(str).orElse(null));
                masterClass.setForm(Optional.ofNullable(row.getCell(3)).map(str).orElse(null));
                masterClass.setShortDescr(Optional.ofNullable(row.getCell(4)).map(str).orElse(null));
                masterClass.setOrganizerFIO(Optional.ofNullable(row.getCell(5)).map(str).orElse(null));
                masterClass.setOrganizerEmail(Optional.ofNullable(row.getCell(6)).map(str).orElse(null));
                Date startDate = Optional.ofNullable(row.getCell(7)).map(Cell::getDateCellValue).orElse(null);
                if (startDate != null) {
                    masterClass.setStartDate(startDate.getTime());
                }
                Date endDate = row.getCell(8).getDateCellValue();
                if (endDate != null) {
                    masterClass.setEndDate(endDate.getTime());
                }
                masterClass.setEmployment(Optional.ofNullable(row.getCell(9)).map(str).orElse(null));
                Date closeDate = Optional.ofNullable(row.getCell(10)).map(Cell::getDateCellValue).orElse(null);
                if (closeDate != null) {
                    masterClass.setCloseDate(closeDate.getTime());
                }
                masterClass.setLocation(Optional.ofNullable(row.getCell(11)).map(str).orElse(null));
                masterClass.setCheckExams(Optional.ofNullable(row.getCell(12)).map(str).orElse(null));
                masterClass.setPassExams(Optional.ofNullable(row.getCell(13)).map(str).orElse(null));
                masterClass.setCost(Optional.ofNullable(row.getCell(14)).map(str).orElse(null));
                masterClass.setAge(Optional.ofNullable(row.getCell(15)).map(str).orElse(null));
                masterClass.setEduLevel(Optional.ofNullable(row.getCell(16)).map(str).orElse(null));
                masterClass.setTargetGroup(Optional.ofNullable(row.getCell(17)).map(str).orElse(null));
                masterClass.setCountConstraint(Optional.ofNullable(row.getCell(18)).map(str).orElse(null));
                masterClass.setCompletionDoc(Optional.ofNullable(row.getCell(19)).map(str).orElse(null));
                masterClass.setAdditionalReq(Optional.ofNullable(row.getCell(20)).map(str).orElse(null));
                masterClass.setMarks(Optional.ofNullable(row.getCell(21)).map(str).orElse(null));
                masterClass.setWhoFill(Optional.ofNullable(row.getCell(23)).map(str).orElse(null));
                masterClass.setLiving(Optional.ofNullable(row.getCell(24)).map(str).orElse(null));
                masterClass.setEating(Optional.ofNullable(row.getCell(25)).map(str).orElse(null));
                masterClass.setCar(Optional.ofNullable(row.getCell(26)).map(str).orElse(null));
                masterClass.setChannel(Optional.ofNullable(row.getCell(27)).map(str).orElse(null));
                masterClass.setImg(Optional.ofNullable(row.getCell(28)).map(str).orElse(null));
                masterClass.setInfoLink(Optional.ofNullable(row.getCell(29)).map(str).orElse(null));
                masterClass.setCompetences(Optional.ofNullable(row.getCell(30)).map(str).orElse(null));
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

    private String cellToStr(Cell cell) {
        try {
            switch (cell.getCellType()) {
                case Cell.CELL_TYPE_STRING:
                    return cell.getRichStringCellValue().getString();
                case Cell.CELL_TYPE_NUMERIC:
                    if (DateUtil.isCellDateFormatted(cell)) {
                        return cell.getDateCellValue().toString();
                    } else {
                        return Double.valueOf(cell.getNumericCellValue()).toString();
                    }
                case Cell.CELL_TYPE_BOOLEAN:
                    return Boolean.valueOf(cell.getBooleanCellValue()).toString();
                case Cell.CELL_TYPE_FORMULA:
                    return cell.getCellFormula();
                default:
                    return null;
            }
        } catch (NullPointerException e) {
            return null;
        }
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
