package net.javaguides.ems.service;


import net.javaguides.ems.model.Users;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.List;

@Service
public class PdfService {
    public void createPdf(String destination, List<Users> users) {
        try {
            PdfWriter writer = new PdfWriter(destination);
            com.itextpdf.kernel.pdf.PdfDocument pdfDoc = new com.itextpdf.kernel.pdf.PdfDocument(writer);
            Document document = new Document(pdfDoc);

            document.add(new Paragraph("User Details"));

            for (Users user : users) {
                document.add(new Paragraph("Name: " + user.getName()));
                document.add(new Paragraph("Age: " + user.getAge()));
                document.add(new Paragraph("Email: " + user.getEmail()));
                document.add(new Paragraph(" "));
            }
            document.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
