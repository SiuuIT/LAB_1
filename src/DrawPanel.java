import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.util.Objects;

public class DrawPanel extends JPanel {

    // Just a single image, TODO: Generalize !!!!!!!!!!!
    BufferedImage volvoImage;
    BufferedImage saabImage;
    BufferedImage scaniaImage;


    // To keep track of a single cars position
    Point volvoPoint = new Point();
    Point saabPoint = new Point();
    Point scaniaPoint = new Point();

    private ArrayList<Point> carPoints = new ArrayList<>();
    private ArrayList<BufferedImage> carImages = new ArrayList<>();

    Point carPoint = new Point();

    void moveit(Cars car, int x, int y) {
        if (car instanceof Saab) {
            saabPoint.x = x;
            saabPoint.y = y;
        } else if (car instanceof Volvo) {
            volvoPoint.x = x;
            volvoPoint.y = y;
        } else if (car instanceof Scania) {
            scaniaPoint.x = x;
            scaniaPoint.y = y;
        }

    }

    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.

            volvoImage = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResource("pics/Volvo240.jpg")));
            carPoints.add(volvoPoint);
            saabImage = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResource("pics/Saab95.jpg")));
            carPoints.add(saabPoint);
            scaniaImage = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResource("pics/Scania.jpg")));
            carPoints.add(scaniaPoint);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < carPoints.size(); i++) {
            Point carPoint = carPoints.get(i);

            if (i == 0) {
                g.drawImage(volvoImage, carPoint.x, carPoint.y, null);
            } else if (i == 1) {
                g.drawImage(saabImage, carPoint.x, carPoint.y + 100, null);
            } else if (i == 2) {
                g.drawImage(scaniaImage, carPoint.x, carPoint.y + 200, null);
            }
        }
    }
}
