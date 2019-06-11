package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
@Path("/banque")
public class BanqueRest {
	private static Map<Integer,Account> accounts=new HashMap<>();
	@GET
	@Path("/conversion/{montant}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public double conversion(@PathParam(value="montant") double mt) {
		return mt*mt;
	}
	@GET
	@Path("/comptes/{code}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Account getAccount(@PathParam(value="code") int code) {
		return accounts.get(code);
	}
	@GET
	@Path("/comptes")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Account> listAccount(){
		
		return new ArrayList<>(accounts.values());
	}
	@POST
	@Path("/comptes")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Account save(Account cp) {
		cp.setDateCreation(new Date());
		accounts.put(cp.getCode(),cp);
		return cp;
	}
	@PUT
	@Path("/comptes/{code}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Account update(Account cp,@PathParam("code") int code) {
		accounts.put(code,cp);
		return cp;
	}
	@DELETE
	@Path("/comptes/{code}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public boolean delete(@PathParam("code") int code) {
		accounts.remove(code);
		return true;
	}
}
