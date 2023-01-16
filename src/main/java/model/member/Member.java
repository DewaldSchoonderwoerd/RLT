package model.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class Member {

    private static final Logger LOG = LoggerFactory.getLogger(Member.class);

    public Member(String gamerTag, String platform, boolean isActive, String airTableId, String discordName) {
        this.gamerTag = gamerTag;
        this.platform = platform;
        this.discordName = discordName;
        this.isActive = isActive;
        this.airTableId = airTableId;
    }

    private String gamerTag;
    private String platform;
    private String discordName;
    private boolean isActive;
    private String airTableId;
    private int mmr1v1;
    private int mmr2v2;
    private int mmr3v3;
    private int average;

    public String getGamerTag() {
        return gamerTag;
    }

    public void setGamerTag(String gamerTag) {
        this.gamerTag = gamerTag;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public int getMmr1v1() {
        return mmr1v1;
    }

    public void setMmr1v1(int mmr1v1) {
        this.mmr1v1 = mmr1v1;
    }

    public int getMmr2v2() {
        return mmr2v2;
    }

    public void setMmr2v2(int mmr2v2) {
        this.mmr2v2 = mmr2v2;
    }

    public int getMmr3v3() {
        return mmr3v3;
    }

    public void setMmr3v3(int mmr3v3) {
        this.mmr3v3 = mmr3v3;
    }

    public int getAverage() {
        return average;
    }

    public void setAverage(int average) {
        this.average = average;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getAirTableId() {
        return airTableId;
    }

    public void setAirTableId(String airTableId) {
        this.airTableId = airTableId;
    }

    public String getDiscordName() {
        return discordName;
    }

    public void setDiscordName(String discordName) {
        this.discordName = discordName;
    }

    @Override
    public String toString() {
        return "Member{" +
                "gamerTag='" + gamerTag + '\'' +
                ", platform='" + platform + '\'' +
                ", discordName='" + discordName + '\'' +
                ", isActive=" + isActive +
                ", airTableId='" + airTableId + '\'' +
                ", mmr1v1=" + mmr1v1 +
                ", mmr2v2=" + mmr2v2 +
                ", mmr3v3=" + mmr3v3 +
                ", average=" + average +
                '}';
    }

    public void setAgg(){
        int[] tab = {this.getMmr1v1(), this.getMmr2v2(), this.getMmr3v3()};

        int average = 0;
        if (Arrays.stream(tab).average().isPresent())
            average = (int) Arrays.stream(tab).average().getAsDouble();
        this.setAverage(average);

        LOG.info(this.toString());
    }
}
