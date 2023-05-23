package com.example.MedManager.helper;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;
import com.example.MedManager.model.Dataset;
public class ExcepHelper {
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERs = { "Пол пациента", "Дата рождения пациента", "Id пациента", "Код МКБ-10",
            "Диагноз", "Дата оказания услуги", "Должность", "Назначения" };
    static String SHEET = "Sheet1";

    public static boolean hasExcelFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }

        return true;
    }

    public static List<Dataset> excelToDatasets(InputStream is) {
        try {
            Workbook workbook = new XSSFWorkbook(is);

            Sheet sheet = workbook.getSheet(SHEET);
            Iterator<Row> rows = sheet.iterator();

            List<Dataset> sheets = new ArrayList<Dataset>();

            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();

                // skip header
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cellsInRow = currentRow.iterator();

                Dataset sheet1 = new Dataset();

                int cellIdx = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();

                    switch (cellIdx) {
                        case 0:
                            sheet1.setSex(currentCell.getStringCellValue());
                            break;

                        case 1:
                            sheet1.setBirthDay(currentCell.getStringCellValue());
                            break;

                        case 2:
                            sheet1.setIdPatient(currentCell.getStringCellValue());
                            break;

                        case 3:
                            sheet1.setCodeMkb(currentCell.getStringCellValue());
                            break;
                        case 4:
                            sheet1.setDiagnosis(currentCell.getStringCellValue());
                            break;
                        case 5:
                            sheet1.setDateConsultation(currentCell.getStringCellValue());
                            break;
                        case 6:
                            sheet1.setOffice(currentCell.getStringCellValue());
                            break;
                        case 7:
                            sheet1.setTests(currentCell.getStringCellValue());
                            break;

                        default:
                            break;
                    }

                    cellIdx++;
                }

                sheets.add(sheet1);
            }

            workbook.close();

            return sheets;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }
}
