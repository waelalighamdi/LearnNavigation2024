package ai.ghamdi.learnnavigation2024.appScreen

import ai.ghamdi.learnnavigation2024.ui.theme.LearnNavigation2024Theme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AppScreen(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        modifier = modifier
            .fillMaxSize()
            .padding(32.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun AuthScreenPreview() {
    LearnNavigation2024Theme {
        AppScreen("Hello, I'm the App Screen!")
    }
}