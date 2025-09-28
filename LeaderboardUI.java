import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class LeaderboardUI extends JFrame {
    private DefaultTableModel boardModel;

    public LeaderboardUI() {
        setTitle("Leaderboard");
        setSize(640, 420);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(8,8));

        String[] cols = {"Rank", "Team", "Played", "Won", "Drawn", "Lost", "Points", "Net Run Rate"};
        boardModel = new DefaultTableModel(cols, 0);
        JTable table = new JTable(boardModel);
        add(new JLabel("Tournament Leaderboard", JLabel.CENTER), BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // TODO: Load from DB using Leaderboard.getCurrentStandings()
        boardModel.addRow(new Object[] {1, "Team Alpha", 3, 3, 0, 0, 9, "+1.25"});
        boardModel.addRow(new Object[] {2, "Team Beta", 3, 2, 0, 1, 6, "+0.50"});
        boardModel.addRow(new Object[] {3, "Team Gamma", 3, 1, 0, 2, 3, "-0.75"});
        boardModel.addRow(new Object[] {4, "Team Delta", 3, 0, 0, 3, 0, "-1.00"});

        setLocationRelativeTo(null);
    }
}
