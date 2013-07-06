package Controler;

import Model.LivroEJB;
import View.Livro;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


   
@ManagedBean
@RequestScoped
public class LivroMB {
    
   @PersistenceContext
   EntityManager em;
         
   @EJB
   LivroEJB livroEJB;
   
   public Livro livro = new Livro();
   public List<Livro> livros = new ArrayList<Livro>();

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }
    
   public List<Livro> findAllLivros() {

        javax.persistence.Query query = em.createQuery("select l from Livro l");
        return query.getResultList();
    }
   public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
    
     public void salvarLivro() {
       System.out.println("Entrei!"); 
       livroEJB.salvar(livro);
       livro = new Livro(); 
       livros = findAllLivros();
       setLivro(new Livro());
       
    }
    public void apaga(Livro livro) {

        System.out.println("Vou apagar o usuario " + livro.getTitulo() + " id=" + livro.getAutor());
        em.getTransaction().begin();
        em.remove(livro);
        em.getTransaction().commit();
    }
    public void editar(Livro livro){
        this.livro = livro;
    }
   public LivroMB() {
    }
   
}
