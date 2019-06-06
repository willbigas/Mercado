package br.com.mercado.uteis;

import br.com.mercado.factory.Conexao;
import java.io.InputStream;
import java.sql.Connection;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Will
 */
public class Relatorio {

    private static Connection con = Conexao.getConexao();

    public static void chamarRelatorio(String enderecoArq) {
        JasperPrint jasperPrint = null;
        try {
            jasperPrint = JasperFillManager.fillReport(enderecoArq, null, con);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatório /n " + e);
            
        }
        JasperViewer.viewReport(jasperPrint , false); // false para não fechar a aplicação quando fechar o relatório.
        
    }
    
     public static void chamarRelatorio(InputStream enderecoArq) {
        JasperPrint jasperPrint = null;
        try {
            jasperPrint = JasperFillManager.fillReport(enderecoArq, null, con);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatório /n " + e);
            
        }
        JasperViewer.viewReport(jasperPrint , false); // false para não fechar a aplicação quando fechar o relatório.
        
    }
}
