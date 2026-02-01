package com.example.myaepp1.ui.flashcards

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myaepp1.ui.common.MyTopBar

@Composable
fun FlashcardsScreen(
    onExit: () -> Unit
) {
    // Shuffle once per session
    val cards = remember { flashcards.shuffled() }

    var index by remember { mutableStateOf(0) }
    var isFlipped by remember { mutableStateOf(false) }

    val currentCard = cards.getOrNull(index)

    Scaffold(
        topBar = {
            MyTopBar(
                title = "Flashcards Θεωρίας",
                onBackClick = onExit
            )
        }
    ) { padding ->

        if (currentCard == null) {
            // END STATE
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Τέλος flashcards :)")
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = onExit) {
                    Text("Έξοδος")
                }
            }
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(24.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                // PROGRESS
                Text(
                    text = "${index + 1} / ${cards.size}",
                    style = MaterialTheme.typography.bodySmall
                )

                Spacer(modifier = Modifier.height(12.dp))

                // CARD
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .clickable { isFlipped = !isFlipped },
                    elevation = CardDefaults.cardElevation(6.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(20.dp)
                            .verticalScroll(rememberScrollState()),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = if (isFlipped)
                                currentCard.answer
                            else
                                currentCard.question,
                            style = if (isFlipped)
                                MaterialTheme.typography.bodyLarge
                            else
                                MaterialTheme.typography.titleLarge
                        )
                    }
                }

                // ℹHINT
                if (!isFlipped) {
                    Text(
                        text = "Πατήστε για απάντηση",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // NAVIGATION
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Button(
                        onClick = {
                            if (index > 0) {
                                index--
                                isFlipped = false
                            }
                        },
                        enabled = index > 0
                    ) {
                        Text("Προηγούμενη")
                    }

                    Button(
                        onClick = {
                            if (index < cards.lastIndex) {
                                index++
                                isFlipped = false
                            }
                        },
                        enabled = index < cards.lastIndex
                    ) {
                        Text("Επόμενη")
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                //  EXIT
                OutlinedButton(
                    onClick = onExit,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Έξοδος")
                }
            }
        }
    }
}

