package com.si.integrator.assinatura;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.StringReader;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.crypto.dsig.CanonicalizationMethod;
import javax.xml.crypto.dsig.DigestMethod;
import javax.xml.crypto.dsig.Reference;
import javax.xml.crypto.dsig.SignatureMethod;
import javax.xml.crypto.dsig.SignedInfo;
import javax.xml.crypto.dsig.Transform;
import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.keyinfo.X509Data;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.jdom.output.XMLOutputter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;



public class Assinatura {

    private static final String C14N_TRANSFORM_METHOD = "http://www.w3.org/TR/2001/REC-xml-c14n-20010315";
  


 

    /**
     *
     * @param caminhoCertificado
     * @param senhaCertificado
     * @paaram senhaCertificado
     * @param caminhoArquivo
     * @return
     * @throws Exception
     */
    public static String assinarDocumento(String caminhoCertificado, String senhaCertificado, String caminhoArquivo,String id) throws Exception {

        final KeyStore keyStore = KeyStore.getInstance("PKCS12");
        try (InputStream certificadoStream = new FileInputStream(new File(caminhoCertificado))) {
            keyStore.load(certificadoStream, senhaCertificado.toCharArray());
        }

        final KeyStore.PrivateKeyEntry keyEntry = (KeyStore.PrivateKeyEntry) keyStore.getEntry(
                keyStore.aliases().nextElement(),
                new KeyStore.PasswordProtection(senhaCertificado.toCharArray()));

        final XMLSignatureFactory signatureFactory = XMLSignatureFactory.getInstance("DOM");

        final List<Transform> transforms = new ArrayList<>(2);
        transforms.add(signatureFactory.newTransform(Transform.ENVELOPED, (TransformParameterSpec) null));
        transforms.add(signatureFactory.newTransform(C14N_TRANSFORM_METHOD, (TransformParameterSpec) null));

        final KeyInfoFactory keyInfoFactory = signatureFactory.getKeyInfoFactory();
        final X509Data x509Data = keyInfoFactory.newX509Data(Collections.singletonList((X509Certificate) keyEntry.getCertificate()));
        final KeyInfo keyInfo = keyInfoFactory.newKeyInfo(Collections.singletonList(x509Data));

  	  
         
     // Create a Reference to the enveloped document (in this case,
     // you are signing the whole document, so a URI of "" signifies
     // that, and also specify the SHA1 digest algorithm and
     // the ENVELOPED Transform.
     Reference ref = signatureFactory.newReference
      ("", signatureFactory.newDigestMethod(DigestMethod.SHA1, null),
       Collections.singletonList
        (signatureFactory.newTransform
         (Transform.ENVELOPED, (TransformParameterSpec) null)),
          null, null);

        	  
        	    // Create the SignedInfo.   
        	    SignedInfo signedInfo = signatureFactory   
        	            .newSignedInfo(signatureFactory.newCanonicalizationMethod(   
        	                    CanonicalizationMethod.INCLUSIVE,   
        	                    (C14NMethodParameterSpec) null), signatureFactory.newSignatureMethod(SignatureMethod.RSA_SHA1, null),   
        	                    Collections.singletonList(ref));  
                     
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                dbf.setNamespaceAware(true);
                Document doc = dbf.newDocumentBuilder().parse
                		(new InputSource(new StringReader(caminhoArquivo)));

                // Create a DOMSignContext and specify the RSA PrivateKey and
                // location of the resulting XMLSignature's parent element.
                DOMSignContext dsc = new DOMSignContext
                    (keyEntry.getPrivateKey(), doc.getDocumentElement());

                // Create the XMLSignature, but don't sign it yet.
                final XMLSignature signature = signatureFactory.newXMLSignature(signedInfo, keyInfo);

                // Marshal, generate, and sign the enveloped signature.
                signature.sign(dsc);
         

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            final Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(new DOMSource(doc), new StreamResult(outputStream));
            return outputStream.toString();
        }

    }
    
	


}