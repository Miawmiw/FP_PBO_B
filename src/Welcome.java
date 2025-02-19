import javax.swing.*;
import java.awt.*;

public class Welcome extends JWindow {

    private final int duration;

    public Welcome(int d){
        duration = d;
        setSize(905, 700);
        setLocationRelativeTo(null);
    }

    public void showWelcome(){
        ImageSplash imageSplash = new ImageSplash();

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 40));
        panel.setOpaque(false);

        // Progress bar top
        JProgressBar progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(false);
        progressBar.setPreferredSize(new Dimension(getWidth() -10, 15));
        progressBar.setForeground(Color.GREEN);
        progressBar.setVisible(true);
        panel.add(progressBar);

        imageSplash.add(progressBar, "Top");
        getContentPane().add(imageSplash, "Center");

        setVisible(true);

        for (int i = 0; i < 100; i++) {
            try {
                progressBar.setValue(i);
                Thread.sleep(duration);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        setVisible(false);
    }

    // Show and Exit welcome Screen
    public void showAndWelcome(){
        showWelcome();
        dispose();
    }


    // For image welcome
    private static class ImageSplash extends JPanel {

        private final ImageIcon image;

        public ImageSplash(){
            image = new ImageIcon("welcomeImage.png");
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            image.paintIcon(this, g, 0, 0);
        }
    }
}
