package ex1;

import java.util.Set;

public class Mensagem {
    String emailRemetente;
    Set<String> lst_destinatarios;
    String assunto;
    String texto;

    public Mensagem(String emailRemetente, Set<String> lst_destinatarios, String assunto, String texto) {
        this.emailRemetente = emailRemetente;
        this.lst_destinatarios = lst_destinatarios;
        this.assunto = assunto;
        this.texto = texto;
    }

    public String getEmailRemetente() {
        return emailRemetente;
    }

    public Set<String> getLst_destinatarios() {
        return lst_destinatarios;
    }
}
