# Overview

Este es un proyecto de prueba para mostrar habilidades de programación.

Esta construido con arquitectura MVVM y usa los siguientes componentes.

- Retrofit para los servicios de red (API REST)
- Android Jetpack de los cuales se usan LiveData, ViewModel
- Glide para carga de imagenes desde red de manera facil


## ¿Como ejecutarlo?

Despues de clonado se debe crear un archivo `config.properties` en la carpeta raiz del proyecto, este no esta versionado por que su proposito es separar las url y secretos que usa la app del codigo fuente.

Existe un archivo de ejemplo llamado `config.properties.sample`
que tiene la base para crear ese archivo

para este ejemplo la url basica es https://dir_url_api.com/sites/ y el site-id es "MLA"

Para este ejemplo la url de principal que tiene la forma 

`https://mi-direccion-endpoint/sites/<site_id>/.../`
el campo `apiUrl` corresponde a la direccion antes del `site_id` y este ultimo corresponde a la otra variable con el mismo nombre


## Miscelaneo
- Existe otro proyecto creado con los mismos propositos que tiene un desarrollo un poco mas extenso sin usar algunos componentes que ahorran codigo: https://github.com/rpenates/ImgurLab

