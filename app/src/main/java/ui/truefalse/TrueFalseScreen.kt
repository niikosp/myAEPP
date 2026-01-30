package com.example.myaepp1.ui.truefalse

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myaepp1.ui.common.MyTopBar

@Composable
fun TrueFalseScreen(
    onExit: () -> Unit
) {
    val questions = remember {
        trueFalseQuestions.shuffled()
    }

    val totalQuestions = questions.size

    var index by remember { mutableStateOf(0) }
    var score by remember { mutableStateOf(0) }
    var showResult by remember { mutableStateOf(false) }
    var isCorrect by remember { mutableStateOf(false) }

    val currentQuestion = questions.getOrNull(index)

    Scaffold(
        topBar = {
            MyTopBar(
                title = "Σ-Λ Πανελληνίων",
                onBackClick = onExit
            )
        }
    ) { padding ->

        if (currentQuestion == null) {
            // ✅ FINAL SCORE SCREEN
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Τελικό σκορ",
                    style = MaterialTheme.typography.headlineMedium
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "$score / $totalQuestions",
                    style = MaterialTheme.typography.headlineLarge
                )

                Spacer(modifier = Modifier.height(24.dp))

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
                verticalArrangement = Arrangement.SpaceBetween
            ) {

                // ✅ SCORE + PROGRESS
                Text(
                    text = "Σκορ: $score / $totalQuestions   (${index + 1}/$totalQuestions)",
                    style = MaterialTheme.typography.bodyLarge
                )

                Text(
                    text = currentQuestion.text,
                    style = MaterialTheme.typography.headlineSmall
                )

                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {

                    if (showResult) {
                        Text(
                            text = if (isCorrect)
                                "Η απάντησή σου είναι σωστή ✔"
                            else
                                "Η απάντησή σου είναι λανθασμένη ✖",
                            color = if (isCorrect)
                                MaterialTheme.colorScheme.primary
                            else
                                MaterialTheme.colorScheme.error,
                            style = MaterialTheme.typography.titleLarge
                        )
                        if (!isCorrect) {
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "Σωστή απάντηση: " +
                                        if (currentQuestion.correctAnswer) "Σωστό" else "Λάθος",
                                style = MaterialTheme.typography.bodyLarge
                            )
                        }



                        Button(
                            onClick = {
                                index++
                                showResult = false
                            },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text("Επόμενη")
                        }

                    } else {
                        Button(
                            onClick = {
                                isCorrect = currentQuestion.correctAnswer == true
                                if (isCorrect) score++
                                showResult = true
                            },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text("Σωστό")
                        }

                        Button(
                            onClick = {
                                isCorrect = currentQuestion.correctAnswer == false
                                if (isCorrect) score++
                                showResult = true
                            },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text("Λάθος")
                        }
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
