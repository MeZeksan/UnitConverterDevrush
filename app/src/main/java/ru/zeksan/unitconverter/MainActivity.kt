package ru.zeksan.unitconverter

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import ru.zeksan.unitconverter.ui.theme.UnitConverterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UnitConverter()
                }
            }
        }
    }
}


@Composable
fun UnitConverter(){


    Column{
        Text(text = "Unit Converter",color = Color.Magenta)

        //OutlinedTextField - одно из трех текстовых полей. Это выделенно вокруг
        OutlinedTextField(
            value ="",
            onValueChange = {
            //что произойдет, если значение изменится - {} - по сути ничего
                 })


        Row {
            //создали локальный контекст? Хз в чем его истинное прендназначение
            val context = LocalContext.current
            Button(onClick = { Toast
                .makeText(context,
                    "Thanks for clicking!",
                    Toast.LENGTH_SHORT).show()
            })
            {
                Text(text = "Click me!")
            }
        }

        //он находится отдельно, не в строках или стобцах сверху
        Text(text="Result:",color = Color.Magenta)

    }
}
//собственный превью
@Preview(showBackground = true)
@Composable
fun UnitConverterPreview(){
    UnitConverter()
}