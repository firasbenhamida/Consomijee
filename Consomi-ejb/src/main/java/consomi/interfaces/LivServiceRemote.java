package consomi.interfaces;

import javax.ejb.Remote;

import consomi.entities.Liv;

@Remote
public interface LivServiceRemote {
	public Liv[] All();
	public void Delete(int id);
	public void Add(Liv L,String m);
}
