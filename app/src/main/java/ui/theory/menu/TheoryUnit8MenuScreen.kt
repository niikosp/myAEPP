package com.example.myaepp1.ui.theory.menu

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TheoryUnit8MenuScreen(
    onSubUnitClick: (Int) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Θεωρία – Ενότητα 8",
            style = MaterialTheme.typography.headlineMedium
        )

        (1..4).forEach { subUnit ->
            Button(
                onClick = { onSubUnitClick(subUnit) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Ενότητα 8.$subUnit")
            }
        }
    }
}
