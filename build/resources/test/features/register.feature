Feature: Registro de un usuario en el sistema

  Como nuevo usuario del sistema
  quiero registrarme a la pagina
  para visualizar los servicios que ofrece la pagina

  Scenario: 01 - Registro exitoso de un usuario
    Given que el usuario ingresa al formulario de la pagina Beta Testin
    When se registra correctamente en la pagina
    Then se recibira un mensaje indicando que el usuario fue creado exitosamente

  Scenario Outline: 02 - Registro no exitoso de un cliente
    Given que el usuario ingresa al formulario de la pagina Beta Testin
    When diligencia los campos del formulario con la contraseña "<incorrecta>"
    Then  recibe un mensaje indicando que la contrasena debe contener al menos seis caracteres
    Then no se registrara el cliente a la tienda
  Examples:
  |tipo error                 |
  |minimo_8_caracteres        |
  |confirmacion de contraseña |

    #longitud minima de 8 caracteres
    #-- debe tener una mayuscula, una minuscula, un numero y un caracter especial
  #confirmacion de contraseña
