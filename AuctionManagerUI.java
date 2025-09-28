import java.awt.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;

public class AuctionManagerUI extends JFrame {
    private DefaultListModel<String> playerListModel = new DefaultListModel<>();
    private JList<String> playerList;
    private JLabel lblCurrentBid = new JLabel("Current Bid: 0");
    private JTextField tfBid = new JTextField(8);

    public AuctionManagerUI() {
        setTitle("Auction Manager (Client)");
        setSize(480, 340);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(8,8));

        // Left: player list
        playerList = new JList<>(playerListModel);
        playerList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(playerList), BorderLayout.WEST);

        // Right: bidding panel
        JPanel bidPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(6,6,6,6); c.fill = GridBagConstraints.HORIZONTAL;

        c.gridx = 0; c.gridy = 0; bidPanel.add(new JLabel("Selected Player:"), c);
        c.gridx = 1; c.gridy = 0; bidPanel.add(new JLabel(" (select on left)"), c);

        c.gridx = 0; c.gridy = 1; bidPanel.add(lblCurrentBid, c);
        c.gridx = 0; c.gridy = 2; bidPanel.add(new JLabel("Your Bid:"), c);
        c.gridx = 1; bidPanel.add(tfBid, c);

        JButton btnPlace = new JButton("Place Bid");
        btnPlace.addActionListener(e -> placeBid());
        c.gridx = 0; c.gridy = 3; c.gridwidth = 2; bidPanel.add(btnPlace, c);

        add(bidPanel, BorderLayout.CENTER);

        // Sample players (in actual use, these are pushed from admin)
        playerListModel.addElement("P001 - Arjun (base 5000)");
        playerListModel.addElement("P002 - Rohit (base 7000)");
        playerListModel.addElement("P003 - Vikram (base 3000)");

        playerList.addListSelectionListener((ListSelectionEvent e) -> {
            if (!e.getValueIsAdjusting()) {
                String sel = playerList.getSelectedValue();
                if (sel != null) {
                    // In real app you'd fetch current bid for this player
                    lblCurrentBid.setText("Current Bid: 0");
                }
            }
        });

        setLocationRelativeTo(null);
    }

    private void placeBid() {
        String sel = playerList.getSelectedValue();
        if (sel == null) {
            JOptionPane.showMessageDialog(this, "Select a player first.");
            return;
        }
        String bidText = tfBid.getText().trim();
        try {
            int bid = Integer.parseInt(bidText);
            // TODO: Send bid to AuctionServer via sockets
            JOptionPane.showMessageDialog(this, "Bid of " + bid + " placed for " + sel + " (simulated).");
            lblCurrentBid.setText("Current Bid: " + bid);
            tfBid.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Enter a valid integer bid.");
        }
    }
}
