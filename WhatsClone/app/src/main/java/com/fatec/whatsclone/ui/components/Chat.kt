package com.fatec.whatsclone.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fatec.whatsclone.model.ChatMessage
import com.fatec.whatsclone.ui.theme.Green40
import com.fatec.whatsclone.ui.theme.WhatsCloneTheme

@Composable
fun Chat(
    chatMessages: MutableList<ChatMessage>,
    messageText: String,
    currentUser: Int,
    onMessageChange: (String) -> Unit,
    onSendClick: () -> Unit,
    innerPadding: PaddingValues
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(chatMessages) { message ->
                ChatMessageItem(message)
            }
        }

        // Layout para a área de entrada de mensagem com o botão
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = messageText,
                onValueChange = onMessageChange,
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp),
                placeholder = { Text("Type a message") },
                shape = RoundedCornerShape(16.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color.LightGray,
                    focusedBorderColor = MaterialTheme.colorScheme.primary
                )
            )

            // FloatingActionButton dentro do Row
            FloatingActionButton(
                onClick = onSendClick,
                containerColor = Green40,
                modifier = Modifier.padding(start = 8.dp) // Adiciona margem esquerda
            ) {
                Icon(imageVector = Icons.Default.Send, contentDescription = "Send")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChatPreview() {
    WhatsCloneTheme {
        val chatMessages = remember { mutableStateListOf<ChatMessage>() }
        chatMessages.add(ChatMessage("Oie", true, 1))
        chatMessages.add(ChatMessage("Eai", true, 0))

        Chat(
            chatMessages,
            "",
            0,
            onMessageChange = {},
            onSendClick = {},
            innerPadding = PaddingValues(10.dp)
        )
    }
}