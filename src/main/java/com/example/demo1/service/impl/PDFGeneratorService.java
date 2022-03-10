package com.example.demo1.service.impl;

import com.example.demo1.entity.Note;
import com.example.demo1.repository.INoteRepository;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class PDFGeneratorService {
    @Autowired
    private INoteRepository nr;

    public void export(HttpServletResponse response,long cours_id, long user_id, String currentDateTime) throws IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontTitle.setSize(18);
        Note n = nr.findPdf(user_id,cours_id);
        String x =n.getUser().getUser_nom();
        String y = n.getCoursn().getCours_nom();
        double z = n.getNote_val();

        Paragraph paragraph = new Paragraph("nom: "+x, fontTitle);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
        fontParagraph.setSize(12);

        Paragraph paragraph2 = new Paragraph("cours: "+y, fontParagraph);
        paragraph2.setAlignment(Paragraph.ALIGN_CENTER);
        Paragraph paragraph3 = new Paragraph("Note: " + z + " Mention ", fontParagraph);
        if(z>=15) {paragraph3.add("Trés bien");
        }else{paragraph3.add("Passable");}
        Paragraph paragraph4 = new Paragraph("Obtenu le: "+currentDateTime, fontParagraph);
        paragraph4.setAlignment(Paragraph.ALIGN_CENTER);
        paragraph3.setAlignment(Paragraph.ALIGN_CENTER);



        document.add(paragraph);
        document.add(paragraph2);
        document.add(paragraph3);
        document.add(paragraph4);
        document.close();
    }
}