
package Model;

import View.Livro;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
@LocalBean
public class LivroEJB {

    
    @PersistenceContext(name="BibliotecaPU")
    EntityManager em;
    
      
    public void salvar(Livro livro) {
       em.merge(livro);
       System.out.println("Salvei o Livro!");
    }
    
}
