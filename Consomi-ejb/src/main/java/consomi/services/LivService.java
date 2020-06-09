package consomi.services;

import java.io.InputStream;
import java.io.Reader;

import java.util.concurrent.TimeUnit;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import consomi.interfaces.*;
import com.jayway.jsonpath.JsonPath;

import consomi.entities.Liv;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import org.json.simple.parser.JSONParser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.google.gson.Gson;







/**
 * Session Bean implementation class UserService
 */
@Stateless
@LocalBean
public class LivService implements LivServiceRemote, LivServiceLocal {

	
	
	/**
     * Default constructor. 
     */
    public LivService() {
        
    }

	@Override
	public Liv[] All() {
    	Client client = ClientBuilder.newClient();
    		
    	WebTarget web = client.target("http://localhost:6587/Liv"); 
    	
    	WebTarget user = web.path("");
    	
    	Response response = user.request().get();
    	
    	String result = response.readEntity(String.class); 
   	
  

    	Gson gson = new Gson();  
    	Liv[] L = gson.fromJson(result, Liv[].class);
    	
          
    	 System.out.println("z"+L[1].getMail());

		
    	 /*try {
    		    Thread.sleep(50000000);
    		} catch (InterruptedException ie) {
    		    // ...
    		}*/

    	response.close(); 

    	return L;    	
	
	}
	
	@Override
	public void Delete(int id)
	{
		Client client = ClientBuilder.newClient();
		WebTarget web = client.target("http://localhost:6587/Livraison/D/"+ id); 
    	
    	WebTarget user = web.path("");
    	
    	Response response = user.request().get();
    	
    	String result = response.readEntity(String.class); 
    	System.out.println(id);
	}
	
	@Override
	public void Add(Liv L,String m)
	{
		Client client = ClientBuilder.newClient();
		WebTarget web = client.target("http://localhost:6587/livraison/r?e=" + L.getMail() +"&a=" + L.getadresse() + "&m="+ m); 
    	
    	WebTarget user = web.path("");
    	
    	Response response = user.request().get();
    	
    	String result = response.readEntity(String.class); 
	}
	
	

}
