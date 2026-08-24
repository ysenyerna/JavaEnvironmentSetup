import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpClient;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.imageio.ImageIO;

public class Main {
    public static void main(String[] args) {
        printHeader();

        checkJavaVersion();
        checkFileTools();
        checkDateAndTimeTools();
        checkNetworkTools();
        checkImageTools();
        checkDatabaseDriver();

        System.out.println();
        System.out.println("Setup check complete.");
        System.out.println("If all required checks passed, your Java environment is ready for the course.");
    }

    public static void printHeader() {
        System.out.println("Java Course Setup Check");
        System.out.println("-----------------------");
    }

    public static void checkJavaVersion() {
        System.out.println();
        System.out.println("Checking Java version...");
        System.out.println("Java Version: " + System.getProperty("java.version"));
        System.out.println("Java Vendor: " + System.getProperty("java.vendor"));
        System.out.println("Java is running successfully.");
    }

    public static void checkFileTools() {
        System.out.println();
        System.out.println("Checking file tools...");

        String fileName = "setup-check.txt";

        try {
            PrintWriter writer = new PrintWriter(fileName);
            writer.println("Java file writing works.");
            writer.println("This file was created by the Module 1 setup check.");
            writer.close();

            File file = new File(fileName);

            if (file.exists()) {
                System.out.println("File tools are available.");
                System.out.println("Created file: " + file.getName());
                System.out.println("File size: " + file.length() + " bytes");
            } else {
                System.out.println("File check failed: file was not created.");
            }

        } catch (IOException e) {
            System.out.println("File check failed: " + e.getMessage());
        }
    }

    public static void checkDateAndTimeTools() {
        System.out.println();
        System.out.println("Checking date and time tools...");

        LocalDate today = LocalDate.now();
        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy h:mm a");

        System.out.println("Today's date: " + today);
        System.out.println("Current date and time: " + now.format(formatter));
        System.out.println("Date and time tools are available.");
    }

    public static void checkNetworkTools() {
        System.out.println();
        System.out.println("Checking network tools...");

        try {
            HttpClient client = HttpClient.newHttpClient();

            if (client != null) {
                System.out.println("HttpClient is available.");
                System.out.println("Network programming tools are available.");
            } else {
                System.out.println("Network check failed: HttpClient could not be created.");
            }

        } catch (Exception e) {
            System.out.println("Network check failed: " + e.getMessage());
        }
    }

    public static void checkImageTools() {
        System.out.println();
        System.out.println("Checking image tools...");

        try {
            int width = 200;
            int height = 100;

            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    if (x < width / 2) {
                        image.setRGB(x, y, Color.BLUE.getRGB());
                    } else {
                        image.setRGB(x, y, Color.ORANGE.getRGB());
                    }
                }
            }

            File outputFile = new File("setup-image.png");
            ImageIO.write(image, "png", outputFile);

            if (outputFile.exists()) {
                System.out.println("Image tools are available.");
                System.out.println("Created image file: " + outputFile.getName());
            } else {
                System.out.println("Image check failed: image file was not created.");
            }

        } catch (IOException e) {
            System.out.println("Image check failed: " + e.getMessage());
        }
    }

    public static void checkDatabaseDriver() {
        System.out.println();
        System.out.println("Checking SQLite JDBC driver...");

        try {
            Class.forName("org.sqlite.JDBC");
            System.out.println("SQLite JDBC driver was found.");
            System.out.println("Database tools are ready for the JDBC module.");
        } catch (ClassNotFoundException e) {
            System.out.println("SQLite JDBC driver was NOT found.");
            System.out.println("This is okay if your instructor has not provided the JDBC driver yet.");
            System.out.println("For the JDBC module, make sure the SQLite JDBC .jar file is added to the project.");
        }
    }
}