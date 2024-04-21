package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeArticleApp()
                }
            }
        }
    }
}

@Composable
fun ComposeArticleApp() {
    ArticleCard (
        title = stringResource(R.string.title_heading),
        shortDescription = stringResource(R.string.short_description),
        longDescription = stringResource(R.string.long_description),
        imagePainter = painterResource(id = R.drawable.bg_compose_background)
    )
}


@Composable
fun ArticleCard (
    title: String,
    shortDescription: String,
    longDescription: String,
    imagePainter: Painter,
    modifier: Modifier = Modifier,

) {
   Column(modifier = modifier) {
        Image(painter = imagePainter, contentDescription = null)

       Text(
           text = title,
           modifier = modifier.padding(16.dp),
           fontSize = 25 .sp
       )

       Text(
            text = shortDescription,
           modifier = modifier.padding(start = 16.dp, end = 16.dp),
           textAlign = TextAlign.Justify
       )

       Text(
            text = longDescription,
           modifier = modifier.padding(16.dp),
           textAlign = TextAlign.Justify
       )

   }
}

@Preview(showBackground = true)
@Composable
fun ComposeArticleAppPreview() {
    ComposeArticleTheme {
        ComposeArticleApp()
    }
}