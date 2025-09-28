public class Tournament {
    private int tournamentId;
    private String tname;
    public Tournament(int tournamentId, String tname) {
        this.tournamentId = tournamentId;
        this.tname = tname;
    }
    public int getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(int tournamentId) {
        this.tournamentId = tournamentId;
    }

    public String getName() {
        return tname;
    }

    public void setName(String name) {
        this.tname = name;
    }
}
