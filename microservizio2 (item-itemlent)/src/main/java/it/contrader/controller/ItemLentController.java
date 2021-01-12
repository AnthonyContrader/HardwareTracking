package it.contrader.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import it.contrader.dto.ItemLentDTO;
import it.contrader.service.ItemLentService;

@RestController
@RequestMapping("/track")
@CrossOrigin(origins = "http://localhost:4200") 
public class ItemLentController {
	
	@Autowired
	ItemLentService service;
	
	@GetMapping("/getall")
	public List<ItemLentDTO> getAll(){
		return service.getAll();		
	}
	
	@GetMapping("/getmyrequests/{fiscalCode}")
	public List<ItemLentDTO> getAll(@PathVariable("fiscalCode") String fiscalCode){
		
		List<ItemLentDTO> myRequests = new ArrayList<>();
		
		for(ItemLentDTO tempItemLent: service.getAll())
			if(tempItemLent.getFiscalCodeForLent().equals(fiscalCode))
				myRequests.add(tempItemLent);
		
		return myRequests;
	}
	
	@PostMapping("/request")
	public ItemLentDTO insert (@RequestBody ItemLentDTO dto) {
		
		boolean exists = false;
		
		List<ItemLentDTO> items = service.getAll();
		
		for(ItemLentDTO item: items)
			if(item.getFiscalCodeForLent().equals(dto.getFiscalCodeForLent())
					&& item.getItemName().equals(dto.getItemName()))
						exists = true;
		
		if(!exists) {
			SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
			Date date = new Date(System.currentTimeMillis());
			formatter.format(date);
			dto.setDate(formatter.format(date));
			service.insert(dto);
			return dto;
		} else
			return null;
	}
	
	@DeleteMapping("/return/{info}")
	public void delete(@PathVariable("info") String info) {
		
		String[] pieces = info.split("-");
		String fiscalCode = pieces[0];
		String itemName = pieces[1];
		
		service.delete(fiscalCode, itemName);
	}
	
	@GetMapping("/downloadstandard")
	public void download() {
		
		try{
			
			Document document = new Document();
			String path = "C:\\Users\\Simone Briffa\\Desktop\\Contrader\\HardwareTracking - Microservizi\\Frontend\\src\\assets\\trackItemsStandard.pdf";
			PdfWriter.getInstance(document, new FileOutputStream(path));

			document.open();
			Font font = FontFactory.getFont(FontFactory.COURIER, 10, BaseColor.BLACK);
			String info = "TRACK ITEMS";
			int i = 1;
			
            for(ItemLentDTO tempItem: service.getAll()) {
            	info += "\n " + i + ") " + tempItem.toString();
            	i++;
            } 
            
            System.out.println(info);
            
            Paragraph chunk = new Paragraph(info, font);
            document.add(chunk);
            
            document.close();
            
		}catch (DocumentException  e) {
            e.getMessage();
            e.printStackTrace();
        } catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping("/downloadtable")
	public void downloadtable() {
		
	try {
		
		Document document = new Document();
		String path = "C:\\Users\\Simone Briffa\\Desktop\\Contrader\\HardwareTracking - Microservizi\\Frontend\\src\\assets\\trackItemsTable.pdf";
		
		PdfWriter.getInstance(document, new FileOutputStream(path));

		document.open();

		PdfPTable table = new PdfPTable(5);
		addTableHeader(table);
		addRows(table);

		document.add(table);
		
		document.close();
		
		} catch (DocumentException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private void addTableHeader(PdfPTable table) {
	    Stream.of("FIRST NAME", "LAST NAME", "FISCAL CODE", "ITEM", "DATE OF REQUEST")
	      .forEach(columnTitle -> {
	        PdfPCell header = new PdfPCell();
	        header.setBackgroundColor(BaseColor.LIGHT_GRAY);
	        header.setBorderWidth(2);
	        header.setPhrase(new Phrase(columnTitle));
	        table.addCell(header);
	    });
	}
	
	private void addRows(PdfPTable table) {
		
		for(ItemLentDTO item: service.getAll()) {
		
			table.addCell(item.getFirstNameOwner());
			table.addCell(item.getLastNameOwner());
			table.addCell(item.getFiscalCodeForLent());
			table.addCell(item.getItemName());
			table.addCell(item.getDate());
		}
		
	}
	

}
