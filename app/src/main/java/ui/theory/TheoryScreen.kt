package com.example.myaepp1.ui.theory

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.example.myaepp1.ui.common.MyTopBar

@Composable
fun TheoryScreen(
    title: String,
    assetFileName: String,
    onBackClick: () -> Unit
) {
    Scaffold(
        topBar = {
            MyTopBar(
                title = title,
                onBackClick = onBackClick
            )
        }
    ) { paddingValues ->
        AndroidView(
            modifier = Modifier.padding(paddingValues),
            factory = { context ->
                WebView(context).apply {
                    webViewClient = WebViewClient()
                    settings.javaScriptEnabled = false
                    loadUrl("file:///android_asset/theory/$assetFileName")
                }
            }
        )
    }
}
