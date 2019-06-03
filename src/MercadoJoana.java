
import br.com.mercado.control.TelaLoginControl;
import br.com.mercado.model.Categoria;
import br.com.mercado.uteis.InterfaceJanela;
import br.com.mercado.uteis.Mensagem;
import br.com.mercado.uteis.Texto;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 *
 * @author William
 */
public class MercadoJoana {

    public static void main(String[] args) {

        try {
            InterfaceJanela.MudaSwingParaPadraoDoSO();
        } catch (Exception exception) {
            Mensagem.erro(Texto.ERRO_INTERFACE);
        }
        TelaLoginControl telaLogin = new TelaLoginControl();
        telaLogin.chamarTelaLoginAction();

    }

}
