package com.fatec.whatsclone.ui.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.fatec.whatsclone.model.ChatMessage
import com.fatec.whatsclone.model.UserInfo
import com.fatec.whatsclone.ui.components.InfoCard
import com.fatec.whatsclone.ui.components.Chat
import com.fatec.whatsclone.ui.components.InputInfoCard
import com.fatec.whatsclone.ui.theme.WhatsCloneTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BasicWhatsapp() {
    val defaultUserInfo = UserInfo(email = "leal@leal.com", nome = "Vinicius")

    var showInfo by remember { mutableStateOf(false) }
    var showInputInfo by remember { mutableStateOf(false) }
    val chatMessages = remember { mutableStateListOf<ChatMessage>() }
    val userInfo = remember { mutableStateOf(defaultUserInfo) }
    var messageText by remember { mutableStateOf("") }
    var currentUser by remember { mutableStateOf(1) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("John Doe") },
                actions = {
                    IconButton(onClick = { showInfo = true }) {
                        Icon(Icons.Filled.Info, contentDescription = "Info")
                    }
                    IconButton(onClick = { showInputInfo = true }) {
                        Icon(Icons.Filled.MoreVert, contentDescription = "More")
                    }
                }
            )
        },
        content = { innerPadding ->
            if (showInfo) {
                InfoCard(onDismiss = { showInfo = false }, innerPadding, userInfo)
            } else if (showInputInfo) {
                InputInfoCard(onDismiss = { showInputInfo = false }, innerPadding, userInfo)
            } else {
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
    )
}

@Preview(showBackground = true)
@Composable
fun WhatsAppScreenPreview() {
    WhatsCloneTheme {
        BasicWhatsapp()
    }
}
