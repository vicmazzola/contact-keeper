package com.example.contactkeeper

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.contactkeeper.ui.ContactsScreen
import com.example.contactkeeper.ui.theme.ContactKeeperTheme
import com.example.contactkeeper.viewmodel.ContactsViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ContactKeeperTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    val viewModel: ContactsViewModel = viewModel()
                    ContactsScreen(viewModel)
                }
            }
        }
    }
}


@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun ContactsScreenPreview() {
    ContactKeeperTheme {
        val viewModel = ContactsViewModel()
        ContactsScreen(viewModel)
    }
}
