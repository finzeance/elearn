package com.mccserverapp.project.Service;

import java.io.File;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.mccserverapp.project.Model.dto.request.EmailRequest;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmailService {

    private JavaMailSender javaMailSender;

    public EmailRequest sendSimpleMessage(EmailRequest emailRequest) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(emailRequest.getTo());
        message.setSubject(emailRequest.getSubject());
        message.setText(emailRequest.getBody());

        javaMailSender.send(message);
        System.out.println();
        System.out.println("Email success to send...");
        return emailRequest;

    }

    public EmailRequest sendMessageWithAttachment(EmailRequest emailRequest) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(emailRequest.getTo());
            helper.setSubject(emailRequest.getSubject());
            helper.setText(emailRequest.getBody());

            String htmlMsg = "<!DOCTYPE html>"
                    + "<html>"
                    + "<head>"
                    + "<style>"
                    + ".button{ border: none; color: white; padding: 12px 16px; text-align: center; text-decoration: none; display: inline-block; font-size: 15px; margin: 4px 50px; transition-duration: 0.4s; cursor: pointer}"
                    + ".button1 {background-color: white; color: black; border: 2px solid #C13584; border-radius: 15px;}"
                    + ".button1:hover {background-color: #C13584;color: white;}"
                    + ".button2 {background-color: white; color: black; border: 2px solid #4CAF50;border-radius: 15px;}"
                    + ".button2:hover {background-color: #4CAF50;color: white;}"
                    + ".button3 {background-color: white; color: black; border: 2px solid #EE4D2D;border-radius: 15px;}"
                    + ".button3:hover {background-color: #EE4D2D;color: white;}"
                    + ".button4 {background-color: white; color: black; border: 2px solid #000000;border-radius: 15px;}"
                    + ".button4:hover {background-color: #000000;color: white;}"
                    + ".button5 {background-color: white; color: black; border: 2px solid #F5BA00;border-radius: 15px;}"
                    + ".button5:hover {background-color: #F5BA00;color: white;}"
                    + ".button6 {background-color: white; color: black; border: 2px solid #00FF7C;border-radius: 15px;}"
                    + ".button6:hover {background-color: #00FF7C;color: white;}"
                    + "</style>"
                    + "</head>"
                    + "<body>"
                    + "<table align='center' border='1' cellpadding='50' cellspacing='10' width='950'>"
                    + "<tr> <td bgcolor='#ffffff'>"
                    + "<a href='https://www.tokopedia.com/'>"
                    + "<img src='https://www.freepnglogos.com/uploads/logo-tokopedia-png/berita-tokopedia-info-berita-terbaru-tokopedia-6.png' alt='Facebook' width='80' height='80' style='display: block;' border='0' /></a>"
                    + "<h1 style='color:#4CAF50'><center>Informasi Pemesanan Tokopedia</center></h1>"
                    + "<p style='background-color:#404040'> . </p>"
                    + "<p>Hai <b>Fuad Zein,<b></p>"
                    + "<p style='font-size:15px'><b>Pembayaran anda telah terverifikasi dan pesanan telah di teruskan ke penjual<b></p>"
                    + "<p>Terima kasih, Berikut detail pembayaranmu:</p>"
                    + "<p> </p>"
                    + "<table align='center' border-style: dotted cellpadding='25' cellspacing='7' width='800'>"
                    + "<tr> <td bgcolor=grey>"
                    + "<p style='font-family: courier;'> Total Bayar &emsp; &emsp; &emsp;: Rp.250.000</p>"
                    + "<p style='font-family: courier;'> Metode Pembayaran&emsp;: BCA Virtual Account</p>"
                    + "<p style='font-family: courier;'> Waktu Pembayaran  &emsp;: Jumat, 24 Maret 2023</p>"
                    + "</td> </tr>"
                    + "</table>"
                    + "<p> Terimakasih sudah belanja di toko kami, berikan rating sesuai kualitas performa kami. </p>"
                    + "<p style='font-size:25px'> <center><b> Our Official Account</b> </center></p>"
                    + "<button class='button button1'><a style ='text-decoration:none;' href='https://www.instagram.com/elite.ltd/'>Instagram</a></button>"
                    + "<button class='button button2'><a style ='text-decoration:none;' href='https://tokopedia.link/5QvJSXqoyyb'>Tokopedia</a></button>"
                    + "<button class='button button3'><a style ='text-decoration:none;' href='https://shopee.co.id/elite.ltd'>Shopee</a></button>"
                    + "<button class='button button4'><a style ='text-decoration:none;' href='https://www.tiktok.com/@elite.limited?is_from_webapp=1&sender_device=pc'>Tiktok</a></button>"
                    + "<p style='background-color:#404040'> . </p>"

                    + "<p> <b>Ringkasan Pembayaran <b></p>"
                    + "<p style='font-family: courier;'> harga (1 barang)&emsp; &emsp; &emsp;Rp215.000</p>"
                    + "<p style='font-family: courier;'> Asuransi pengiriman&emsp; &emsp;Rp15.000 </p>"
                    + "<p style='font-family: courier;'> Ongkos Kirim&emsp; &emsp; &emsp;&emsp;&emsp;&emsp;Rp10.000 </p>"
                    + "<p style='font-family: courier;'> Jasa Aplikasi&emsp; &emsp; &emsp;&emsp;&emsp;Rp10.000 </p>"
                    + "<p style='font-family: courier;'> Total Bayar&emsp; &emsp; &emsp;&emsp;&emsp;&emsp;Rp250.000 </p>"
                    + "<p> </p>"
                    + "<p> <b>Rincian Pesanan <b></p>"
                    + "<p style='font-family: courier;'> No. Invoice: INF/240320230001 </p>"
                    + "<p style='font-family: courier;'> Toko Elite </p>"
                    + "<button class='button button5'><a style ='text-decoration:none;' href='https://tokopedia.link/PVDAghhezyb'>Beli Lagi</a></button>"
                    + "<button class='button button6'><a style ='text-decoration:none;' href='https://www.tokopedia.com/order-list'>Transaksi</a></button>"
                    + "</td> </tr>"
                    + "</table>"
                    + "</body>"
                    + "</html>";

            helper.setText(htmlMsg, true);

            FileSystemResource file = new FileSystemResource(
                    new File(emailRequest.getAttach()));

            helper.addAttachment(file.getFilename(), file);
            javaMailSender.send(message);
            System.out.println();
            System.out.println("Email success to send...");
        } catch (Exception e) {
            System.out.println("Email failed to send...");
        }

        return emailRequest;
    }

    // Cara 1 = Multiple by Email
    public EmailRequest sendMessageWithAttachmentMultiple(EmailRequest emailRequest) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(InternetAddress.parse(emailRequest.getTo()));
            helper.setSubject(emailRequest.getSubject());
            helper.setText(emailRequest.getBody());

            FileSystemResource file = new FileSystemResource(
                    new File(emailRequest.getAttach()));

            helper.addAttachment(file.getFilename(), file);
            javaMailSender.send(message);
            System.out.println();
            System.out.println("Email success to end...");
        } catch (Exception e) {
            throw new IllegalStateException("Email failed to send...");
        }

        return emailRequest;
    }

    // Cara 2 - Multiple by Object
    public Iterable<EmailRequest> sendMessageWithAttachmentMultipleObject(
            Iterable<EmailRequest> emailRequests) {
        emailRequests.forEach(emailRequest -> {
            try {
                MimeMessage message = javaMailSender.createMimeMessage();
                MimeMessageHelper helper = new MimeMessageHelper(message, true);

                helper.setTo(emailRequest.getTo());
                helper.setSubject(emailRequest.getSubject());
                helper.setText(emailRequest.getBody());

                FileSystemResource file = new FileSystemResource(
                        new File(emailRequest.getAttach()));

                helper.addAttachment(file.getFilename(), file);
                javaMailSender.send(message);
                System.out.println();
                System.out.println("Email success to send...");
            } catch (Exception e) {
                throw new IllegalStateException("Email failed to send...");
            }
        });
        return emailRequests;
    }

}
