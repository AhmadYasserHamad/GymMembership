/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg4;
import java.util.*;
import java.io.*;

/**
 *
 * @author ahmadyasserhamad
 */
public abstract class Database{
    
    private String filename;

    public Database(String filename) {
        this.filename = filename;
    }
    
    public abstract void readFromFile() throws FileNotFoundException;
    public abstract Object createRecordFrom(String line);
    public abstract ArrayList<? extends Object> returnAllRecords();
    public abstract boolean contains(String key);
    public abstract Object getRecord(String key);
    public abstract void deleteRecord(String key);
    public abstract void saveToFile() throws IOException;

    public String getFilename() {
        return filename;
    }
    
}
