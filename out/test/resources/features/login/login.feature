Feature: Ingreso de un usuario a la pagina Beta testin

  Como cliente registrado de la pagina Beta Testin
  quiero ingresar a la pagina
  para visualizar su contenido

  Scenario: Ingreso exitoso de un usuario
    Given que el usuario se encuentra registrado en la pagina Beta Testin
    When inicia secion de manera correcta
    Then se visualizara en la pagina el nombre del usuario

  Scenario Outline: ingreso fallido a la pagina por no diligenciar algun campo obligatorio
    Given que el usuario se encuentra registrado en la pagina Beta Testin
    When diligencia los campos del formulario de loguin sin especificar "<campoObligatorio>"
    Then recibo un mensaje indicando el campo obligatorio que esta sin diligenciar
    Examples:
      |campoObligatorio        |
      |      usuario           |
      |      contrasena        |
      |   usuarioYContrasena   |


  Scenario Outline: ingreso fallido a la pagina por usuario o contrasena incorrecta
    Given que el usuario se encuentra registrado en la pagina Beta Testin
    When diligencia los campos del formulario de loguin de forma incorrecta "<equivocacion>"
    Then recibo un mensaje indicando el campo esta iniciando seccion de manera incorrecta
    Examples:
      |   equivocacion         |
      |      usuario           |
      |      contrasena        |

