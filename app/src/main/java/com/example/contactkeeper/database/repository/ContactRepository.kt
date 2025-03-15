package com.example.contactkeeper.database.repository

import android.content.Context
import com.example.contactkeeper.database.dao.ContactDb
import com.example.contactkeeper.model.Contact

class ContactRepository(context: Context) {

    //INSTANCE FROM DB WHO KNOWS GO THROUGHOUT CONTACTS
    var db = ContactDb.getDatabase(context).contactDao()

    fun insertContact(contact: Contact): Long {
        return db.insertContact(contact = contact)
    }

    fun updateContact(contact: Contact): Int {
        return db.updateContact(contact = contact)
    }

    fun deleteContact(contact: Contact): Int {
        return db.deleteContact(contact = contact)
    }

    fun getContactById(idContact: Long): Contact {
        return db.getContactById(idContact = idContact)
    }


    fun getAllContacts(): List<Contact> {
        return db.getAllContacts()
    }
}