/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bouncing.logic;

/**
 *
 * @author steve
 */
public class Usuario {

    public Usuario() {
    }

    public Usuario(String id, String pass, Funcionario usuario) {
        this.id = id;
        this.pass = pass;
        this.funcionario = usuario;
    }

    public String getId() {
        return id;
    }

    public String getPass() {
        return pass;
    }

    public Funcionario getUsuario() {
        return funcionario;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setUsuario(Funcionario usuario) {
        this.funcionario = usuario;
    }

    @Override
    public String toString() {
        StringBuilder r = new StringBuilder();
        r.append("Id: ").append(id);
        r.append("Pass: ").append(pass);
        r.append("Usuario: ").append(funcionario.getNombre());
        return r.toString();
    }

    String id;
    String pass;
    Funcionario funcionario;
}
