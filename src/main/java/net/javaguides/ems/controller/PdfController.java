package net.javaguides.ems.controller;

import net.javaguides.ems.model.Users;
import net.javaguides.ems.service.PdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/api/pdf")
public class PdfController {

    @Autowired
    private PdfService pdfService;

    @GetMapping("/generate")
    public String generatePDF() {
        Date date = new Date() ;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        List<Users> users = Arrays.asList(
                new Users("John Doe", 25, "john.doe@example.com"),
                new Users("Jane Smith", 30, "jane.smith@example.com")
        );
        String destination = "/home/thirumal/backend/java/user_details-"+dateFormat.format(date)+".pdf";
        pdfService.createPdf(destination, users);
        return "PDF generated successfully at: " + destination;

    }
}
