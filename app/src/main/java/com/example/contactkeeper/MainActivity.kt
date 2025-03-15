package com.example.contactkeeper

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.contactkeeper.database.repository.ContactRepository
import com.example.contactkeeper.model.Contact
import com.example.contactkeeper.ui.theme.ContactKeeperTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ContactKeeperTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        ContactsScreen()
                    }
                }
            }
        }
    }
}

@Composable
fun ContactsScreen() {
    var nameState = remember {
        mutableStateOf("")
    }

    var phoneState = remember {
        mutableStateOf("")
    }

    var friendState = remember {
        mutableStateOf(false)
    }

    // GET CONTEXT
    val context = LocalContext.current
    val contactRepository = ContactRepository(context)

    var contactListState = remember {
        mutableStateOf(contactRepository.getAllContacts())
    }

    Column {
        ContactForm(
            name = nameState.value,
            phone = phoneState.value,
            friend = friendState.value,
            onNameChange = {
                nameState.value = it
            },
            onPhoneChange = {
                phoneState.value = it
            },
            onFriendChange = {
                friendState.value = it
            },
            update = {
                contactListState.value = contactRepository.getAllContacts()
            }
        )
        ContactList(contactListState)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactForm(
    name: String,
    phone: String,
    friend: Boolean,
    onNameChange: (String) -> Unit,
    onPhoneChange: (String) -> Unit,
    onFriendChange: (Boolean) -> Unit,
    update: () -> Unit
) {

    // GET CONTEXT
    val context = LocalContext.current
    val contactRepository = ContactRepository(context)

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = "Contact Registration",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(
                0xFFE91E63
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = name,
            onValueChange = { onNameChange(it) },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Contact Name")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                capitalization = KeyboardCapitalization.Words
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = phone,
            onValueChange = { onPhoneChange(it) },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Contact Phone")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Phone
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Checkbox(checked = friend, onCheckedChange = {
                onFriendChange(it)
            })
            Text(text = "Friend")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                val contact = Contact(
                    id = 0,
                    name = name,
                    phone = phone,
                    isFriend = friend
                )
                contactRepository.insertContact(contact)
                update()

            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "REGISTER",
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun ContactList(contactList: MutableState<List<Contact>>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        for (contact in contactList.value) {
            ContactCard(contact)
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}

@Composable
fun ContactCard(contact: Contact) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.LightGray
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .weight(2f)
            ) {
                Text(
                    text = contact.name,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = contact.phone,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = if (contact.isFriend) "Friend" else "Contact",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = ""
                )
            }
        }
    }
}
