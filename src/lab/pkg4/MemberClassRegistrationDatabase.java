/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg4;

import java.util.*;
import java.io.*;
import java.time.*;

/**
 *
 * @author ahmadyasserhamad
 */
public class MemberClassRegistrationDatabase extends Database{

    private ArrayList<MemberClassRegistration> records = new ArrayList();

    public MemberClassRegistrationDatabase(String filename) {
        super(filename);
    }

    @Override
    public void readFromFile() throws FileNotFoundException {
        File file = new File(getFilename());
        Scanner fileContent = new Scanner(file);
        while (fileContent.hasNextLine()) {
            String registration = fileContent.nextLine();
            String[] dividedRegistration = registration.split(",");
            MemberClassRegistration newRegistration = new MemberClassRegistration(dividedRegistration[0], dividedRegistration[1], dividedRegistration[2], LocalDate.parse(dividedRegistration[3]));
            records.add(newRegistration);
        }
    }

    @Override
    public MemberClassRegistration createRecordFrom(String line) {
        String[] dividedLine = line.split(",");
        MemberClassRegistration newRegistration = new MemberClassRegistration(dividedLine[0], dividedLine[1], dividedLine[2], LocalDate.parse(dividedLine[3]));
        return newRegistration;
    }

    @Override
    public ArrayList<MemberClassRegistration> returnAllRecords() {
        return records;
    }

    @Override
    public boolean contains(String key) {
        for (MemberClassRegistration registration : records) {
            if (registration.getSearchKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public MemberClassRegistration getRecord(String key) {
        for (MemberClassRegistration registration : records) {
            if (registration.getSearchKey().equals(key)) {
                return registration;
            }
        }
        System.out.println("Member class registration does not exist.");
        return null;
    }

    public void insertRecord(MemberClassRegistration record) {
        for (MemberClassRegistration registration : records) {
            if (registration.equals(record)) {
                System.out.println("Record already exists.");
                return;
            }
        }
        records.add(record);
    }

    @Override
    public void deleteRecord(String key) {
        for (MemberClassRegistration registration : records) {
            if (registration.getSearchKey().equals(key)) {
                records.remove(registration);
                return;
            }
        }
        System.out.println("No records found matching the key.");
    }

    @Override
    public void saveToFile() throws IOException {
        FileWriter writer = new FileWriter(getFilename(), true);
        for (MemberClassRegistration registration : records) {
            writer.write("\r\n");
            writer.write(registration.lineRepresentation());
        }
        writer.close();
    }

}
