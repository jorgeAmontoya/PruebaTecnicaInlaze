package Models;


/**
 * Clase que contiene el modelo especificando los datos necesarios que se requieren
 * para crear un usuario
 */
public class UsersModels {
    private String nombre;
    private String email;
    private String contrasena;
    private String confirmarContrasena;

    public String getName() {
        return nombre;
    }

    public void setName(String name) {
        this.nombre = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return contrasena;
    }

    public void setPassword(String password) {
        this.contrasena = password;
    }

    public String getConfirmPassword() {
        return confirmarContrasena;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmarContrasena = confirmPassword;
    }
}
