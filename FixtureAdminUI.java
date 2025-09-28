import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FixtureAdminUI extends JFrame {
    private DefaultTableModel fixturesModel;

    public FixtureAdminUI() {
        setTitle("Fixture Manager (Admin)");
        setSize(760, 420);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(8,8));

        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton btnAdd = new JButton("Add Fixture");
        JButton btnEdit = new JButton("Edit Selected");
        JButton btnDelete = new JButton("Delete Selected");
        top.add(btnAdd); top.add(btnEdit); top.add(btnDelete);

        String[] cols = {"Fixture ID", "Team A", "Team B", "Date", "Time", "Venue", "Status"};
        fixturesModel = new DefaultTableModel(cols, 0);
        JTable table = new JTable(fixturesModel);
        add(top, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // sample fixtures
        fixturesModel.addRow(new Object[] {"F001", "Team Alpha", "Team Beta", "2025-10-04", "15:00", "Stadium 1", "Scheduled"});
        fixturesModel.addRow(new Object[] {"F002", "Team Gamma", "Team Delta", "2025-10-05", "18:00", "Stadium 2", "Scheduled"});

        btnAdd.addActionListener(e -> {
            FixtureDialog dlg = new FixtureDialog(this, null);
            dlg.setVisible(true);
            if (dlg.saved) {
                fixturesModel.addRow(dlg.toRow());
            }
        });

        btnEdit.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row == -1) { JOptionPane.showMessageDialog(this, "Select a fixture to edit."); return; }
            Object[] data = new Object[7];
            for (int i = 0; i < 7; i++) data[i] = fixturesModel.getValueAt(row, i);
            FixtureDialog dlg = new FixtureDialog(this, data);
            dlg.setVisible(true);
            if (dlg.saved) {
                Object[] r = dlg.toRow();
                for (int i = 0; i < r.length; i++) fixturesModel.setValueAt(r[i], row, i);
            }
        });

        btnDelete.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row != -1) fixturesModel.removeRow(row);
        });

        setLocationRelativeTo(null);
    }

    // simple dialog to create/edit fixture
    static class FixtureDialog extends JDialog {
        boolean saved = false;
        JTextField[] fields = new JTextField[7];

        FixtureDialog(JFrame parent, Object[] data) {
            super(parent, "Fixture", true);
            setSize(420, 360);
            setLayout(new GridLayout(9, 1, 6, 6));
            String[] labels = {"Fixture ID", "Team A", "Team B", "Date (YYYY-MM-DD)", "Time (HH:MM)", "Venue", "Status"};
            for (int i = 0; i < labels.length; i++) {
                JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
                p.add(new JLabel(labels[i]));
                fields[i] = new JTextField(22);
                if (data != null) fields[i].setText(String.valueOf(data[i]));
                p.add(fields[i]);
                add(p);
            }
            JButton btnSave = new JButton("Save");
            btnSave.addActionListener(e -> { saved = true; dispose(); });
            add(btnSave);
            setLocationRelativeTo(parent);
        }

        Object[] toRow() {
            Object[] row = new Object[7];
            for (int i = 0; i < 7; i++) row[i] = fields[i].getText().trim();
            return row;
        }
    }
}
