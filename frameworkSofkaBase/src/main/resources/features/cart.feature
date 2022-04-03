# language: es

@FeatureName:comprarProductos
Característica: Comprar productos por medio del sitio web
  Yo como usuario de Your Logo
  Quiero realizar la compra
  Para adquirir los productos de la tienda

  @ScenarioName:realizarCompra
  Escenario: Realizar compras
    Dado que estoy logueado en el sitio web de la tienda
    Cuando realizo el proceso de compra
    Entonces se mostrará mensaje de confirmacion

  @ScenarioName:comprarSinAceptarTerminos
  Escenario: Realizar comprar sin aceptar terminos
    Dado que procedo a realizar el pago de los productos seleccionados
    Cuando no acepto los terminos y condiciones
    Entonces se mostrará el mensaje de notificación