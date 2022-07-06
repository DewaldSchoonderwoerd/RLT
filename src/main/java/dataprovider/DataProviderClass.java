package dataprovider;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DataProviderClass {

    private static final Logger LOG = LoggerFactory.getLogger(DataProviderClass.class);

    private static XSSFSheet getSheet(String sheetPath, String spreadSheetName, String sheetName) throws IOException {
        File path = new File("");
        FileInputStream file = new FileInputStream(
                path.getAbsolutePath() + sheetPath + spreadSheetName + ".xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet(sheetName);

        file.close();
        return sheet;
    }

    private static Object[][] excelDataProviderMethod(String folder, String file, String sheetName) {
        Object[][] retObjArr = {{folder}};
        try {
            XSSFSheet sheet = getSheet("/src/main/resources/", file, sheetName);

            int rowCount = sheet.getPhysicalNumberOfRows();
            int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

            retObjArr = new Object[rowCount - 1][colCount];
            for (int row = 1; row < rowCount; row++) {
                for (int col = 0; col < colCount; col++) {
                    retObjArr[row - 1][col] = sheet.getRow(row).getCell(col).toString();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retObjArr;
    }

    @DataProvider(name = "memberList")
    public static Object[][] getMemberList(){
        LOG.info("Fetching data from excel sheet");
        return excelDataProviderMethod("","membersList", "membersList");
    }

}
