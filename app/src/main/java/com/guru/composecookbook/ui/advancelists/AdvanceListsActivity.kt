package com.guru.composecookbook.ui.advancelists

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import androidx.ui.tooling.preview.Preview
import com.guru.composecookbook.theme.ComposeCookBookTheme
import com.guru.composecookbook.ui.dynamic.DynamicUIActivity

class AdvanceListsActivity : AppCompatActivity() {

    private val isDarkTheme: Boolean by lazy {
        intent?.getBooleanExtra(DynamicUIActivity.DARK_THEME, false) ?: false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCookBookTheme(isDarkTheme) {
                // A surface container using the 'background' color from the theme
                Scaffold(
                    topBar = {
                        TopAppBar(title = { Text(text = "Advance Lists") })
                    }
                ) {
                    // ShimmerList()
                    PullRefreshList {

                    }
                }
            }
        }
    }

    companion object {
        const val DARK_THEME = "darkTheme"
        fun newIntent(context: Context, isDarkTheme: Boolean) =
            Intent(context, AdvanceListsActivity::class.java).apply {
                putExtra(DARK_THEME, isDarkTheme)
            }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview10() {
    ComposeCookBookTheme {
        ShimmerList()
    }
}