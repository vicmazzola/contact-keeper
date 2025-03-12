package com.example.contactkeeper.viewmodel

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.contactkeeper.model.Contact

class ContactsViewModel : ViewModel() {
    var name by mutableStateOf("")
    var phone by mutableStateOf("")
    var isFriend by mutableStateOf(false)
    var contactsList by mutableStateOf(listOf<Contact>())

    fun addContact() {
        if (name.isNotEmpty() && phone.isNotEmpty()) {
            contactsList = contactsList + Contact(name, phone, isFriend)
            name = ""
            phone = ""
            isFriend = false
        }
    }

    fun deleteContact(contact: Contact) {
        contactsList = contactsList - contact
    }
}
