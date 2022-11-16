package com.sonder.marvelapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sonder.marvelapplication.characters.data.network.response.CharactersResponse
import com.sonder.marvelapplication.characters.data.network.response.Data
import com.sonder.marvelapplication.characters.ui.CharacterViewModel
import com.sonder.marvelapplication.ui.theme.MarvelApplicationTheme
import dagger.hilt.android.AndroidEntryPoint
import okio.Utf8.size
import java.nio.file.Files.size

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val character: CharacterViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MarvelApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting(character)
                }
            }
        }
    }
}

@Composable
fun Greeting(loginViewModel: CharacterViewModel) {
    val rvState = rememberLazyListState()
    Column(Modifier.fillMaxWidth()) {
        val name: String by loginViewModel.name.observeAsState(initial = "Holis :)")
        Button(
            onClick = { loginViewModel.onLoginSelected() },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFF4EA8E9),
                disabledBackgroundColor = Color(0xFF78C8F9),
                contentColor = Color.White,
                disabledContentColor = Color.White
            )
        ) {
            Text(text = "Log In")
        }
        LazyColumn(
            state = rvState,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(2) {
                Text(
                    text = name,
                    color = Color.White,
                    fontSize = 25.sp,
                    modifier = Modifier.align(CenterHorizontally)
                )
            }
        }
    }
}
