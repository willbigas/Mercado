
import br.com.mercadodonajoana.dao.CategoriaDao;
import br.com.mercadodonajoana.dao.ProdutoDao;
import br.com.mercadodonajoana.model.Categoria;


/**
 *
 * @author William
 */
public class TestandoPersistenciaBanco {
    
    public static void main(String[] args) {
        ProdutoDao produtoDao = new ProdutoDao();
        CategoriaDao categoriaDao = new CategoriaDao();
        
        Categoria c = new Categoria();
        c.setId(1);
        c.setNome("Teste");
        
       categoriaDao.deletar(2);
        
//        Fornecedor f = new Fornecedor();
//        f.setId(1);
//        f.setNome("Beauty Color");
//        f.setTelefone("30337442");
//        f.setEndereco("Rua Dália");
//        
//        Produto p = new Produto();
//       p.setId(1);
//       p.setNome("Esmalte Colorama 5.5");
//       p.setCodBarras(15151515);
//       p.setQuantidade(15);
//       p.setValor(25.5);
//       p.setCategoria(c);
//       p.setFornecedor(f);
//       produtoDao.inserir(p);
       
       
    }
}
