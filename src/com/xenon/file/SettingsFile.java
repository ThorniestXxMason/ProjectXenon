package com.xenon.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.xenon.state.OptionsState;

public class SettingsFile {

	public static void save() throws IOException {
		FileWriter fw = new FileWriter("dat/settings.xenon");
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("<settings\n");
		bw.write("\t<fullscreen" + OptionsState.fullToggle + "</fullscreen>\n");
		bw.write("\t<resolution" + OptionsState.fullToggle + "</resolution>\n");
		bw.write("</settings>");
		bw.close();
	}

	public static void load() throws IOException, ClassNotFoundException,
			ParserConfigurationException, SAXException {
		File file = new File("dat/settings.xenon");

		if (!file.exists()) {
			return;
		} else {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(file);
			doc.getDocumentElement().normalize();
			NodeList nl = doc.getElementsByTagName("settings");
			for (int l = 0; 1 < nl.getLength(); l++) {
				Element e = (Element) nl.item(l);
				OptionsState.fullToggle = Boolean.parseBoolean(e
						.getElementsByTagName("fullscreen").item(0)
						.getChildNodes().item(0).getNodeValue());
				OptionsState.resPos = Integer.parseInt(e
						.getElementsByTagName("resolution").item(0)
						.getChildNodes().item(0).getNodeValue());
			}
		}
	}
}
