package gmail.deyrohit1212.unitconvertor


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import gmail.deyrohit1212.unitconvertor.ui.theme.UnitConvertorTheme
import kotlin.math.roundToInt


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConvertorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UnitConvertor()
                }
            }
        }
    }
}

@Composable
fun UnitConvertor() {
    var input by remember { mutableStateOf("") }
    var output by remember { mutableStateOf("0.00") }
    var inputunit by remember { mutableStateOf("Meters") }
    var outputunit by remember { mutableStateOf("Meters") }
    var factor by remember { mutableDoubleStateOf(1.00) }
    var factoroutput by remember { mutableDoubleStateOf(1.00) }
    var iExpanded by remember { mutableStateOf(false) }
    var oExpanded by remember { mutableStateOf(false) }

    fun resultconversion() {
        val inputvalue = input.toDoubleOrNull() ?: 0.0
        val result = (inputvalue * factor * 100.0/factoroutput).roundToInt() / 100.00
        output = result.toString()
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center, Alignment.CenterHorizontally
    ) {
        //App
        Text(text = "Unit Convertor"
            ,style =MaterialTheme.typography.headlineLarge
        )
        Spacer(modifier = Modifier.height(40.dp))

        OutlinedTextField(value = input
            , onValueChange = {
            input = it
            resultconversion()
        },
            label = { Text("Enter the value") })
        Spacer(modifier = Modifier.height(15.dp))

        Row {
            //Input Box
            Box {
                // Input Button
                Button(onClick = { iExpanded = true }) {
                    Text(text = inputunit)
                    Icon(Icons.Default.ArrowDropDown,
                        contentDescription = "Arrow Down")
                }
                DropdownMenu(expanded = iExpanded, onDismissRequest = { iExpanded = false })
                {

                    DropdownMenuItem(
                        text = { Text("Milimeters") },
                        onClick = {
                            iExpanded = false
                            inputunit = "Miliimeters"
                            factor = 0.001
                            resultconversion()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Centimeters") },
                        onClick = {
                            iExpanded = false
                            inputunit = "Centimeters"
                            factor = 0.01
                            resultconversion()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Meters") },
                        onClick = {
                            iExpanded = false
                            inputunit = "Meters"
                            factor = 1.0
                            resultconversion()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Kilometers") },
                        onClick = {
                            iExpanded = false
                            inputunit = "Kilometers"
                            factor = 1000.00
                            resultconversion()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Inches") },
                        onClick = {
                            iExpanded = false
                            inputunit = "Inches"
                            factor = 0.0254
                            resultconversion()
                    })
                    DropdownMenuItem(
                        text = { Text("Miles") },
                        onClick = {
                            iExpanded = false
                            inputunit = "Inches"
                            factor = 1609.34
                            resultconversion()
                    })
                }
            }
                Spacer(modifier = Modifier.width(30.dp))

                //Output Box
                Box {
                    Button(onClick = { oExpanded = true }) {
                        Text(text = outputunit)
                        Icon(Icons.Default.ArrowDropDown,
                            contentDescription = "Arrow Drop Down")
                    }
                    DropdownMenu(expanded = oExpanded, onDismissRequest = { oExpanded = false })
                    {
                        DropdownMenuItem(
                            text = { Text("Milimeters") },
                            onClick = {
                                oExpanded = false
                                outputunit = "Miliimeters"
                                factoroutput = 0.001
                                resultconversion()
                        })
                        DropdownMenuItem(text = { Text("Centimeters") },
                            onClick = {
                            oExpanded = false
                            outputunit = "Centimeters"
                            factoroutput = 0.01
                            resultconversion()
                        })
                        DropdownMenuItem(
                            text = { Text("Meters") },
                            onClick = {
                                oExpanded = false
                                outputunit = "Meters"
                                factoroutput = 1.0
                                resultconversion()
                        })
                        DropdownMenuItem(
                            text = { Text("Kilometers") },
                            onClick = {
                                oExpanded = false
                                outputunit = "Kilometers"
                                factoroutput = 1000.0
                                resultconversion()
                        })
                        DropdownMenuItem(
                            text = { Text("Inches") },
                            onClick = {
                                oExpanded = false
                                outputunit = "Inches"
                                factoroutput = 39.3701
                                resultconversion()
                        })
                        DropdownMenuItem(
                            text = { Text("Miles") },
                            onClick = {
                                oExpanded = false
                                outputunit = "Miles"
                                factoroutput = 1609.34
                                resultconversion()
                        })
                    }
                }
            }
            Spacer(modifier = Modifier.height(25.dp))
            //Result Text
            Text(text = "The Result : $output $outputunit"
                ,style =MaterialTheme.typography.headlineMedium
                ,color =Color.Blue
                , fontStyle = FontStyle.Italic
                )
        }
    }

@Preview(showBackground = true)
    @Composable
    fun UnitConvertorPreview() {
        UnitConvertor()
    }