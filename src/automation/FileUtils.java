package automation;

import automation.data.AutomationElement;
import automation.data.thingsWhatCanGetLocked.Window;
import automation.data.thingsWhatCanRaiseOrLower.GarageDoor;
import automation.data.thingsWhatHaveSwitches.Heating;
import automation.data.thingsWhatHaveSwitches.Light;
import automation.data.thingsWhatHaveSwitches.Oven;

import java.io.*;

public class FileUtils {

    public static final String path = "C:\\Users\\Sergio\\IdeaProjects\\ED-SUBJECT\\HomeAutomationFX\\";

    public static final String fileName = "status.dat";

    public static void saveStatus(AutomationElement[] elements) {
        try (PrintWriter printWriter = new PrintWriter(path + fileName)) {
            for ( AutomationElement e : elements ) {
                printWriter.println(e);
            }
        } catch ( FileNotFoundException e ) {
            System.out.println("File " + fileName + " not found");
            e.printStackTrace();
        }
    }

    public static AutomationElement buildAutomationElement(String[] info, int count) {
        switch ( count ) {
            default:
                return null;
            case 0:
                return new GarageDoor(info[0], info[1].equalsIgnoreCase("locked"), Integer.parseInt(info[2]));
            case 1:
                return new Window(info[0], info[1].equalsIgnoreCase("locked"), Integer.parseInt(info[2]));
            case 2:
                return new Heating(info[0], Integer.parseInt(info[2]), info[1].equalsIgnoreCase("on"));
            case 3:
                return new Oven(info[0], Integer.parseInt(info[2]), info[1].equalsIgnoreCase("on"));
            case 4: case 5:
                return new Light(info[0], info[1].equalsIgnoreCase("on"));
        }
    }

    public static void setAutomationElements(AutomationElement[] elements) {
        try ( FileReader fileReader = new FileReader(path + fileName) ) {
            BufferedReader bf = new BufferedReader(fileReader);
            String line = bf.readLine();
            int count = 0;
            do {
                String[] info = line.split(";");

                elements[count] = buildAutomationElement(info, count);

                line = bf.readLine();
                count++;
            } while ( line != null );
        } catch ( FileNotFoundException e ) {
            System.out.println("File " + fileName + " not found");
        } catch ( IOException e ) {
            e.printStackTrace();
        }
    }

}
