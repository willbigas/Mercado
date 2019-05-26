
import br.com.mercadodonajoana.control.TelaLoginControl;
import br.com.mercadodonajoana.uteis.InterfaceJanela;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author William
 */
public class MercadoJoana {
    
    public static void main(String[] args) {
        try {
            InterfaceJanela.MudaSwingParaPadraoDoSO();
        } catch (Exception exception) {
            System.out.println("Erro na mudança de interface do sistema!" + exception.getMessage());
        }
        TelaLoginControl telaLogin = new TelaLoginControl();
        telaLogin.chamarTelaLoginAction();
//      
    }
    
}
