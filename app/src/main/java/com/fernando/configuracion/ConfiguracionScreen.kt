package com.fernando.configuracion

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ConfiguracionScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = {},
    onTipoUsuarioClick: () -> Unit = {},
    onTamanoTextoClick: () -> Unit = {},
    onPermisosClick: () -> Unit = {},
    onReportarProblemaClick: () -> Unit = {}
) {
    var notificaciones by rememberSaveable { mutableStateOf(true) }
    var modoOscuro by rememberSaveable { mutableStateOf(false) }
    var lectorPantalla by rememberSaveable { mutableStateOf(false) }
    var compartirDatos by rememberSaveable { mutableStateOf(true) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(colorResource(R.color.fondo_pantalla))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp)
        ) {
            IconButton(
                onClick = onBackClick,
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .size(48.dp),
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
                text = stringResource(R.string.titulo),
                modifier = Modifier.align(Alignment.Center),
                fontSize = 28.sp,
                fontWeight = FontWeight.Medium,
                color = colorResource(R.color.texto)
            )
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = 32.dp)
        ) {
            item { SeccionTitulo(stringResource(R.string.seccion_preferencias)) }
            item {
                ItemSwitch(
                    titulo = stringResource(R.string.notificaciones_titulo),
                    subtitulo = stringResource(R.string.notificaciones_subtitulo),
                    checked = notificaciones,
                    onCheckedChange = { notificaciones = it }
                )
            }
            item { Divisor() }
            item {
                Item(
                    titulo = stringResource(R.string.tipo_usuario_titulo),
                    subtitulo = stringResource(R.string.tipo_usuario_subtitulo),
                    onClick = onTipoUsuarioClick
                )
            }
            item { Divisor() }
            item { SeccionTitulo(stringResource(R.string.seccion_accesibilidad)) }
            item {
                ItemSwitch(
                    titulo = stringResource(R.string.modo_oscuro_titulo),
                    subtitulo = stringResource(R.string.modo_oscuro_subtitulo),
                    checked = modoOscuro,
                    onCheckedChange = { modoOscuro = it }
                )
            }
            item { Divisor() }
            item {
                Item(
                    titulo = stringResource(R.string.tamano_texto_titulo),
                    subtitulo = stringResource(R.string.tamano_texto_subtitulo),
                    onClick = onTamanoTextoClick
                )
            }
            item { Divisor() }
            item {
                ItemSwitch(
                    titulo = stringResource(R.string.lector_pantalla_titulo),
                    subtitulo = stringResource(R.string.lector_pantalla_subtitulo),
                    checked = lectorPantalla,
                    onCheckedChange = { lectorPantalla = it }
                )
            }
            item { Divisor() }
            item { SeccionTitulo(stringResource(R.string.seccion_privacidad)) }
            item {
                ItemSwitch(
                    titulo = stringResource(R.string.compartir_datos_titulo),
                    subtitulo = stringResource(R.string.compartir_datos_subtitulo),
                    checked = compartirDatos,
                    onCheckedChange = { compartirDatos = it }
                )
            }
            item { Divisor() }
            item {
                Item(
                    titulo = stringResource(R.string.permisos_titulo),
                    subtitulo = stringResource(R.string.permisos_subtitulo),
                    onClick = onPermisosClick
                )
            }
            item { Divisor() }
            item { SeccionTitulo(stringResource(R.string.seccion_ayuda)) }
            item {
                Text(
                    text = stringResource(R.string.reportar_problema),
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onReportarProblemaClick() }
                        .padding(horizontal = 28.dp, vertical = 12.dp),
                    fontSize = 16.sp,
                    color = colorResource(R.color.texto),
                    textDecoration = TextDecoration.Underline
                )
            }
            item { Divisor() }
        }
    }
}

@Composable
private fun SeccionTitulo(texto: String) {
    Text(
        text = texto,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 28.dp, end = 28.dp, top = 28.dp, bottom = 12.dp),
        fontSize = 24.sp,
        fontWeight = FontWeight.Normal,
        color = colorResource(R.color.texto)
    )
}

@Composable
private fun ItemSwitch(
    titulo: String,
    subtitulo: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onCheckedChange(!checked) }
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
        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange,
            colors = SwitchDefaults.colors(
                checkedThumbColor = colorResource(R.color.blanco),
                checkedTrackColor = colorResource(R.color.azul_principal),
                checkedBorderColor = colorResource(R.color.azul_principal),
                uncheckedThumbColor = colorResource(R.color.switch_off_thumb),
                uncheckedTrackColor = colorResource(R.color.switch_off_track),
                uncheckedBorderColor = colorResource(R.color.switch_off_thumb)
            )
        )
    }
}

@Composable
private fun Item(
    titulo: String,
    subtitulo: String,
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
        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = null,
            tint = colorResource(R.color.texto)
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
private fun ConfiguracionScreenPreview() {
    MaterialTheme {
        ConfiguracionScreen()
    }
}