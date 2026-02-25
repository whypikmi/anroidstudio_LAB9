package com.example.androidstudio_lab9

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.runtime.setValue
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidstudio_lab9.data.Datasource
import com.example.androidstudio_lab9.model.Serial
import com.example.androidstudio_lab9.ui.theme.Androidstudio_lab9Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Androidstudio_lab9Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.onBackground
                ) {
                    SerialCatalogApp()
                }
            }
        }
    }
}

@Composable
fun SerialCard(
    serial: Serial,
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier) {
        Column {
            Image(
                painter = painterResource(serial.imageResourceId),
                contentDescription = stringResource(serial.titleResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(500.dp),
                contentScale = ContentScale.Crop
            )
            Column(modifier = Modifier.padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center) {
                Text(
                    text = stringResource(serial.titleResourceId),
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier
                        .padding(bottom = 1.dp)
                )
                Text(
                    text = stringResource(serial.descriptionResourceId),
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(bottom = 1.dp)
                )
            }
        }
    }
}
@Composable
fun SerialNavigator(serialList: List<Serial>, modifier: Modifier = Modifier) {
    var currentIndex by remember { mutableStateOf(0) }
    val currentserial = serialList.getOrNull(currentIndex) ?: return
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        SerialCard(
            serial = currentserial,
            modifier = Modifier.padding(26.dp)
        )
    }
}

@Composable
fun SerialCatalogApp() {
    val serialList = Datasource().loadSerialList()
    SerialNavigator(serialList = serialList)
}
@Preview(showBackground = true)
@Composable
private fun SerialCardPreiew() {
    Androidstudio_lab9Theme {
        SerialCard (
            Serial(
                R.string.item1,
                R.string.item1_description,
                R.drawable.item1
            )
        )
    }
}