package th.co.priorsolution.training.newhttp.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import th.co.priorsolution.training.newhttp.model.AddressModel;
import th.co.priorsolution.training.newhttp.model.PersonModel;
import th.co.priorsolution.training.newhttp.model.ResponseModel;

import java.util.List;

@Service
public class AppService {


    public ResponseModel<AddressModel> getAddressDataAndResponse(){
        ResponseModel<AddressModel> result = new ResponseModel<>();

        result.setStatus(200);
        result.setDescription("ok");
        try {
            // do some business
            result.setData(this.getAddressData());
        } catch (Exception e){
            result.setStatus(500);
            result.setDescription(e.getMessage());
        }
        return result;
    }

    private AddressModel getAddressData() {
        AddressModel addressModel = new AddressModel();
        addressModel.setDistrict("Bangna");
        addressModel.setSubDistrict("Bangna");
        addressModel.setProvince("Bangkok");
        addressModel.setPostalCode("10260");
        addressModel.setHouseNo("999");
        return addressModel;
    }

    public ResponseModel<PersonModel> getPersonDataAndResponse(){
        //default response
        ResponseModel<PersonModel> result = new ResponseModel<>();
        result.setStatus(200);
        result.setDescription("ok");
        try {
            // do some business
            result.setData(this.getPersonData());
        } catch (Exception e){
            result.setStatus(500);
            result.setDescription(e.getMessage());
        }

        return result;
    }

    private PersonModel getPersonData(){
        PersonModel personModel = new PersonModel();
        personModel.setAge(15);
        personModel.setNickName("Mao");
        return personModel;
    }
}
