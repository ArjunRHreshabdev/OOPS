import javax.swing.*;
import java.awt.*;
import java.io.File;

public class RegistrationForm extends JFrame {
    private JLabel imgPreview;
    private File selectedImage;

    public RegistrationForm() {
        setTitle("Register Player / Create Team");
        setSize(600, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel p = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(6, 6, 6, 6);
        c.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblType = new JLabel("Register as:");
        String[] types = {"Player", "Team"};
        JComboBox<String> cbType = new JComboBox<>(types);

        JLabel lblName = new JLabel("Name:");
        JTextField tfName = new JTextField(20);

        JLabel lblAge = new JLabel("Age (player):");
        JTextField tfAge = new JTextField(5);

        JLabel lblTeam = new JLabel("Team (for Player):");
        JTextField tfTeam = new JTextField(15);

        // --- Image Upload ---
        JLabel lblImage = new JLabel("Player Image:");
        JButton btnUpload = new JButton("Upload Image");
        imgPreview = new JLabel("No image", JLabel.CENTER);
        imgPreview.setPreferredSize(new Dimension(150, 150));
        imgPreview.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        btnUpload.addActionListener(e -> chooseImage());

        JButton btnSubmit = new JButton("Submit");
        JLabel status = new JLabel(" ", JLabel.CENTER);

        btnSubmit.addActionListener(e -> {
            String type = (String) cbType.getSelectedItem();
            String name = tfName.getText().trim();

            if (name.isEmpty()) {
                status.setText("Name required.");
                return;
            }

            if (type.equals("Player") && selectedImage == null) {
                status.setText("Player image required.");
                return;
            }

            // TODO: Save to DB (players/teams table, and image path or BLOB)
            String imgPath = (selectedImage != null) ? selectedImage.getAbsolutePath() : "N/A";
            status.setText(type + " '" + name + "' registered. Img: " + imgPath);
        });

        // Layout
        c.gridx = 0; c.gridy = 0; p.add(lblType, c);
        c.gridx = 1; p.add(cbType, c);

        c.gridx = 0; c.gridy = 1; p.add(lblName, c);
        c.gridx = 1; p.add(tfName, c);

        c.gridx = 0; c.gridy = 2; p.add(lblAge, c);
        c.gridx = 1; p.add(tfAge, c);

        c.gridx = 0; c.gridy = 3; p.add(lblTeam, c);
        c.gridx = 1; p.add(tfTeam, c);

        c.gridx = 0; c.gridy = 4; p.add(lblImage, c);
        c.gridx = 1; p.add(btnUpload, c);

        c.gridx = 1; c.gridy = 5; p.add(imgPreview, c);

        c.gridx = 0; c.gridy = 6; c.gridwidth = 2; p.add(btnSubmit, c);
        c.gridy = 7; p.add(status, c);

        add(p);
        setLocationRelativeTo(null);
    }

    private void chooseImage() {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter(
                "Image files", "jpg", "jpeg", "png", "gif"
        ));
        int result = chooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            selectedImage = chooser.getSelectedFile();

            // Scale preview to 150x150
            ImageIcon icon = new ImageIcon(selectedImage.getAbsolutePath());
            Image scaled = icon.getImage().getScaledInstance(
                    imgPreview.getWidth(), imgPreview.getHeight(),
                    Image.SCALE_SMOOTH
            );
            imgPreview.setIcon(new ImageIcon(scaled));
            imgPreview.setText(""); // remove "No image"
        }
    }
}
