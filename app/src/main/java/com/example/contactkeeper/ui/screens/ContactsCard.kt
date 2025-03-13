package com.example.contactkeeper.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.contactkeeper.model.Contact

@Composable
fun ContactCard(contact: Contact, onDelete: (Contact) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            Column(
                modifier = Modifier
                    .weight(1f) // 🔥
                    .padding(end = 8.dp)
            ) {
                Text(text = contact.name, fontSize = 24.sp)
                Text(text = contact.phone, fontSize = 16.sp)
                Text(text = if (contact.isFriend) "Friend" else "Not a Friend", fontSize = 16.sp)
            }
            IconButton(onClick = { onDelete(contact) }) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete Contact"
                )
            }
        }
    }
}
