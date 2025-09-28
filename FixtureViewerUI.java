import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FixtureViewerUI extends JFrame {
    public FixtureViewerUI() {
        setTitle("Fixture Viewer");
        setSize(700, 340);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(8,8));

        String[] cols = {"Fixture ID", "Team A", "Team B", "Date", "Time", "Venue", "Status"};
        DefaultTableModel model = new DefaultTableModel(cols, 0);
        JTable table = new JTable(model);

        // TODO: load fixtures from DB (read-only)
        model.addRow(new Object[] {"F001", "Team Alpha", "Team Beta", "2025-10-04", "15:00", "Stadium 1", "Scheduled"});
        model.addRow(new Object[] {"F002", "Team Gamma", "Team Delta", "2025-10-05", "18:00", "Stadium 2", "Scheduled"});

        add(new JLabel("Upcoming Fixtures", JLabel.CENTER), BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);

        setLocationRelativeTo(null);
    }
}
