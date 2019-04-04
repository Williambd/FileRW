/**
 * Created by williambd
 * on 2019-04-04
 * to allow a user to edit files.
 * 
 */

package readfromafile;

import java.io.*;
import java.io.BufferedReader;
import static java.lang.System.in;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author lidea9928
 */
public class ReadFromAFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner sc = new Scanner(System.in);
        boolean end = false;
        while(!end){
        System.out.println("do you want to:");
        System.out.println("make a new file(n)");
        System.out.println("Rewrite File(rw)");
        System.out.println("Add to File(w)");
        System.out.println("Read file(r)");
            System.out.println("end program(e)");
        String next = scanln();
        if (next.equals("n")){
            newFile();
        }else if(next.equals("rw")){
            write(false);
        }else if(next.equals("w")){
            write(true);
        }else if(next.equals("r")){
            System.out.println("What file would you like to read?");
            readFile(scanln());
        }else if(next.equals("e")){
            end = true;
        }}
    }
    /**
     * Writes the users input to a file.
     * @param ap 
     */
    public static void write(boolean ap){
        System.out.println("Write to what File?");
        BufferedWriter writer;
        try {
        writer = new BufferedWriter(new FileWriter(scanln(),ap));
        System.out.println("Write below: type ??end when done");
        String l;
        
        while (!(l = scanln()).equals("??end")){
            writer.write(l);
            writer.newLine();
        }
            System.out.println("");
        writer.close();
        }catch (IOException ex) {
            Logger.getLogger(ReadFromAFile.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("File Not Found");
        }
    }
    
    /**
     * creates new file that user names
     * @throws IOException 
     */
    public static void newFile() throws IOException{
        System.out.println("Name of File:");
        File file= new File(scanln());
        if (file.createNewFile()){
            System.out.println("File Created \n");
        }else{
            System.out.println("File already exists \n");
        }
        
    }
    
    /**
     * Scans a line
     * @return String of the next line.
     */
    public static String scanln(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
    
    /**
     *  Reads a file
     * @param nameOfFile
     * @throws IOException 
     */
    public static void readFile(String nameOfFile) throws IOException{
        
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(nameOfFile));
            String line;
            while ((line = br.readLine()) != null){
                System.out.println(line);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadFromAFile.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
                System.out.println("");
            } catch (IOException ex) {
                Logger.getLogger(ReadFromAFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
