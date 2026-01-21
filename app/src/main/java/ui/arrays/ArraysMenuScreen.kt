package com.example.myaepp1.ui.arrays

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myaepp1.ui.common.MyTopBar
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.layout.Arrangement



@Composable
fun ArraysMenuScreen(
    onItemClick: (Int) -> Unit,
    onBackClick: () -> Unit
) {
    val methods = listOf(
        "Διάβασμα & Γράψιμο στοιχείων πίνακα",
        "Εύρεση μέγιστου στοιχείου σε μονοδιάστατο πίνακα",
        "Εύρεση ελάχιστου στοιχείου σε δισδιάστατο πίνακα",
        "Σειριακή αναζήτηση",
        "Αλγόριθμος φυσαλίδας(bubble sort)",
        "Δυαδική αναζήτηση",
        "Συγχώνευση πινάκων",
        "Συχνότητες",
        "Τετραγωνικοί πίνακες",
        "Αραιοί πίνακες",



    )

    Scaffold(
        topBar = {
            MyTopBar(
                title = "Μεθοδολογίες Πινάκων",
                onBackClick = onBackClick
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            itemsIndexed(methods) { index, title ->
                Button(
                    onClick = { onItemClick(index) },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(title)
                }
            }
        }
    }
}
