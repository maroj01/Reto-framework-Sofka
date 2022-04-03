# language: es

@FeatureName:solicitarInformacion
Característica: Solicitar información por medio del sitio web
  Yo como usuario de Your Logo
  Quiero asesoria
  Para adquirir los productos del sitio web

  @ScenarioName:consultarConSoporte
  Escenario: Realizar consulta adjuntando soporte de pago
    Dado que deseo obtener informacion de un producto comprado
    Cuando me contacto ingresando toda la informacion solicitada
    Entonces se mostrará mensaje de confirmación de envío

  @ScenarioName:consultarIncompletaLaInformacion
  Escenario: Realizar consulta con la información incompleta
    Dado que requiero solicitar atencion de servicio al cliente
    Cuando hago la solicitud sin escribir mensaje
    Entonces se mostrará el mensaje de advertencia