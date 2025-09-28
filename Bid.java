import java.math.BigDecimal;
import java.sql.Timestamp;

public class Bid {

    private int bidId;
    private int playerId;
    private int teamId;
    private BigDecimal bidAmount;

    public Bid(int bidId, int playerId, int teamId, BigDecimal bidAmount, Timestamp timestamp) {
        this.bidId = bidId;
        this.playerId = playerId;
        this.teamId = teamId;
        this.bidAmount = bidAmount;
    }

    // Getters and Setters
    public int getBidId() {
        return bidId;
    }

    public void setBidId(int bidId) {
        this.bidId = bidId;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public BigDecimal getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(BigDecimal bidAmount) {
        this.bidAmount = bidAmount;
    }
}