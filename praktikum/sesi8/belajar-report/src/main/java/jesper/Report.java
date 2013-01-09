package jesper;

import java.io.InputStream;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

public class Report{
	private static String templateReport = "jesper/produk.jrxml";

	public static void main(String[] xx) throws Exception {
		// 1. Load template
		InputStream template = Report.class.getResourceAsStream(templateReport);
		JasperDesign jd = JRXmlLoader.load(template);

		// 2. Compile
		JasperReport report = JasperCompileManager.compileReport(jd);

		// 3. Isi data
		List<Produk> daftarProduk = buatSampleData();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("tahun", 2012);

		JasperPrint jrprint = JasperFillManager.fillReport(report,params,new JRBeanCollectionDataSource(daftarProduk));

		// 4. Export
		JRPdfExporter exporter = new JRPdfExporter();
		exporter.setParameter(JRExporterParameter.JASPER_PRINT,jrprint);
		exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,"target/daftar-Produk-pdf");
		exporter.exportReport();
	}

	private static List<Produk> buatSampleData(){
		// nantinya ini query dari database
		List<Produk> hasil = new ArrayList<Produk>();

		Produk p1 = new Produk();
		p1.setKode("NPM-001");
		p1.setNama("Produk 001");
		p1.setHarga(10000);
		hasil.add(p1);

		Produk p2 = new Produk();
		p2.setKode("NPM-002");
		p2.setNama("Produk 002");
		p2.setHarga(12000);
		hasil.add(p2);

		Produk p3 = new Produk();
		p3.setKode("NPM-003");
		p3.setNama("Produk 003");
		p3.setHarga(9000);
		hasil.add(p3);

		Produk p4 = new Produk();
		p4.setKode("NPM-004");
		p4.setNama("Produk 004");
		p4.setHarga(15000);
		hasil.add(p4);

		Produk p5 = new Produk();
		p5.setKode("NPM-005");
		p5.setNama("Produk 005");
		p5.setHarga(20000);
		hasil.add(p5);

		return hasil;

	}
}
