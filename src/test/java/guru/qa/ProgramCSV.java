package guru.qa;

import com.codeborne.selenide.Configuration;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static guru.qa.TestReadMore.*;

public class ProgramCSV {
    public static String storePrefix;
    public static String url_path;

    public static void writeCSVNull(String filePath) {

        File file = new File(filePath);
        try {
            FileWriter outputfile = new FileWriter(file, false);
            CSVWriter writer = new CSVWriter(outputfile);
            writer.writeNext(null);
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeCSV(String filePath, String prefix, String url) {

        File file = new File(filePath);
        try {
            FileWriter outputfile = new FileWriter(file, true);
            CSVWriter writer = new CSVWriter(outputfile);
            String[] data1 = { prefix, url };
            writer.writeNext(data1);
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void newReaderDesktop() throws CsvValidationException, IOException {
        FileReader filereader;
        try {
            filereader = new FileReader(readCSVPath);
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
        writeCSVNull(writeCSVPathDesktop);
        CSVReader csvReader = new CSVReader(filereader);
        String[] nextRecord;
        while ((nextRecord = csvReader.readNext()) != null) {
            storePrefix = nextRecord[0];
            url_path = nextRecord[1];
            Configuration.browserSize = desktopResolution;
            open(storePrefix + url_path + ".html");
            if (storePrefix.contains("en")) {
                if ($("body").getText().contains("Read more")
                        || $(".readmore").exists()){
                    writeCSV(writeCSVPathDesktop, storePrefix, url_path);
                    System.out.println(storePrefix + url_path);
                } else {
                    System.out.println(storePrefix + url_path + " - NONE!");
                }
            }
            if (storePrefix.contains("de")) {
                if ($("body").getText().contains("Mehr lesen")
                || $(".readmore").exists()) {
                 writeCSV(writeCSVPathDesktop, storePrefix, url_path);
                 System.out.println(storePrefix + url_path);
                } else {
                    System.out.println(storePrefix + url_path + " - NONE!");
                }
            }
            if (storePrefix.contains("fr")) {
                if ($("body").getText().contains("Lire la suite")
                     || $(".readmore").exists()) {
                 writeCSV(writeCSVPathDesktop, storePrefix, url_path);
                 System.out.println(storePrefix + url_path);
                 } else {
                 System.out.println(storePrefix + url_path + " - NONE!");
                 }
             }
         }
    }

    public static void newReaderMobile() throws CsvValidationException, IOException {
        FileReader filereader;
        try {
            filereader = new FileReader(readCSVPath);
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
        writeCSVNull(writeCSVPathMobile);
        CSVReader csvReader = new CSVReader(filereader);
        String[] nextRecord;
        while ((nextRecord = csvReader.readNext()) != null) {
            storePrefix = nextRecord[0];
            url_path = nextRecord[1];
            Configuration.browserSize = mobileResolution;
            open(storePrefix + url_path + ".html");
            if (storePrefix.contains("en")) {
                if ($("body").getText().contains("Read more")
                        || $(".readmore").exists()){
                    writeCSV(writeCSVPathMobile, storePrefix, url_path);
                    System.out.println(storePrefix + url_path);
                } else {
                    System.out.println(storePrefix + url_path + " - NONE!");
                }
            }
            if (storePrefix.contains("de")) {
                if ($("body").getText().contains("Mehr lesen")
                || $(".readmore").exists()) {
                 writeCSV(writeCSVPathMobile, storePrefix, url_path);
                 System.out.println(storePrefix + url_path);
                } else {
                    System.out.println(storePrefix + url_path + " - NONE!");
                }
            }
            if (storePrefix.contains("fr")) {
                if ($("body").getText().contains("Lire la suite")
                     || $(".readmore").exists()) {
                 writeCSV(writeCSVPathMobile, storePrefix, url_path);
                 System.out.println(storePrefix + url_path);
                 } else {
                 System.out.println(storePrefix + url_path + " - NONE!");
                 }
             }
         }
    }

    public static void newReaderTablet() throws CsvValidationException, IOException {
        FileReader filereader;
        try {
            filereader = new FileReader(readCSVPath);
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
        writeCSVNull(writeCSVPathTablet);
        CSVReader csvReader = new CSVReader(filereader);
        String[] nextRecord;
        while ((nextRecord = csvReader.readNext()) != null) {
            storePrefix = nextRecord[0];
            url_path = nextRecord[1];
            Configuration.browserSize = tabletResolution;
            open(storePrefix + url_path + ".html");
            if (storePrefix.contains("en")) {
                if ($("body").getText().contains("Read more")
                        || $(".readmore").exists()){
                    writeCSV(writeCSVPathTablet, storePrefix, url_path);
                    System.out.println(storePrefix + url_path);
                } else {
                    System.out.println(storePrefix + url_path + " - NONE!");
                }
            }
            if (storePrefix.contains("de")) {
                if ($("body").getText().contains("Mehr lesen")
                || $(".readmore").exists()) {
                 writeCSV(writeCSVPathTablet, storePrefix, url_path);
                 System.out.println(storePrefix + url_path);
                } else {
                    System.out.println(storePrefix + url_path + " - NONE!");
                }
            }
            if (storePrefix.contains("fr")) {
                if ($("body").getText().contains("Lire la suite")
                     || $(".readmore").exists()) {
                 writeCSV(writeCSVPathTablet, storePrefix, url_path);
                 System.out.println(storePrefix + url_path);
                 } else {
                 System.out.println(storePrefix + url_path + " - NONE!");
                 }
             }
         }
    }
}



