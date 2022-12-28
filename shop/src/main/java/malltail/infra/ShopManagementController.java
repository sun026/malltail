package malltail.infra;
import malltail.domain.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;


@RestController
// @RequestMapping(value="/shopManagements")
@Transactional
public class ShopManagementController {
    @Autowired
    ShopManagementRepository shopManagementRepository;



    @RequestMapping(value = "shopManagements/{id}/acceptorder",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8")
    public ShopManagement acceptOrder(@PathVariable(value = "id") Long id, HttpServletRequest request, HttpServletResponse response) throws Exception {
            System.out.println("##### /shopManagement/acceptOrder  called #####");
            Optional<ShopManagement> optionalShopManagement = shopManagementRepository.findById(id);
            
            optionalShopManagement.orElseThrow(()-> new Exception("No Entity Found"));
            ShopManagement shopManagement = optionalShopManagement.get();
            shopManagement.acceptOrder();
            
            shopManagementRepository.save(shopManagement);
            return shopManagement;
            
    }
    



    @RequestMapping(value = "shopManagements/{id}/rejectorder",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8")
    public ShopManagement rejectOrder(@PathVariable(value = "id") Long id, HttpServletRequest request, HttpServletResponse response) throws Exception {
            System.out.println("##### /shopManagement/rejectOrder  called #####");
            Optional<ShopManagement> optionalShopManagement = shopManagementRepository.findById(id);
            
            optionalShopManagement.orElseThrow(()-> new Exception("No Entity Found"));
            ShopManagement shopManagement = optionalShopManagement.get();
            shopManagement.rejectOrder();
            
            shopManagementRepository.save(shopManagement);
            return shopManagement;
            
    }
    



}
