package com.example.pack_mate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pack_mate.ui.theme.Pack_mateTheme

data class Maker(val name: String, val part: String)

class AboutActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Pack_mateTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AboutScreen()
                }
            }
        }
    }
}

@Composable
fun AboutScreen() {
    val makers = listOf(
        Maker("정아현", "프론트엔드"),
        Maker("이준호", "백엔드"),
        Maker("김도영", "백엔드"),
        Maker("이수진", "AI")
    )

    Text(text = "만든 사람들")

    Spacer(modifier = Modifier)

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        itemsIndexed(items = makers,
            key = {_,item -> item.name}
        ) { _, maker ->
            MakerItem(maker = maker)
        }
    }
}
@Composable
fun MakerItem(maker: Maker) {
    Card(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "이름: ${maker.name}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "파트: ${maker.part}", style = MaterialTheme.typography.bodySmall)
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    Pack_mateTheme {
        AboutScreen()
    }
}