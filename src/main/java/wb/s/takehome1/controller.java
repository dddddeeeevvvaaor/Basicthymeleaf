package wb.s.takehome1;

import java.io.File;
import java.io.IOException;
import java.sql.Date;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class controller {

    @RequestMapping(value="/takehome", method=RequestMethod.POST)
    public String takehome(@RequestParam("inputname") String Nama,
                            @RequestParam("inputdate") Date Tanggal,
                            @RequestParam("inputimage") MultipartFile Foto,
                            Model model) throws IOException {
        
        byte[] foto = Foto.getBytes();
        String base64Image = Base64.encodeBase64String(foto);
        String fotolink = "data:image/png;base64,".concat (base64Image);

        model.addAttribute("name", Nama);
        model.addAttribute("date", Tanggal);
        model.addAttribute("image", fotolink);

        return "main";
    }
}
