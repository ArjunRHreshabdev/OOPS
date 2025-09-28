import java.awt.*;
import javax.swing.*;

public class LandingPage extends JFrame {
    public LandingPage() {
        setTitle("Tournament Management - Landing");
        setSize(420, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(8, 8, 8, 8);
        c.fill = GridBagConstraints.HORIZONTAL;

        JLabel title = new JLabel("Tournament Management System", JLabel.CENTER);
        title.setFont(title.getFont().deriveFont(16f).deriveFont(Font.BOLD));
        c.gridx = 0; c.gridy = 0; c.gridwidth = 2;
        panel.add(title, c);

        JButton btnLogin = new JButton("Admin Login");
        btnLogin.addActionListener(e -> open(new LoginPage()));

        JButton btnRegister = new JButton("Register Player / Team");
        btnRegister.addActionListener(e -> open(new RegistrationForm()));

        JButton btnLeaderboard = new JButton("View Leaderboard");
        btnLeaderboard.addActionListener(e -> open(new LeaderboardUI()));

        JButton btnAuctionAdmin = new JButton("Auction (Admin)");
        btnAuctionAdmin.addActionListener(e -> open(new AuctionAdminUI()));

        JButton btnAuctionManager = new JButton("Auction Manager (Client)");
        btnAuctionManager.addActionListener(e -> open(new AuctionManagerUI()));

        JButton btnFixtureAdmin = new JButton("Fixture Manager");
        btnFixtureAdmin.addActionListener(e -> open(new FixtureAdminUI()));

        JButton btnFixtureViewer = new JButton("Fixture Viewer");
        btnFixtureViewer.addActionListener(e -> open(new FixtureViewerUI()));

        JButton btnMatchEntry = new JButton("Enter Match Result");
        btnMatchEntry.addActionListener(e -> open(new MatchResultEntryUI()));

        JPanel grid = new JPanel(new GridLayout(4, 2, 8, 8));
        grid.add(btnLogin);
        grid.add(btnRegister);
        grid.add(btnAuctionAdmin);
        grid.add(btnAuctionManager);
        grid.add(btnFixtureAdmin);
        grid.add(btnFixtureViewer);
        grid.add(btnMatchEntry);
        grid.add(btnLeaderboard);

        c.gridx = 0; c.gridy = 1; c.gridwidth = 2;
        panel.add(grid, c);

        add(panel);
    }

    private void open(JFrame frame) {
        frame.setVisible(true);
        frame.setLocationRelativeTo(this);
    }
}
