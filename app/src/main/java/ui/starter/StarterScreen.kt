package com.example.myaepp1.ui.starter

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun StarterScreen(
    onStartClick: () -> Unit,
    onCreatorClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "MyΑΕΠΠ",
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.headlineLarge
        )

        Text(
            text = "Προετοιμασία για τις Πανελλήνιες",
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f)
        )

        Spacer(modifier = Modifier.height(40.dp))

        Button(
            onClick = onStartClick,
            modifier = Modifier.fillMaxWidth(0.6f)
        ) {
            Text("Πάμε", fontSize = 18.sp)
        }

    }
}
