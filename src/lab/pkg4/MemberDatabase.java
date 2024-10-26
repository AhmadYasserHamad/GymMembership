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
public class MemberDatabase extends Database{

    private ArrayList<Member> records = new ArrayList();

    public MemberDatabase(String filename) {
        super(filename);
    }

    @Override
    public void readFromFile() throws FileNotFoundException {
        File file = new File(getFilename());
        Scanner fileContent = new Scanner(file);
        while (fileContent.hasNextLine()) {
            String trainer = fileContent.nextLine();
            String[] dividedMember = trainer.split(",");
            Member newMember = new Member(dividedMember[0], dividedMember[1], dividedMember[2], dividedMember[3], dividedMember[4], dividedMember[5]);
            records.add(newMember);
        }
    }

    @Override
    public Member createRecordFrom(String line) {
        String[] dividedLine = line.split(",");
        Member newMember = new Member(dividedLine[0], dividedLine[1], dividedLine[2], dividedLine[3], dividedLine[4], dividedLine[5]);
        return newMember;
    }

    @Override
    public ArrayList<Member> returnAllRecords() {
        return records;
    }

    @Override
    public boolean contains(String key) {
        for (Member member : records) {
            if (member.getSearchKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Member getRecord(String key) {
        for (Member member : records) {
            if (member.getSearchKey().equals(key)) {
                return member;
            }
        }
        System.out.println("Member does not exist.");
        return null;
    }

    public void insertRecord(Member record) {
        for (Member member : records) {
            if (member.equals(record)) {
                System.out.println("Record already exists.");
                return;
            }
        }
        records.add(record);
    }

    @Override
    public void deleteRecord(String key) {
        for (Member member : records) {
            if (member.getSearchKey().equals(key)) {
                records.remove(member);
                return;
            }
        }
        System.out.println("No records found matching the key.");
    }

    @Override
    public void saveToFile() throws IOException {
        FileWriter writer = new FileWriter(getFilename(), true);
        for (Member member : records) {
            writer.write("\r\n");
            writer.write(member.lineRepresentation());
        }
        writer.close();
    }

}
