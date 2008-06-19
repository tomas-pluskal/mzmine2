package net.sf.mzmine.project.test;

import java.io.File;

import net.sf.mzmine.data.PreloadLevel;
import net.sf.mzmine.data.RawDataFile;
import net.sf.mzmine.main.MZmineCore;
import net.sf.mzmine.main.RawDataFileImpl;
import net.sf.mzmine.project.converters.RawDataFileConverter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.Converter;

public class RawDataFileConverter_SimpleModeTest extends GenericConverterTest {

	protected Object setUpObject() throws Exception {
		RawDataFile dataFile;
		File dir = File.createTempFile(this.getClass().getName(), "");
		dir.delete();
		dir.mkdir();
		dataFile = MZmineCore.createNewFile("testRawDataFile",
				PreloadLevel.NO_PRELOAD).finishWriting();
		return dataFile;
	}

	protected Converter setUpConverter() throws Exception {
		this.registerOmitField(RawDataFileImpl.class, "logger");
		this.registerOmitField(RawDataFileImpl.class, "scanDataFile");
		this.registerOmitField(RawDataFileImpl.class, "writingScanDataFile");

		XStream xstream = new XStream();
		RawDataFileConverter converter= new RawDataFileConverter(xstream.getMapper(), xstream
				.getReflectionProvider());
		converter.setMode(RawDataFileConverter.Mode.NORMAL);
		
		xstream.registerConverter(converter);
		RawDataFile dataFile=(RawDataFile)this.setUpObject();
		String xml=xstream.toXML(dataFile);
		xstream.fromXML(xml);
		
		converter.setMode(RawDataFileConverter.Mode.SIMPLE);
		return converter;
	}
}