package com.example.contactkeeper.database.dao

interface ContactDao {

    fun insertContact()

    fun updateContact()

    fun deleteContact()

    fun getContactById()

    fun getAllContacts()
}