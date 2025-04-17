package com.fatec.whatsclone.ui.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.fatec.whatsclone.model.ChatMessage
import com.fatec.whatsclone.ui.components.Chat
import com.fatec.whatsclone.ui.navigation.Screen
import com.fatec.whatsclone.ui.theme.WhatsCloneTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatScreen(navController: NavController) {
    val defaultUserInfo = "leal&leal"

    val chatMessages = remember { mutableStateListOf<ChatMessage>() }
    var messageText by remember { mutableStateOf("") }
    var currentUser by remember { mutableStateOf(1) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("John Doe") },
                actions = {
                    IconButton(onClick = {
                        navController.navigate(
                            Screen.Information.createRoute("name")
                        )
                    }) {
                        Icon(Icons.Filled.Info, contentDescription = "Info")
                    }
                    IconButton(onClick = { }) {
                        Icon(Icons.Filled.MoreVert, contentDescription = "More")
                    }
                }
            )
        }
    ) { innerPadding ->
        Chat(
            chatMessages = chatMessages,
            messageText = messageText,
            currentUser = currentUser,
            onMessageChange = { messageText = it },
            onSendClick = {
                if (messageText.isNotBlank()) {
                    chatMessages.add(
                        ChatMessage(
                            messageText,
                            isSent = true,
                            user = currentUser
                        )
                    )
                    messageText = ""
                    currentUser = if (currentUser == 1) 2 else 1
                }
            },
            innerPadding = innerPadding
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ChatScreenPreview() {
    WhatsCloneTheme {
        val navController = rememberNavController()
        ChatScreen(navController)
    }
}
