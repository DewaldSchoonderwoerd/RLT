package model.member;

public class Member {

    public Member(String gamerTag, String platform) {
        this.gamerTag = gamerTag;
        this.platform = platform;
    }

    private String gamerTag;
    private String platform;
    private int mmr1v1;
    private int mmr2v2;
    private int mmr3v3;
    private int mmrTour;
    private double average;
    private int max;
    private int min;
    private int sum;

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

    public int getMmrTour() {
        return mmrTour;
    }

    public void setMmrTour(int mmrTour) {
        this.mmrTour = mmrTour;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Member{" +
                "gamerTag='" + gamerTag + '\'' +
                ", platform='" + platform + '\'' +
                ", mmr1v1='" + mmr1v1 + '\'' +
                ", mmr2v2='" + mmr2v2 + '\'' +
                ", mmr3v3='" + mmr3v3 + '\'' +
                ", mmrTour='" + mmrTour + '\'' +
                ", average=" + average +
                ", max=" + max +
                ", min=" + min +
                ", sum=" + sum +
                '}';
    }
}
