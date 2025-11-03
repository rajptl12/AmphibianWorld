package com.raj.amphibianworld.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import androidx.compose.animation.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.raj.amphibianworld.data.AmphibianModel

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AmphibianListScreen(uiState: AmphibianUiState, onRetry: () -> Unit) {
    when (uiState) {
        is AmphibianUiState.Loading -> Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }

        is AmphibianUiState.Error -> Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(uiState.message)
            Button(onClick = onRetry) { Text("Retry") }
        }

        is AmphibianUiState.Success -> Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {

            Text(
                text = "🐸 Amphibian World",
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 26.sp
                ),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(vertical = 12.dp)
            )

            LazyColumn {
                items(uiState.amphibians) { amphibian ->
                    AmphibianDetailCard(amphibian)
                }
            }
        }
    }
}

@Composable
fun AmphibianCard(item: AmphibianModel) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .animateContentSize(),
        elevation = CardDefaults.cardElevation(6.dp),
        onClick = { expanded = !expanded }
    ) {
        Column(modifier = Modifier.padding(10.dp)) {
            Text(
                text = item.name,
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
            )
            Text(
                text = item.type,
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = MaterialTheme.colorScheme.primary
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            AsyncImage(
                model = item.imgSrc,
                contentDescription = item.name,
                modifier = Modifier.fillMaxWidth()
            )

            AnimatedVisibility(visible = expanded) {
                Text(
                    text = item.description,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }
    }
}
