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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import ru.zeksan.unitconverter.ui.theme.UnitConverterTheme
import kotlin.math.roundToInt

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

    var inputValue by remember { mutableStateOf("") }
    var outputValue by remember { mutableStateOf("") }
    var inputUnit by remember { mutableStateOf("Meters") }
    var outputUnit by remember { mutableStateOf("Meters")}
    var iExpanded by remember{ mutableStateOf(false) }
    var oExpanded by remember{ mutableStateOf(false) }
    val iconverisonFactor = remember { mutableStateOf(1.00) }
    val oConversionFactor= remember { mutableStateOf(1.00) }


    fun convertUnits(){

        val inputValueDouble = inputValue.toDoubleOrNull() ?: 0.0
        val result = (inputValueDouble * iconverisonFactor.value * 100.0/ oConversionFactor.value).roundToInt()/100.0
        outputValue = result.toString()
    }

    Column(
        //Выравнивание UI
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Text(text = "Unit Converter",
            style = MaterialTheme.typography.headlineLarge)
        //spacer как и padding добавляет расстояние вокруг объекта

        //OutlinedTextFielSpacer(modifier = Modifier.height(16.dp))d - одно из трех текстовых полей. Это выделенно вокруг
        OutlinedTextField(
            //значение равно входному значению
            value =inputValue,
            onValueChange = {
            //что произойдет, если значение изменится - {} - по сути ничего
                //если значение изменится, то присваиваем его то, что изменилось
                inputValue = it
                convertUnits()
            },
            //выглядит охеренно, это подсказка, которая взлетает наверх
            label = ({Text("Enter Value")})
            )
        Spacer(modifier = Modifier.height(16.dp))

        Row {
            //создали локальный контекст? Хз в чем его истинное прендназначение
            //val context = LocalContext.current

            /**Накладывает Composable файлы друг на друга. Выпадающее меню? */
            //input Box
            Box{
                Button(onClick = { iExpanded = true }) {
                    //input Button
                    Text(text = inputUnit)
                    //Иконка, contentDescription - для слабовидящих!
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow Down")
                }
                DropdownMenu(expanded = iExpanded, onDismissRequest = { iExpanded = false }) {
                    //expanded -открыт или нет    onDidmissRequest - что произойдет, если нажмут вне этого меню
                    DropdownMenuItem(
                        //text ждет composable, поэтому передаем Text
                        text = {Text("Centimeters")},
                        onClick = {
                            iExpanded = false
                            inputUnit = "Centimeters"
                            iconverisonFactor.value = 0.01
                            convertUnits()
                        })
                    DropdownMenuItem(
                        text = {Text("Meters")},
                        onClick = {
                            iExpanded = false
                            inputUnit = "Meters"
                            iconverisonFactor.value = 1.0
                            convertUnits()
                        })
                    DropdownMenuItem(
                        text = {Text("Foot")},
                        onClick = {
                            iExpanded = false
                            inputUnit = "Foot"
                            iconverisonFactor.value = 0.3048
                            convertUnits()
                        })
                    DropdownMenuItem(
                        text = {Text("Milimeters")},
                        onClick = {
                            iExpanded = false
                            inputUnit = "Milimeters"
                            iconverisonFactor.value = 0.001
                            convertUnits()
                        })
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            //output Box
            Box{
                Button(onClick = { oExpanded = true}) {
                    Text(text = outputUnit)
                    //Иконка, contentDescription - для слабовидящих!
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow Down")
                }
                DropdownMenu(expanded = oExpanded, onDismissRequest = { oExpanded = false }) {
                    DropdownMenuItem(
                        //text ждет composable, поэтому передаем Text
                        text = {Text("Centimeters")},
                        onClick = {
                            oExpanded = false
                            outputUnit = "Centimeters"
                            oConversionFactor.value = 0.01
                            convertUnits()}
                    )
                    DropdownMenuItem(
                        text = {Text("Meters")},
                        onClick = {
                            oExpanded = false
                            outputUnit = "Meters"
                            oConversionFactor.value = 1.00
                            convertUnits()
                        })
                    DropdownMenuItem(
                        text = {Text("Foot")},
                        onClick = {
                            oExpanded = false
                            outputUnit = "Foot"
                            oConversionFactor.value = 0.3048
                            convertUnits()
                        })
                    DropdownMenuItem(
                        text = {Text("Milimeters")},
                        onClick = {
                            oExpanded = false
                            outputUnit = "Milimeters"
                            oConversionFactor.value = 0.001
                            convertUnits()
                        })
                }
            }
        }
        //он находится отдельно, не в строках или стобцах сверху
        Text(text="Result:$outputValue $outputUnit",
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.headlineMedium,
            fontFamily = FontFamily.Serif,
            color = Color.Magenta
        )

    }
}
//собственный превью
@Preview(showBackground = true)
@Composable
fun UnitConverterPreview(){
    UnitConverter()
}