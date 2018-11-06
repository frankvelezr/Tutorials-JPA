package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.StreamSupport;

@Controller
public class QueryController {

    @Autowired
    CustomerRepository repository;

    @GetMapping("/all")
    public @ResponseBody Iterable<Customer> index() {
        Iterable<Customer> all = repository.findAll();
        StreamSupport.stream(all.spliterator(), false).forEach(x -> System.out.println(x.toString()));
        return all;
    }

}