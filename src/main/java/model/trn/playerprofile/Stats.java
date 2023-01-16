
package model.trn.playerprofile;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Stats {

    @SerializedName("wins")
    @Expose
    private Wins wins;
    @SerializedName("goals")
    @Expose
    private Goals goals;
    @SerializedName("mVPs")
    @Expose
    private MVPs mVPs;
    @SerializedName("saves")
    @Expose
    private Saves saves;
    @SerializedName("assists")
    @Expose
    private Assists assists;
    @SerializedName("shots")
    @Expose
    private Shots shots;
    @SerializedName("goalShotRatio")
    @Expose
    private GoalShotRatio goalShotRatio;
    @SerializedName("score")
    @Expose
    private Score score;
    @SerializedName("seasonRewardLevel")
    @Expose
    private SeasonRewardLevel seasonRewardLevel;
    @SerializedName("seasonRewardWins")
    @Expose
    private SeasonRewardWins seasonRewardWins;
    @SerializedName("tRNRating")
    @Expose
    private TRNRating tRNRating;
    @SerializedName("tier")
    @Expose
    private Tier tier;
    @SerializedName("division")
    @Expose
    private Division division;
    @SerializedName("matchesPlayed")
    @Expose
    private MatchesPlayed matchesPlayed;
    @SerializedName("winStreak")
    @Expose
    private WinStreak winStreak;
    @SerializedName("rating")
    @Expose
    private Rating rating;

    public Wins getWins() {
        return wins;
    }

    public void setWins(Wins wins) {
        this.wins = wins;
    }

    public Goals getGoals() {
        return goals;
    }

    public void setGoals(Goals goals) {
        this.goals = goals;
    }

    public MVPs getmVPs() {
        return mVPs;
    }

    public void setmVPs(MVPs mVPs) {
        this.mVPs = mVPs;
    }

    public Saves getSaves() {
        return saves;
    }

    public void setSaves(Saves saves) {
        this.saves = saves;
    }

    public Assists getAssists() {
        return assists;
    }

    public void setAssists(Assists assists) {
        this.assists = assists;
    }

    public Shots getShots() {
        return shots;
    }

    public void setShots(Shots shots) {
        this.shots = shots;
    }

    public GoalShotRatio getGoalShotRatio() {
        return goalShotRatio;
    }

    public void setGoalShotRatio(GoalShotRatio goalShotRatio) {
        this.goalShotRatio = goalShotRatio;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public SeasonRewardLevel getSeasonRewardLevel() {
        return seasonRewardLevel;
    }

    public void setSeasonRewardLevel(SeasonRewardLevel seasonRewardLevel) {
        this.seasonRewardLevel = seasonRewardLevel;
    }

    public SeasonRewardWins getSeasonRewardWins() {
        return seasonRewardWins;
    }

    public void setSeasonRewardWins(SeasonRewardWins seasonRewardWins) {
        this.seasonRewardWins = seasonRewardWins;
    }

    public TRNRating gettRNRating() {
        return tRNRating;
    }

    public void settRNRating(TRNRating tRNRating) {
        this.tRNRating = tRNRating;
    }

    public Tier getTier() {
        return tier;
    }

    public void setTier(Tier tier) {
        this.tier = tier;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public MatchesPlayed getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setMatchesPlayed(MatchesPlayed matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public WinStreak getWinStreak() {
        return winStreak;
    }

    public void setWinStreak(WinStreak winStreak) {
        this.winStreak = winStreak;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

}
