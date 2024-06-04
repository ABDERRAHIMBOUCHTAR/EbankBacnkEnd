    package com.example.ebankingbackend.web;

    import com.example.ebankingbackend.dtos.AccoutOperationDTO;
    import com.example.ebankingbackend.dtos.CustomerDTO;
    import com.example.ebankingbackend.exceptions.BankAccountNotDFoundException;
    import com.example.ebankingbackend.exceptions.CustomerNotFOundException;
    import com.example.ebankingbackend.services.BankAccountService;
    import lombok.AllArgsConstructor;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;

    @RestController
    @AllArgsConstructor  //injection dependence de bankaccountService
    @CrossOrigin("*")
    public class CustomerRestController {

        private BankAccountService bankAccountService;

        @GetMapping("/customers")
        public List<CustomerDTO> customers() {
            return  bankAccountService.listCustomers();
        }

        @GetMapping("/customers/customers")
        public List<CustomerDTO> searchCustomers(
                @RequestParam(name = "keyword", defaultValue = "") String keyword) {
            return  bankAccountService.searchCustomers( "%"+keyword+"%");
        }

        @GetMapping("/customers/{id}")
        public CustomerDTO getCustomer(@PathVariable(name = "id") Long customerId) throws CustomerNotFOundException {
            return bankAccountService.getCustomer(customerId);
        }

        @PostMapping("/customers")
        public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO) {  //RequestBody pour indiquer a spring que donneer customerDTO en va recuperer au corps de la requete format json
           return bankAccountService.saveCustomer(customerDTO);
        }

        @PutMapping("/customers/{customerId}")
        public CustomerDTO updateCustomer(@PathVariable Integer customerId,@RequestBody CustomerDTO customerDTO){  //donnee customer provienne du corps de le requete
            customerDTO.setId(customerId);
            return bankAccountService.updateCustomer(customerDTO);
        }

        @DeleteMapping("/customer/{id}")
        public void deleteCustomer(@PathVariable Long id) throws CustomerNotFOundException {
            bankAccountService.deleteCustomer(id);
        }


    }
