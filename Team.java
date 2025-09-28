import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Team {
    private int teamId;
    private String teamName;
    private BigDecimal budget;
    private List<Player> players;

    public Team(int teamId, String teamName, BigDecimal budget) {
        this.teamId = teamId;
        this.teamName =teamName;
        this.budget = budget;
        this.players = new ArrayList<>();
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void deductFromBudget(BigDecimal amount) {
        this.budget = this.budget.subtract(amount);
    }

    public String toString() {
        return "Team{" +
                "teamId=" + teamId +
                ", teamName='" + teamName + '\'' +
                ", budget=" + budget +
                ", playerCount=" + players.size() +
                '}';
    }
}