
import br.com.mercado.control.TelaLoginControl;

/**
 *
 * @author William
 */
public class MercadoJoana {

    public static void main(String[] args) {

//        try {
//            InterfaceJanela.MudaSwingParaPadraoDoSO();
//        } catch (Exception exception) {
//            Mensagem.erro(Texto.ERRO_INTERFACE);
//        }
        TelaLoginControl telaLogin = new TelaLoginControl();
        telaLogin.chamarTelaLoginAction();

    }

}
