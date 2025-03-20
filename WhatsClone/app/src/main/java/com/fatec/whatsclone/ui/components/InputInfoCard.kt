package com.fatec.whatsclone.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fatec.whatsclone.model.UserInfo
import com.fatec.whatsclone.ui.theme.WhatsCloneTheme

@Composable
fun InputInfoCard(onDismiss: () -> Unit, innerPadding: PaddingValues, userInfo: MutableState<UserInfo>) {
    var messageText by remember { mutableStateOf("") }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(innerPadding)
            .padding(16.dp),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Alterar Informação do Usuário", style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.height(16.dp))
            Text("Nome", style = MaterialTheme.typography.titleSmall)
            OutlinedTextField(
                value = messageText,
                onValueChange = { messageText = it},
                modifier = Modifier
                    .padding(8.dp),
                shape = RoundedCornerShape(16.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color.LightGray,
                    focusedBorderColor = MaterialTheme.colorScheme.primary
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = onDismiss) {
                Text("Fechar")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InputInfoCardPreview() {
    WhatsCloneTheme {
        val defaultUserInfo = UserInfo(email = "leal@leal.com", nome = "Vinicius")
        val userInfo = remember { mutableStateOf(defaultUserInfo) }

        InputInfoCard(onDismiss = {}, innerPadding = PaddingValues(10.dp), userInfo)
    }
}