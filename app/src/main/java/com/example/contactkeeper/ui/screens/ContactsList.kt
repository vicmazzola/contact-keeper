package com.example.contactkeeper.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.contactkeeper.model.Contact

@Composable
fun ContactList(contacts: List<Contact>, onDelete: (Contact) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        contacts.forEach { contact ->
            ContactCard(contact, onDelete)
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}
