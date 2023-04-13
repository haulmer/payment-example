
# Aplicación de ejemplo para transaccionar
Aplicación de ejemplo que realiza una transacción de pago utilizando la aplicación de Pagos.
Solo se puede ejecutar en **terminales SUNMI** de pagos.

Para ver con mayor detalle la integración, visitar [developers.tuu.cl](https://developers.tuu.cl/docs/intent-inter-app)

## Requisitos.
- Instalar **"Integration payment"** desde la tienda SUNMI.
  Si no aparece esta aplicación, se debe solicitar desde el chat de la comunidad adjuntando el **SERIAL NUMBER** del dispositivo.

## Tecnologías utilizadas

-   Kotlin
-   Android Studio
-   Gradle

## Instalación

1.  Clonar el repositorio: `https://github.com/haulmer/payment-example.git`
2.  Abrir el proyecto en Android Studio.

## Consideraciones
- La llamada para abrir el intent de pagos, se encuentra en la clase `FirstFragment.kt`
- El control del Intent es realizado en la clase `PaymentConnection.kt`

## Contacto

[Slack de la comunidad ](https://join.slack.com/t/haulmer/shared_invite/zt-1t6sb8ew4-y~Ndd4gkEaJOldqd9tHlvA)