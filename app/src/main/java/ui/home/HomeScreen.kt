package com.example.myaepp1.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    onTheoryClick: () -> Unit,
    onArraysClick: () -> Unit,
    onCreatorClick: () -> Unit,
    onTrueFalseClick: () -> Unit,
    onFlashcardsClick: () -> Unit

) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "MyΑΕΠΠ",
            style = MaterialTheme.typography.headlineMedium
        )

        Button(
            onClick = { onTheoryClick() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Θεωρία")
        }

        Button(
            onClick = { onFlashcardsClick() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Flashcards θεωρίας")
        }


        Button(
            onClick = { onTrueFalseClick() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Σ-Λ Πανελληνίων")
        }





        Button(
            onClick = { onArraysClick()},
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Μεθοδολογίες Πινάκων")
        }

        Button(onClick = { onCreatorClick() }, modifier = Modifier.fillMaxWidth()) {
            Text("Από τον Δημιουργό")
        }

    }

}
