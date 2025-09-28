import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MatchResultEntryUI extends JFrame {
    private DefaultTableModel matchModel;

    public MatchResultEntryUI() {
        setTitle("Match Result Entry");
        setSize(760, 420);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(8,8));

        String[] cols = {"Fixture ID", "Team A", "Team B", "Score A", "Score B", "Winner"};
        matchModel = new DefaultTableModel(cols, 0);
        JTable table = new JTable(matchModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Sample matches
        matchModel.addRow(new Object[] {"F001", "Team Alpha", "Team Beta", "", "", ""});
        matchModel.addRow(new Object[] {"F002", "Team Gamma", "Team Delta", "", "", ""});

        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton btnEnter = new JButton("Enter Result");
        btnEnter.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row == -1) { JOptionPane.showMessageDialog(this, "Select a match."); return; }
            String scA = JOptionPane.showInputDialog(this, "Score for " + matchModel.getValueAt(row,1));
            String scB = JOptionPane.showInputDialog(this, "Score for " + matchModel.getValueAt(row,2));
            if (scA == null || scB == null) return;
            matchModel.setValueAt(scA, row, 3);
            matchModel.setValueAt(scB, row, 4);
            try {
                int a = Integer.parseInt(scA.trim());
                int b = Integer.parseInt(scB.trim());
                matchModel.setValueAt(a > b ? matchModel.getValueAt(row,1) : (b > a ? matchModel.getValueAt(row,2) : "Draw"), row, 5);
                // TODO: Persist to matches table and update leaderboard (JDBC and points calc)
                JOptionPane.showMessageDialog(this, "Result recorded (simulated).");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Enter valid integer scores.");
            }
        });
        bottom.add(btnEnter);
        add(bottom, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
    }
}
