package com.neighbor.neighborsrefrigerator.scenarios.main.post.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.neighbor.neighborsrefrigerator.data.PostData
import com.neighbor.neighborsrefrigerator.scenarios.main.post.ItemImage
import com.neighbor.neighborsrefrigerator.view.DeclarationDialog
import java.text.SimpleDateFormat

@Composable
fun SharePostDetail(navHostController: NavHostController, post: PostData) {

    val formatter = SimpleDateFormat("yyyy-mm-dd hh:mm:ss")
    val postTime = formatter.parse(post.validateDate)

    val day = "${postTime?.year}년 ${postTime?.month}월 ${postTime?.day}일"
    val validateType = when (post.validateType) {
        1 -> "유통기한"
        2 -> "제조일자"
        3 -> "구매일자"
        else -> {
            ""
        }
    }

    val scaffoldState = rememberScaffoldState()
    var declarationDialogState by remember {
        mutableStateOf(false)
    }
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = {},
                actions = {
                    IconButton(onClick = { declarationDialogState = true }) {
                        Icon(Icons.Filled.Warning, contentDescription = "", tint = Color.Red)
                    }
                },
                navigationIcon = {
                    IconButton(onClick =  { navHostController.navigateUp() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "")
                    }
                },
                backgroundColor = Color.Transparent,
                elevation = 0.dp
            )
        }
    ) {
        Surface(modifier = Modifier
            .padding(it)
            .fillMaxSize()) {
            if (declarationDialogState) {
                DeclarationDialog(type = 1) {
                    declarationDialogState = false
                }
            }
            Column {
                Text(text = "상품 자세히 보기", fontSize = 20.sp, modifier = Modifier.padding(start = 30.dp, top = 10.dp, bottom = 20.dp))
                Row() {
                    Spacer(modifier = Modifier.width(30.dp))
                    val modifier = Modifier.size(150.dp)
                    post.productImg?.let {
                        ItemImage(productImg = post.productImg, modifier = modifier)
                    }


                    Spacer(modifier = Modifier.width(30.dp))
                    Text(text = post.title, fontSize = 20.sp)
                }
                Spacer(modifier = Modifier.height(30.dp))
                Surface(shape = MaterialTheme.shapes.large.copy(topEnd = CornerSize(70.dp))) {
                    Column(modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color(0xff00ac77))) {
                        Text(text = "내 위치에서 ${post.distance}km", fontSize = 20.sp, color = Color.White)
                        Text(text = "$validateType : $day", fontSize = 20.sp, color = Color.White)
                    }
                }
            }
        }
    }
}

@Composable
fun Detail(){

}



@Preview
@Composable
fun Rreview111() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                actions = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.Warning, contentDescription = "")
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "")
                    }
                },
                backgroundColor = Color.Transparent,
                elevation = 0.dp
            )
        }
    ) {
        Surface(modifier = Modifier.padding(it)) {

        }
    }
}