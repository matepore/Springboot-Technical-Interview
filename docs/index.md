# Bienvenido a la Documentación de Mi Proyecto

¡Hola! 👋 Bienvenido a la documentación oficial de **Mi Proyecto**.

Esta documentación está organizada para que puedas entender rápidamente la estructura, configuración y uso del proyecto.

---

## Contenido

- [Guía de Introducción](guia/introduccion.md)
- [Guía de Instalación](guia/instalacion.md)
- [API y Configuración](#configuracion)

---

## Configuración

Para configurar el proyecto, asegúrate de tener los siguientes servicios corriendo:

- PostgreSQL en `localhost:5432`
- Redis en `localhost:6379`

Si estás usando Docker Compose, ya vienen preconfigurados en los servicios `postgres` y `redis`.

---

## Imagen de Ejemplo

Si quieres incluir imágenes dentro de tu documentación:

![Logo de ejemplo](assets/logo.png)

> Asegúrate de colocar las imágenes dentro de la carpeta `docs/assets/`.

---

## Comenzar a Usar

Para levantar el servidor de documentación:

```bash
docker-compose up mkdocs
