package Controler;

import Model.EmprestimoEJB;
import View.Emprestimo;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ManagedBean
@RequestScoped
public class EmprestimoMB {

    
    @PersistenceContext
    EntityManager em;
    
    @EJB
    EmprestimoEJB emprestimoEJB;
    
    public Emprestimo emprestimo = new Emprestimo();

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }
    
    public EmprestimoMB() {
    }
    
    public void salvar() {
       System.out.println("Entrei!"); 
       emprestimoEJB.salvar(emprestimo);
    }
}
