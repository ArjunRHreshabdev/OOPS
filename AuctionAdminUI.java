import java.awt.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AuctionAdminUI extends JFrame {
    private DefaultTableModel playersModel;

    public AuctionAdminUI() {
        setTitle("Auction Admin Interface");
        setSize(800, 450);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(8,8));

        // Top control bar
        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton btnStart = new JButton("Start Auction");
        JButton btnStop = new JButton("Stop Auction");
        JButton btnNext = new JButton("Next Player");
        top.add(btnStart);
        top.add(btnStop);
        top.add(btnNext);

        // Players table (player list with base price & winning bid)
        String[] cols = {"Player ID", "Player Name", "Base Price", "Current Bid", "Winning Team"};
        playersModel = new DefaultTableModel(cols, 0);
        JTable playersTable = new JTable(playersModel);
        JScrollPane scroll = new JScrollPane(playersTable);

        // Sample data (replace with DB load)
        addSamplePlayers();

        add(top, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

        // TODO: Integrate with AuctionManager clients via Sockets
        btnStart.addActionListener(e -> JOptionPane.showMessageDialog(this, "Auction started (simulated)."));
        btnStop.addActionListener(e -> JOptionPane.showMessageDialog(this, "Auction stopped (simulated)."));
        btnNext.addActionListener(e -> JOptionPane.showMessageDialog(this, "Move to next player (simulated)."));

        setLocationRelativeTo(null);
    }

    private void addSamplePlayers() {
        Vector<Object> r1 = new Vector<>(); r1.add("P001"); r1.add("Arjun"); r1.add(5000); r1.add(0); r1.add("");
        Vector<Object> r2 = new Vector<>(); r2.add("P002"); r2.add("Rohit"); r2.add(7000); r2.add(0); r2.add("");
        Vector<Object> r3 = new Vector<>(); r3.add("P003"); r3.add("Vikram"); r3.add(3000); r3.add(0); r3.add("");
        playersModel.addRow(r1); playersModel.addRow(r2); playersModel.addRow(r3);
    }
}
