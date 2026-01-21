package com.example.myaepp1.ui.arrays

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.example.myaepp1.ui.common.MyTopBar

@Composable
fun ArraysTheoryScreen(
    methodIndex: Int,
    onBackClick: () -> Unit
) {
    val fileName = "method_$methodIndex.html"

    Scaffold(
        topBar = {
            MyTopBar(
                title = "Μεθοδολογίες Πινάκων",
                onBackClick = onBackClick
            )
        }
    ) { padding ->
        AndroidView(
            modifier = Modifier.padding(padding),
            factory = { context ->
                WebView(context).apply {
                    webViewClient = WebViewClient()
                    settings.javaScriptEnabled = false
                    loadUrl("file:///android_asset/arrays/$fileName")
                }
            }
        )
    }
}


