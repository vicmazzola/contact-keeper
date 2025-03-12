package com.example.contactkeeper.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.contactkeeper.viewmodel.ContactsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactForm(viewModel: ContactsViewModel) {
    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = viewModel.name,
            onValueChange = { viewModel.name = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Contact Name") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                capitalization = KeyboardCapitalization.Words
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = viewModel.phone,
            onValueChange = { viewModel.phone = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Phone Number") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Phone
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            Checkbox(
                checked = viewModel.isFriend,
                onCheckedChange = { viewModel.isFriend = it }
            )
            Text(text = "Friend")
        }
        Button(
            onClick = { viewModel.addContact() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "REGISTER")
        }
    }
}
