package consomi;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import consomi.entities.Liv;
import consomi.interfaces.*;



@ManagedBean(name="LivBean")
@SessionScoped
public class LivBean implements Serializable {

	
	private String[] S ;
	public String e;
	public String m;
	public String s;
	private int[] I ;
	private Liv l;
	
	@EJB
	LivServiceLocal LivService;
	
	
	public LivBean() {
	S =  new String[10] ;
	l = new Liv();	
	}

	/**
	 * 
	 */
	public String gete() {
		return e;
	}
	
	public void sete(String e) {
		this.e = e;
	}
	public String getm() {
		return m;
	}
	
	public void setm(String m) {
		this.m = m;
	}
	public String gets() {
		return s;
	}
	
	public void sets(String s) {
		this.s = s;
	}

	public void test() {
		
	Liv[] L=LivService.All();
	System.out.println(L[1].getMail()+s);
	}
	
	public Liv[] Stat() {
	
		Liv[] L= LivService.All();
		return L;
	}
	
	public String stat() {
		
		String L= LivService.All()[1].getadresse();
		 System.out.println(L);
		return L;
	}
	
	public Liv[] GetL() 
	{
	Liv[] L= LivService.All();
	 System.out.println(L);
		
	 
	 for (int i = 0; i < L.length; i++) {
		    S[i]=L[i].getMail();
		    
	 }
	 System.out.println(S[0]+S[1]);
	 
	 for(int i = 0; i < L.length; i++)        // on va jusqu'a taille du tableau - 1 (3)
	 {
		 for(int j = i+1; j < L.length-1; j++)    // car tab[3 + 1] = tab[4] n'est pas défini !
		 {
	            if(L[j].getactivite() >L[i].getactivite() )
	            { 
	            	l = L[i];
	            
	            L[i]=L[j];
	            L[j]=l;
	            System.out.println(l );
	            System.out.println(L[i]);
	            System.out.println(L[j]);
	            }
	            
		 }
	 }
	 
	 
		return L;
	}

	
	public String D(int id)
	{
		String navigateTo = "null";
		LivService.Delete(id);
		System.out.println(id);
		navigateTo = "/template/Liv/Livreur?faces-redirect=true"; 
		return navigateTo;
	}
	
	public String A()
	{
		String navigateTo = "null";
	    l.setadresse(s);
	    l.setMail(e);
		LivService.Add(l,m);
		System.out.println("added");
		navigateTo = "/template/Liv/Livreur?faces-redirect=true"; 
		return navigateTo;
	}
	
	
	

}
