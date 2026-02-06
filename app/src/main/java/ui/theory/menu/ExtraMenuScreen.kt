package com.example.myaepp1.ui.theory.menu

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myaepp1.ui.common.MyTopBar

@Composable
fun ExtrasMenuScreen(
    onExtraClick: (String) -> Unit,
    onBackClick: () -> Unit
) {
    val extras = listOf(
        "stack" to "Στοίβα",
        "queue" to "Ουρά",
        "lists" to "Λίστες",
        "trees" to "Δένδρα",
        "graphs" to "Γράφοι",
        "select" to "Επίλεξε",
        "modular" to "Τμηματικός Προγραμματισμός",
        "error_categories" to "Κατηγορίες Λαθών",
        "oop" to "Αντικειμενοστραφής προγραμματισμός"
    )

    Scaffold(
        topBar = {
            MyTopBar(
                title = "Extras",
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
            extras.forEach { (id, title) ->
                Button(
                    onClick = { onExtraClick(id) },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(title)
                }
            }
        }
    }
}


