Feature: Ingresar a la pagina de la tienda demo web shop

  como cliente registrado de la tienda demo web shop
  quiero ingresar a la pagina de la tienda
  para realizar compras.

  Scenario: Ingreso exitoso a la pagina de la tienda
    Given que ingreso a la pagina de Log in como un cliente registrado
    When diligencio los campos Email y password de un cliente registrado
    And doy clic en el boton Log in
    Then recibo un mensaje de bienvenida a la pagina de la tienda

  Scenario: ingreso fallido a la pagina de la tienda demo web shop
    Given que ingreso a la pagina de Log in como un cliente registrado
    When diligencio los campos Email y password del formulario con una contrasena incorrecta
    And doy clic en el boton Log in
    Then recibo un mensaje indicando que las credenciales son incorrectas
    Then no puedo ingresar a la pagina de la tienda