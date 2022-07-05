package convert;

import java.io.FileNotFoundException;

import org.json.JSONObject;
import org.json.XML;

public class JsonToXml {

	public static void main(String... s) throws FileNotFoundException {

		String json_data = "{\r\n"
				+ "  \"_id\": {\r\n"
				+ "    \"$oid\": \"629e652a376b320677695558\"\r\n"
				+ "  },\r\n"
				+ "  \"evtInfoContri\": {\r\n"
				+ "    \"id\": \"************************************\",\r\n"
				+ "    \"ideEvento\": {\r\n"
				+ "      \"tpAmb\": \"*\",\r\n"
				+ "      \"procEmi\": \"*\",\r\n"
				+ "      \"verProc\": \"********************\"   \r\n"
				+ "    },\r\n"
				+ "    \"ideContri\": {\r\n"
				+ "        \"tpInsc\": \"*\",\r\n"
				+ "        \"nrInsc\": \"**************\"\r\n"
				+ "    },\r\n"
				+ "    \"infoContri\": {\r\n"
				+ "        \"inclusao\": {\r\n"
				+ "            \"idePeriodo\": {\r\n"
				+ "                \"iniValid\": \"*******\",\r\n"
				+ "                \"fimValid\": \"*******\"\r\n"
				+ "            },\r\n"
				+ "            \"infoCadastro\": {\r\n"
				+ "                \"clasTrib\": \"**\",\r\n"
				+ "                \"indEscrituracao\": \"*\",\r\n"
				+ "                \"indDesoneracao\": \"*\",\r\n"
				+ "                \"indAcordoSemMulta\": \"*\",\r\n"
				+ "                \"indSitPJ\": \"*\",\r\n"
				+ "                \"indUniao\": \"*\",\r\n"
				+ "                \"dtTransfFinsLucr\": \"?\",\r\n"
				+ "                \"dtObito\": \"?\",\r\n"
				+ "                \"contato\": {\r\n"
				+ "                    \"nmCtt\": \"**********************************************************************\",\r\n"
				+ "                    \"cpfCtt\": \"***********\",\r\n"
				+ "                    \"foneFixo\": \"*************\",\r\n"
				+ "                    \"foneCel\": \"*************\",\r\n"
				+ "                    \"email\": \"************************************************************\"\r\n"
				+ "                },\r\n"
				+ "                \"softHouse\": [\r\n"
				+ "                    \"629e6bd8376b320677695561\"\r\n"
				+ "                ],\r\n"
				+ "                \"infoEFR\": {\r\n"
				+ "                    \"ideEFR\": \"*\",\r\n"
				+ "                    \"cnpjEFR\": \"**************\"\r\n"
				+ "                }\r\n"
				+ "            }\r\n"
				+ "        }\r\n"
				+ "    }\r\n"
				+ "  }\r\n"
				+ "}";

		JSONObject obj = new JSONObject(json_data);
		// converting json to xml
		String xml_data = XML.toString(obj);
		System.out.println(xml_data);
		
		
	}
}
