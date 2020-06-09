package consomi.interfaces;

import javax.ejb.Local;

import consomi.entities.Liv;

@Local
public interface LivServiceLocal {
	public Liv[] All();
	public void Delete(int id);
	public void Add(Liv L,String m);
}
