package ca.tetervak.dicerollerlab2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ca.tetervak.dicerollerlab2.ui.theme.DiceRollerLab2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerLab2Theme {
                DiceRollerApp()
            }
        }
    }
}


@Preview
@Composable
fun DiceRollerApp(){
    DiceImageWithButton(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun DiceImageWithButton(modifier: Modifier = Modifier) {
    var rand by remember { mutableStateOf(5) }
    val imageResource = when(rand){
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally){
        Image(painter = painterResource(imageResource), contentDescription = "5")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { rand = (1..6).random() }){
            Text(text = stringResource(R.string.roll))
        }
    }
}
