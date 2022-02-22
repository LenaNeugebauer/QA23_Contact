package com.telran.contacts.tests;

import com.telran.contacts.fw.DataProviders;
import com.telran.contacts.model.Contact;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (!app.getHeader().isSignOutBtnPresent()) {
            app.getUser().login();
        }
    }

    @Test
    public void addContactPositiveTest() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        app.getContact().addContact(new Contact().setName("Karl").setLastName("Adam").setPhone("12345" + i)
                .setEmail("adam" + i + "@gm.com").setAddress("Koblenz").setDesc("torward"));

        Assert.assertTrue(app.getContact().isContactCreated("Karl"));
        app.getContact().removeContact();
    }

    @Test(dataProvider = "newContact", dataProviderClass = DataProviders.class,enabled = false)
    public void addContactPositiveFromDataProviderTest(String name, String lastName, String phone, String email, String address, String desc) {
        app.getContact().addContact(new Contact().setName(name).setLastName(lastName).setPhone(phone)
                .setEmail(email).setAddress(address).setDesc(desc));

        Assert.assertTrue(app.getContact().isContactCreated("Oliver"));
        app.getContact().removeContact();
    }

    @Test(dataProvider = "newContactFromCSV", dataProviderClass = DataProviders.class,enabled = false)
    public void addContactPositiveFromDataProviderWithCSVTest(Contact contact) {
        app.getContact().addContact(contact);

        logger.info("Contact present. Actual result: " + String.valueOf(app.getContact().isContactCreated(contact.getName())) + " .Expected result: true");
        logger.info("Contact present. Actual result: " + String.valueOf(app.getContact().isContactCreatedByPhone(contact.getPhone())) + " .Expected result: true");
        app.getContact().removeContact();
    }

    @Test
    public void addContactNegativeWithoutEmailTest() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        app.getContact().addContact(new Contact().setName("Karl").setLastName("Adam").setPhone("12345" + i)
                .setAddress("Koblenz").setDesc("torward"));

        Assert.assertTrue(app.getContact().isSaveBtnPresent());
    }

}