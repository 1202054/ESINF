package ex1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Servidor {
    List<Mensagem> caixaIn;
    List<Mensagem> caixaOut;

    public Servidor(List<Mensagem> caixaIn, List<Mensagem> caixaOut) {
        this.caixaIn = caixaIn;
        this.caixaOut = caixaOut;
    }

    public List<Mensagem> getCaixaIn() {
        return caixaIn;
    }

    public List<Mensagem> getCaixaOut() {
        return caixaOut;
    }

    public Map<String, Map<String, Integer>> numberMessagesSent(){
        Map<String, Map<String, Integer>> numberMessages = new HashMap<>();

        for (Mensagem mensagem : getCaixaOut()) {
            String remetente = mensagem.emailRemetente;
            for (String lista: mensagem.getLst_destinatarios()) {
                if (!numberMessages.containsKey(remetente)){
                    numberMessages.put(remetente,new HashMap<>());
                    numberMessages.get(remetente).put(lista,1);
                }else{
                    if (!numberMessages.get(remetente).containsKey(lista)){
                        numberMessages.get(remetente).put(lista,1);
                    }else {
                        Integer quantidade = numberMessages.get(remetente).get(lista);
                        numberMessages.get(remetente).put(lista, quantidade + 1);
                    }
                }
            }
        }
        return numberMessages;
    }
}
