public class Match{
    private int matchId;
    private int tournamentId;
    private int teamAId;
    private int teamBId;
    private String status;

    public Match(int matchId, int tournamentId, int teamAId, int teamBId, String status) {
        this.matchId = matchId;
        this.tournamentId = tournamentId;
        this.teamAId = teamAId;
        this.teamBId = teamBId;
        this.status = status;
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public int getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(int tournamentId) {
        this.tournamentId = tournamentId;
    }

    public int getTeamAId() {
        return teamAId;
    }

    public void setTeamAId(int teamAId) {
        this.teamAId = teamAId;
    }

    public int getTeamBId() {
        return teamBId;
    }

    public void setTeamBId(int teamBId) {
        this.teamBId = teamBId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}