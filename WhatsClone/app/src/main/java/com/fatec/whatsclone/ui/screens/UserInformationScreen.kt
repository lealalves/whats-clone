package com.fatec.whatsclone.ui.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.fatec.whatsclone.model.UserInfo
import com.fatec.whatsclone.ui.components.InfoCard
import com.fatec.whatsclone.ui.theme.WhatsCloneTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserInformationScreen(userInformation: String, navController: NavController) {
    val name : String = userInformation.split(";")[0]
    val email : String = userInformation.split(";")[1]
    val userInfo = UserInfo(email, name)
    Scaffold (
        topBar = {
            TopAppBar(
                title = { Text("Informações do Usuário") },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigateUp()
                    }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Retornar"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Text(name)
//        InfoCard(innerPadding, userInfo)
    }
}

@Preview(showBackground = true)
@Composable
fun UserInformationScreenPreview() {
    WhatsCloneTheme {
        val navController = rememberNavController()
        UserInformationScreen(userInformation = "", navController)
    }
}