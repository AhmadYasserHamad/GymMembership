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
public class TrainerDatabase extends Database{

    private ArrayList<Trainer> records = new ArrayList();

    public TrainerDatabase(String filename) {
        super(filename);
    }

    @Override
    public void readFromFile() throws FileNotFoundException {
        File file = new File(getFilename());
        Scanner fileContent = new Scanner(file);
        while (fileContent.hasNextLine()) {
            String trainer = fileContent.nextLine();
            String[] dividedTrainer = trainer.split(",");
            Trainer newTrainer = new Trainer(dividedTrainer[0], dividedTrainer[1], dividedTrainer[2], dividedTrainer[3], dividedTrainer[4]);
            records.add(newTrainer);
        }
    }

    @Override
    public Trainer createRecordFrom(String line) {
        String[] dividedLine = line.split(",");
        Trainer newTrainer = new Trainer(dividedLine[0], dividedLine[1], dividedLine[2], dividedLine[3], dividedLine[4]);
        return newTrainer;
    }

    @Override
    public ArrayList<Trainer> returnAllRecords() {
        return records;
    }

    @Override
    public boolean contains(String key) {
        for (Trainer trainer : records) {
            if (trainer.getSearchKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Trainer getRecord(String key) {
        for (Trainer trainer : records) {
            if (trainer.getSearchKey().equals(key)) {
                return trainer;
            }
        }
        System.out.println("Trainer does not exist.");
        return null;
    }

    public void insertRecord(Trainer record) {
        for (Trainer trainer : records) {
            if (trainer.equals(record)) {
                System.out.println("Record already exists.");
                return;
            }
        }
        records.add(record);
    }

    @Override
    public void deleteRecord(String key) {
        for (Trainer trainer : records) {
            if (trainer.getSearchKey().equals(key)) {
                records.remove(trainer);
                return;
            }
        }
        System.out.println("No records found matching the key.");
    }

    @Override
    public void saveToFile() throws IOException {
        FileWriter writer = new FileWriter(getFilename(),true);
        for (Trainer trainer : records) {
            writer.write("\r\n");
            writer.write(trainer.lineRepresentation());
        }
        writer.close();
    }

}
