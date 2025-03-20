package com.fatec.whatsclone.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fatec.whatsclone.ui.theme.WhatsCloneTheme

@Composable
fun Balao() {
    var mostrarBalao by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        Button(onClick = { mostrarBalao = !mostrarBalao }) {
            Text("Mostrar Balão")
        }

        if (mostrarBalao) {
            Box(
                modifier = Modifier
                    .align(Alignment.Center)
                    .background(Color.Black.copy(alpha = 0.7f), shape = RoundedCornerShape(8.dp))
                    .padding(16.dp)
            ) {
                Text("Isso é um balão flutuante!", color = Color.White)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WhatsAppScreenPreview() {
    WhatsCloneTheme {
        Balao()
    }
}