package com.example.contactkeeper.ui

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.contactkeeper.ui.screens.ContactForm
import com.example.contactkeeper.ui.screens.ContactList
import com.example.contactkeeper.viewmodel.ContactsViewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ContactsScreen(viewModel: ContactsViewModel = viewModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        ContactForm(viewModel)
        Spacer(modifier = Modifier.height(8.dp))
        ContactList(viewModel.contactsList, onDelete = viewModel::deleteContact)
    }
}
