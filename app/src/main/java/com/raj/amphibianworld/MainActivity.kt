package com.raj.amphibianworld

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.raj.amphibianworld.ui.theme.AmphibianListScreen
import com.raj.amphibianworld.ui.theme.AmphibianViewModel
import com.raj.amphibianworld.ui.theme.AmphibianWorldTheme
import androidx.compose.runtime.collectAsState


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AmphibianWorldTheme {
                val viewModel: AmphibianViewModel = viewModel()
                val state = viewModel.uiState.collectAsState().value

                AmphibianListScreen(
                    uiState = state,
                    onRetry = { viewModel.fetchAmphibians() }
                )
            }
        }
    }
}
