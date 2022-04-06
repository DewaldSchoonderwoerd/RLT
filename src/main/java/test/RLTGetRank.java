package test;

import base.Base;
import base.web.pom.RLTProfilePage;
import dataprovider.DataProviderClass;
import model.member.Member;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static base.web.utls.Maths.agg;

public class RLTGetRank extends Base {

    private static final Logger LOG = LoggerFactory.getLogger(RLTGetRank.class);
    private static final List<Member> memberList = new ArrayList<>();
    private RLTProfilePage rltProfilePage;

    @BeforeClass(alwaysRun = true)
    private void setup() {
        rltProfilePage = new RLTProfilePage(driver);
    }

    @Test(dataProvider = "memberList", dataProviderClass = DataProviderClass.class)
    public void getRank(String memberName, String platform) {
        Member member = new Member(memberName, platform);

        LOG.info("Fetch MMR for: " + memberName + " - " + platform);
        try {
            rltProfilePage.goTo(platform, memberName);
            rltProfilePage.pullMmr(member);
            LOG.info("Fetch complete");
            agg(member);
        } catch (org.openqa.selenium.TimeoutException e) {
            member.setMmr1v1(0);
            member.setMmr2v2(0);
            member.setMmr3v3(0);
//            member.setMmrTour(0);
        }

        memberList.add(member);
    }

    @AfterSuite
    private void setupExcel() throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("MembersStats");

        int rowCount = 0;
        Row row = sheet.createRow(0);

        row.createCell(0).setCellValue("GAMER TAG");
        row.createCell(1).setCellValue("PLATFORM");
        row.createCell(2).setCellValue("MMR 1v1");
        row.createCell(3).setCellValue("MMR 2v2");
        row.createCell(4).setCellValue("MMR 3v3");
//        row.createCell(5).setCellValue("MMR TOURNAMENT");
        row.createCell(5).setCellValue("AVERAGE MMR");
        row.createCell(6).setCellValue("TOTAL SUM OF MMR");
        row.createCell(7).setCellValue("MAX MMR");
        row.createCell(8).setCellValue("MIN MMR");

        LOG.info("Members full list - " + memberList);
        for (Member aMember : memberList) {
            row = sheet.createRow(++rowCount);
            int columnCount = 0;

            row.createCell(columnCount++).setCellValue(aMember.getGamerTag());
            row.createCell(columnCount++).setCellValue(aMember.getPlatform());
            row.createCell(columnCount++).setCellValue(aMember.getMmr1v1());
            row.createCell(columnCount++).setCellValue(aMember.getMmr2v2());
            row.createCell(columnCount++).setCellValue(aMember.getMmr3v3());
//            row.createCell(columnCount++).setCellValue(aMember.getMmrTour());
            row.createCell(columnCount++).setCellValue(aMember.getAverage());
            row.createCell(columnCount++).setCellValue(aMember.getSum());
            row.createCell(columnCount++).setCellValue(aMember.getMax());
            row.createCell(columnCount).setCellValue(aMember.getMin());
        }

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        try (FileOutputStream outputStream = new FileOutputStream(timestamp + " - MembersStats.xlsx")) {
            workbook.write(outputStream);
        }
    }
}
