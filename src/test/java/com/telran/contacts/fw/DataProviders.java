package com.telran.contacts.fw;

import com.telran.contacts.model.Contact;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    @DataProvider
    public Iterator<Object[]> newContact() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Oliver", "Kan", "987654321", "kan@gm.com", "Berlin", "torward"});
        list.add(new Object[]{"Oliver", "Kan", "987654328", "kan+1@gm.com", "Berlin", "torward"});
        list.add(new Object[]{"Oliver", "Kan", "987654329", "kan+2@gm.com", "Berlin", "torward"});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> newContactFromCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contact.csv")));

        String line = reader.readLine();

        while (line != null) {
            String[] split = line.split(",");

            list.add(new Object[]{new Contact().setName(split[0]).setLastName(split[1])
                    .setPhone(split[2]).setEmail(split[3]).setAddress(split[4]).setDesc(split[5])});
            line = reader.readLine();
        }
        return list.iterator();
    }
}