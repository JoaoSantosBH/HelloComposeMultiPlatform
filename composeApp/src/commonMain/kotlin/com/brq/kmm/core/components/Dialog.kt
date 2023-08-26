//package com.brq.hellocompose.core.components
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.Button
//import androidx.compose.material3.ButtonDefaults
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Surface
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.window.Dialog
//import com.brq.hellocompose.R
//import com.brq.hellocompose.ui.theme.Cyan900
//
//@Composable
//fun CustomDialogWithDraweableCompose(
//    title: Int, info: String, image: Int,
//    buttonText: Int,
//    positiveClick: () -> Unit,
//    setShowDialog: (Boolean) -> Unit,
//    onCloseDialogClick: () -> Unit
//) {
//
//    val btnText = buttonText ?: R.string.button_ok
//
//    Dialog(onDismissRequest = { setShowDialog(false) }) {
//        Surface(
//            shape = RoundedCornerShape(8.dp),
//            color = Color.White
//        ) {
//            Box(
//                contentAlignment = Alignment.Center
//            ) {
//                Column() {
//                    TopHeaderLayout(onCloseDialogClick)
//                    Spacer(modifier = Modifier.height(16.dp))
//                    TitleLayout(stringResource(id = title))
//                    Spacer(modifier = Modifier.height(16.dp))
//                    DrawerLayout(image)
//                    Spacer(modifier = Modifier.height(16.dp))
//                    InfoLayout(info)
//                    Spacer(modifier = Modifier.height(32.dp))
//                    ButtonLayout(positiveClick, btnText)
//                }
//            }
//        }
//    }
//}
//
//@Composable
//private fun ButtonLayout(positiveClick: () -> Unit, btnText: Int) {
//    Row(
//        modifier = Modifier
//            .padding(start = 64.dp, bottom = 24.dp, end = 64.dp)
//            .height(56.dp)
//            .fillMaxWidth(),
//    ) {
//        Button(
//            onClick = { positiveClick.invoke() },
//            enabled = true,
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(46.dp),
//            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
//        ) {
//            Text(text = stringResource(id = btnText), color = Color.White)
//        }
//    }
//}
//
//@Composable
//private fun InfoLayout(info: String) {
//    Row(
//        modifier = Modifier
//            .fillMaxWidth(),
//        horizontalArrangement = Arrangement.Center
//    ) {
//        Text(
//            textAlign = TextAlign.Center,
//            text = info,
//            style = MaterialTheme.typography.labelMedium,
//            color = Cyan900
//        )
//    }
//}
//
//@Composable
//private fun DrawerLayout(image: Int) {
//    Row(
//        modifier = Modifier
//            .fillMaxWidth(),
//        horizontalArrangement = Arrangement.Center
//    )
//    {
//        Image(painter = painterResource(id = image), contentDescription = "", Modifier.size(80.dp))
//    }
//}
//
//@Composable
//fun TitleLayout(title: String) {
//    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
//        Text(
//            text = title,
//            fontWeight = FontWeight.Bold,
//            style = MaterialTheme.typography.labelLarge, color = Color.Red
//        )
//    }
//}
//
//@Composable
//private fun TopHeaderLayout(setShowDialog: () -> Unit) {
//    Column(modifier = Modifier.padding(top = 16.dp)) {
//
//        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
//
//            Spacer(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .weight(1f)
//            )
//            Image(
//                modifier = Modifier
//                    .weight(1f)
//                    .padding(top = 15.dp),
//                painter = painterResource(id = R.drawable.baseline_info_24),
//                contentDescription = ""
//            )
//            Column(
//                modifier = Modifier
//                    .weight(1f).padding(end = 16.dp)
//            ) {
//                Image(
//                    modifier = Modifier
//                        .align(Alignment.End).clickable { setShowDialog.invoke() },
//                    painter = painterResource(id = R.drawable.baseline_close_24),
//                    contentDescription = ""
//                )
//            }
//        }
//    }
//}
//
