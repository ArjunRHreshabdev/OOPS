import javax.swing.*;
import java.awt.*;

public class LoginPage extends JFrame {
    public LoginPage() {
        setTitle("Admin Login");
        setSize(360, 210);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel p = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(6, 6, 6, 6);
        c.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblUser = new JLabel("Username:");
        JTextField tfUser = new JTextField(18);
        JLabel lblPass = new JLabel("Password:");
        JPasswordField pf = new JPasswordField(18);

        JButton btnLogin = new JButton("Login");
        JLabel status = new JLabel(" ", JLabel.CENTER);

        btnLogin.addActionListener(e -> {
            String user = tfUser.getText().trim();
            String pass = new String(pf.getPassword());
            // TODO: Replace with real authentication (JDBC + hashed password check)
            if (user.equals("admin") && pass.equals("admin")) {
                status.setText("Login successful.");
                SwingUtilities.invokeLater(() -> {
                    new FixtureAdminUI().setVisible(true);
                    this.dispose();
                });
            } else {
                status.setText("Invalid credentials.");
            }
        });

        c.gridx = 0; c.gridy = 0; p.add(lblUser, c);
        c.gridx = 1; p.add(tfUser, c);
        c.gridx = 0; c.gridy = 1; p.add(lblPass, c);
        c.gridx = 1; p.add(pf, c);
        c.gridx = 0; c.gridy = 2; c.gridwidth = 2; p.add(btnLogin, c);
        c.gridy = 3; p.add(status, c);

        add(p);
        setLocationRelativeTo(null);
    }
}
