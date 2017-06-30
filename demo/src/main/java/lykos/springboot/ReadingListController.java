package lykos.springboot;

import cn.creditease.bdp.auth.service.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by lykos on 2017/6/22.
 */
@Controller
@RequestMapping("/readingList")
public class ReadingListController {
    @Resource
    private ReadingListRepository readingListRepository;

    private Logger logger = LoggerFactory.getLogger(ReadingListController.class);

    @RequestMapping(value = "/{reader}", method = RequestMethod.GET)
    public String readersBooks(@PathVariable("reader") String reader, Model model) {
        List<Book> books = readingListRepository.findByReader(reader);
        if (books == null) {
            return "readingList";
        }
        logger.info("reader[{}]'s books:{}",reader,books);
        model.addAttribute("books", books);
        return "readingList";
    }
    @RequestMapping(value = "/{reader}",method = RequestMethod.POST)
    public String addToReadingList(@PathVariable("reader")String reader,Book book){
        book.setReader(reader);
        readingListRepository.save(book);
        return "redirect:/readingList/{reader}";
    }
    @RequestMapping(value = "/loginOut",method = RequestMethod.GET)
    public String loginOut(@PathVariable("reader")String reader, Book book, HttpServletRequest request, HttpServletResponse response){
        AuthService.logout(request,response);
        return "";
    }
}

