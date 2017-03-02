package es.ucm.abd.practica2.dao;

import es.ucm.abd.practica2.model.Abedemon;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;

import org.w3c.dom.Element;

/**
 * Implementación concreta del DAO que hace llamadas a eXist.
 * 
 * @author Manuel Montenegro (mmontene@ucm.es)
 */
public class AbedemonDAOImpl implements AbedemonDAO {

	private final XQDataSource ds;

	public AbedemonDAOImpl(XQDataSource ds) {
		this.ds = ds;
	}

	/**
	 * Obtiene los tipos de especies disponibles en la BD.
	 * 
	 * @return Lista de tipos de especies (sin duplicados)
	 * @throws XQException
	 */
	@Override
	public List<String> getTypes() {
		// DONE: Implementar
		InputStream is = getClass().getResourceAsStream("Abedemon1.xquery");
		XQConnection con;
		try {
			con = ds.getConnection();
			XQPreparedExpression exp = con.prepareExpression(is);
			XQResultSequence rs = exp.executeQuery();
			List<String> types = new ArrayList<String>();
			while (rs.next()) {
				types.add(rs.getItemAsString(null));
			}
			rs.close();
			con.close();
			exp.close();
			return types;
		} catch (XQException e) {
			System.err.println("Error obteniendo tipos");
			return null;
		}finally{
			
		}
	}

	/**
	 * Obtiene las especies de abedemon de un determinado.
	 * 
	 * @param type
	 *            Tipo a buscar
	 * @return Especies encontradas del tipo pasado como parámetro.
	 */
	@Override
	public List<Abedemon> getAbedemonsOf(String type) {
		// DONE: Implementar
		InputStream is = getClass().getResourceAsStream("Abedemon2.xquery");
		XQConnection con;
		try {
			con = ds.getConnection();
			XQPreparedExpression exp = con.prepareExpression(is);
			exp.bindString(new QName("tipo"), type, null);
			XQResultSequence rs = exp.executeQuery();
			List<Abedemon> abedemons = new ArrayList<Abedemon>();
			
			while (rs.next()){
				Element el = (Element)rs.getNode();
				Abedemon abd = new Abedemon(el.getAttribute("id"), el.getAttribute("nombre"), Integer.parseInt(el.getAttribute("num-ataques")));
				abedemons.add(abd);
			}
			rs.close();
			con.close();
			exp.close();
			return abedemons;
		} catch (XQException e) {
			System.err.println("Error obteniendo abedemons por tipo");
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Obtiene la descripción de una especie de abedemon.
	 * 
	 * @param id
	 *            ID de la especie a describir
	 * @return Código XHTML con la descripción de la especie
	 */
	@Override
	public String getAbedemonDescription(String id) {
		//DONE: Implementar
		InputStream is = getClass().getResourceAsStream("Abedemon3.xquery");
		XQConnection con;
		
		try {
			con = ds.getConnection();
			XQPreparedExpression exp = con.prepareExpression(is);
			exp.bindString(new QName("id"), id, null);
			XQResultSequence rs = exp.executeQuery();
			if (rs != null)
				rs.next();
			String abedemon = rs.getItemAsString(null);
			
			rs.close();
			con.close();
			exp.close();
			return abedemon;
		} catch (XQException e) {
			System.err.println("Error obteniendo la descripción");
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Obtiene el daño máximo recibido por un abedemon de una especie dada al
	 * ser atacado por otro.
	 * 
	 * @param idAttacker
	 *            ID de la especie del atacante.
	 * @param idReceiver
	 *            ID de la especie que recibe el daño.
	 * @return Máximo daño que puede infligir el atacante.
	 */
	@Override
	public Integer getDamage(String idAttacker, String idReceiver) {
		// TODO: Implementar (parte opcional)
		InputStream is = getClass().getResourceAsStream("Abedemon4.xquery");
		XQConnection con;
		
		try {
			con = ds.getConnection();
			XQPreparedExpression exp = con.prepareExpression(is);
			exp.bindString(new QName("yoId"), idAttacker, null);
			exp.bindString(new QName("adversarioId"), idReceiver, null);
			XQResultSequence rs = exp.executeQuery();
			String damage = "";
			
			if(rs.next())
				damage = rs.getItemAsString(null);
			else 
				return 0;
			
			rs.close();
			con.close();
			exp.close();
			return Integer.parseInt(damage);
		} catch (XQException e) {
			System.err.println("Error obteniendo la descripción");
			e.printStackTrace();
			return null;
		}
	}
}
