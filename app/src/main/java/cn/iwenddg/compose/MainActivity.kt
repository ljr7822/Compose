package cn.iwenddg.compose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.Card
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.io.StringReader

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SelectableText()
        }
    }

    // 文字
    @Preview
    @Composable
    fun TextDemo() {
        // 显示资源中的文字
        //Text(stringResource(R.string.test))
        // 设置文字样式
        Text(
            "hello world",
            color = Color.Blue,
            fontSize = 20.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.width(150.dp)
        )
    }

    // 文字中包含多种样式
    @Preview
    @Composable
    fun MultipleStylesInText() {
        Text(buildAnnotatedString {
            withStyle(style = SpanStyle(color = Color.Blue)) {
                append("H")
            }
            append("ello ")

            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Red)) {
                append("W")
            }
            append("orld")
        })
    }

    // 选择文字:要启用文字选择，需要使用 SelectionContainer 可组合项封装文字元素
    @Preview
    @Composable
    fun SelectableText() {
        SelectionContainer {
            Text("This text is selectable")
        }
    }

    @Preview
    @Composable
    fun ComposablePreview() {
        Row(
            // 使用 Modifier函数来创建布局属性
            modifier = Modifier
                .size(150.dp)
                .background(Color.Yellow),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(Modifier.size(50.dp).background(Color.Red))
            Box(Modifier.size(50.dp).background(Color.Blue))
        }
    }
}