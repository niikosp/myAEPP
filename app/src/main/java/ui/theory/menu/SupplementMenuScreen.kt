package com.example.myaepp1.ui.theory.menu

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myaepp1.ui.common.MyTopBar

@Composable
fun SupplementMenuScreen(
    onItemClick: (String) -> Unit,
    onExtrasClick: () -> Unit,
    onBackClick: () -> Unit
) {
    val items = listOf(
        "data_structures" to "Δομές δεδομένων και αλγόριθμοι",
        "design_techniques" to "Τεχνικές σχεδίασης αλγορίθμων",
        "modern_envs" to "Σύγχρονα προγραμματιστικά περιβάλλοντα",
        "debugging" to "Εκσφαλμάτωση προγράμματος"
    )

    Scaffold(
        topBar = {
            MyTopBar(
                title = "Συμπληρωματικό βιβλίο",
                onBackClick = onBackClick
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text("Ενότητες", style = MaterialTheme.typography.titleMedium)

            items.forEach { (id, title) ->
                Button(
                    onClick = { onItemClick(id) },
                    modifier = Modifier.fillMaxWidth()
                ) { Text(title) }
            }

            Spacer(Modifier.height(12.dp))

            Text("Extras", style = MaterialTheme.typography.titleMedium)

            Button(
                onClick = onExtrasClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Extras")
            }
        }
    }
}
