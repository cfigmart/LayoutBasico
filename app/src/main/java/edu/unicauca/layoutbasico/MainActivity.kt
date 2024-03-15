package edu.unicauca.layoutbasico

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.unicauca.layoutbasico.ui.theme.LayoutBasicoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LayoutBasicoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PantallaPrincipal()
                }
            }
        }
    }
}


@Composable
fun BarraBuscar(modifier:Modifier = Modifier){
    TextField(
        value = "",
        leadingIcon = {
                      Icon(
                          imageVector = Icons.Default.Search,
                          contentDescription = stringResource(id = R.string.text_search))

        },
        placeholder = {
                      Text(text = stringResource(id = R.string.text_search))
        },
        onValueChange = {},
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = MaterialTheme.colorScheme.surface,
            focusedContainerColor = MaterialTheme.colorScheme.surface
        ),
        modifier = modifier
            .fillMaxWidth()
            .heightIn(56.dp)
    )
}

@Composable
@Preview(showBackground = true)
fun PreviewBarraBuscar(){
    BarraBuscar()
}

@Composable
fun TarjetaImagenTexto(
    @StringRes textoId: Int,
    @DrawableRes imagenId: Int,
    modifier:Modifier = Modifier){
    Column (horizontalAlignment = Alignment.CenterHorizontally){
        Image(
            painter = painterResource(id = imagenId),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier
                .size(88.dp)
                .clip(CircleShape)



            )
        Text(text = stringResource(id = textoId),
            modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp),
            style = MaterialTheme.typography.bodyMedium)
    }
}

@Preview
@Composable
fun PreviewTarjetaImagenTexto(){
    TarjetaImagenTexto(
        textoId = R.string.inversions_txt,
        imagenId = R.drawable.ab1_inversions
    )
}

@Composable
fun PantallaPrincipal(modifier:Modifier = Modifier){
    Column (verticalArrangement = Arrangement.Top) {
        BarraBuscar()
        TarjetaImagenTexto(
            textoId = R.string.quick_yoga_txt,
            imagenId = R.drawable.ab2_quick_yoga

        )
    }
}

@Preview
@Composable
fun PreviewPantallaPrincipal(){
    PantallaPrincipal()
}










