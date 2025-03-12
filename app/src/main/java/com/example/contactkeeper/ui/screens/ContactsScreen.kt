package com.example.contactkeeper.ui

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.contactkeeper.ui.screens.ContactForm
import com.example.contactkeeper.ui.screens.ContactList
import com.example.contactkeeper.viewmodel.ContactsViewModel

@Composable
fun ContactsScreen(viewModel: ContactsViewModel = viewModel()) {
    Column {
        ContactForm(viewModel)
        ContactList(viewModel.contactsList, onDelete = viewModel::deleteContact)
    }
}