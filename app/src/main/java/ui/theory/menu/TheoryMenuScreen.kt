package com.example.myaepp1.ui.theory.menu

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myaepp1.ui.common.MyTopBar


@Composable
fun TheoryMenuScreen(
    onChapterClick: (String) -> Unit,
    onBackClick: () -> Unit
) {
    val chapters = listOf(
        "ch1" to "Κεφάλαιο 1",
        "ch2" to "Κεφάλαιο 2",
        "ch3_9" to "Κεφάλαιο 3 & 9",
        "ch4" to "Κεφάλαιο 4",
        "ch6" to "Κεφάλαιο 6",
        "ch10" to "Κεφάλαιο 10",
        "ch13" to "Κεφάλαιο 13",
        "supplement" to "Συμπληρωματικό βιβλίο"
    )

    Scaffold(
        topBar = {
            MyTopBar(
                title = "Θεωρία",
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
            chapters.forEach { (id, title) ->
                Button(
                    onClick = { onChapterClick(id) },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(title)
                }
            }
        }
    }
}


