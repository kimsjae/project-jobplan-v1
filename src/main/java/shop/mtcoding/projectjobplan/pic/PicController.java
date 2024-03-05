package shop.mtcoding.projectjobplan.pic;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import shop.mtcoding.projectjobplan.user.User;
import shop.mtcoding.projectjobplan.user.UserRepository;
import shop.mtcoding.projectjobplan.user.UserResponse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@RequiredArgsConstructor
@Controller
public class PicController {
    private final UserRepository userRepository;
    private final PicRepository picRepository;

    @PostMapping("/upload/{id}")
    public String upload(PicRequest.UploadDTO requestDTO, @PathVariable int id, RedirectAttributes redirectAttrs){
        // 1. 데이터 전달 받고
        String title = requestDTO.getTitle();
        MultipartFile imgFile = requestDTO.getImgFile();

        // 2. 파일저장 위치 설정해서 파일을 저장 (UUID 붙여서 롤링)
        String imgFilename = UUID.randomUUID()+"_"+imgFile.getOriginalFilename();
        Path imgPath = Paths.get("./upload/"+imgFilename);
        try {
            Files.write(imgPath, imgFile.getBytes());

            // 3. DB에 저장 (title, realFileName)
            picRepository.insert(title, imgFilename);

            Pic pic = picRepository.findById(1);
            
            // 세션에 저장됨
            redirectAttrs.addFlashAttribute("pic", pic);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return "redirect:/user/"+id;
    }

    @GetMapping("/uploadForm/{id}")
    public String uploadForm(@PathVariable int id, HttpServletRequest request){
        User user = userRepository.findById(id);
        request.setAttribute("user", user);
        return "user/uploadForm";
    }

}