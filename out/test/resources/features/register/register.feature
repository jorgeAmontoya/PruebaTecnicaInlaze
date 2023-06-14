Feature: Registro de un usuario en la pagina beta testin

  Como nuevo usuario del sistema
  quiero registrarme a la pagina
  para visualizar los servicios que ofrece la pagina

  Scenario: 01 - Registro exitoso de un usuario
    Given que el usuario ingresa al formulario de la pagina Beta Testin
    When se registra correctamente en la pagina
    Then se recibira un mensaje indicando que el usuario fue creado exitosamente

  Scenario Outline: 02 - Registro no exitoso de un cliente por contrasena
    Given que el usuario ingresa al formulario de la pagina Beta Testin
    When diligencia los campos del formulario con la contraseña "<incorrecta>"
    Then  recibe un mensaje indicando que la contrasena es incorrecta
    And no se registrara el usario en la pagina
  Examples:
  |incorrecta               |
  |minimo_8_caracteres        |
  |confirmaciondecontrasena |


  Scenario Outline: 03 - Registro no exitoso de un cliente por no diligenciar todos los campos obligatorios
    Given que el usuario ingresa al formulario de la pagina Beta Testin
    When diligencia los campos del formulario sin especificar "<campoObligatorio>"
    Then recibira un mensaje indicando que campo obligatorio falta por diligenciar
    And no se registrara el usario en la pagina

    Examples:
    |campoObligatorio        |
    |      nombre            |
    |       Email            |
    |      contrasena        |
    |confirmacionDeContrasena|