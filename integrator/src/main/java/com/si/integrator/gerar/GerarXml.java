package com.si.integrator.gerar;

import org.jdom.output.XMLOutputter;

import java.io.File;

import java.io.FileWriter;

import java.io.IOException;

import org.jdom.Document;

import org.jdom.Element;

import org.jdom.output.XMLOutputter;

public class GerarXml {
	public static void gerar(org.w3c.dom.Document document)
	  {
	      Element Reinf = new Element("Reinf");

	      //Define Agenda como root

	      Document documento = new Document(Reinf);


	      for (int i=0;i<5;i++){

	            Element contato = new Element("Contato");

	            //Adiciona o atributo id ao Contato

	            contato.setAttribute("id",Integer.toString(i));

	            //Criando os elementos de contato

	            Element nome = new Element("nome");

	            nome.setText("Glaucio Guerra");

	            Element telefone = new Element("telefone");

	            telefone.setText("123-456");

	            Element endereco = new Element("endereco");

	            endereco.setText("Av. Amaral Peixoto S/N");

	            Element email = new Element("email");

	            email.setText("glaucioguerra@gmail.com");

	            //Adicionando os elementos nome, telefone,

	            //endereco e email em Contato

	            contato.addContent(nome);

	            contato.addContent(telefone);

	            contato.addContent(endereco);

	            contato.addContent(email);

	            //Adicionado o Contato a Agenda

	            Reinf.addContent(contato);

	      }

	      XMLOutputter xout = new XMLOutputter();
		
		  }
}
