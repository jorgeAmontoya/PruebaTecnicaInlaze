Feature: Salida de un usuario de la pagina Beta testin

  Como cliente que esta en el home de la pagina Beta Testin
  quiero cerrar sesion
  para poder salir de la pagina Beta Testin

  Scenario: Cierre de sesion exitoso de un usuario
    Given que el usuario se encuentra en el home de la pagina beta Testin
    When el usuario cierra sesion
    Then sera redireccionado a la pagina del Login