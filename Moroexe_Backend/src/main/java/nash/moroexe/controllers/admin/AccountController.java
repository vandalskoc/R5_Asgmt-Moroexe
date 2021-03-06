package nash.moroexe.controllers.admin;


import nash.moroexe.dto.request.AccountRequestDTO;
import nash.moroexe.dto.request.SignUpDTO;
import nash.moroexe.dto.response.AccountResponseDTO;
import nash.moroexe.services.AccountServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api/admin/account")
public class AccountController {
    private final AccountServices accountServices;

    @Autowired
    public AccountController(AccountServices accountServices) {
        this.accountServices = accountServices;
    }

    @GetMapping("/ping")
    String pingServices() {
        return "Account Services is UP";
    }

    @GetMapping
    List<AccountResponseDTO> getAllAccount() {
        return (this.accountServices.getAllAccount());
    }

    @GetMapping("/{id}")
    AccountResponseDTO findAccountByID(@PathVariable long id){
        return  this.accountServices.findAccountById(id);
    }

    @PostMapping
    AccountResponseDTO createAccount(SignUpDTO account) {
        return this.accountServices.createAccount(account);
    }

    @PutMapping
    AccountRequestDTO updateAccout(AccountRequestDTO accountDTO, Long id){
        return this.accountServices.updateAccount(accountDTO,id);
    }







}

