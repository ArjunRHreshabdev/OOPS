import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LandingPage landing = new LandingPage();
            landing.setVisible(true);
        });
    }
}
