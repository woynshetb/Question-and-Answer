package com.example.qaapp

import android.os.Bundle
import android.widget.Button
import androidx.compose.material.*
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import com.example.qaapp.ui.theme.QAAppTheme
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QAAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    var qaList = listOf<QA>(
        QA(
            question = "Use a ___ Composable to display an image",
            answerIndex=2,
            choices = listOf<String>(
                "Button",
                "Text",
                "Image",
                "Icon"




                ),

            ),

            QA(
                question = "Alignment.Center centers UI components both horizontally and vertically.",
                answerIndex=0,
                choices = listOf<String>(
                    "True",
                    "False",


                ),

            ),
        QA(
            question = "Composable functions can store an object in memory using the ___ composable",
            answerIndex=0,
            choices = listOf<String>(
                "remember",
                "Column",
                "Modifier",
                "@Composable"


                ),

            ),
        QA(
            question = "The debugger allows you to inspect variables when code execution has been suspended.",
            answerIndex=0,
            choices = listOf<String>(
                "True",
                "False",



            ),

            ),
        QA(
            question = "By using ___ values in a composable function, variables can be made into observables that schedule a recomposition when their value is changed.",
            answerIndex=3,
            choices = listOf<String>(
                "remember",
                "Modifier",
                "@Composable",
                "mutableStateOf"



                ),

            ),
        QA(
            question = "The ___ debugger feature allows you to navigate back up the call stack.",
            answerIndex=0,
            choices = listOf<String>(
                "Step over",
                "Step out",
                "Step into",
                "Resume program"



            ),

            ),





        )

    var result by remember { mutableStateOf(0) }
    var canAnswer by remember { mutableStateOf(true) }

    val scrollState = androidx.compose.foundation.rememberScrollState()


    Column (
modifier = modifier.verticalScroll(scrollState).padding(20.dp),
horizontalAlignment = Alignment.Start,


            ) {

        Row {
            Text(text = "You have answerd")
            Spacer(modifier = modifier.width(10.dp))
            Text(text = "$result" )
        }



        qaList.mapIndexed { indexParent, qa ->
            Column() {

             Row(
                 modifier = modifier
             ){
                 Text(text = (indexParent+1).toString())
                 Spacer(modifier = modifier.width(10.dp))
                 Text(text = qa.question)}


                    qa.choices.mapIndexed { index, choice ->
                        Button(

                            onClick = {

                                if (index == qa.answerIndex && qa == qaList[indexParent]  && canAnswer) {
                                    result = result + 1
                                    canAnswer = false
                                }
                                else{
                                    canAnswer = true
                                }

                            }) {
                            Text(text = choice)
                        }
                    }


            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    QAAppTheme {
        Greeting("Android")
    }
}



 class QA (
    var question:String,
    var answerIndex:Int,
    var choices:List<String>
        )