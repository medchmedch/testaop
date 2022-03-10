package com.example.demo1.controller;

import com.example.demo1.entity.Note;
import com.example.demo1.repository.INoteRepository;
import com.example.demo1.service.impl.QRCodeGenerator;
import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.Base64;

@Controller
public class MainController {
    @Autowired
    private INoteRepository nr;


    @GetMapping("/qrcode")
    public String getQRCode(Model model, @RequestParam("cours_id") long cours_id,@RequestParam("user_id") long user_id){
        Note n = nr.findPdf(user_id,cours_id);
        String QR_CODE_IMAGE_PATH = "./src/main/resources/static/img/"+cours_id+"_"+user_id+".png";
        String medium="x";
        String github="Nom: "+ n.getUser().getUser_nom()+" Cours : "+n.getCoursn().getCours_nom()+" Note: "+n.getNote_val();

        byte[] image = new byte[0];
        try {

            // Generate and Return Qr Code in Byte Array
            image = QRCodeGenerator.getQRCodeImage(medium,250,250);

            // Generate and Save Qr Code Image in static/image folder
            QRCodeGenerator.generateQRCodeImage(github,250,250,QR_CODE_IMAGE_PATH);

        } catch (WriterException | IOException e) {
            e.printStackTrace();
        }
        // Convert Byte Array into Base64 Encode String
        String qrcode = Base64.getEncoder().encodeToString(image);

        model.addAttribute("medium",medium);
        model.addAttribute("github",github);
        model.addAttribute("qrcode",qrcode);

        return "qrcode";
    }
}