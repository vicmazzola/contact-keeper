package com.example.contactkeeper.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.contactkeeper.model.Contact

@Dao
interface ContactDao {

    @Insert
    fun insertContact(contact: Contact): Long

    @Update
    fun updateContact(contact: Contact): Int

    @Delete
    fun deleteContact(contact: Contact): Int

    @Query("SELECT * FROM tb_contact WHERE id = :idContact")
    fun getContactById(idContact: Long): Contact

    @Query("SELECT * FROM tb_contact ORDER BY name ASC")
    fun getAllContacts(): List<Contact>
}