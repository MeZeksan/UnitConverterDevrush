package ru.zeksan.unitconverter

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
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


    Column(
        //Выравнивание UI
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){


        Text(text = "Unit Converter")
        //spacer как и padding добавляет расстояние вокруг объекта
        Spacer(modifier = Modifier.height(16.dp))
        //OutlinedTextField - одно из трех текстовых полей. Это выделенно вокруг
        OutlinedTextField(
            value ="",
            onValueChange = {
            //что произойдет, если значение изменится - {} - по сути ничего
            })
        Spacer(modifier = Modifier.height(16.dp))

        Row {
            //создали локальный контекст? Хз в чем его истинное прендназначение
            //val context = LocalContext.current

            /**Накладывает Composable файлы друг на друга. Выпадающее меню? */
            Box{
                Button(onClick = { /*TODO*/ }) {
                    Text("Select")
                    //Иконка, contentDescription - для слабовидящих!
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow Down")
                }
                DropdownMenu(expanded = true, onDismissRequest = { /*TODO*/ }) {
                    DropdownMenuItem(
                        //text ждет composable, поэтому передаем Text
                        text = {Text("Centimeters")},
                        onClick = { /*TODO*/ })
                    DropdownMenuItem(
                        text = {Text("Meters")},
                        onClick = { /*TODO*/ })
                    DropdownMenuItem(
                        text = {Text("Foot")},
                        onClick = { /*TODO*/ })
                    DropdownMenuItem(
                        text = {Text("Milimeters")},
                        onClick = { /*TODO*/ })
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box{
                Button(onClick = { /*TODO*/ }) {
                    Text("Select")
                    //Иконка, contentDescription - для слабовидящих!
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow Down")
                }
                DropdownMenu(expanded = false, onDismissRequest = { /*TODO*/ }) {
                    DropdownMenuItem(
                        //text ждет composable, поэтому передаем Text
                        text = {Text("Centimeters")},
                        onClick = { /*TODO*/ })
                    DropdownMenuItem(
                        text = {Text("Meters")},
                        onClick = { /*TODO*/ })
                    DropdownMenuItem(
                        text = {Text("Foot")},
                        onClick = { /*TODO*/ })
                    DropdownMenuItem(
                        text = {Text("Milimeters")},
                        onClick = { /*TODO*/ })
                }
            }
        }
        //он находится отдельно, не в строках или стобцах сверху
        Text(text="Result:", modifier = Modifier.padding(16.dp))

    }
}
//собственный превью
@Preview(showBackground = true)
@Composable
fun UnitConverterPreview(){
    UnitConverter()
}