package com.brq.kmm.features.login.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.brq.kmm.MainRes
import com.brq.kmm.core.components.LoadingLayout
import com.brq.kmm.features.login.presentation.LoginEvent
import com.brq.kmm.features.login.presentation.LoginUiStates
import io.github.skeptick.libres.compose.painterResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginLayout(
    onEvent: (LoginEvent) -> Unit,
    state: LoginUiStates,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 12.dp)
            .background(color = MaterialTheme.colorScheme.background), contentAlignment = Alignment.TopCenter
    ) {
        LazyColumn(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            item {
                Image(painter = painterResource(MainRes.image.logotmdb), contentDescription = null)
                Spacer(Modifier.height(16.dp))
                Text(
                    modifier = Modifier.testTag("Login title"),
                    text = MainRes.string.login_label_text,
                    style = TextStyle(fontSize = 22.sp, fontFamily = FontFamily.Monospace)
                )

                Spacer(modifier = Modifier.height(20.dp))
                TextField(
                    modifier = Modifier
                        .testTag("Name textField")
                        .focusRequester(FocusRequester())
                        .onFocusChanged { focusState ->
                            if (!focusState.isFocused){
                                onEvent(LoginEvent.ValidateNameField(state.name))
                            }
                        },
                    label = { Text(text = MainRes.string.hint_name_text) },
                    singleLine = true,
                    value = TextFieldValue(
                        text = state.name,
                        selection = TextRange(state.name.length)),
                    onValueChange = { tfv ->
                        onEvent(LoginEvent.ValidateNameField(tfv.text))
                    },
                    isError = state.isNameError,
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Next,
                        keyboardType = KeyboardType.Email
                    )
                )
                if (state.isNameError) {
                    Text(
                        text = state.nameErrorHint,
                        color = MaterialTheme.colorScheme.error,
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                TextField(
                    modifier = Modifier.testTag("Pass textField"),
                    label = { Text(text = MainRes.string.hint_pass_text) },
                    value = TextFieldValue(
                        text = state.pass,
                        selection = TextRange(state.pass.length)),
                    visualTransformation = PasswordVisualTransformation(),
                    onValueChange = { tfv ->
                        onEvent(LoginEvent.ValidatePassField(tfv.text))
                    },
                    isError = state.isPassError,
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Next,
                        keyboardType = KeyboardType.Password
                    ),
                    keyboardActions = KeyboardActions(
                        onGo = {
                            onEvent.invoke(LoginEvent.ValidateLogin)
                        }
                    )
                )
                if (state.isPassError) {
                    Text(
                        text = state.passErrorHint,
                        color = MaterialTheme.colorScheme.error,
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))
                if (state.wrongPassError) {
                    Text(
                        text = MainRes.string.wrong_pass,
                        color = MaterialTheme.colorScheme.error,
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
                Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
                    if (state.isLoading) {
                        LoadingLayout(PaddingValues())
                    } else {
                        Button(
                            onClick = {
                                onEvent(LoginEvent.ValidateLogin)
                            },
                            shape = RoundedCornerShape(50.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary),
                            modifier = Modifier
                                .fillMaxWidth()
                                .testTag("Button Login")
                                .height(50.dp)
                        ) {
                            Text(text = MainRes.string.login_label_text)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))
                ClickableText(
                    text = AnnotatedString(MainRes.string.forgot_pass_text),
                    onClick = {  },
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = FontFamily.Default
                    )
                )
            }

        }
    }

}