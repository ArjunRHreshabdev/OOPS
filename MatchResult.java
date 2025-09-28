public class MatchResult {
    private int matchId;
    private int teamAScore;
    private int teamBScore;
    private int winnerId; // Use 0 or -1 to indicate a draw

    // Constructor
    public MatchResult(int matchId, int teamAScore, int teamBScore, int winnerId) {
        this.matchId = matchId;
        this.teamAScore = teamAScore;
        this.teamBScore = teamBScore;
        this.winnerId = winnerId;
    }

    // Getters and Setters
    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public int getTeamAScore() {
        return teamAScore;
    }

    public void setTeamAScore(int teamAScore) {
        this.teamAScore = teamAScore;
    }

    public int getTeamBScore() {
        return teamBScore;
    }

    public void setTeamBScore(int teamBScore) {
        this.teamBScore = teamBScore;
    }

    public int getWinnerId() {
        return winnerId;
    }

    public void setWinnerId(int winnerId) {
        this.winnerId = winnerId;
    }
}
