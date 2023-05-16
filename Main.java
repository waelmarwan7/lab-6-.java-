/*
 *
 * Name: Ahmed Mohammed Bakr Ahmed
 * ID: 2000037
 * Sec: 1
 * Lab no.: 6
 *
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            // Read file name through args
            String fileName = "Input files\\" + args[0];
            File input = new File(fileName);

            // Read file if exists else it throws FileNotFoundException
            FileReader reader = new FileReader(input);

            // Check the extension of the file & if it isn't .arxml throw NotValidAutosarFileException
            if (!fileName.endsWith(".arxml")) {
                throw new NotValidAutosarFileException("Invalid file extension!!");
            }
            
            // Check if the file is empty or not and if empty throw EmptyAutosarFileException
            if (input.length()==0){
                throw new EmptyAutosarFileException("Empty File!!");
            }

            // Read the file and store the string in it in a StringBuider "data"
            int byteRead;
            StringBuilder data = new StringBuilder();
            while ((byteRead = reader.read()) != -1) {
                data.append((char) byteRead);
            }

            // Close FileReader
            reader.close();
            
            // Use Scanner to read the data line by line
            Scanner scanner = new Scanner(data.toString());
            
            // The ArrayList is used to store all containers of arxml file
            ArrayList<Container> containers = new ArrayList<>();
            
            // While the scanner can find a new line in the data string 
            while (scanner.hasNextLine()) {
                
                // Start to read each line and if it contains a container tag, start to store the attributes
                String line = scanner.nextLine();
                if (line.contains("<CONTAINER")) {
                    String containerId = line.substring(line.indexOf("ID="));

                    String shortNameTag = scanner.nextLine();

                    String shortName = shortNameTag.substring(shortNameTag.indexOf(">")+1 , shortNameTag.indexOf("</"));

                    String longNameTag = scanner.nextLine();
                    String longName = longNameTag.substring(longNameTag.indexOf(">") + 1, longNameTag.indexOf("</"));
                    Container c = new Container();
                    c.setContainerID(containerId);
                    c.setShortName(shortName);
                    c.setLongName(longName);
                    containers.add(c);
                }
            }
            
            // Sort the ArrayList of containers
            Collections.sort(containers);
           
            // Calculate the new file name and store it in outName
            String outName = "Output Files\\"+ args[0].substring(0,args[0].indexOf("."))+"_mod.arxml";
           
            /* Open FileWriter and start to write into the destination 
             * If the destination not found it creates a directory and creates a file in it
             */
            File file = new File("Output Files");
            file.mkdir();
            FileWriter fileWriter = new FileWriter(outName);
          
            // Write containers to output file in Output Files directory
            fileWriter.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n   <AUTOSAR>\n");
            for (int i = 0; i < containers.size(); i++){
                fileWriter.write(containers.get(i).toString());
            }
            fileWriter.write("   </AutoSar>");
          
            // Make sure that data has been transimitted correctly and close FileWriter
            fileWriter.flush();
            fileWriter.close();

        } catch (NotValidAutosarFileException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
