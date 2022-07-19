package com.si.integrator.convert;
import java.io.IOException;
import java.io.StringReader;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.json.JSONObject;
import org.json.XML;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import com.si.integrator.assinatura.Assinatura;



public class Convert {
	
	private static String TIPO;
	private static String indUniao;
	private static String indDesoneracao;
	private static String dtTransfFinsLucr; 
	private static  Integer clasTrib;
	private static  String indEscrituracao;
	private static  String IndAcordoIsenMulta;
	private static  String iniValid;
	private static String fimValid;
	private static String cpf;  
	private static String nmCtt; 	
	private static String foneCel;  
	private static String foneFixo;
	private static String email;
	private static String cnpjEFR;
	private static String ideEFR ;
	private static String indSitPJ;
	private static String dtObito; 

	public  static String jsonToXml(String json) throws Exception {
		
		JSONObject obj = new JSONObject(json);
		
		
		
		String id = obj.getJSONObject("evtInfoContri").getString("id");
		String nrInsc = obj.getJSONObject("evtInfoContri").getJSONObject("ideContri").getString("nrInsc");
		String tpInsc = obj.getJSONObject("evtInfoContri").getJSONObject("ideContri").getString("tpInsc");
		String tpAmb = obj.getJSONObject("evtInfoContri").getJSONObject("ideEvento").getString("tpAmb");
		String procEmi = obj.getJSONObject("evtInfoContri").getJSONObject("ideEvento").getString("procEmi");
		String verProc = obj.getJSONObject("evtInfoContri").getJSONObject("ideEvento").getString("verProc");
		
		
		
		//o tipo é concatenado no corpo do xml
		if(json.contains("inclusao")) {
			 TIPO = "inclusao";
			 
				 indUniao = obj.getJSONObject("evtInfoContri").getJSONObject("infoContri").getJSONObject("inclusao").getJSONObject("infoCadastro").getString("indUniao");
				 indDesoneracao = obj.getJSONObject("evtInfoContri").getJSONObject("infoContri").getJSONObject("inclusao").getJSONObject("infoCadastro").getString("indDesoneracao");
				 dtTransfFinsLucr = obj.getJSONObject("evtInfoContri").getJSONObject("infoContri").getJSONObject("inclusao").getJSONObject("infoCadastro").getString("dtTransfFinsLucr");
				 clasTrib = obj.getJSONObject("evtInfoContri").getJSONObject("infoContri").getJSONObject("inclusao").getJSONObject("infoCadastro").getInt("clasTrib");
				 indEscrituracao = obj.getJSONObject("evtInfoContri").getJSONObject("infoContri").getJSONObject("inclusao").getJSONObject("infoCadastro").getString("indEscrituracao");
				 IndAcordoIsenMulta = obj.getJSONObject("evtInfoContri").getJSONObject("infoContri").getJSONObject("inclusao").getJSONObject("infoCadastro").getString("IndAcordoIsenMulta");
				 iniValid = obj.getJSONObject("evtInfoContri").getJSONObject("infoContri").getJSONObject("inclusao").getJSONObject("idePeriodo").getString("iniValid");
				 fimValid = obj.getJSONObject("evtInfoContri").getJSONObject("infoContri").getJSONObject("inclusao").getJSONObject("idePeriodo").getString("fimValid");
				 indSitPJ = obj.getJSONObject("evtInfoContri").getJSONObject("infoContri").getJSONObject("inclusao").getJSONObject("infoCadastro").getString("indSitPJ");
				 dtObito = obj.getJSONObject("evtInfoContri").getJSONObject("infoContri").getJSONObject("inclusao").getJSONObject("infoCadastro").getString("dtObito");
				 cpf = obj.getJSONObject("evtInfoContri").getJSONObject("infoContri").getJSONObject("inclusao").getJSONObject("infoCadastro").getJSONObject("contato").getString("cpfCtt");
				 nmCtt = obj.getJSONObject("evtInfoContri").getJSONObject("infoContri").getJSONObject("inclusao").getJSONObject("infoCadastro").getJSONObject("contato").getString("nmCtt");		
				 foneCel = obj.getJSONObject("evtInfoContri").getJSONObject("infoContri").getJSONObject("inclusao").getJSONObject("infoCadastro").getJSONObject("contato").getString("foneCel");
				 foneFixo = obj.getJSONObject("evtInfoContri").getJSONObject("infoContri").getJSONObject("inclusao").getJSONObject("infoCadastro").getJSONObject("contato").getString("foneFixo");
				 email = obj.getJSONObject("evtInfoContri").getJSONObject("infoContri").getJSONObject("inclusao").getJSONObject("infoCadastro").getJSONObject("contato").getString("email");
				 cnpjEFR = obj.getJSONObject("evtInfoContri").getJSONObject("infoContri").getJSONObject("inclusao").getJSONObject("infoCadastro").getJSONObject("infoEFR").getString("cnpjEFR");
				 ideEFR = obj.getJSONObject("evtInfoContri").getJSONObject("infoContri").getJSONObject("inclusao").getJSONObject("infoCadastro").getJSONObject("infoEFR").getString("ideEFR");
			 		 
		}	if(json.contains("alteracao")) {
			 TIPO = "alteracao";
			 
				 indUniao = obj.getJSONObject("evtInfoContri").getJSONObject("infoContri").getJSONObject("alteracao").getJSONObject("infoCadastro").getString("indUniao");
				 indDesoneracao = obj.getJSONObject("evtInfoContri").getJSONObject("infoContri").getJSONObject("alteracao").getJSONObject("infoCadastro").getString("indDesoneracao");
				 dtTransfFinsLucr = obj.getJSONObject("evtInfoContri").getJSONObject("infoContri").getJSONObject("alteracao").getJSONObject("infoCadastro").getString("dtTransfFinsLucr");
				 clasTrib = obj.getJSONObject("evtInfoContri").getJSONObject("infoContri").getJSONObject("inclusao").getJSONObject("infoCadastro").getInt("clasTrib");
				 indEscrituracao = obj.getJSONObject("evtInfoContri").getJSONObject("infoContri").getJSONObject("alteracao").getJSONObject("infoCadastro").getString("indEscrituracao");
				 IndAcordoIsenMulta = obj.getJSONObject("evtInfoContri").getJSONObject("infoContri").getJSONObject("alteracao").getJSONObject("infoCadastro").getString("IndAcordoIsenMulta");
				 iniValid = obj.getJSONObject("evtInfoContri").getJSONObject("infoContri").getJSONObject("alteracao").getJSONObject("idePeriodo").getString("iniValid");
				 fimValid = obj.getJSONObject("evtInfoContri").getJSONObject("infoContri").getJSONObject("alteracao").getJSONObject("idePeriodo").getString("fimValid");
				 indSitPJ = obj.getJSONObject("evtInfoContri").getJSONObject("infoContri").getJSONObject("alteracao").getJSONObject("infoCadastro").getString("indSitPJ");
				 dtObito = obj.getJSONObject("evtInfoContri").getJSONObject("infoContri").getJSONObject("alteracao").getJSONObject("infoCadastro").getString("dtObito");
				 cpf = obj.getJSONObject("evtInfoContri").getJSONObject("infoContri").getJSONObject("alteracao").getJSONObject("infoCadastro").getJSONObject("contato").getString("cpfCtt");
				 nmCtt = obj.getJSONObject("evtInfoContri").getJSONObject("infoContri").getJSONObject("alteracao").getJSONObject("infoCadastro").getJSONObject("contato").getString("nmCtt");		
				 foneCel = obj.getJSONObject("evtInfoContri").getJSONObject("infoContri").getJSONObject("alteracao").getJSONObject("infoCadastro").getJSONObject("contato").getString("foneCel");
				 foneFixo = obj.getJSONObject("evtInfoContri").getJSONObject("infoContri").getJSONObject("alteracao").getJSONObject("infoCadastro").getJSONObject("contato").getString("foneFixo");
				 email = obj.getJSONObject("evtInfoContri").getJSONObject("infoContri").getJSONObject("alteracao").getJSONObject("infoCadastro").getJSONObject("contato").getString("email");
				 cnpjEFR = obj.getJSONObject("evtInfoContri").getJSONObject("infoContri").getJSONObject("alteracao").getJSONObject("infoCadastro").getJSONObject("infoEFR").getString("cnpjEFR");
				 ideEFR = obj.getJSONObject("evtInfoContri").getJSONObject("infoContri").getJSONObject("alteracao").getJSONObject("infoCadastro").getJSONObject("infoEFR").getString("ideEFR"); 		  
			 
		}	if(json.contains("exclusao")) {
			 TIPO = "exclusao";	 
			 
				 indUniao = obj.getJSONObject("evtInfoContri").getJSONObject("infoContri").getJSONObject("exclusao").getJSONObject("infoCadastro").getString("indUniao");
				 indDesoneracao = obj.getJSONObject("evtInfoContri").getJSONObject("infoContri").getJSONObject("exclusao").getJSONObject("infoCadastro").getString("indDesoneracao");
				 dtTransfFinsLucr = obj.getJSONObject("evtInfoContri").getJSONObject("infoContri").getJSONObject("exclusao").getJSONObject("infoCadastro").getString("dtTransfFinsLucr");
				 clasTrib = obj.getJSONObject("evtInfoContri").getJSONObject("infoContri").getJSONObject("exclusao").getJSONObject("infoCadastro").getInt("clasTrib");
				 indEscrituracao = obj.getJSONObject("evtInfoContri").getJSONObject("infoContri").getJSONObject("exclusao").getJSONObject("infoCadastro").getString("indEscrituracao");
				 IndAcordoIsenMulta = obj.getJSONObject("evtInfoContri").getJSONObject("infoContri").getJSONObject("exclusao").getJSONObject("infoCadastro").getString("IndAcordoIsenMulta");
				 iniValid = obj.getJSONObject("evtInfoContri").getJSONObject("infoContri").getJSONObject("exclusao").getJSONObject("idePeriodo").getString("iniValid");
				 fimValid = obj.getJSONObject("evtInfoContri").getJSONObject("infoContri").getJSONObject("exclusao").getJSONObject("idePeriodo").getString("fimValid");
				 indSitPJ = obj.getJSONObject("evtInfoContri").getJSONObject("infoContri").getJSONObject("exclusao").getJSONObject("infoCadastro").getString("indSitPJ");
				 dtObito = obj.getJSONObject("evtInfoContri").getJSONObject("infoContri").getJSONObject("exclusao").getJSONObject("infoCadastro").getString("dtObito");
				 cpf = obj.getJSONObject("evtInfoContri").getJSONObject("infoContri").getJSONObject("exclusao").getJSONObject("infoCadastro").getJSONObject("contato").getString("cpfCtt");
				 nmCtt = obj.getJSONObject("evtInfoContri").getJSONObject("infoContri").getJSONObject("exclusao").getJSONObject("infoCadastro").getJSONObject("contato").getString("nmCtt");		
				 foneCel = obj.getJSONObject("evtInfoContri").getJSONObject("infoContri").getJSONObject("exclusao").getJSONObject("infoCadastro").getJSONObject("contato").getString("foneCel");
				 foneFixo = obj.getJSONObject("evtInfoContri").getJSONObject("infoContri").getJSONObject("exclusao").getJSONObject("infoCadastro").getJSONObject("contato").getString("foneFixo");
				 email = obj.getJSONObject("evtInfoContri").getJSONObject("infoContri").getJSONObject("exclusao").getJSONObject("infoCadastro").getJSONObject("contato").getString("email");
				 cnpjEFR = obj.getJSONObject("evtInfoContri").getJSONObject("infoContri").getJSONObject("exclusao").getJSONObject("infoCadastro").getJSONObject("infoEFR").getString("cnpjEFR");
				 ideEFR = obj.getJSONObject("evtInfoContri").getJSONObject("infoContri").getJSONObject("exclusao").getJSONObject("infoCadastro").getJSONObject("infoEFR").getString("ideEFR"); 
			 	 			 
		}


	
		String xml_concat = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
				+ "			<Reinf xmlns=\"http://www.reinf.esocial.gov.br/schemas/evtInfoContribuinte/v1_05_01\" >\r\n"
				+ "				<evtInfoContri id= \""+id+"\" >\r\n"
				+ "					<infoContri>\r\n"
				+ "						<"+TIPO+">\r\n"
				+ "							<idePeriodo>\r\n"
				+ "								<fimValid>"+fimValid+"</fimValid>\r\n"
				+ "								<iniValid>"+iniValid+"</iniValid>\r\n"
				+ "							</idePeriodo>\r\n"
				+ "							<infoCadastro>\r\n"
				+ "								<indUniao>"+indUniao+"</indUniao>\r\n"
				+ "								<indDesoneracao>"+indDesoneracao+"</indDesoneracao>\r\n"
				+ "								<dtTransfFinsLucr>"+dtTransfFinsLucr+"</dtTransfFinsLucr>\r\n"
				+ "								<clasTrib>"+clasTrib+"</clasTrib>\r\n"
				+ "								<indEscrituracao>"+indEscrituracao+"</indEscrituracao>\r\n"
				+ "								<IndAcordoIsenMulta>"+IndAcordoIsenMulta+"</IndAcordoIsenMulta>\r\n"
				+ "								<infoEFR>\r\n"
				+ "									<cnpjEFR>"+cnpjEFR+"</cnpjEFR>\r\n"
				+ "									<ideEFR>"+ideEFR+"</ideEFR>\r\n"
				+ "								</infoEFR>\r\n"
				+ "								<indSitPJ>"+indSitPJ+"</indSitPJ>\r\n"
				+ "								<dtObito>"+dtObito+"</dtObito>\r\n"
				+ "								<contato>\r\n"
				+ "									<cpfCtt>"+cpf+"</cpfCtt>\r\n"
				+ "									<nmCtt>"+nmCtt+"</nmCtt>\r\n"
				+ "									<foneCel>"+foneCel+"</foneCel>\r\n"
				+ "									<foneFixo>"+foneFixo+"</foneFixo>\r\n"
				+ "									<email>"+email+"</email>\r\n"
				+ "								</contato>\r\n"
				+ "							</infoCadastro>\r\n"
				+ "						</"+TIPO+">\r\n"
				+ "					</infoContri>\r\n"
				+ "					<ideContri>\r\n"
				+ "						<nrInsc>"+nrInsc+"</nrInsc>\r\n"
				+ "						<tpInsc>"+tpInsc+"</tpInsc>\r\n"
				+ "					</ideContri>\r\n"
				+ "					<ideEvento>\r\n"
				+ "			           <tpAmb>"+tpAmb+"</tpAmb>\r\n"
				+ "						<procEmi>"+procEmi+"</procEmi>\r\n"
				+ "						<verProc>"+verProc+"</verProc>\r\n"
				+ "					</ideEvento>\r\n"
				+ "				</evtInfoContri>\r\n"
				+ "			</Reinf>";
		System.out.println(xml_concat);
        String caminhoDoCertificadoDoCliente = "*****.pfx";
        String senhaDoCertificado = "****";
       

    
			String resultado = Assinatura.assinarDocumento(caminhoDoCertificadoDoCliente,senhaDoCertificado,xml_concat,id);
			System.out.println(resultado);

		

		return resultado;

        	
	}
	 
	private static Document convertStringToXMLDocument(String xmlString) 
	  {
	    //Parser that produces DOM object trees from XML content
	    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	     
	    //API to obtain DOM Document instance
	    DocumentBuilder builder = null;
	    try
	    {
	      //Create DocumentBuilder with default configuration
	      builder = factory.newDocumentBuilder();
	       
	      //Parse the content to Document object
	      Document doc = builder.parse(new InputSource(new StringReader(xmlString)));
	      return doc;
	    } 
	    catch (Exception e) 
	    {
	      e.printStackTrace();
	    }
	    return null;
	  }
	
	

}
