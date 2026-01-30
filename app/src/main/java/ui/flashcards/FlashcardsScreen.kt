package com.example.myaepp1.ui.flashcards

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myaepp1.ui.common.MyTopBar
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState


@Composable
fun FlashcardsScreen(
    onExit: () -> Unit
) {
    val cards = remember {
        flashcards.shuffled()
    }

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


                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(
                        onClick = {
                            index++
                            isFlipped = false
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Επόμενη")
                    }

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
}

