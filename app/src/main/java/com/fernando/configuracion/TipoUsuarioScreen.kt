package com.fernando.configuracion

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TipoUsuarioScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = {}
) {
    var seleccion by rememberSaveable { mutableStateOf(0) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(colorResource(R.color.fondo_pantalla))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = onBackClick,
                modifier = Modifier.size(48.dp),
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = colorResource(R.color.fondo_boton_atras),
                    contentColor = colorResource(R.color.azul_principal)
                )
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = stringResource(R.string.regresar)
                )
            }
            Text(
                text = stringResource(R.string.tipo_usuario_titulo),
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center,
                fontSize = 28.sp,
                fontWeight = FontWeight.Medium,
                color = colorResource(R.color.texto)
            )
            Spacer(modifier = Modifier.size(48.dp))
        }

        Text(
            text = stringResource(R.string.tipo_usuario_seleccion),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 28.dp, end = 28.dp, top = 28.dp, bottom = 12.dp),
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            color = colorResource(R.color.texto)
        )

        ItemOpcion(
            titulo = stringResource(R.string.tipo_usuario_aspirante_titulo),
            subtitulo = stringResource(R.string.tipo_usuario_aspirante_subtitulo),
            seleccionado = seleccion == 0,
            onClick = { seleccion = 0 }
        )
        Divisor()
        ItemOpcion(
            titulo = stringResource(R.string.tipo_usuario_becario_titulo),
            subtitulo = stringResource(R.string.tipo_usuario_becario_subtitulo),
            seleccionado = seleccion == 1,
            onClick = { seleccion = 1 }
        )
        Divisor()
    }
}

@Composable
private fun ItemOpcion(
    titulo: String,
    subtitulo: String,
    seleccionado: Boolean,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(horizontal = 28.dp, vertical = 14.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = titulo,
                fontSize = 18.sp,
                color = colorResource(R.color.texto)
            )
            Text(
                text = subtitulo,
                fontSize = 14.sp,
                color = colorResource(R.color.subtitulo)
            )
        }
        RadioButton(
            selected = seleccionado,
            onClick = onClick,
            colors = RadioButtonDefaults.colors(
                selectedColor = colorResource(R.color.azul_principal),
                unselectedColor = colorResource(R.color.switch_off_thumb)
            )
        )
    }
}

@Composable
private fun Divisor() {
    HorizontalDivider(
        thickness = 1.dp,
        color = colorResource(R.color.divisor)
    )
}

@Preview(showBackground = true, widthDp = 390, heightDp = 844)
@Composable
private fun TipoUsuarioScreenPreview() {
    MaterialTheme {
        TipoUsuarioScreen()
    }
}