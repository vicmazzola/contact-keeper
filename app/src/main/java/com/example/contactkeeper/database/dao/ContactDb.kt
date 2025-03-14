package com.example.contactkeeper.database.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.contactkeeper.model.Contact

@Database(
    entities = [Contact::class],
    version = 1
)

abstract class ContactDb : RoomDatabase() {

    abstract fun contactDao(): ContactDao

    companion object {

        private lateinit var instance: ContactDb

        fun getDatabase(context: Context): ContactDb {

            if (!::instance.isInitialized) {

                instance = Room
                    .databaseBuilder(
                        context,
                        ContactDb::class.java,
                        "contact_db"

                    )
                    .allowMainThreadQueries()

                    //ONLY FOR TEST
                    .fallbackToDestructiveMigration()
                    .build()

            }
            return instance

        }

    }

}