package com.example.contactkeeper.viewmodel

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.contactkeeper.model.Contact

class ContactsViewModel : ViewModel() {
    var name by mutableStateOf("")
    var phone by mutableStateOf("")
    var isFriend by mutableStateOf(false)

    var contactsList = mutableStateListOf<Contact>()

    fun addContact() {
        if (name.isNotEmpty() && phone.isNotEmpty()) {
            contactsList.add(Contact(name, phone, isFriend))
            clearFields()
        }
    }

    fun deleteContact(contact: Contact) {
        contactsList.remove(contact)
    }

    private fun clearFields() {
        name = ""
        phone = ""
        isFriend = false
    }
}
